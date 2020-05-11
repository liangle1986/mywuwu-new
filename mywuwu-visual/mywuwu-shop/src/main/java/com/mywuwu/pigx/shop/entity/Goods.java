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
 * @date 2019-08-26 22:22:37
 */
@Data
@TableName("goods")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Goods extends Model<Goods> {
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
	private Integer categoryId;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String goodsSn;
	/**
	 * 商品名称
	 */
	@ApiModelProperty(value = "")
	private String name;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer brandId;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer goodsNumber;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String keywords;
	/**
	 * 商品简介
	 */
	@ApiModelProperty(value = "商品简介")
	private String goodsBrief;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String goodsDesc;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer isOnSale;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private LocalDateTime addTime;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer sortOrder;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer isDelete;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer attributeCategory;
	/**
	 * 专柜价格
	 */
	@ApiModelProperty(value = "专柜价格")
	private BigDecimal counterPrice;
	/**
	 * 附加价格
	 */
	@ApiModelProperty(value = "附加价格")
	private BigDecimal extraPrice;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer isNew;
	/**
	 * 商品单位
	 */
	@ApiModelProperty(value = "商品单位")
	private String goodsUnit;
	/**
	 * 商品主图
	 */
	@ApiModelProperty(value = "商品主图")
	private String primaryPicUrl;
	/**
	 * 商品列表图
	 */
	@ApiModelProperty(value = "商品列表图")
	private String listPicUrl;
	/**
	 * 零售价格
	 */
	@ApiModelProperty(value = "零售价格")
	private BigDecimal retailPrice;
	/**
	 * 销售量
	 */
	@ApiModelProperty(value = "销售量")
	private Integer sellVolume;
	/**
	 * 主sku　product_id
	 */
	@ApiModelProperty(value = "主sku　product_id")
	private Integer primaryProductId;
	/**
	 * 单位价格，单价
	 */
	@ApiModelProperty(value = "单位价格，单价")
	private BigDecimal unitPrice;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String promotionDesc;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String promotionTag;
	/**
	 * APP专享价
	 */
	@ApiModelProperty(value = "APP专享价")
	private BigDecimal appExclusivePrice;
	/**
	 * 是否是APP专属
	 */
	@ApiModelProperty(value = "是否是APP专属")
	private Integer isAppExclusive;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer isLimited;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer isHot;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private BigDecimal marketPrice;
	/**
	 * 创建人ID
	 */
	@ApiModelProperty(value = "创建人ID")
	private Long createUserId;
	/**
	 * 修改人ID
	 */
	@ApiModelProperty(value = "修改人ID")
	private Long updateUserId;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	private LocalDateTime updateTime;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Long createUserDeptId;
}
