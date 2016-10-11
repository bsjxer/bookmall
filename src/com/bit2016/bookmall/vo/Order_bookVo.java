package com.bit2016.bookmall.vo;

public class Order_bookVo {
	private Long order_no;
	private Long book_no;
	private Long amount;
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Order_bookVO [order_no=" + order_no + ", book_no=" + book_no + ", amount=" + amount + "]";
	}
	
}
