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
 * Author: lianglele (liangle1986@126.com)
 */

package com.mywuwu.pigx.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.shop.entity.Footprint;

/**
 * @author 足迹
 * @date 2019-08-26 22:22:23
 */
public interface FootprintService extends IService<Footprint> {
	/**
	 * @description: 获取用户足迹
	 * @return: 足迹信息
	 * @author: lianglele
	 * @date: 2019-12-14 18:16
	 */
	R selectFootPrintList();
}
