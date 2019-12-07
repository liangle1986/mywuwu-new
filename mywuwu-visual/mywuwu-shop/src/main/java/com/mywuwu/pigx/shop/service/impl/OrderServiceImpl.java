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
package com.mywuwu.pigx.shop.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.security.util.SecurityUtils;
import com.mywuwu.pigx.shop.entity.Goods;
import com.mywuwu.pigx.shop.entity.GoodsSpecificationEntity;
import com.mywuwu.pigx.shop.entity.Order;
import com.mywuwu.pigx.shop.entity.OrderGoods;
import com.mywuwu.pigx.shop.mapper.OrderMapper;
import com.mywuwu.pigx.shop.service.*;
import com.mywuwu.pigx.shop.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pigx code generator
 * @date 2019-08-26 22:22:44
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

	/**
	 * 会员信息
	 */
	@Autowired
	private UserService userService;
	/**
	 * 商品信息
	 */
	@Autowired
	private GoodsService goodsService;
	/**
	 * 商品订单
	 */
	@Autowired
	private OrderGoodsService orderGoodsService;

	/**
	 * 商品规格
	 */
	@Autowired
	private GoodsSpecificationService specificationService;

	/**
	 * 优惠券
	 */
	@Autowired
	private UserCouponService couponService;

	@Override
	public R saveUserOrderInfo(OrderVo order) {

		try {
			//根据openid查询订单
			if (baseMapper.selectCount(Wrappers.<Order>query().lambda().eq(Order::getUserId, order.getOpentId())) > 0) {

				Order newOrder = baseMapper.selectOne(Wrappers.<Order>query().lambda().eq(Order::getUserId, order.getOpentId()).last("limit 1"));
				newOrder.setUserId(order.getOpentId());
				newOrder.setGoodsPrice(order.getPrice());
				baseMapper.updateById(newOrder);
			} else {
				Order newOrder = new Order();
				newOrder.setUserId(order.getOpentId());
				newOrder.setGoodsPrice(order.getPrice());
//				newOrder.set
				baseMapper.insert(newOrder);
			}
			return R.ok("下单成功");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return R.failed("下单失败" + e.getMessage());

		}

	}

}
