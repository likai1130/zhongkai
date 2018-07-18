package com.mf.vo;

/**
 * @ClassName: GoodsVO
 * @Description: 库存导出
 * @date 2018/7/18
 * @Copyright © 2017北京数人科技有限公司
 */
public class GoodsVO {

    private String code; // 商品编码

    private String name; // 商品名称

    private String type; // 商品类别

    private String model; // 规格

    private String unit; // 商品单位

    private String scattered; // 零整比

    private int inventoryQuantity; // 库存数量

    private int saleTotal; // 销售总数

    private float lastPurchasingPrice; // 上次采购价格

    private float purchasingPrice; // 采购价格  成本价  假如价格变动 算平均值

    private float sellingPrice; // 出售价格

    private float amount; //库存总值了

    private int minNum; // 库存下限

    private String producer; // 生产厂商

    private String remarks; // 备注

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getScattered() {
        return scattered;
    }

    public void setScattered(String scattered) {
        this.scattered = scattered;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public int getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(int saleTotal) {
        this.saleTotal = saleTotal;
    }

    public float getLastPurchasingPrice() {
        return lastPurchasingPrice;
    }

    public void setLastPurchasingPrice(float lastPurchasingPrice) {
        this.lastPurchasingPrice = lastPurchasingPrice;
    }

    public float getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(float purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
