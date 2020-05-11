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

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.security.util.SecurityUtils;
import com.mywuwu.pigx.shop.entity.*;
import com.mywuwu.pigx.shop.entity.dto.OrderDto;
import com.mywuwu.pigx.shop.mapper.OrderMapper;
import com.mywuwu.pigx.shop.service.*;
import com.mywuwu.pigx.shop.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lianglele
 * @date 2019-08-26 22:22:44
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, ShopOrder> implements OrderService {

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
	 * gouwuche
	 */
	@Autowired
	private CartService cartService;
	/**
	 * dizhi
	 */
	@Autowired
	private AddressService addressService;

	/**
	 * 优惠券
	 */
	@Autowired
	private UserCouponService couponService;
	/**
	 * 城市
	 */
	@Autowired
	private RegionService regionService;
	private Integer goodsCount;

	/**
	 * @description: 获取用户订单
	 * @return: R
	 * @author: lianglele
	 * @date: 2019-12-14 18:46
	 */
	@Override
	public R selectOrderList() {
		try {

			List<ShopOrder> orderList = baseMapper.selectList(Wrappers.<ShopOrder>query().lambda().eq(ShopOrder::getUserId, SecurityUtils.getUser().getId()));
			List<OrderVo> orderVoList = null;
			orderList.stream().forEach(o -> {
				OrderVo vo = new OrderVo();
				BeanUtil.copyProperties(o, vo);
				//获取订单商品
				List<OrderGoods> orderGoodsList = orderGoodsService.list(Wrappers.<OrderGoods>query().lambda().eq(OrderGoods::getOrderId, vo.getId()));
				vo.setOrderGoodsList(orderGoodsList);
				this.goodsCount = 0;
				orderGoodsList.forEach(g -> {
					this.goodsCount += g.getNumber();
				});
				vo.setGoodsCount(goodsCount);
				orderVoList.add(vo);
			});

			return R.ok(orderVoList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return R.failed("查询失败" + e.getMessage());

		}
	}


	@Override
	public R saveUserOrderInfo(OrderDto order) {

		try {
			//根据openid查询订单
			if (baseMapper.selectCount(Wrappers.<ShopOrder>query().lambda().eq(ShopOrder::getUserId, order.getOpentId())) > 0) {

				ShopOrder newOrder = baseMapper.selectOne(Wrappers.<ShopOrder>query().lambda().eq(ShopOrder::getUserId, order.getOpentId()).last("limit 1"));
				newOrder.setUserId(order.getUserId());
				newOrder.setGoodsIds(order.getGoodsId());
				newOrder.setAllprice(order.getPrice());
				baseMapper.updateById(newOrder);
			} else {
				ShopOrder newOrder = new ShopOrder();
				newOrder.setUserId(order.getUserId());
				newOrder.setAllprice(order.getPrice());
//				newOrder.setGoodsId(order.getGoodsId());
				baseMapper.insert(newOrder);
			}
			return R.ok("下单成功");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return R.failed("下单失败" + e.getMessage());

		}

	}

	//huoqudingdan xiangqing
	@Override
	public R selectOrderDetail(OrderDto order) {

		ShopOrder neworder = baseMapper.selectOne(Wrappers.<ShopOrder>query().lambda().eq(ShopOrder::getUserId, order.getUserId()));
		if (neworder == null) {
			return R.failed("订单不存在");
		}
//		order.setProvince(regionService.getById(order.getProvince()).getName());
		//根据用户 和商品标示查询购物车
		List<Cart> carList = cartService.list(Wrappers.<Cart>query().lambda().eq(Cart::getUserId,order.getUserId()).in(Cart::getGoodsId, neworder.getGoodsIds().split(",")));
		List<Address> addressList;
		//huoqudizshifouweikong
		if(StringUtils.isNotEmpty(order.getAddressId())){
			addressList = addressService.list(Wrappers.<Address>query().lambda().eq(Address::getUserId, order.getUserId()).eq(Address::getId,order.getAddressId()).orderByDesc(Address::getIsDefault));
		}else{
			addressList = addressService.list(Wrappers.<Address>query().lambda().eq(Address::getUserId, order.getUserId()).orderByDesc(Address::getIsDefault));
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("allPrise", neworder.getAllprice());
		resultMap.put("goodsList", carList);
		resultMap.put("address", addressList);
		return R.ok(resultMap);
	}

}
