package com.mywuwu.gecco.crawler.bean;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.dynamic.DynamicBean;
import com.geccocrawler.gecco.dynamic.DynamicGecco;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.mywuwu.gecco.crawler.entity.GeccoRule;
import com.mywuwu.gecco.utils.ConvertCharsetUtil;
import com.mywuwu.pigx.common.core.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 动态抓取
 * @Author: wisdomwang
 * @Date: 2019-04-12 14:11
 **/
@Component
@Slf4j
public class DynamicGeccoBean {

    private static GeccoEngine ge = null;

    //初始化
//    @Override
    public void init() {
        ge = GeccoEngine.create()
//                .pipelineFactory(springPipelineFactory)
                .classpath("com.mywuwu.gecco.crawler.bean");
    }

    //页面爬取链接及规则
    public R dynamicGecco(GeccoRule geccoRule, String keyword){
        try{
            HttpGetRequest request = new HttpGetRequest(geccoRule.getParentUrl());
            //乱码解决
            request.setCharset(ConvertCharsetUtil.getUrlCharset(geccoRule.getParentUrl()));
            request.addParameter("classId",geccoRule.getClassId().toString());
            request.addParameter("keyword",keyword);
            DynamicBean build = DynamicGecco.html()
                    .gecco(geccoRule.getParentUrl(), "geccoPipeline")
                    .requestField("request").request().build();

            DynamicBean dynamicBean = getDynamicBean(build, geccoRule);
            dynamicBean.register();
			init();
            //开始爬取
            threadStart(request,ge);

            return R.ok("爬取成功");
        }catch (RuntimeException e){
            e.printStackTrace();
            return R.failed("请稍后再试");
        }

    }


    //页面爬取链接及规则
    public R dynamicBatchGecco(GeccoRule geccoRule,String keyword){
        try{
            String parentUrl = geccoRule.getParentUrl();
            String childrenUrl = geccoRule.getChildrenUrl();
            HttpGetRequest request = new HttpGetRequest(parentUrl);
            request.setCharset(ConvertCharsetUtil.getUrlCharset(parentUrl));
            request.addParameter("classId",geccoRule.getClassId().toString());
            request.addParameter("keyword",keyword);

            //对应articles和HrefBean类
            Class<?> article = DynamicGecco.html()
                    .listField("article",
                            DynamicGecco.html()
                                    .stringField("url").csspath("a").href(true).build()
                                    .stringField("text").csspath("a").text().build()
                                    .register()).csspath("*").build().register();//*代表所有的a标签
            //文章列表
            DynamicGecco.html()
                    .gecco(parentUrl, "articlesPipeline")
                    .requestField("request").request().build()
                    .listField("articles",article).csspath("body").build().register();

            //正则获取子链接字段
            List<String> urlField = getUrlField(geccoRule.getChildrenUrl());

            //文章内容
            DynamicBean build = DynamicGecco.html()
                    .gecco(childrenUrl, "articleDetailPipeline")
                    .requestField("request").request().build();
            for(String str:urlField){
                build = build.stringField(str).requestParameter().build();
            }

            DynamicBean dynamicBean = getDynamicBean(build, geccoRule);
            dynamicBean.register();

            init();
            //开始爬取
            R result = threadStart(request, ge);

            return result;
        }catch (RuntimeException e){
            e.printStackTrace();
            return R.failed("很抱歉,请稍后再试");
        }

    }

    /**
     * 使用线程池爬取
     * @param request
     * @param geccoEngine
     */
    private R threadStart(HttpGetRequest request,GeccoEngine geccoEngine){
        //每次调用前需初始化
        init();

        // 创建一个线程池对象，控制要创建几个线程对象。
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //开始爬取
        GeccoEngine engine = geccoEngine.debug(true).start(request);

        // 将线程放入池中进行执行
        executorService.execute(engine);
        // 结束线程池
        executorService.shutdown();

        return R.ok("爬取成功");

    }

    /**
     * 获取子链接的参数
     * @param url
     * @return
     */
    private List<String> getUrlField(String url){
        Pattern pattern = Pattern.compile("\\{([^}]*)\\}");
        Matcher matcher = pattern.matcher(url);
        List<String> list = new ArrayList<>();
        while(matcher.find()) {
            String str = matcher.group(1);
            list.add(str);
        }
        return list;
    }

    /**
     * 获取文章内容
     * @return
     */
    private DynamicBean getDynamicBean(DynamicBean build,GeccoRule geccoRule){
        if (geccoRule != null) {
            if(!StringUtils.isEmpty(geccoRule.getTitle())){
                build.stringField("title").csspath(geccoRule.getTitle()).html(false).build();
            }
            if(!StringUtils.isEmpty(geccoRule.getSubtitle())){
                build.stringField("subtitle").csspath(geccoRule.getSubtitle()).html(false).build();
            }
            if(!StringUtils.isEmpty(geccoRule.getReleaseTime())){
                build.stringField("releaseTime").csspath(geccoRule.getReleaseTime()).html(false).build();
            }
            if(!StringUtils.isEmpty(geccoRule.getAuthor())){
                build.stringField("author").csspath(geccoRule.getAuthor()).html(false).build();
            }
            if(!StringUtils.isEmpty(geccoRule.getContent())){
                build.stringField("content").csspath(geccoRule.getContent()).html(false).build();
            }
        }
        return build;
    }

	public static void main(String[] args) {
		GeccoRule rule = new GeccoRule();
		rule.setTitle("div.con-all.allbox > div.con-left.bgwhite.fl > div.kf-info > h1");
		rule.setParentUrl("http://www.redshu.com/");
		rule.setChildrenUrl("http://www.redshu.com/{project}/{page}");
		rule.setAuthor("body > div.content.allbox > div.con-all.allbox > div.con-left.bgwhite.fl > div.kf-info > ul > li:nth-child(2) > span");
		rule.setReleaseTime("body > div.content.allbox > div.con-all.allbox > div.con-left.bgwhite.fl > div.kf-info > ul > li:nth-child(1) > span");
		rule.setType(1);
		rule.setContent("body > div.content.allbox > div.con-all.allbox > div.con-left.bgwhite.fl");
		rule.setClassId(3223232l);
		DynamicGeccoBean bean = new DynamicGeccoBean();
		bean.dynamicBatchGecco(rule, "");
	}

}
