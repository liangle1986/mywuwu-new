/*
 *    Copyright (c) 2018-2025, lianglele All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the ywuwu.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lianglele (lianglele1986@126.com)
 */

package com.mywuwu.pigx.admin.handler;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mywuwu.pigx.admin.api.dto.UserDTO;
import com.mywuwu.pigx.admin.api.dto.UserInfo;
import com.mywuwu.pigx.admin.api.entity.SysSocialDetails;
import com.mywuwu.pigx.admin.api.entity.SysUser;
import com.mywuwu.pigx.admin.api.entity.WxUser;
import com.mywuwu.pigx.admin.api.feign.RemoteWxUserService;
import com.mywuwu.pigx.admin.mapper.SysSocialDetailsMapper;
import com.mywuwu.pigx.admin.service.SysUserService;
import com.mywuwu.pigx.common.core.constant.SecurityConstants;
import com.mywuwu.pigx.common.core.constant.enums.LoginTypeEnum;
import com.mywuwu.pigx.common.core.util.WebUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author lianglele
 * @date 2019年11月02日
 * <p>
 * 微信小程序
 */
@Slf4j
@Component("MINI")
@AllArgsConstructor
public class MiniAppLoginHandler extends AbstractLoginHandler {
	private final SysUserService sysUserService;
	private final RemoteWxUserService remoteWxUserService;
	private final SysSocialDetailsMapper sysSocialDetailsMapper;

	/**
	 * 小程序登录传入code
	 * <p>
	 * 通过code 调用qq 获取唯一标识
	 *
	 * @param code
	 * @return
	 */
	@Override
	public String identify(String code) {
		Map<String, Object> map = JSONUtil.toBean(code, Map.class);
		String showCode = map.get("code") == null ? "" : map.get("code").toString();

		SysSocialDetails condition = new SysSocialDetails();
		condition.setType(LoginTypeEnum.MINI_APP.getType());
		SysSocialDetails socialDetails = sysSocialDetailsMapper.selectOne(new QueryWrapper<>(condition));

		String url = String.format(SecurityConstants.MINI_APP_AUTHORIZATION_CODE_URL
				, socialDetails.getAppId(), socialDetails.getAppSecret(), showCode);
		String result = HttpUtil.get(url);
		log.debug("微信小程序响应报文:{}", result);

		Object obj = JSONUtil.parseObj(result).get("openid");
		if (obj != null && !map.isEmpty()) {
			saveOrUpdate(obj.toString(), map);
			Object key = JSONUtil.parseObj(result).get("session_key");
			saveOrUpdateWx(obj.toString(), map, key.toString());
			saveOrUpdate(obj.toString(), map);
		}
		return obj.toString();
	}

	/**
	 * openId 获取用户信息
	 *
	 * @param openId
	 * @return
	 */
	@Override
	public UserInfo info(String openId) {
		SysUser user = sysUserService
				.getOne(Wrappers.<SysUser>query()
						.lambda().eq(SysUser::getMiniOpenid, openId));

		if (user == null) {
			log.info("没有获取到微信小程序信息:{}", openId);
			return null;
		}
		return sysUserService.findUserInfo(user);
	}

	/**
	 * 获取用户信息
	 *
	 * @param openId
	 * @return
	 */
	private SysUser getUser(String openId) {
		return sysUserService
				.getOne(Wrappers.<SysUser>query()
						.lambda().eq(SysUser::getMiniOpenid, openId));
	}

	/**
	 * 创建获取更新用户信息
	 *
	 * @param openId 微信开放标示
	 * @param map    微信信息
	 */
	private void saveOrUpdate(String openId, Map<String, Object> map) {

		try {
			SysUser user = getUser(openId);

			JSONObject userInfo = JSONUtil.parseObj(map.get("rawData"));
			if (userInfo != null) {
				String avatarUrl = userInfo.get("avatarUrl") != null ? userInfo.get("avatarUrl").toString() : "";
				String nickName = userInfo.get("nickName") != null ? userInfo.get("nickName").toString() : "";
				if (user != null) {
					user.setAvatar(avatarUrl);
					sysUserService.updateById(user);
				} else {
					UserDTO userDTO = new UserDTO();
//					user = new SysUser();
					userDTO.setAvatar(avatarUrl);
					userDTO.setUsername(openId);
					userDTO.setPassword("123456");
					userDTO.setTenantId(Integer.valueOf(map.get("tenantId").toString()));
					userDTO.setMiniOpenid(openId);
					userDTO.setDeptId(10);
					List<Integer> role = new ArrayList<>();
					role.add(4);
					userDTO.setRole(role);
//					sysUserService.insertUserInfo(user);
					sysUserService.saveUser(userDTO);
				}
			}
		} catch (Exception e) {
			log.error("微信创建或者更新shi b" + e.getMessage(), e);
		}

	}

	/**
	 * 创建获取更新用户信息
	 *
	 * @param openId 微信开放标示
	 * @param map    微信信息
	 */
	private void saveOrUpdateWx(String openId, Map<String, Object> map, String sessionKey) {

		try {
			WxUser wxUser = remoteWxUserService.info(openId);
			String encryptedData = map.get("encryptedData").toString();
			String iv = map.get("iv").toString();
			String showUserinfo = getUserInfo(encryptedData, sessionKey, iv);

			if (StrUtil.isNotEmpty(showUserinfo)) {

				JSONObject userInfo = JSONUtil.parseObj(showUserinfo);

				String avatarUrl = userInfo.get("avatarUrl") != null ? userInfo.get("avatarUrl").toString() : "";
				String nickName = userInfo.get("nickName") != null ? userInfo.get("nickName").toString() : "";
				Integer gender = userInfo.get("gender") != null ? Integer.valueOf(userInfo.get("gender").toString()) : 0;
				if (wxUser != null) {
					wxUser.setAvatar(avatarUrl);
					wxUser.setNickName(nickName);
					wxUser.setLastLoginIp(WebUtils.getIP());
					wxUser.setLastLoginTime(LocalDateTime.now());
					remoteWxUserService.update(wxUser);
				} else {
					wxUser = new WxUser();
					wxUser.setAvatar(avatarUrl);
					wxUser.setUserLevelId(1);
					wxUser.setNickName(nickName);
					wxUser.setUsername(openId);
//					wxUser.setPassword("123456");
					wxUser.setWeixinOpenid(openId);
					wxUser.setBirthday(LocalDateTime.now());
					wxUser.setGender(gender);
					wxUser.setRegisterIp(WebUtils.getIP());
					wxUser.setLastLoginIp(WebUtils.getIP());
					wxUser.setRegisterTime(LocalDateTime.now());
					wxUser.setLastLoginTime(LocalDateTime.now());
					remoteWxUserService.save(wxUser);
				}
			}
		} catch (Exception e) {
			log.error("微信创建或者更新shi b" + e.getMessage(), e);
		}

	}


	/**
	 * 微信小程序解密用户敏感数据获取用户信息
	 *
	 * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
	 * @param sessionKey    数据进行加密签名的密钥
	 * @param iv            加密算法的初始向量
	 * @return
	 */
	public String getUserInfo(String encryptedData, String sessionKey, String iv) {
		String result = "";
		// 被加密的数据
		byte[] dataByte = Base64.decode(encryptedData);
		// 加密秘钥
		byte[] keyByte = Base64.decode(sessionKey);
		// 偏移量
		byte[] ivByte = Base64.decode(iv);
		try {
			// 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
			int base = 16;
			if (keyByte.length % base != 0) {
				int groups = keyByte.length / base
						+ (keyByte.length % base != 0 ? 1 : 0);
				byte[] temp = new byte[groups * base];
				Arrays.fill(temp, (byte) 0);
				System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
				keyByte = temp;
			}
			// 初始化
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
			SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
			AlgorithmParameters parameters = AlgorithmParameters
					.getInstance("AES");
			parameters.init(new IvParameterSpec(ivByte));
			cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
			byte[] resultByte = cipher.doFinal(dataByte);
			if (null != resultByte && resultByte.length > 0) {
				result = new String(resultByte, "UTF-8");
			}
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchPaddingException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidParameterSpecException e) {
			log.error(e.getMessage(), e);
		} catch (IllegalBlockSizeException e) {
			log.error(e.getMessage(), e);
		} catch (BadPaddingException e) {
			log.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidKeyException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidAlgorithmParameterException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchProviderException e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}
}
