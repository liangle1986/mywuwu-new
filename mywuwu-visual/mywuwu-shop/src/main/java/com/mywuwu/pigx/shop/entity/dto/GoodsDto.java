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

package com.mywuwu.pigx.shop.entity.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author lianglele
 * @date 2019-08-26 22:22:37
 */
@Data
@ApiModel(value = "")
public class GoodsDto {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@ApiModelProperty(value = "")
	private Integer id;
	/**
	 *分类id
	 */
	@ApiModelProperty(value = "分类id")
	private Integer categoryId;
	/**
	 *新品首发
	 */
	@ApiModelProperty(value = "新品首发")
	private Integer isNew;
	/**
	 *人气推荐
	 */
	@ApiModelProperty(value = "人气推荐")
	private Integer isHot;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String name;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String order;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String orderField;


}
