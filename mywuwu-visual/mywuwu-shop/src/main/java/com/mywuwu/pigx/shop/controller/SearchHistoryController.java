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

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.log.annotation.SysLog;
import com.mywuwu.pigx.common.security.service.PigxUser;
import com.mywuwu.pigx.common.security.util.SecurityUtils;
import com.mywuwu.pigx.shop.entity.Keywords;
import com.mywuwu.pigx.shop.entity.SearchHistory;
import com.mywuwu.pigx.shop.service.KeywordsService;
import com.mywuwu.pigx.shop.service.SearchHistoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author pigx code generator
 * @date 2019-08-26 22:22:05
 */
@RestController
@AllArgsConstructor
@RequestMapping("/search")
@Api(value = "search", tags = "搜索")
public class SearchHistoryController {

	private final KeywordsService keywordsService;
	private final SearchHistoryService searchHistoryService;

	/**
	 * 分页查询
	 *
	 * @param page          分页对象
	 * @param searchHistory
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R getNideshopSearchHistoryPage(Page page, SearchHistory searchHistory) {
		return R.ok(searchHistoryService.page(page, Wrappers.query(searchHistory)));
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
		return R.ok(searchHistoryService.getById(id));
	}

	/**
	 * 新增
	 *
	 * @param searchHistory
	 * @return R
	 */
	@ApiOperation(value = "新增", notes = "新增")
	@SysLog("新增")
	@PostMapping
	public R save(@RequestBody SearchHistory searchHistory) {
		return R.ok(searchHistoryService.save(searchHistory));
	}

	/**
	 * 修改
	 *
	 * @param searchHistory
	 * @return R
	 */
	@ApiOperation(value = "修改", notes = "修改")
	@SysLog("修改")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('nideshopsearchhistory_edit')")
	public R updateById(@RequestBody SearchHistory searchHistory) {
		return R.ok(searchHistoryService.updateById(searchHistory));
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
	@PreAuthorize("@pms.hasPermission('nideshopsearchhistory_del')")
	public R removeById(@PathVariable Integer id) {
		return R.ok(searchHistoryService.removeById(id));
	}


	/**
	 * 通过id查询
	 *
	 * @return R
	 */
	@ApiOperation(value = "查询", notes = "搜索")
	@GetMapping("/index")
	public R index(String opentId) {

		Map<String, Object> resultObj = new HashMap();
		//获取用户嘻嘻
//		PigxUser user = SecurityUtils.getUser();
		Page page = new Page();
		page.setSize(1);
		List<Keywords> keywordsEntityList = keywordsService.list(Wrappers.<Keywords>query().orderByAsc("id").lambda().eq(Keywords::getIsDefault, 1).last("limit 1"));

		//取一个
		Keywords keywords = keywordsEntityList != null && keywordsEntityList.size() > 0 ? keywordsEntityList.get(0) : null;

		//取出热闹关键词
		List<Keywords> hotKeywordList = keywordsService.list(Wrappers.<Keywords>query().select("keyword,max(is_hot)").lambda().groupBy(Keywords::getKeyword).last("limit 10"));

		page = new Page();
		SearchHistory search = new SearchHistory();
		search.setUserId(opentId);
		IPage<SearchHistory> historyPage = searchHistoryService.page(page, Wrappers.<SearchHistory>query(search).orderByAsc("id"));

		resultObj.put("hotKeywordList", hotKeywordList);
		resultObj.put("defaultKeyword", keywords);
		resultObj.put("historyData", historyPage != null && historyPage.getRecords() != null && historyPage.getRecords().size() > 0 ? historyPage.getRecords() : null);
		return R.ok(resultObj);
	}


	/**
	 * 　　helper
	 */
	@ApiOperation(value = "搜索商品")
	@GetMapping("helper")
	public Object helper(String keyword) {
		Keywords keywords = new Keywords();
		keywords.setKeyword(keyword);
		Page page = new Page<>();
		IPage<Keywords> keywordsList = keywordsService.page(page, Wrappers.query(keywords));
		return R.ok(keywordsList != null ? keywordsList.getRecords() : null);
	}

	/**
	 * 通过id删除
	 *
	 * @param userid id
	 * @return R
	 */
	@ApiOperation(value = "通过userid删除", notes = "通过userid删除")
	@SysLog("通过id删除")
	@DeleteMapping("/clearhistory/{opentId}")
	public R removeByUserId(@PathVariable("opentId") String opentId) {
		return R.ok(searchHistoryService.remove(Wrappers.<SearchHistory>query().lambda().eq(SearchHistory::getUserId, opentId)));
	}

	/**
	 * 添加历史记录
	 *
	 * @param id
	 * @return R
	 */
	@ApiOperation(value = "小程序添加历史记录", notes = "添加历史记录")
	@SysLog("添加历史记录")
	@DeleteMapping("/addHistory")
	public R addHistory(SearchHistory history) {
		//获取是否存在
		if (searchHistoryService.count(Wrappers.query(history)) > 0) {
			return R.ok();
		} else {
			history.setAddTime(Math.toIntExact(new Date().getTime() / 1000));
			return R.ok(searchHistoryService.save(history));
		}

	}


}
