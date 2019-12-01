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
package com.mywuwu.pigx.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.mp.entity.WxFansMsgRes;

/**
 * 微信消息回复业务
 *
 * @author lianglele
 * @date 2019-03-27 20:45:48
 */
public interface WxFansMsgResService extends IService<WxFansMsgRes> {

	/**
	 * 保存并发送回复
	 *
	 * @param wxFansMsgRes
	 * @return
	 */
	R saveAndSend(WxFansMsgRes wxFansMsgRes);
}
