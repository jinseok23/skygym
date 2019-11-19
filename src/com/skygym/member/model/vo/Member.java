package com.skygym.member.model.vo;

import java.sql.Date;

public class Member {
	
	private String userId;
	private String password;
	private String userName;
	private String residentNum;
	private String phone;
	private String email;
	private String address;
	private String interest;
	private Date enrolldate;
	
	public Member() {}

	public Member(String userId, String password, String userName, String residentNum, String phone, String email,
			String address,String interest, Date enrolldate) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.residentNum = residentNum;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.interest = interest;
		this.enrolldate = enrolldate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getResidentNum() {
		return residentNum;
	}

	public void setResidentNum(String residentNum) {
		this.residentNum = residentNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", userName=" + userName + ", residentNum="
				+ residentNum + ", phone=" + phone + ", email=" + email + ", address=" + address + ", interest=" 
				+ interest + ", enrolldate=" + enrolldate + "]";
	}
	
	

}
