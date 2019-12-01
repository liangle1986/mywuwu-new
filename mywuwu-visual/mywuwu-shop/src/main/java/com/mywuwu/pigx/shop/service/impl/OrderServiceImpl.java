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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pigx code generator
 * @date 2019-08-26 22:22:44
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

	private UserService userService;
	private GoodsService goodsService;
	private OrderGoodsService orderGoodsService;

	private GoodsSpecificationService specificationService;

	public R saveUserOrderInfo(OrderVo order) {

		Integer userId = SecurityUtils.getUser().getId();
		try {
			//根据用户ID查询当前下单用户是否一致
			if (userService.getById(userId).getWeixinOpenid().equals(order.getOpentId())) {
				Order showOrder = new Order();

//				showOrder.setOrderPrice(goods);
				baseMapper.insert(showOrder);

//			根据商品id查询商品详情
				Goods goods = goodsService.getById(order.getGoodsId());

				//获取商品规格
				List<GoodsSpecificationEntity> entities = specificationService.list(Wrappers.<GoodsSpecificationEntity>query().lambda().eq(GoodsSpecificationEntity::getGoodsId, goods.getId()));


				String ids = "";
				String value = "";
				if (entities != null && entities.size() > 0) {
					ids = entities.stream().map(s -> s.getId()).collect(Collectors.toList()).toString();
					value = entities.get(0).getValue();
				}


				//创建商品订单
				OrderGoods orderGoods = new OrderGoods();
				orderGoods.setGoodsId(goods.getId());
				orderGoods.setGoodsName(goods.getName());
				orderGoods.setGoodsSn(goods.getGoodsSn());
				orderGoods.setGoodsSpecifitionIds(ids);
				orderGoods.setGoodsSpecifitionNameValue(value);
				orderGoods.setIsReal(goods.getCategoryId());
				orderGoods.setListPicUrl(goods.getListPicUrl());
				orderGoods.setMarketPrice(goods.getMarketPrice());
				orderGoods.setOrderId(showOrder.getId());
				orderGoods.setRetailPrice(goods.getRetailPrice());
				orderGoods.setNumber(order.getNumber());
				orderGoods.setProductId(goods.getPrimaryProductId());
				orderGoodsService.save(orderGoods);
			}
		} catch (Exception e) {

		}
		return R.ok();
	}

}
