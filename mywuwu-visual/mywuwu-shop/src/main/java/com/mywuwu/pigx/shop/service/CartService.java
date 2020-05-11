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
import com.mywuwu.pigx.shop.entity.Cart;

/**
 * @author lianglele code generator
 * @date 2019-08-27 20:54:53
 */
public interface CartService extends IService<Cart> {


	/**
	 * @description: 获取购物车信息
	 * @return: 购物车商品信息
	 * @author: lianglele
	 * @date: 2019-12-07 18:57
	 */
	R selectCartList();

	/**
	 * 添加商品到购物车
	 *
	 * @param cart 添加信息
	 * @return 添加成功或者失败信息
	 */
	R addCartGoods(Cart cart);

	/**
	 * 修改购物车商品
	 *
	 * @param cart 修改商品到信息
	 * @return
	 */
//	R updateCartGoods(Cart cart);

	/**
	 * 提交前验证订单
	 *
	 * @param addressId 地址标示
	 * @return 验证后的信息
	 */
	R checkoutCart(Integer addressId);
}
