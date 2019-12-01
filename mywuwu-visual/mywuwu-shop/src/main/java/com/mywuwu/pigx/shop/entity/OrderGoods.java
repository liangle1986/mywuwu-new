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
 * @author pigx code generator
 * @date 2019-08-26 22:22:56
 */
@Data
@TableName("order_goods")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class OrderGoods extends Model<OrderGoods> {
private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Integer id;
    /**
     * 订单Id
     */
    @ApiModelProperty(value="订单Id")
    private Integer orderId;
    /**
     * 商品id
     */
    @ApiModelProperty(value="商品id")
    private Integer goodsId;
    /**
     * 商品名称
     */
    @ApiModelProperty(value="商品名称")
    private String goodsName;
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
     * 商品数量
     */
    @ApiModelProperty(value="商品数量")
    private Integer number;
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
     * 商品规格详情
     */
    @ApiModelProperty(value="商品规格详情")
    private String goodsSpecifitionNameValue;
    /**
     * 虚拟商品
     */
    @ApiModelProperty(value="虚拟商品")
    private Integer isReal;
    /**
     * 商品规格Ids
     */
    @ApiModelProperty(value="商品规格Ids")
    private String goodsSpecifitionIds;
    /**
     * 图片链接
     */
    @ApiModelProperty(value="图片链接")
    private String listPicUrl;
    }
