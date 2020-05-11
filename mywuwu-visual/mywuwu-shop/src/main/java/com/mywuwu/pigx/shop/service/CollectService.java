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
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.shop.entity.Collect;

/**
 * @author mywuwu 收藏夹
 * @date 2019-08-26 22:23:55
 */
public interface CollectService extends IService<Collect> {

	/**
	  * @description:
	  * @Param null
	  * @return:
	  * @author: lianglele
	  * @date: 2020-04-03 14:47
	  */
	R selectCollectList(Collect collect);
	/**
	  * @description: huiq
	  * @Param null
	  * @return:
	  * @author: lianglele
	  * @date: 2020-04-03 13:35
	  */
	R selectCollectGoods(Collect collect);
}
