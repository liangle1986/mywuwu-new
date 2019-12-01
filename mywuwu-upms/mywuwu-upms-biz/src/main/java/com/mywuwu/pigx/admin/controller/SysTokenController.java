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

package com.mywuwu.pigx.admin.controller;

import com.mywuwu.pigx.admin.api.feign.RemoteTokenService;
import com.mywuwu.pigx.common.core.constant.SecurityConstants;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author lianglele
 * @date 2018/9/4
 * getTokenPage 管理
 */
@RestController
@AllArgsConstructor
@RequestMapping("/token")
@Api(value = "token", tags = "令牌管理模块")
public class SysTokenController {
	private final RemoteTokenService remoteTokenService;

	/**
	 * 分页token 信息
	 *
	 * @param params 参数集
	 * @return token集合
	 */
	@GetMapping("/page")
	public R getTokenPage(@RequestParam Map<String, Object> params) {
		return remoteTokenService.getTokenPage(params, SecurityConstants.FROM_IN);
	}

	/**
	 * 删除
	 *
	 * @param token getTokenPage
	 * @return success/false
	 */
	@SysLog("删除用户token")
	@DeleteMapping("/{token}")
	@PreAuthorize("@pms.hasPermission('sys_token_del')")
	public R removeById(@PathVariable String token) {
		return remoteTokenService.removeTokenById(token, SecurityConstants.FROM_IN);
	}
}
