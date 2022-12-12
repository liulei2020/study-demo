package top.liuleinet.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @classname: JobProcessor
 * @author: lei.liu
 * @description:
 * @date: 2022/12/12
 * @version: v1.0
 **/
public class JobProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        // 解析返回的page，并将解析的结果放到ResultItems中
        // css选择器解析
        //page.putField("div",page.getHtml().css("div.p_content").all());
        // xpath解析
        page.putField("div2",page.getHtml().xpath("//div[@class=s_post]/div[@class=p_content]").regex(".*pan.baidu.com.*").all());
        page.putField("div3",page.getHtml().xpath("//div[@class=s_post]/div[@class=p_content]").regex(".*pan.baidu.com.*").get());
        page.putField("div4",page.getHtml().xpath("//div[@class=s_post]/div[@class=p_content]").regex(".*pan.baidu.com.*").toString());

        // 获取链接
        page.addTargetRequests(page.getHtml().css("div.p_content>a").links().all());
        page.putField("url",page.getHtml().css("div.s_post a").all());
    }

    private Site site = Site.me()
            .setCharset("UTF-8")//编码
            .setSleepTime(1)//抓取间隔时间
            .setTimeOut(1000*10)//超时时间
            .setRetrySleepTime(3000)//重试时间
            .setRetryTimes(3);//重试次数

    @Override
    public Site getSite() {
        return site;
    }

    // 主函数 执行爬虫
    public static void main(String[] args) {
        Spider.create(new JobProcessor())
                .addUrl("https://tieba.baidu.com/f/search/res?isnew=1&kw=&qw=%26%23039%3Bpan.baidu.com%26%23039%3B&rn=10&un=&only_thread=0&sm=1&sd=&ed=&pn=1")  //设置爬取数据的页面
                .addPipeline(new FilePipeline("C:\\Users\\PC\\Desktop\\rs\\"))
                .thread(5)//设置线程数
                .run();
    }
}
