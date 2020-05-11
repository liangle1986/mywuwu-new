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

/**
 * 
 *
 * @author lianglele
 * @date 2019-08-27 20:54:53
 */
@Data
@TableName("cart")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Cart extends Model<Cart> {
private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Integer id;
    /**
     * 会员Id
     */
    @ApiModelProperty(value="会员Id")
    private Integer userId;
    /**
     * sessionId
     */
    @ApiModelProperty(value="sessionId")
    private String sessionId;
    /**
     * 商品Id
     */
    @ApiModelProperty(value="商品Id")
    private Integer goodsId;
    /**
     * 商品序列号
     */
    @ApiModelProperty(value="商品序列号")
    private String goodsSn;
    /**
     * 产品Id
     */
    @ApiModelProperty(value="产品Id")
    private Integer productId;
    /**
     * 产品名称
     */
    @ApiModelProperty(value="产品名称")
    private String goodsName;
    /**
     * 市场价
     */
    @ApiModelProperty(value="市场价")
    private BigDecimal marketPrice;
    /**
     * 零售价格
     */
    @ApiModelProperty(value="零售价格")
    private BigDecimal retailPrice;
    /**
     * 数量
     */
    @ApiModelProperty(value="数量")
    private Integer number;
    /**
     * 规格属性组成的字符串，用来显示用
     */
    @ApiModelProperty(value="规格属性组成的字符串，用来显示用")
    private String goodsSpecifitionNameValue;
    /**
     * product表对应的goods_specifition_ids
     */
    @ApiModelProperty(value="product表对应的goods_specifition_ids")
    private String goodsSpecifitionIds;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer checked;
    /**
     * 商品图片
     */
    @ApiModelProperty(value="商品图片")
    private String listPicUrl;
    }
