package com.mf.vo;

import com.mf.entity.Customer;

import java.util.Date;

/**
 * @ClassName: SaleOutVo
 * @Description:
 * @date 2018/7/18
 * @Copyright © 2017北京数人科技有限公司
 */
public class SaleOutVO {
    private String saleNumber = ""; // 销售单号

    private Date saleDate; // 销售日期

    private String customerName= ""; // 客户名称

    private String contact = ""; // 联系人

    private String number = ""; // 联系电话

    private String address= ""; //客户地址

    private String code = ""; //商品编号

    private String goodsName = ""; //商品名称

    private String model = ""; //规格

    private float price; // 单价

    private int num; // 数量

    private String unit = ""; // 商品单位

    private float total; // 总金额

    private float amountPayable;// 应付金额

    private float amountPaid; // 实付金额

    private String state = ""; // 交易状态 1 已付 2 未付

    private String remarks = ""; // 备注

    private String userName = ""; //操作人


    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public float getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(float amountPayable) {
        this.amountPayable = amountPayable;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
