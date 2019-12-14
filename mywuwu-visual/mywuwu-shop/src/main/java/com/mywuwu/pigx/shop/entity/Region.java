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

package com.mywuwu.pigx.shop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author lianglele
 * @date 2019-08-26 22:22:44
 */
@Data
@TableName("shop_region")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Region extends Model<Region> {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@ApiModelProperty(value = "")
	private Integer id;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String name;
	/**
	 *
	 */
	@TableId
	@ApiModelProperty(value = "")
	private Integer parent_id;
	/**
	 *
	 */
	@TableId
	@ApiModelProperty(value = "")
	private Integer type;	/**
	 *
	 */
	@TableId
	@ApiModelProperty(value = "")
	private Integer agencyId;
}
