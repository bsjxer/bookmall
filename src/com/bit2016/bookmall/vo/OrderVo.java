package com.bit2016.bookmall.vo;

public class OrderVo {
	private Long no;
	private String orderer_name_email;
	private Long price;
	private String destination;
	private Long customer_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrderer_name_email() {
		return orderer_name_email;
	}
	public void setOrderer_name_email(String orderer_name_email) {
		this.orderer_name_email = orderer_name_email;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Long getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(Long customer_no) {
		this.customer_no = customer_no;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", orderer_name_email=" + orderer_name_email + ", price=" + price
				+ ", destination=" + destination + ", customer_no=" + customer_no + "]";
	}
	
	
}
