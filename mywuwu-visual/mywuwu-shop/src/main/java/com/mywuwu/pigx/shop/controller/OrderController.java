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
import com.mywuwu.pigx.shop.entity.Order;
import com.mywuwu.pigx.shop.entity.dto.OrderTo;
import com.mywuwu.pigx.shop.service.OrderService;
import com.mywuwu.pigx.shop.vo.OrderVo;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * @author pigx code generator
 * @date 2019-08-26 22:22:44
 */
@RestController
@AllArgsConstructor
@RequestMapping("/order")
@Api(value = "order", tags = "订单管理")
public class OrderController {

	private final OrderService orderService;

	/**
	 * 分页查询
	 *
	 * @param page  分页对象
	 * @param order
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R getNideshopOrderPage(Page page, Order order) {
		return R.ok(orderService.page(page, Wrappers.query(order)));
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
		return R.ok(orderService.getById(id));
	}

	/**
	 * 新增
	 *
	 * @param order
	 * @return R
	 */
	@ApiOperation(value = "新增", notes = "新增")
	@SysLog("新增")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('nideshoporder_add')")
	public R save(@RequestBody Order order) {
		return R.ok(orderService.save(order));
	}

	/**
	 * 修改
	 *
	 * @param order
	 * @return R
	 */
	@ApiOperation(value = "修改", notes = "修改")
	@SysLog("修改")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('nideshoporder_edit')")
	public R updateById(@RequestBody Order order) {
		return R.ok(orderService.updateById(order));
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
	@PreAuthorize("@pms.hasPermission('nideshoporder_del')")
	public R removeById(@PathVariable Integer id) {
		return R.ok(orderService.removeById(id));
	}

	/**
	 * 客户下单
	 *
	 * @param order 订单
	 * @return R
	 */
	@ApiOperation(value = "下单", notes = "下单")
	@SysLog("下单")
	@PostMapping("/submit")
	public R saveOrder(@RequestBody OrderTo order) {
		return orderService.saveUserOrderInfo(order);
	}

	/**
	 * 获取订单列表
	 *
	 * @return R
	 */
	@ApiOperation(value = "获取订单列表", notes = "获取订单列表")
	@GetMapping("/list")
	public R selectOrderList() {
		return orderService.selectOrderList();
	}
}
