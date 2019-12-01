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

package com.mywuwu.pigx.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mywuwu.pigx.shop.entity.Goods;
import com.mywuwu.pigx.shop.entity.dto.GoodsDto;

import java.util.List;

/**
 * 
 *
 * @author pigx code generator
 * @date 2019-08-26 22:22:37
 */
public interface GoodsService extends IService<Goods> {

	/**
	 * 根据条件查询商品
	 * @param goodsDto 条件对象
	 * @return
	 */
	List<Goods> queryList(GoodsDto goodsDto);
}
