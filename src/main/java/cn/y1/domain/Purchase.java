package cn.y1.domain;

import java.util.List;

public class Purchase {
    private int id;
    private int price;
    private String des;
    private String image;
    private int count;//收藏数量
    private String rimage;//缩略图
    private int sid;//所属商家
    private String sourceId;//抓取数据的来源id
    private Seller seller;//所属商家
    private List<PurchaseImg> purchaseImgList;//商品详情图片列表
    private String rflag;   //是否上架，必输，0代表没有上架，1代表是上架
    private String rdate;   //上架时间



    public Purchase() {
    }

    public Purchase(int id, int price, String des, String image, int count, String rimage, int sid, String sourceId, Seller seller, List<PurchaseImg> purchaseImgList, String rflag, String rdate) {
        this.id = id;
        this.price = price;
        this.des = des;
        this.image = image;
        this.count = count;
        this.rimage = rimage;
        this.sid = sid;
        this.sourceId = sourceId;
        this.seller = seller;
        this.purchaseImgList = purchaseImgList;
        this.rflag = rflag;
        this.rdate = rdate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<PurchaseImg> getPurchaseImgList() {
        return purchaseImgList;
    }

    public void setPurchaseImgList(List<PurchaseImg> purchaseImgList) {
        this.purchaseImgList = purchaseImgList;
    }

    public String getRflag() {
        return rflag;
    }

    public void setRflag(String rflag) {
        this.rflag = rflag;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }
}
