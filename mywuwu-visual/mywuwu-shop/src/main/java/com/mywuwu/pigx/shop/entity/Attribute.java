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

/**
 * 
 *
 * @author lianglele
 * @date 2019-08-26 22:24:12
 */
@Data
@TableName("attribute")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Attribute extends Model<Attribute> {
private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Integer id;
    /**
     * 商品类型
     */
    @ApiModelProperty(value="商品类型")
    private Integer attributeCategoryId;
    /**
     * 属性名称
     */
    @ApiModelProperty(value="属性名称")
    private String name;
    /**
     * 当添加商品时,该属性的添加类别; 0为手功输入;1为选择输入;2为多行文本输入
     */
    @ApiModelProperty(value="当添加商品时,该属性的添加类别; 0为手功输入;1为选择输入;2为多行文本输入")
    private Integer inputType;
    /**
     * 即选择输入,则attr_name对应的值的取值就是该这字段值 
     */
    @ApiModelProperty(value="即选择输入,则attr_name对应的值的取值就是该这字段值 ")
    private String value;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer sortOrder;
    }
