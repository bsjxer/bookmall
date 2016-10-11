package com.bit2016.bookmall.vo;

public class CartVo {
	private Long book_no;
	private Long customer_no;
	private Long amount;
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(Long customer_no) {
		this.customer_no = customer_no;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CartVo [book_no=" + book_no + ", customer_no=" + customer_no + ", amount=" + amount + "]";
	}
}
