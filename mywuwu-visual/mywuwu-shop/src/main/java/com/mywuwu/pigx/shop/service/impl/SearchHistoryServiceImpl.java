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

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.shop.entity.Goods;
import com.mywuwu.pigx.shop.entity.Keywords;
import com.mywuwu.pigx.shop.entity.SearchHistory;
import com.mywuwu.pigx.shop.entity.dto.SearchDto;
import com.mywuwu.pigx.shop.mapper.SearchHistoryMapper;
import com.mywuwu.pigx.shop.service.GoodsService;
import com.mywuwu.pigx.shop.service.KeywordsService;
import com.mywuwu.pigx.shop.service.SearchHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author lianglele
 * @date 2019-08-26 22:22:05
 */
@Service
@AllArgsConstructor
public class SearchHistoryServiceImpl extends ServiceImpl<SearchHistoryMapper, SearchHistory> implements SearchHistoryService {

	private final KeywordsService keywordsService;

	private final GoodsService goodsService;





	@Override
	public R selectSearchInfo(SearchDto searchDto){

		Map<String, Object> resultObj = new HashMap();
		//获取用户嘻嘻
//		PigxUser user = SecurityUtils.getUser();
		List<Keywords> keywordsEntityList = keywordsService.list(Wrappers.<Keywords>query().lambda().eq(Keywords::getIsDefault, 1).last("limit 1"));

		//取一个
		Keywords keywords = keywordsEntityList != null && keywordsEntityList.size() > 0 ? keywordsEntityList.get(0) : null;

		//取出热闹关键词
		List<Keywords> hotKeywordList = keywordsService.list(Wrappers.<Keywords>query().select("keyword,max(is_hot)").lambda().groupBy(Keywords::getKeyword).last("limit 10"));

//		page = new Page();
		SearchHistory search = new SearchHistory();
		search.setUserId(searchDto.getOpenId());
		List<SearchHistory> historyList = this.list(Wrappers.<SearchHistory>query().lambda().eq(SearchHistory::getUserId, searchDto.getOpenId()));
//				IPage<SearchHistory> historyPage = this.page(page, Wrappers.<SearchHistory>query(search).orderByAsc("id"));

		resultObj.put("hotKeywordList", hotKeywordList);
		resultObj.put("defaultKeyword", keywords);
		resultObj.put("historyData",historyList);
		return R.ok(resultObj);
	}

	@Override
	public R selectHelperList(SearchDto searchDto){

		Map<String, Object> resultObj = new HashMap();
		String orderBy;

		if(StringUtils.isNotEmpty(searchDto.getOrder())){
			orderBy = "id";
		} else{
			orderBy = "retail_price";
		}
		List<Goods> goodsList = goodsService.list(Wrappers.<Goods>query().orderByDesc(orderBy).lambda().like(Goods::getName, searchDto.getKeyword()).last("limit 10"));
		resultObj.put("keywords",goodsList);
		return R.ok(resultObj);
	}

}
