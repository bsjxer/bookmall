package com.bit2016.bookmall.vo;

public class CustomerVo {
	private Long no;
	private String name;
	private Long contact;
	private String email;
	private Long password;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPassword() {
		return password;
	}
	public void setPassword(Long password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CustomerVo [no=" + no + ", name=" + name + ", contact=" + contact + ", email=" + email + ", password="
				+ password + "]";
	}
}
