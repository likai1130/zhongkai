package com.mf.vo;

import java.util.Date;

/**
 * @ClassName: SaleOutVo
 * @Description:
 * @date 2018/7/18
 * @Copyright © 2017北京数人科技有限公司
 */
public class PurchaseVO {
    private String purchaseNumber = ""; // 进货单号

    private Date purchaseDate; // 进货日期

    private String supplierName= ""; // 供应商名称

    private String contact = ""; // 联系人

    private String number = ""; // 联系电话

    private String address= ""; //供应商地址

    private String code = ""; //商品编号

    private String goodsName = ""; //商品名称

    private String model = ""; //规格

    private float price; // 单价

    private int num; // 数量

    private String unit = ""; // 商品单位

    private String scattered = ""; // 零整比

    private String produceTime; // 生产日期

    private float total; // 总金额

    private String state = ""; // 交易状态 1 已付 2 未付

    private String remarks = ""; // 备注

    private String userName = ""; //操作人


    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getScattered() {
        return scattered;
    }

    public void setScattered(String scattered) {
        this.scattered = scattered;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    public PurchaseVO() {
    }

    public PurchaseVO(String purchaseNumber, Date purchaseDate, String supplierName, String contact, String number, String address, String remarks, String userName) {
        this.purchaseNumber = purchaseNumber;
        this.purchaseDate = purchaseDate;
        this.supplierName = supplierName;
        this.contact = contact;
        this.number = number;
        this.address = address;
        this.remarks = remarks;
        this.userName = userName;
    }
}
