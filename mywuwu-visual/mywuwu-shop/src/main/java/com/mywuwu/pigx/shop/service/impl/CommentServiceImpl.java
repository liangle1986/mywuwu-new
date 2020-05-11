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
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.shop.entity.Comment;
import com.mywuwu.pigx.shop.entity.dto.CommentDto;
import com.mywuwu.pigx.shop.mapper.CommentMapper;
import com.mywuwu.pigx.shop.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lianglele
 * @date 2019-08-26 22:24:07
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {


	@Override
	public R getCountComment(Integer typeId, Integer valueId) {
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("hasPicCount", baseMapper.getCountComment(typeId, valueId));
		resultMap.put("allCount", baseMapper.selectCount(Wrappers.<Comment>query().lambda().eq(Comment::getTypeId, typeId).eq(Comment::getValueId, valueId)));
		return R.ok(resultMap);
	}


	@Override
	public R selectCommentList(Page page, CommentDto commentDto) {
		if (commentDto.getShowType() != 1) {
			return R.ok(baseMapper.selectCommentList(page, commentDto));
		} else {
			return R.ok(baseMapper.selectPage(page, Wrappers.<Comment>query().lambda().eq(Comment::getTypeId, commentDto.getTypeId()).eq(Comment::getValueId, commentDto.getValueId())));
		}
	}
}
