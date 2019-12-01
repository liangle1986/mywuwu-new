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

package com.mywuwu.pigx.shop.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.log.annotation.SysLog;
import com.mywuwu.pigx.common.security.service.PigxUser;
import com.mywuwu.pigx.common.security.util.SecurityUtils;
import com.mywuwu.pigx.shop.entity.Cart;
import com.mywuwu.pigx.shop.service.CartService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


/**
 * @author pigx code generator
 * @date 2019-08-27 20:54:53
 */
@RestController
@AllArgsConstructor
@RequestMapping("/cart")
@Api(value = "cart", tags = "购物车")
public class CartController {

	private final CartService cartService;

	/**
	 * 分页查询
	 *
	 * @param page 分页对象
	 * @param cart
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R getNideshopCartPage(Page page, Cart cart) {
		return R.ok(cartService.page(page, Wrappers.query(cart)));
	}


	/**
	 * 通过id查询
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}")
	public R getById(@PathVariable("id") Integer id) {
		return R.ok(cartService.getById(id));
	}

	/**
	 * 新增
	 *
	 * @param cart
	 * @return R
	 */
	@ApiOperation(value = "新增", notes = "新增")
	@SysLog("新增")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('nideshopcart_add')")
	public R save(@RequestBody Cart cart) {
		return R.ok(cartService.save(cart));
	}

	/**
	 * 修改
	 *
	 * @param cart
	 * @return R
	 */
	@ApiOperation(value = "修改", notes = "修改")
	@SysLog("修改")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('nideshopcart_edit')")
	public R updateById(@RequestBody Cart cart) {
		return R.ok(cartService.updateById(cart));
	}

	/**
	 * 通过id删除
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除", notes = "通过id删除")
	@SysLog("通过id删除")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('nideshopcart_del')")
	public R removeById(@PathVariable Integer id) {
		return R.ok(cartService.removeById(id));
	}


	/**
	 * chax dangq
	 *
	 * @return
	 */
	@ApiOperation(value = "根据用户标示获取购物车商品", notes = "根据用户标示获取购物车商品")
	@GetMapping("/cartList")
	public R selectCartList() {
		PigxUser user = SecurityUtils.getUser();
		if (user != null) {
			R.ok(cartService.list(Wrappers.<Cart>query().lambda().eq(Cart::getUserId, user.getId())));
		}
		return R.ok(new ArrayList<Cart>());
	}

}
