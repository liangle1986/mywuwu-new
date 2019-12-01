package com.mywuwu.gecco.crawler.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.gecco.crawler.entity.GeccoData;
import com.mywuwu.gecco.crawler.mapper.GeccoDataMapper;
import com.mywuwu.gecco.crawler.service.IGeccoDataService;
import com.mywuwu.pigx.common.core.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;

/**
 * <p>
 * 爬取的文章数据 服务实现类
 * </p>
 *
 * @author wisdom
 * @since 2019-04-15
 */
@Service
@Slf4j
public class GeccoDataServiceImpl extends ServiceImpl<GeccoDataMapper, GeccoData> implements IGeccoDataService {

}
