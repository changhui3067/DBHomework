//这是一个model 和 orders表对应
package com.sp.model;

public class OrderBean {
	
	
	private long ordersId ;
	private long userId;  
	private java.util.Date orderDate;
	private String payMode ;
	private byte isPayed;
	private float totalPrice ;
	public byte getIsPayed() {
		return isPayed;
	}
	public void setIsPayed(byte isPayed) {
		this.isPayed = isPayed;
	}
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	public long getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(long ordersId) {
		this.ordersId = ordersId;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
