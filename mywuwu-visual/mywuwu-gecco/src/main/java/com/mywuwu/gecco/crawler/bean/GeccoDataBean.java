package com.mywuwu.gecco.crawler.bean;

import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @Description: 爬取工具类
 * @Author: wisdomwang
 * */
//@Gecco(pipelines="geccoPipeline")//Dynamic下不用定义bean
public class GeccoDataBean implements HtmlBean {

    //@Request
    private HttpRequest request;

    //@HtmlField(cssPath = "div#u1 a")
    private String title;

    //@HtmlField(cssPath = "div.qrcode-text b")
    private String releaseTime;

    //@HtmlField(cssPath = "div.ftCon-Wrapper p#lh a")
    private String content;

}
