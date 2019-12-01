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
 * @date 2019-08-26 22:23:06
 */
@Data
@TableName("product")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Product extends Model<Product> {
private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Integer id;
    /**
     * 商品Id
     */
    @ApiModelProperty(value="商品Id")
    private Integer goodsId;
    /**
     * 商品规格ids
     */
    @ApiModelProperty(value="商品规格ids")
    private String goodsSpecificationIds;
    /**
     * 商品序列号
     */
    @ApiModelProperty(value="商品序列号")
    private String goodsSn;
    /**
     * 商品编码
     */
    @ApiModelProperty(value="商品编码")
    private Integer goodsNumber;
    /**
     * 零售价格
     */
    @ApiModelProperty(value="零售价格")
    private BigDecimal retailPrice;
    /**
     * 价格
     */
    @ApiModelProperty(value="价格")
    private BigDecimal marketPrice;
    }
