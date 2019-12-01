package com.mywuwu.gecco.crawler.entity;

import java.io.Serializable;
import java.util.Date;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * <p>
 * 爬取的文章数据
 * </p>
 *
 * @author wisdom
 * @since 2019-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gecco_data")
public class GeccoData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类ID
     */
    private Long classId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章副标题
     */
    private String subtitle;

    /**
     * 发布时间
     */
    @TableField("release_time")
    private String releaseTime;

    /**
     * 作者
     */
    private String author;

    /**
     * 主要内容
     */
    private String content;

    /**
     * 添加时间
     */
    private Date addTime;

    public GeccoData() {
    }

    public GeccoData(String title, String subtitle, String releaseTime, String author, String content) {
        this.title = title;
        this.subtitle = subtitle;
        this.releaseTime = releaseTime;
        this.author = author;
        this.content = content;
    }
}
