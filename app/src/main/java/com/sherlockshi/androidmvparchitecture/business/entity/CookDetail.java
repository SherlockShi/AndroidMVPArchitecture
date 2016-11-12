package com.sherlockshi.androidmvparchitecture.business.entity;

/**
 * Author: SherlockShi
 * Date:   2016-10-31 22:59
 * Description: 菜谱详情
 */

public class CookDetail {

    /**
     * count : 8587
     * description : 除黄油外，其他材料混合揉成光滑面团，摊开面团，加入融化的黄油，继续揉面至可拉开坚韧的薄膜，收圆入盆，基础发酵．2
     * fcount : 0
     * food : 面粉,杞枣粉,酵母,蛋液,牛奶,黄油
     * id : 10
     * images :
     * img : /cook/150802/79b05ad0532a0ef682ae920ff9b67764.jpg
     * keywords : 发酵 面团 黄油 完成后 最后
     * message : <h2>菜谱简介</h2><hr>     <h2>材料 </h2><hr>
     <p>面粉200克，杞枣粉20克，酵母2克，糖20克，盐3克，蛋液20克，牛奶100克，黄油8克</p>   <h2>做法 </h2><hr>
     <p>1. 除黄油外，其他材料混合揉成光滑面团，摊开面团，加入融化的黄油，继续揉面至可拉开坚韧的薄膜，收圆入盆，基础发酵． </p>
     <p>2. 基础发酵完成后，排气，取出，分割四等份，滚圆，覆盖，中间发酵15分钟． </p>
     <p>3. 取一个面团，擀开，翻面，从上往下紧密卷起，收口处捏紧，用手轻轻搓揉成橄榄形． </p>
     <p>4. 间隔排放入铺垫好的烤盘上，入烤箱做最后发酵． </p>
     <p>5. 最后发酵完成后，刷蛋液，用刀片划开一道口（可省略） </p>
     <p>6. 烤箱180度预热好，中层，15分钟（上色均匀后盖锡纸）</p>
     * name : 杞枣餐包
     * rcount : 0
     * status : true
     * url : http://www.tngou.net/cook/show/10
     */

    private int count;
    private String description;
    private int fcount;
    private String food;
    private int id;
    private String images;
    private String img;
    private String keywords;
    private String message;
    private String name;
    private int rcount;
    private boolean status;
    private String url;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
