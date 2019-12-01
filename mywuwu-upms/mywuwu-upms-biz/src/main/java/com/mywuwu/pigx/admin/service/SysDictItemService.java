/*
 *    Copyright (c) 2018-2025, mywuwu All rights reserved.
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
 * Author: mywuwu (lianglele1986@126.com)
 */
package com.mywuwu.pigx.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mywuwu.pigx.admin.api.entity.SysDictItem;
import com.mywuwu.pigx.common.core.util.R;

/**
 * 字典项
 *
 * @author mywuwu
 * @date 2019/03/19
 */
public interface SysDictItemService extends IService<SysDictItem> {

	/**
	 * 删除字典项
	 *
	 * @param id 字典项ID
	 * @return
	 */
	R removeDictItem(Integer id);

	/**
	 * 更新字典项
	 *
	 * @param item 字典项
	 * @return
	 */
	R updateDictItem(SysDictItem item);
}
