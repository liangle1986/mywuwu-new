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
import com.mywuwu.pigx.shop.entity.Comment;
import com.mywuwu.pigx.shop.entity.dto.CommentDto;
import com.mywuwu.pigx.shop.service.CommentService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * @author mywuwu 评论
 * @date 2019-08-26 22:24:07
 */
@RestController
@AllArgsConstructor
@RequestMapping("/comment")
@Api(value = "comment", tags = "评论")
public class CommentController {

	private final CommentService commentService;

	/**
	 * 分页查询
	 *
	 * @param page    分页对象
	 * @param comment
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R getNideshopCommentPage(Page page, Comment comment) {
		return R.ok(commentService.page(page, Wrappers.query(comment)));
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
		return R.ok(commentService.getById(id));
	}

	/**
	 * 新增
	 *
	 * @param comment
	 * @return R
	 */
	@ApiOperation(value = "新增", notes = "新增")
	@SysLog("新增")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('nideshopcomment_add')")
	public R save(@RequestBody Comment comment) {
		return R.ok(commentService.save(comment));
	}

	/**
	 * 修改
	 *
	 * @param comment
	 * @return R
	 */
	@ApiOperation(value = "修改", notes = "修改")
	@SysLog("修改")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('nideshopcomment_edit')")
	public R updateById(@RequestBody Comment comment) {
		return R.ok(commentService.updateById(comment));
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
	@PreAuthorize("@pms.hasPermission('nideshopcomment_del')")
	public R removeById(@PathVariable Integer id) {
		return R.ok(commentService.removeById(id));
	}


	/**
	 * 发表评论
	 *
	 * @param comment 脆响
	 * @return R
	 */
	@ApiOperation(value = "发表评论", notes = "发表评论")
	@SysLog("发表评论")
	@PostMapping("/saveComment")
	public R saveComment(@RequestBody Comment comment) {
		return R.ok(commentService.save(comment));
	}


	/**
	 * 获取评论数量
	 *
	 * @param typeId 类型标示
	 * @return R
	 * @Param valueId 商品标示
	 */
	@ApiOperation(value = "获取评论数量", notes = "获取评论数量")
	@GetMapping("/{typeId}/{valueId}")
	public R getCount(@PathVariable("typeId") Integer typeId, @PathVariable("typeId") Integer valueId) {
		return commentService.getCountComment(typeId, valueId);
	}

	/**
	 * 获取评论数量
	 *
	 * @param commentDto 查询参数
	 * @return R
	 */
	@ApiOperation(value = "获取评论数量", notes = "获取评论数量")
	@GetMapping("/pageList}")
	public R selectCommentList(Page page, CommentDto commentDto) {
		return commentService.selectCommentList(page, commentDto);
	}

}
