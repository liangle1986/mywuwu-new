package com.mywuwu.gecco.crawler.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;




import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wisdom
 * @since 2019-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gecco_rule")
public class GeccoRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类ID
     */
    private Long classId;

    /**
     * 规则名称
     */
    @TableField("rule_name")
    private String ruleName;

    /**
     * 父链接
     */
    @TableField("parent_url")
    private String parentUrl;

    /**
     * 子链接
     */
    @TableField("children_url")
    private String childrenUrl;

    /**
     * 外部链接规则
     */
    @TableField("out_rule")
    private String outRule;

    /**
     * 内部链接规则
     */
    @TableField("inner_rule")
    private String innerRule;

    /**
     * 标题规则
     */
    private String title;

    /**
     * 副标题规则
     */
    private String subtitle;

    /**
     * 发布时间规则
     */
    @TableField("release_time")
    private String releaseTime;

    /**
     * 作者规则
     */
    @TableField("author")
    private String author;

    /**
     * 内容规则
     */
    private String content;

    /**
     * 类型:0单页爬取 1:层级爬取
     */
    private Integer type;

}
