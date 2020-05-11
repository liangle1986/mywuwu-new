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
import com.mywuwu.pigx.shop.entity.ShopOrder;
import com.mywuwu.pigx.shop.entity.dto.OrderDto;

/**
 * @author lianglele
 * @date 2019-08-26 22:22:44
 */
public interface OrderService extends IService<ShopOrder> {
	/**
	 * 创建订单
	 *
	 * @param order 订单信息
	 * @return
	 */
	R saveUserOrderInfo(OrderDto order);

	/**
	 * @description: 获取用户订单
	 * @return: R
	 * @author: lianglele
	 * @date: 2019-12-14 18:46
	 */
	R selectOrderList();
	/**
	  * @description:
	  * @Param ordera
	  * @return:
	  * @author: lianglele
	  * @date: 2020-04-02 14:24
	  */
	R selectOrderDetail(OrderDto order);
}
