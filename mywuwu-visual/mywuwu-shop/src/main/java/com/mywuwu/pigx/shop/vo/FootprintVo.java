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

package com.mywuwu.pigx.shop.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 用户足迹
 * @date 2019-08-26 22:22:23
 */
@Data
@ApiModel(value = "")
public class FootprintVo {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(value = "主键")
	private Integer id;
	/**
	 * 会员Id
	 */
	@ApiModelProperty(value = "会员Id")
	private Integer userId;
	/**
	 * 商品id
	 */
	@ApiModelProperty(value = "商品id")
	private Integer goodsId;
	/**
	 * 记录时间
	 */
	@ApiModelProperty(value = "记录时间")
	private Integer addTime;
	/**
	 * 转发人
	 */
	@ApiModelProperty(value = "转发人")
	private Integer referrer;
	/**
	 * 商品名称
	 */
	@ApiModelProperty(value = "商品名称")
	private String name;
	/**
	 * 商品列表图
	 */
	@ApiModelProperty(value = "商品列表图")
	private String listPicUrl;
	/**
	 * 零售价格
	 */
	@ApiModelProperty(value = "零售价格")
	private Double retailPrice;

	/**
	 * 商品简介
	 */
	@ApiModelProperty(value="商品简介")
	private String goodsBrief;
}
