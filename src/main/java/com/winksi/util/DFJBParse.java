package com.winksi.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.winksi.model.DFJBData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class DFJBParse implements Runnable{
    public static ThreadPoolTaskExecutor threadPoolTaskExecutor = (ThreadPoolTaskExecutor) new ClassPathXmlApplicationContext("classpath:spring-config.xml").getBean("extractorPool");
    private static MongoTemplate mongoTemplate = (MongoTemplate) new ClassPathXmlApplicationContext("classpath:spring-config.xml").getBean("mongoTemplate");

    private static final String domain = "http://www.dfjb.com.cn/map.aspx";
    private int reTryCount = 10;
    private static int lostUrl = 0;
    private String cityName;
    private static int count = 0;
    private String url;
    private int method;
    public DFJBParse(){

    }
    public DFJBParse(String url, int method, String cityName){
        this.url = url;
        this.method = method;
        this.cityName = cityName;
    }
    public void startParse(){
        String html = URLParseToStr.getInstance().getStrForHTML(domain);

        if(html == null){
            System.err.println("服务器无响应!");

            return;
        }

        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("html body div.storeBox.clearfix div.searchBox div.province span.selectbox ul#clist.son_ul").select("li[id]");
        for(int i = 0;elements != null &&  i < elements.size(); ++i) {
            if (elements.get(i).attr("id").equals("5")) {
                continue;
            }
            String provinceID = elements.get(i).attr("id");

            JSONArray cities = JSONArray.parseArray(URLParseToStr.getInstance().getStrForHTML("http://www.dfjb.com.cn/handler/GetMapInfo.ashx?_=1418026487297&op=dlist&cid=" + provinceID));
            for (int j = 0;cities != null && j <cities.size() ; j++) {
                JSONObject city = cities.getJSONObject(j);
                String tempUrl = "http://www.dfjb.com.cn/handler/GetMapInfo.ashx?_=1418029245445&op=all&cid=" + provinceID + "&d=" + city.getString("id");

                threadPoolTaskExecutor.execute(new DFJBParse(tempUrl, 1, elements.get(i).text()));
            }
        }
    }
    public void page_1(){
        String html = URLParseToStr.getInstance().getStrForHTML(this.url);
        while(html == null){
            if(--reTryCount <= 0){
                lostUrl++;
                return;
            }
        }

        JSONArray datas = JSONArray.parseArray(html);
        for (int i = 0;datas != null && i < datas.size(); ++i) {
            JSONObject data = datas.getJSONObject(i);

            DFJBData shopData = new DFJBData();
            shopData.setName(data.getString("map_shopName"));
            shopData.setAddress(data.getString("Address"));
            shopData.setPhone(data.getString("TelNumber"));
            shopData.setOfficehours(data.getString("officehours"));
            shopData.setCityName(this.cityName);
            shopData.setUrl(this.url);

//            mongoTemplate.save(shopData, "dongfangjibaiCateZzhoulei");
            System.out.println(shopData.getName()+"::"+shopData.getUrl()+"\t"+shopData.getOfficehours());
            System.out.println("------------------++++++++++数据量" + ++count + "+++++++++++-------------");
        }
    }
    public void run() {
        switch (this.method){
            case 1:
                page_1();
                break;
        }
    }
}
