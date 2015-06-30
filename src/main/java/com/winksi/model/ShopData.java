package com.winksi.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * 抽取最终结果类
 * 
 * @author xubing
 * 
 */
public class ShopData implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String _id;// 主键id

	protected String cityName;// 城市名称

	protected String name;// 名称

	protected String shortname;// 简称

	protected Integer cityid;// 城市id

	protected String address;// 地址

	protected Integer maincategory;// 分类

	protected String categoryids;// 分类 示例:"美食 湘菜 铁东区"

	protected String officialurl;// 网站

	protected String logo;// Logo
	
	protected String imgName;

	protected String imgUrl;// imgUrl
	
	protected String businessmodel; // 生产方式

	protected String weibo;// 微博

	protected String zip; // 邮编

	protected Integer origin; // 来源id，爬虫是一个 来源 ，分配一个id，其他合作伙伴每一个分配一个 id。

	protected Date updatedtime = new Date();// 更新时间

	protected Integer checkuserid;// 审核人编号

	protected Integer certification;// 认证

	protected Integer radomid;// 4位随机编码，生成后不能改变，给客户端的时候编号*10000+随机编码

	protected String category;// 抓取的分类标签，来源于合作伙伴的时候合作伙伴提供，以 ，分割

	protected String tag;// 抓取关键字，去重，以,分隔

	protected String feature;// 特色 示例:"剁椒蒸鱼头 蒸萝卜 干锅土豆片"

	protected String netkeywords;// 官网关键字

	protected String intro;// 介绍

	protected String phone;// 电话

	protected String url;// 来源url

	protected Integer operation;// 业务类型

	protected Integer phonelevel;// 全国通用号码

	protected Integer blackterminal;// 终端是否下载

	protected String products;// 商家经营范围

	protected Integer discussNum;// 评论数

	protected Date discussTime;// 最新评论时间

	protected JSONObject grade;// 星级,{"环境" : "6.7","评分" : "准四星商户","口味" :
								// "7.3","人均" : "¥52","服务" : "7.1"}

	protected Boolean transaction;// 是否有交易

	protected Date transactionTime;// 最新交易时间

	protected String annex;// 分店信息

	protected String parentId;

	protected Integer top;

    protected Double lat;

    protected Double lng;

	protected JSONArray tuangouArray;

	protected JSONArray youhuis;

	protected Integer weight;

	protected JSONArray discont;// 折扣, 贴现率

	protected ArrayList<String> branchUrl;// 分店url
	protected Integer enId;

    protected ArrayList<Double> gps;

    public ArrayList<Double> getGps() {
        return gps;
    }

    public void setGps(Double longitude,Double latitude) {


        if(gps==null&&longitude!=null&&latitude!=null){
            gps= Lists.newArrayList();
            gps.add(0,longitude);
            gps.add(1,latitude);
        }
    }
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public Integer getEnId() {
		return enId;
	}

	public void setEnId(Integer enId) {
		this.enId = enId;
	}

	public Boolean getTransaction() {
		return transaction;
	}

	public JSONArray getYouhuis() {
		return youhuis;
	}

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public ArrayList<String> getBranchUrl() {
		return branchUrl;
	}

	public void setBranchUrl(ArrayList<String> branchUrl) {
		this.branchUrl = branchUrl;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public JSONArray getTuangouArray() {
		return tuangouArray;
	}

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public void setTuangouArray(JSONArray tuangouArray) {
		this.tuangouArray = tuangouArray;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getDiscussNum() {
		return discussNum;
	}

	public void setDiscussNum(Integer discussNum) {
		this.discussNum = discussNum;
	}

	public Date getDiscussTime() {
		return discussTime;
	}

	public void setDiscussTime(Date discussTime) {
		this.discussTime = discussTime;
	}

	public JSONObject getGrade() {
		return grade;
	}

	public void setGrade(JSONObject grade) {
		this.grade = grade;
	}

	public Boolean isTransaction() {
		return transaction;
	}

	public void setTransaction(Boolean transaction) {
		this.transaction = transaction;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getAnnex() {
		return annex;
	}

	public void setAnnex(String annex) {
		this.annex = annex;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public JSONArray getDiscont() {
		return discont;
	}

	public void setDiscont(JSONArray discont) {
		this.discont = discont;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getMaincategory() {
		return maincategory;
	}

	public void setMaincategory(Integer maincategory) {
		this.maincategory = maincategory;
	}

	public String getCategoryids() {
		return categoryids;
	}

	public void setCategoryids(String categoryids) {
		this.categoryids = categoryids;
	}

	public String getOfficialurl() {
		return officialurl;
	}

	public void setOfficialurl(String officialurl) {
		this.officialurl = officialurl;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getBusinessmodel() {
		return businessmodel;
	}

	public void setBusinessmodel(String businessmodel) {
		this.businessmodel = businessmodel;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Integer getOrigin() {
		return origin;
	}

	public void setOrigin(Integer origin) {
		this.origin = origin;
	}

	public Date getUpdatedtime() {
		return updatedtime;
	}

	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}

	public Integer getCheckuserid() {
		return checkuserid;
	}

	public void setCheckuserid(Integer checkuserid) {
		this.checkuserid = checkuserid;
	}

	public Integer getCertification() {
		return certification;
	}

	public void setCertification(Integer certification) {
		this.certification = certification;
	}

	public Integer getRadomid() {
		return radomid;
	}

	public void setRadomid(Integer radomid) {
		this.radomid = radomid;
	}

	public Integer getOperation() {
		return operation;
	}

	public void setOperation(Integer operation) {
		this.operation = operation;
	}

	public Integer getPhonelevel() {
		return phonelevel;
	}

	public void setPhonelevel(Integer phonelevel) {
		this.phonelevel = phonelevel;
	}

	public Integer getBlackterminal() {
		return blackterminal;
	}

	public void setBlackterminal(Integer blackterminal) {
		this.blackterminal = blackterminal;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getNetkeywords() {
		return netkeywords;
	}

	public void setNetkeywords(String netkeywords) {
		this.netkeywords = netkeywords;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public void setYouhuis(JSONArray youhuis) {
		this.youhuis = youhuis;

	}
	public JSONArray setYouhuis() {
		return this.youhuis;

	}
}