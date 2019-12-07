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

package com.mywuwu.pigx.shop.controller.home;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.security.service.PigxUser;
import com.mywuwu.pigx.common.security.util.SecurityUtils;
import com.mywuwu.pigx.shop.entity.*;
import com.mywuwu.pigx.shop.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author: lianglele
 * @date: 2019-11-09 21:54
 */
@RestController
@AllArgsConstructor
@RequestMapping("/index")
@Api(value = "home", tags = "首页接口文档")
public class HomeIndexController {

	private final AdService adService;
	private final ChannelService channelService;
	private final GoodsService goodsService;
	private final BrandService brandService;
	private final TopicService topicService;
	private final CategoryService categoryService;
	private final CartService cartService;


	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/index")
	public R index() {
		Map<String, Object> resultObj = new HashMap<>();
		List<Ad> banner = adService.list(Wrappers.<Ad>query().lambda().eq(Ad::getAdPositionId, 1));
		resultObj.put("banner", banner);

		List<Channel> channels = channelService.list(Wrappers.<Channel>query().orderByAsc("sort_order"));
		resultObj.put("channel", channels);

		Page page = new Page();
		page.setSize(7);
		Goods goods = new Goods();
		goods.setIsNew(1);
		goods.setIsDelete(0);
		IPage<Goods> newGoods = goodsService.page(page, Wrappers.<Goods>query(goods));
		resultObj.put("newGoodsList", newGoods.getRecords());

		page = new Page();
		page.setSize(5);
		goods = new Goods();
		goods.setIsHot(1);
		goods.setIsDelete(0);
		IPage<Goods> hotGoods = goodsService.page(page, Wrappers.<Goods>query(goods));
		resultObj.put("hotGoodsList", hotGoods.getRecords());

		//查询当前用户购物车
		PigxUser user = SecurityUtils.getUser();
		List<Cart> cartList = new ArrayList<>();
		if (user != null) {
			//查询列表数据
			cartList = cartService.list(Wrappers.<Cart>query().lambda().eq(Cart::getUserId, user.getId()));
		}
//		if(cartList != null && cartList.size() > 0 && hotGoods.getRecords()!= null && hotGoods.getRecords().size() > 0){
//			for (Goods good: hotGoods.getRecords()){
//				cartList.stream().map(c->{
//					if(good.getId().equals(c.getGoodsId()){
//						good.set
//					}
//				}));
//			}
//
//		}
		Brand brand = new Brand();
		brand.setIsNew(1);
		page = new Page();
		page.setSize(4);
		IPage<Brand> brandList = brandService.page(page, Wrappers.<Brand>query(brand).orderByAsc("new_sort_order"));
		resultObj.put("brandList", brandList.getRecords());

		page = new Page();
		page.setSize(3);
		IPage<Topic> topicList = topicService.page(page);
		resultObj.put("topicList", topicList.getRecords());

		Category category = new Category();
		category.setParentId(0);
		category.setName("推荐");
		List<Category> categoryList = categoryService.list(Wrappers.query(category));
		List<Map<String, Object>> newCategoryList = new ArrayList<>();

		if (categoryList != null && categoryList.size() > 0) {
			categoryList.stream().forEach(c -> {
				Category cate = new Category();
				cate.setParentId(c.getId());
				List<Category> categoryEntList = categoryService.list(Wrappers.query(cate));
				List<Integer> childCategoryIds = categoryEntList.stream().map(ch -> ch.getId()).collect(Collectors.toList());
				Page pa = new Page();
				pa.setSize(7);
				IPage<Goods> categoryGoods = goodsService.page(pa, Wrappers.<Goods>query().in("category_id", childCategoryIds));
				Map<String, Object> newCategory = new HashMap<String, Object>();
				newCategory.put("id", c.getId());
				newCategory.put("name", c.getName());
				newCategory.put("goodsList", categoryGoods);
				newCategoryList.add(newCategory);
			});
		}
		resultObj.put("categoryList", newCategoryList);
		return R.ok(resultObj);
	}
}
