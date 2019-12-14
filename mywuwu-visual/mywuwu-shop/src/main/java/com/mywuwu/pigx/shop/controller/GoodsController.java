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

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.log.annotation.SysLog;
import com.mywuwu.pigx.common.security.service.PigxUser;
import com.mywuwu.pigx.common.security.util.SecurityUtils;
import com.mywuwu.pigx.shop.entity.*;
import com.mywuwu.pigx.shop.entity.dto.GoodsDto;
import com.mywuwu.pigx.shop.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author pigx code generator
 * @date 2019-08-26 22:22:37
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/goods")
@Api(value = "goods", tags = "商品")
public class GoodsController {

	private final GoodsService goodsService;

	private final CategoryService categoryService;

	private final GoodsSpecificationService goodsSpecificationService;

	private final ProductService productService;

	private final GoodsGalleryService goodsGalleryService;

	private final GoodsIssueService goodsIssueService;

	private final BrandService brandService;

	private final AttributeService attributeService;

	private final GoodsAttributeService goodsAttributeService;

	/**
	 * 分页查询
	 *
	 * @param page  分页对象
	 * @param goods
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R getNideshopGoodsPage(Page page, Goods goods) {
		return R.ok(goodsService.page(page, Wrappers.query(goods)));
	}

	/**
	 * 根据分类标示查询
	 *
	 * @param goodsDto
	 * @return
	 */
	@ApiOperation(value = "根据分类查询", notes = "根据分类查询")
	@GetMapping("/goodsList")
	public R queryList(GoodsDto goodsDto) {
		try {
			Map<String, Object> map = new HashMap<>();

			if (goodsDto != null && goodsDto.getCategoryId() != null) {

				map.put("currentNav", categoryService.getById(goodsDto.getCategoryId()));
			}


			map.put("data", goodsService.queryList(goodsDto));

			return R.ok(map);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}


	/**
	 * 通过id查询
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/detailaction")
	public R getById(Integer id) {
		Map<String, Object> map = new HashMap<>();

		//查询当前用户购物车
		PigxUser user = SecurityUtils.getUser();

		Goods goods = goodsService.getById(id);
		map.put("info", goods);

		List<GoodsSpecificationEntity> goodsSpecificationEntityList = goodsSpecificationService.list(Wrappers.<GoodsSpecificationEntity>query().lambda().eq(GoodsSpecificationEntity::getGoodsId, id));
		map.put("specificationList", goodsSpecificationEntityList);

		List<Product> productList = productService.list(Wrappers.<Product>query().lambda().eq(Product::getGoodsId, id));
		map.put("productList", productList);

		List<GoodsGallery> goodsGalleryList = goodsGalleryService.list(Wrappers.<GoodsGallery>query().lambda().eq(GoodsGallery::getGoodsId, id));
		map.put("gallery", goodsGalleryList);

		List<GoodsIssue> goodsIssueList = goodsIssueService.list();
		map.put("issue", goodsIssueList);

		Brand brand = brandService.getById(goods.getBrandId());
		map.put("brand", brand);

		List<GoodsAttribute> goodsAttributeList = goodsAttributeService.list(Wrappers.<GoodsAttribute>query().lambda().eq(GoodsAttribute::getGoodsId, id));

		List<Integer> attrIds = goodsAttributeList.stream().map(a -> a.getAttributeId()).collect(Collectors.toList());

		List<Attribute> attributeList = null;
		if (attrIds != null && attrIds.size() > 0) {

			attributeList = attributeService.list(Wrappers.<Attribute>query().orderByAsc("id").lambda().in(Attribute::getId, attrIds));
		}

		if (attributeList != null && attributeList.size() > 0) {
			attributeList.stream().forEach(att -> {
				goodsAttributeList.stream().filter(a -> a.getAttributeId() == att.getId()).forEach(a -> {
					if (StrUtil.isNotEmpty(a.getValue())) {
						att.setValue(a.getValue());
					}
				});

			});

		}


		map.put("attribute", attributeList);
		map.put("allnumber", goodsGalleryList.size());
		map.put("collected", true);


		return R.ok(map);
	}

	/**
	 * 新增
	 *
	 * @param goods
	 * @return R
	 */
	@ApiOperation(value = "新增", notes = "新增")
	@SysLog("新增")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('nideshopgoods_add')")
	public R save(@RequestBody Goods goods) {
		return R.ok(goodsService.save(goods));
	}

	/**
	 * 修改
	 *
	 * @param goods
	 * @return R
	 */
	@ApiOperation(value = "修改", notes = "修改")
	@SysLog("修改")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('nideshopgoods_edit')")
	public R updateById(@RequestBody Goods goods) {
		return R.ok(goodsService.updateById(goods));
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
	@PreAuthorize("@pms.hasPermission('nideshopgoods_del')")
	public R removeById(@PathVariable Integer id) {
		return R.ok(goodsService.removeById(id));
	}


	/**
	 * 获取销售商品的数量
	 *
	 * @return R
	 */
	@ApiOperation(value = "获取销售商品的数量", notes = "获取销售商品的数量")
	@GetMapping("/count")
	public R selectGoodsCount() {
		return R.ok(goodsService.count(Wrappers.<Goods>query().lambda().eq(Goods::getIsDelete, 0).eq(Goods::getIsOnSale, 1)));
	}

	/**
	 * 获取sku信息，用于购物车编辑时选择规格
	 *
	 * @returns {Promise.<Promise|PreventPromise|void>}
	 */
	@ApiOperation(value = "获取sku信息", notes = "获取sku信息")
	@GetMapping("/sku/{id}")
	public R selectSku(@PathVariable Integer id) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("specificationList", goodsSpecificationService.list(Wrappers.<GoodsSpecificationEntity>query().lambda().eq(GoodsSpecificationEntity::getGoodsId, id)));
		resultMap.put("specificationList", productService.list(Wrappers.<Product>query().lambda().eq(Product::getGoodsId, id)));

		return R.ok(resultMap);
	}

}
