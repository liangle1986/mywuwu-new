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
 * @author pigx code generator
 * @date 2019-08-26 22:24:17
 */
@Data
@TableName("comment_picture")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class CommentPicture extends Model<CommentPicture> {
private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Integer id;
    /**
     * 评价Id
     */
    @ApiModelProperty(value="评价Id")
    private Integer commentId;
    /**
     * 评价图片
     */
    @ApiModelProperty(value="评价图片")
    private String picUrl;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sortOrder;
    }
