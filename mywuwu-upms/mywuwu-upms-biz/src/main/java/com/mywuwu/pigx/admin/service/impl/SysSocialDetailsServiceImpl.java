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

package com.mywuwu.pigx.admin.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.pigx.admin.api.dto.UserInfo;
import com.mywuwu.pigx.admin.api.entity.SysSocialDetails;
import com.mywuwu.pigx.admin.api.entity.SysUser;
import com.mywuwu.pigx.admin.handler.LoginHandler;
import com.mywuwu.pigx.admin.mapper.SysSocialDetailsMapper;
import com.mywuwu.pigx.admin.mapper.SysUserMapper;
import com.mywuwu.pigx.admin.service.SysSocialDetailsService;
import com.mywuwu.pigx.common.core.constant.CacheConstants;
import com.mywuwu.pigx.common.core.constant.enums.LoginTypeEnum;
import com.mywuwu.pigx.common.security.util.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author lianglele
 * @date 2018年08月16日
 */
@Slf4j
@AllArgsConstructor
@Service("sysSocialDetailsService")
public class SysSocialDetailsServiceImpl extends ServiceImpl<SysSocialDetailsMapper, SysSocialDetails> implements SysSocialDetailsService {
	private final Map<String, LoginHandler> loginHandlerMap;
	private final CacheManager cacheManager;
	private final SysUserMapper sysUserMapper;

	/**
	 * 绑定社交账号
	 *
	 * @param type type
	 * @param code code
	 * @return
	 */
	@Override
	public Boolean bindSocial(String type, String code) {
		String identify = loginHandlerMap.get(type).identify(code);
		SysUser sysUser = sysUserMapper.selectById(SecurityUtils.getUser().getId());

		if (LoginTypeEnum.GITEE.getType().equals(type)) {
			sysUser.setGiteeLogin(identify);
		} else if (LoginTypeEnum.OSC.getType().equals(type)) {
			sysUser.setOscId(identify);
		} else if (LoginTypeEnum.WECHAT.getType().equals(type)) {
			sysUser.setWxOpenid(identify);
		} else if (LoginTypeEnum.QQ.getType().equals(type)) {
			sysUser.setQqOpenid(identify);
		} else if (LoginTypeEnum.MINI_APP.getType().equals(type)) {
			sysUser.setMiniOpenid(identify);
		}

		sysUserMapper.updateById(sysUser);
		//更新緩存
		cacheManager.getCache(CacheConstants.USER_DETAILS).evict(sysUser.getUsername());
		return Boolean.TRUE;
	}

	/**
	 * 根据入参查询用户信息
	 *
	 * @param inStr TYPE@code
	 * @return
	 */
	@Override
	public UserInfo getUserInfo(String inStr) {
		String[] inStrs = inStr.split(StringPool.AT);
		String type = inStrs[0];
		String loginStr = inStrs[1];
		return loginHandlerMap.get(type).handle(loginStr);
	}

	@Override
	public UserInfo getUserInfoObj(Map<String, Object> object) {
		System.out.println(JSONUtil.toJsonStr(object));
		return loginHandlerMap.get(object.get("state")).handle(JSONUtil.toJsonStr(object));
	}
}
