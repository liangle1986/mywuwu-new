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

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.security.service.PigxUser;
import com.mywuwu.pigx.common.security.util.SecurityUtils;
import com.mywuwu.pigx.shop.entity.*;
import com.mywuwu.pigx.shop.mapper.CartMapper;
import com.mywuwu.pigx.shop.service.*;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author pigx code generator
 * @date 2019-08-27 20:54:53
 */
@Service
@AllArgsConstructor
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

	private final GoodsService goodsService;
	private final ProductService productService;
	private final GoodsSpecificationService goodsSpecificationService;
	private final AddressService addressService;
	private final UserCouponService couponService;

	@Override
	public R selectCartList() {
		try {
			PigxUser user = SecurityUtils.getUser();

			Map<String, Object> resultMap = new HashMap<>();

			// 获取购物车统计信息
			AtomicInteger goodsCount = new AtomicInteger();
			AtomicReference<Double> goodsAmount = new AtomicReference<>(0.00);
			AtomicInteger checkedGoodsCount = new AtomicInteger();
			AtomicReference<Double> checkedGoodsAmount = new AtomicReference<>(0.00);
			if (user != null) {
				List<Cart> cartList = baseMapper.selectList(Wrappers.<Cart>query().lambda().eq(Cart::getUserId, user.getId()).eq(Cart::getSessionId, 1));
				resultMap.put("cartList", cartList);

				cartList.stream().forEach(c -> {
					goodsCount.addAndGet(c.getNumber());
					goodsAmount.updateAndGet(v -> v + c.getNumber() * c.getRetailPrice());
					if (c.getChecked() != null && c.getChecked() > 0) {
						checkedGoodsCount.addAndGet(c.getNumber());
						checkedGoodsAmount.updateAndGet(v -> v + c.getNumber() * c.getRetailPrice());
					}

					// 查找商品的图片
					c.setListPicUrl(goodsService.getById(c.getGoodsId()).getListPicUrl());
				});
				resultMap.put("goodsCount", goodsCount);
				resultMap.put("goodsAmount", goodsAmount);
				resultMap.put("checkedGoodsCount", checkedGoodsCount);
				resultMap.put("checkedGoodsAmount", checkedGoodsAmount);

			}
			return R.ok(resultMap);
		} catch (Exception e) {
			return R.failed("查询失败。");
		}
	}

	@Override
	public R addCartGoods(Cart cart) {
		// 判断商品是否可以购买
		Goods goods = goodsService.getById(cart.getGoodsId());
		if (goods == null || goods.getIsDelete() == 1) {
			return R.failed(400, "商品已下架");
		}

		// 取得规格的信息,判断规格库存
		Product productInfo = productService.getOne(Wrappers.<Product>query().lambda().eq(Product::getGoodsId, goods.getId()).eq(Product::getId, cart.getProductId()));
		if (productInfo == null || productInfo.getGoodsNumber() < cart.getNumber()) {
			return R.failed(400, "库存不足");
		}

		// 判断购物车中是否存在此规格商品
		Cart cartInfo = baseMapper.selectOne(Wrappers.<Cart>query().lambda().eq(Cart::getGoodsId, goods.getId()).eq(Cart::getProductId, productInfo.getId()));
		if (cartInfo == null) {
			// 添加操作

			// 添加规格名和值
			List<String> goodsSepcifitionValue = null;
			if (!StrUtil.isEmpty(productInfo.getGoodsSpecificationIds())) {

				List<GoodsSpecificationEntity> goodsSpecif = goodsSpecificationService.list(Wrappers.<GoodsSpecificationEntity>query().lambda().in(GoodsSpecificationEntity::getGoodsId, Arrays.asList(productInfo.getGoodsSpecificationIds().split("_"))));
				goodsSepcifitionValue = goodsSpecif.stream().map(g -> g.getValue()).collect(Collectors.toList());

			}
			// 添加到购物车
			cart.setGoodsSn(productInfo.getGoodsSn());
			cart.setGoodsName(goods.getName());
			cart.setListPicUrl(goods.getListPicUrl());
			cart.setSessionId("1");
			cart.setUserId(SecurityUtils.getUser().getId());
			cart.setRetailPrice(productInfo.getRetailPrice());
			cart.setMarketPrice(productInfo.getRetailPrice());
			cart.setGoodsSpecifitionNameValue(goodsSepcifitionValue.stream().collect(Collectors.joining(";")));
			cart.setGoodsSpecifitionIds(productInfo.getGoodsSpecificationIds());
			cart.setChecked(1);
			baseMapper.insert(cart);
		} else {
			// 如果已经存在购物车中，则数量增加
			if (productInfo.getGoodsNumber() < (cart.getNumber() + cartInfo.getNumber())) {
				return R.failed(400, "库存不足");
			}
			cartInfo.setNumber(cart.getNumber() + cartInfo.getNumber());
			baseMapper.updateById(cartInfo);

		}
		return this.selectCartList();
	}

	@Override
	public R updateCartGoods(Cart cart) {
		// 判断商品是否可以购买
		Goods goods = goodsService.getById(cart.getGoodsId());
		if (goods == null || goods.getIsDelete() == 1) {
			return R.failed(400, "商品已下架");
		}

		// 取得规格的信息,判断规格库存
		Product productInfo = productService.getOne(Wrappers.<Product>query().lambda().eq(Product::getGoodsId, goods.getId()).eq(Product::getId, cart.getProductId()));
		if (productInfo == null || productInfo.getGoodsNumber() < cart.getNumber()) {
			return R.failed(400, "库存不足");
		}

		// 判断购物车中是否存在此规格商品
		Cart cartInfo = baseMapper.selectOne(Wrappers.<Cart>query().lambda().eq(Cart::getGoodsId, goods.getId()).eq(Cart::getProductId, productInfo.getId()));
		if (cartInfo == null) {
			// 只是更新number
			if (cartInfo.getProductId() == cart.getProductId()) {
				cartInfo.setNumber(cart.getNumber());
				baseMapper.updateById(cartInfo);
				return this.selectCartList();
			}
		}
		Cart newCartInfo = baseMapper.selectOne(Wrappers.<Cart>query().lambda().eq(Cart::getGoodsId, goods.getId()).eq(Cart::getProductId, productInfo.getId()));
		if (newCartInfo == null) {
			// 添加操作

			// 添加规格名和值
			List<String> goodsSepcifitionValue = null;
			if (!StrUtil.isEmpty(productInfo.getGoodsSpecificationIds())) {

				List<GoodsSpecificationEntity> goodsSpecif = goodsSpecificationService.list(Wrappers.<GoodsSpecificationEntity>query().lambda().in(GoodsSpecificationEntity::getGoodsId, Arrays.asList(productInfo.getGoodsSpecificationIds().split("_"))));
				goodsSepcifitionValue = goodsSpecif.stream().map(g -> g.getValue()).collect(Collectors.toList());


			}
			// 添加到购物车
			cart.setGoodsSn(productInfo.getGoodsSn());
			cart.setGoodsName(goods.getName());
			cart.setListPicUrl(goods.getListPicUrl());
			cart.setSessionId("1");
			cart.setUserId(SecurityUtils.getUser().getId());
			cart.setRetailPrice(productInfo.getRetailPrice());
			cart.setMarketPrice(productInfo.getRetailPrice());
			cart.setGoodsSpecifitionNameValue(goodsSepcifitionValue.stream().collect(Collectors.joining(";")));
			cart.setGoodsSpecifitionIds(productInfo.getGoodsSpecificationIds());
			cart.setChecked(1);
			baseMapper.insert(cart);
		} else {
			// 如果已经存在购物车中，则数量增加
			if (productInfo.getGoodsNumber() < (cart.getNumber() + cartInfo.getNumber())) {
				return R.failed(400, "库存不足");
			}
			cartInfo.setNumber(cart.getNumber() + cartInfo.getNumber());
			baseMapper.updateById(cartInfo);

		}
		return this.selectCartList();
	}


	/**
	 * 提交前验证订单
	 *
	 * @param addressId 地址标示
	 * @return 验证后的信息
	 */
	@Override
	public R checkoutCart(Integer addressId) {

		Map<String, Object> resultMap = new HashMap<>();
		try {

			Address chechAddr = null;
			if (addressId == null) {
				chechAddr = new Address();
				chechAddr.setIsDefault(1);
				chechAddr.setUserId(SecurityUtils.getUser().getId());
				chechAddr = addressService.getOne(Wrappers.query(chechAddr));
			} else {
				chechAddr = new Address();
				chechAddr.setId(addressId);
				chechAddr.setUserId(SecurityUtils.getUser().getId());
				chechAddr = addressService.getOne(Wrappers.query(chechAddr));
			}
			// 根据收货地址计算运费
			Double freightPrice = 0.00;

			Map<String, Object> cartMap = (Map<String, Object>) selectCartList().getData();

			// 获取要购买的商品
			List<Cart> cartList = (List<Cart>) cartMap.get("cartList");
			resultMap.put("checkedGoodsList", cartList.stream().filter(c -> c.getChecked() == 1).collect(Collectors.toList()));
			// 获取可用的优惠券信息，功能还示实现
			List<UserCoupon> couponList = couponService.list();
			Double couponPrice = 0.00; // 使用优惠券减免的金额
			// 计算订单的费用
			Double goodsTotalPrice = (Double) cartMap.get("checkedGoodsAmount"); // 商品总价
			Double orderTotalPrice = (Double) cartMap.get("checkedGoodsAmount") + freightPrice - couponPrice; // 订单的总价
			Double actualPrice = orderTotalPrice - 0.00; // 减去其它支付的金额后，要实际支付的金额


			resultMap.put("checkedAddress", chechAddr);
			resultMap.put("freightPrice", freightPrice);
			resultMap.put("checkedCoupon", "");
			resultMap.put("couponList", couponList);
			resultMap.put("couponPrice", couponPrice);
			resultMap.put("goodsTotalPrice", goodsTotalPrice);
			resultMap.put("orderTotalPrice", orderTotalPrice);
			resultMap.put("actualPrice", actualPrice);
			return R.ok(resultMap);
		} catch (Exception e) {
			return R.failed("验证订单失败");
		}

	}
}
