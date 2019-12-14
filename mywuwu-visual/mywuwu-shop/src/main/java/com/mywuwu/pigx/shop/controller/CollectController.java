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
import com.mywuwu.pigx.common.security.util.SecurityUtils;
import com.mywuwu.pigx.shop.entity.Collect;
import com.mywuwu.pigx.shop.service.CollectService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * @author 个人收藏
 * @date 2019-08-26 22:23:55
 */
@RestController
@AllArgsConstructor
@RequestMapping("/collect")
@Api(value = "collect", tags = "收藏")
public class CollectController {

	private final CollectService collectService;

	/**
	 * 分页查询
	 *
	 * @param page    分页对象
	 * @param collect
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R getNideshopCollectPage(Page page, Collect collect) {
		return R.ok(collectService.page(page, Wrappers.query(collect)));
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
		return R.ok(collectService.getById(id));
	}

	/**
	 * 新增
	 *
	 * @param collect
	 * @return R
	 */
	@ApiOperation(value = "新增", notes = "新增")
	@SysLog("新增")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('nideshopcollect_add')")
	public R save(@RequestBody Collect collect) {
		return R.ok(collectService.save(collect));
	}

	/**
	 * 修改
	 *
	 * @param collect
	 * @return R
	 */
	@ApiOperation(value = "修改", notes = "修改")
	@SysLog("修改")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('nideshopcollect_edit')")
	public R updateById(@RequestBody Collect collect) {
		return R.ok(collectService.updateById(collect));
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
	@PreAuthorize("@pms.hasPermission('nideshopcollect_del')")
	public R removeById(@PathVariable Integer id) {
		return R.ok(collectService.removeById(id));
	}


	/**
	 * 查询收藏夹商品
	 *
	 * @param collect id
	 * @return R
	 */
	@ApiOperation(value = " 查询收藏夹商品", notes = " 查询收藏夹商品")
	@GetMapping("/index")
	public R getById(Collect collect) {
		return collectService.selectCollectList(collect);
	}


	/**
	 * 添加收藏或者取消收藏
	 *
	 * @param collect
	 * @return R
	 */
	@ApiOperation(value = "添加收藏或者取消收藏", notes = "添加收藏或者取消收藏")
	@SysLog("添加收藏或者取消收藏")
	@PostMapping("addordelete")
	public R addordelete(@RequestBody Collect collect) {

		collect.setUserId(SecurityUtils.getUser().getId());
		Collect showCollect = collectService.getOne(Wrappers.query(collect));
		//取消
		if (showCollect != null) {
			return R.ok(collectService.removeById(showCollect.getId()), "	取消收藏成功");
		} else {
			collect.setAddTime((int) (new Date().getTime() / 1000));
			return R.ok(collectService.save(collect), "收藏成功");
		}
	}


}
