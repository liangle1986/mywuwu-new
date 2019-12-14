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
import com.mywuwu.pigx.shop.entity.OrderGoods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lianglele
 * @date 2019-08-26 22:22:44
 */
@Data
@ApiModel(value = "")
public class OrderVo {
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
	private String orderSn;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String userId;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer orderStatus;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer shippingStatus;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer payStatus;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String consignee;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String country;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String province;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String city;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String district;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String address;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String mobile;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String postscript;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer shippingId;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String shippingName;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String payId;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String payName;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private BigDecimal shippingFee;
	/**
	 * 实际需要支付的金额
	 */
	@ApiModelProperty(value = "实际需要支付的金额")
	private BigDecimal actualPrice;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer integral;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private BigDecimal integralMoney;
	/**
	 * 订单总价
	 */
	@ApiModelProperty(value = "订单总价")
	private BigDecimal orderPrice;
	/**
	 * 商品总价
	 */
	@ApiModelProperty(value = "商品总价")
	private BigDecimal goodsPrice;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private LocalDateTime addTime;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private LocalDateTime confirmTime;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private LocalDateTime payTime;
	/**
	 * 配送费用
	 */
	@ApiModelProperty(value = "配送费用")
	private Integer freightPrice;
	/**
	 * 使用的优惠券id
	 */
	@ApiModelProperty(value = "使用的优惠券id")
	private Integer couponId;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer parentId;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Double couponPrice;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String callbackStatus;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String shippingNo;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Double fullCutPrice;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String orderType;

	/**
	 * 订单商品
	 */
	@ApiModelProperty(value = "订单商品")
	private List<OrderGoods> orderGoodsList;
	/**
	 * 订单商品数量
	 */
	@ApiModelProperty(value = "")
	private Integer goodsCount;

}
