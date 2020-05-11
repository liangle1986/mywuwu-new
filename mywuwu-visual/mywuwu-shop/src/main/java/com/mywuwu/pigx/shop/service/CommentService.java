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

package com.mywuwu.pigx.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.shop.entity.Comment;
import com.mywuwu.pigx.shop.entity.dto.CommentDto;

/**
 * @author lianglele
 * @date 2019-08-26 22:24:07
 */
public interface CommentService extends IService<Comment> {

	/**
	 * 获取评论数量
	 *
	 * @param typeId  类型id
	 * @param valueId 商品id
	 * @return
	 */
	R getCountComment(Integer typeId, Integer valueId);

	/**
	 * 获取评论信息
	 * @param commentDto 参数
	 * @param  page 分页
	 * @return
	 */
	R selectCommentList(Page page, CommentDto commentDto);
}
