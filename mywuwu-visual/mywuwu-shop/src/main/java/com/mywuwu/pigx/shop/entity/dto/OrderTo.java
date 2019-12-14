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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author pigx code generator
 * @date 2019-08-26 22:22:44
 */
@Data
@ApiModel(value = "")
public class OrderTo {
	private static final long serialVersionUID = 1L;


	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer userId;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer goodsId;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer number;

	/**
	 * 商品总价
	 */
	@ApiModelProperty(value = "商品总价")
	private Double price;

	/**
	 * 微信开放标
	 */
	@ApiModelProperty(value = "")
	private String opentId;

}
