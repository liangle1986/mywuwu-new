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
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.log.annotation.SysLog;
import com.mywuwu.pigx.shop.entity.Topic;
import com.mywuwu.pigx.shop.entity.TopicCategory;
import com.mywuwu.pigx.shop.service.TopicCategoryService;
import com.mywuwu.pigx.shop.service.TopicService;
import com.mywuwu.pigx.shop.vo.TopicVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * @author lianglele
 * @date 2019-08-26 22:21:34
 */
@RestController
@AllArgsConstructor
@RequestMapping("/topic")
@Api(value = "topic", tags = "管理")
public class TopicController {

	private final TopicService topicService;

	/**
	 * 分页查询
	 *
	 * @param page  分页对象
	 * @param topic
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R getNideshopTopicCategoryPage(Page page, Topic topic) {
		return R.ok(topicService.queryPageList(page, topic));
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
		Topic topic = topicService.getById(id);

		TopicVo topicVo = new TopicVo();
		BeanUtil.copyProperties(topic, topicVo);

		if (topic != null && topic.getTopicCategoryId() != null) {
			topicVo.setRecommendList(topicService.list(Wrappers.<Topic>query().lambda().eq(Topic::getTopicCategoryId, topic.getTopicCategoryId())));
		}
		return R.ok(topicVo);
	}

	/**
	 * 新增
	 *
	 * @param topic
	 * @return R
	 */
	@ApiOperation(value = "新增", notes = "新增")
	@SysLog("新增")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('topic_add')")
	public R save(@RequestBody Topic topic) {
		return R.ok(topicService.save(topic));
	}

	/**
	 * 修改
	 *
	 * @param topic
	 * @return R
	 */
	@ApiOperation(value = "修改", notes = "修改")
	@SysLog("修改")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('nideshoptopiccategory_edit')")
	public R updateById(@RequestBody Topic topic) {
		return R.ok(topicService.updateById(topic));
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
	@PreAuthorize("@pms.hasPermission('topic_del')")
	public R removeById(@PathVariable Integer id) {
		return R.ok(topicService.removeById(id));
	}

}
