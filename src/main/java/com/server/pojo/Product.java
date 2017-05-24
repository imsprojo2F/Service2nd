package com.server.pojo;

public class Product {
	private Integer id;

	private String uid;

	private String name;

	private String descript;

	private String description;

	private String imgsrc;

	private Integer price;

	private String currency;

	private String typeId;

	private String createTime;

	private String updateTime;

	private String editBy;

	private Integer views;

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc == null ? null : imgsrc.trim();
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency == null ? null : currency.trim();
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId == null ? null : typeId.trim();
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime == null ? null : createTime.trim();
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime == null ? null : updateTime.trim();
	}

	public String getEditBy() {
		return editBy;
	}

	public void setEditBy(String editBy) {
		this.editBy = editBy == null ? null : editBy.trim();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", uid=" + uid + ", name=" + name + ", description=" + description + ", imgsrc="
				+ imgsrc + ", price=" + price + ", currency=" + currency + ", typeId=" + typeId + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", editBy=" + editBy + ", views=" + views + "]";
	}

}