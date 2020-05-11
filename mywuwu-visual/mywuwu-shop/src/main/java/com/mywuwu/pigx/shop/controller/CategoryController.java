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

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.log.annotation.SysLog;
import com.mywuwu.pigx.shop.entity.Category;
import com.mywuwu.pigx.shop.service.CategoryService;
import com.mywuwu.pigx.shop.service.GoodsService;
import com.mywuwu.pigx.shop.vo.CategoryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * @author lianglele
 * @date 2019-08-26 22:23:32
 */
@RestController
@AllArgsConstructor
@RequestMapping("/category")
@Api(value = "category", tags = "分类")
public class CategoryController {

	private final CategoryService categoryService;


	/**
	 * 分页查询
	 *
	 * @param page     分页对象
	 * @param category
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R getNideshopCategoryPage(Page page, Category category) {
		return R.ok(categoryService.page(page, Wrappers.query(category)));
	}

	/**
	 * 通过show_index查询
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/categoryNav")
	public R getShowIndex(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Category category = categoryService.getOne(Wrappers.<Category>query().lambda().eq(Category::getShowIndex, id).eq(Category::getLevel, "L1"));
		map.put("currentNav", category);
		map.put("data", categoryService.list(Wrappers.<Category>query().lambda().eq(Category::getParentId, 0)));
		return R.ok(map);
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

		CategoryVo categoryVo = new CategoryVo();
		BeanUtil.copyProperties(categoryService.getById(id), categoryVo);
		Category category = new Category();
		category.setParentId(id);
		categoryVo.setSubList(categoryService.queryList(category));
		return R.ok(categoryVo);
	}

	/**
	 * 新增
	 *
	 * @param category
	 * @return R
	 */
	@ApiOperation(value = "新增", notes = "新增")
	@SysLog("新增")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('nideshopcategory_add')")
	public R save(@RequestBody Category category) {
		return R.ok(categoryService.save(category));
	}

	/**
	 * 修改
	 *
	 * @param category
	 * @return R
	 */
	@ApiOperation(value = "修改", notes = "修改")
	@SysLog("修改")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('nideshopcategory_edit')")
	public R updateById(@RequestBody Category category) {
		return R.ok(categoryService.updateById(category));
	}

	/**
	 * 通过id删除
	 *R
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除", notes = "通过id删除")
	@SysLog("通过id删除")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('nideshopcategory_del')")
	public R removeById(@PathVariable Integer id) {
		return R.ok(categoryService.removeById(id));
	}


	/**
	 * 分页查询
	 *
	 * @param category
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据分类条件查询查询")
	@GetMapping("/index")
	public R getCategoryList(Category category) {
		return R.ok(categoryService.queryList(category));
	}


}
