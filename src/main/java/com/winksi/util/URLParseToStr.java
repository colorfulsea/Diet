package com.winksi.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 * Created by zhoulei on 2014/12/3.
 * 通过链接解析网页获取转换为字符串的网页内容,单例模式
 */
public class URLParseToStr {
    private static String encoding = "GBK";//编码格式,默认GBK
    //设置超时
    private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();
    private URLParseToStr(){

    }
    private static URLParseToStr urlParseToStr = new URLParseToStr();
    public static URLParseToStr getInstance(){
        return urlParseToStr;
    }

    /**
     * 获取转换为字符串的网页
     * @return
     */
    public String getStrForHTML(String url){

        String html = null;
        HttpGet httpGet = null;//请求判定

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;

        try {
            httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);//设置配置

            httpResponse = httpClient.execute(httpGet);//获取请求
            if(httpResponse.getStatusLine().getStatusCode() != 200){
                System.err.println("状态码异常");
            }

            setEncoding(httpResponse.getEntity());//设置编码

            html = IOUtils.toString(httpResponse.getEntity().getContent(), this.encoding);
        }catch (SocketTimeoutException e){
            System.err.println(url + "连接超时 ");
        }catch (ConnectTimeoutException e){
            System.err.println(url + "服务器无响应");
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            //释放资源
            if(httpResponse != null){
                try {
                    httpResponse.close();
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return html;
    }

    /**
     * 设置转换编码格式
     * @param httpEntity
     */
    private void setEncoding(HttpEntity httpEntity){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(httpEntity.getContentEncoding() == null){//使用提供的方法解析编码，如果无法得到编码头则采用字符串分割法尝试
            String[] headerTemp;
            int charsetIndex = -1;//编码信息下标

            //如果头信息携带编码则查找关键字首次出现位置截取编码信息
            if( ( charsetIndex = httpEntity.getContentType().toString().indexOf("charset") ) != -1){
                //从下标标注出开始截取
                headerTemp = httpEntity.getContentType().toString().substring(charsetIndex).split("=");

                this.encoding = headerTemp[1].trim();
            }else{
                return;
            }
        }else{
            this.encoding = httpEntity.getContentEncoding().getValue();
        }
    }
}