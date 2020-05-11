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

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.shop.entity.Collect;
import com.mywuwu.pigx.shop.entity.Goods;
import com.mywuwu.pigx.shop.mapper.CollectMapper;
import com.mywuwu.pigx.shop.service.CollectService;
import com.mywuwu.pigx.shop.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lianglele
 * @date 2019-08-26 22:23:55
 */
@Service
@AllArgsConstructor
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

	private final GoodsService goodsService;

	@Override
	public R selectCollectList(Collect collect) {
		return R.ok(baseMapper.selectCollectList(collect));
	}

	@Override
	public R selectCollectGoods(Collect collect){
		Map<String, Object> resultMap = new HashMap<>();

		List<Integer> goodsIds = new ArrayList<>();
		if(this.count(Wrappers.<Collect>query().lambda().eq(Collect::getUserId,collect.getUserId()))> 0){

			goodsIds =  this.list(Wrappers.<Collect>query().lambda().eq(Collect::getUserId,collect.getUserId())).stream().map(Collect::getValueId).collect(Collectors.toList());

			resultMap.put("collectGoodsList", goodsService.list(Wrappers.<Goods>query().lambda().in(Goods::getId, goodsIds)));
		}
		return R.ok(resultMap);
	}
}
