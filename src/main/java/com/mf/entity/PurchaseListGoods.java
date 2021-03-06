package com.mf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 进货单商品实体
 * @author Administrator
 *
 */
@Entity
@Table(name="t_purchaseListGoods")
public class PurchaseListGoods {
	
	@Id
	@GeneratedValue
	private Integer id; // 编号
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="purchaseListId")
	private PurchaseList purchaseList; // 进货单也是pojo
	
	@Column(length=50)
	private String code; // 商品编码
	
	@Column(length=50)
	private String name; // 商品名称
	
	@Column(length=50)
	private String model; // 商品型号
	
	@ManyToOne
	@JoinColumn(name="typeId")
	private GoodsType type; // 商品类别 关联pojo
	
	@Transient
	private Integer typeId; // 类别id
	
	private Integer goodsId; // 商品id
	
	@Column(length=10)
	private String unit; // 商品单位
	
	private float price; // 单价
	
	private int num; // 数量
	
	private float total; // 总金额

	@Column(length=10)
	private String scattered; // 零散比

	@Column(length=50)
	private String produceTime; // 生产日期

	@Transient
	private String codeOrName; // 查询用到 根据商品编码或者商品名称查询

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PurchaseList getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(PurchaseList purchaseList) {
		this.purchaseList = purchaseList;
	}

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public GoodsType getType() {
		return type;
	}

	public void setType(GoodsType type) {
		this.type = type;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	
	public String getCodeOrName() {
		return codeOrName;
	}

	public void setCodeOrName(String codeOrName) {
		this.codeOrName = codeOrName;
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

	@Override
	public String toString() {
		return "PurchaseListGoods [id=" + id + ", purchaseList=" + purchaseList + ", code=" + code + ", name=" + name
				+ ", model=" + model + ", type=" + type + ", typeId=" + typeId + ", goodsId=" + goodsId + ", unit="
				+ unit + ", price=" + price + ", num=" + num + ", total=" + total + "]";
	}
	
	
	
}
