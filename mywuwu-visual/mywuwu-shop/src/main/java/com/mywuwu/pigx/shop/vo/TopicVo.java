package com.mywuwu.pigx.shop.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mywuwu.pigx.shop.entity.Topic;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel(value = "规格表")
public class TopicVo{

    //主键
    private Integer id;
    //活动主题
    private String title;
    //活动内容
    private String content;
    //化名
    private String avatar;
    //活动条例图片
    private String itemPicUrl;
    //子标题
    private String subtitle;
    //活动类别
    private Integer topicCategoryId;
    //活动价格
    private BigDecimal priceInfo;
    //
    private String readCount;
    //场景图片链接
    private String scenePicUrl;
    //活动模板Id
    private Integer topicTemplateId;
    //活动标签Id
    private Integer topicTagId;

    //获取推荐信息
    private List<Topic> recommendList;

}
