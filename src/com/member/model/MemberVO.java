package com.member.model;

//Table Name : MEMBER(會員)
public class MemberVO implements java.io.Serializable{
	private Integer MEM_NO;
	private String MEM_NAME;
	private String MEM_GENDER;
	private Integer MEM_PHONE;
	private String MEM_EMAIL;
	private String MEM_ADDRESS;
	private String MEM_ACCOUNT;
	private String MEM_PASSWORD;
	private String MEM_BIRTH;
	private String MEM_STA;
	
	
	
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	public MemberVO(Integer mEM_NO, String mEM_NAME, String mEM_GENDER, Integer mEM_PHONE, String mEM_EMAIL,
			String mEM_ADDRESS, String mEM_ACCOUNT, String mEM_PASSWORD, String mEM_BIRTH, String mEM_STA) {
		super();
		this.MEM_NO = mEM_NO;
		this.MEM_NAME = mEM_NAME;
		this.MEM_GENDER = mEM_GENDER;
		this.MEM_PHONE = mEM_PHONE;
		this.MEM_EMAIL = mEM_EMAIL;
		this.MEM_ADDRESS = mEM_ADDRESS;
		this.MEM_ACCOUNT = mEM_ACCOUNT;
		this.MEM_PASSWORD = mEM_PASSWORD;
		this.MEM_BIRTH = mEM_BIRTH;
		this.MEM_STA = mEM_STA;
	}



	public Integer getMEM_NO() {
		return MEM_NO;
	}
	public void setMEM_NO(Integer mEM_NO) {
		this.MEM_NO = mEM_NO;
	}
	public String getMEM_NAME() {
		return MEM_NAME;
	}
	public void setMEM_NAME(String mEM_NAME) {
		this.MEM_NAME = mEM_NAME;
	}
	public String getMEM_GENDER() {
		return MEM_GENDER;
	}
	public void setMEM_GENDER(String mEM_GENDER) {
		this.MEM_GENDER = mEM_GENDER;
	}
	public Integer getMEM_PHONE() {
		return MEM_PHONE;
	}
	public void setMEM_PHONE(Integer mEM_PHONE) {
		this.MEM_PHONE = mEM_PHONE;
	}
	public String getMEM_EMAIL() {
		return MEM_EMAIL;
	}
	public void setMEM_EMAIL(String mEM_EMAIL) {
		this.MEM_EMAIL = mEM_EMAIL;
	}
	public String getMEM_ADDRESS() {
		return MEM_ADDRESS;
	}
	public void setMEM_ADDRESS(String mEM_ADDRESS) {
		this.MEM_ADDRESS = mEM_ADDRESS;
	}
	public String getMEM_ACCOUNT() {
		return MEM_ACCOUNT;
	}
	public void setMEM_ACCOUNT(String mEM_ACCOUNT) {
		this.MEM_ACCOUNT = mEM_ACCOUNT;
	}
	public String getMEM_PASSWORD() {
		return MEM_PASSWORD;
	}
	public void setMEM_PASSWORD(String mEM_PASSWORD) {
		this.MEM_PASSWORD = mEM_PASSWORD;
	}
	public String getMEM_BIRTH() {
		return MEM_BIRTH;
	}
	public void setMEM_BIRTH(String mEM_BIRTH) {
		this.MEM_BIRTH = mEM_BIRTH;
	}
	public String getMEM_STA() {
		return MEM_STA;
	}
	public void setMEM_STA(String mEM_STA) {
		this.MEM_STA = mEM_STA;
	}

}

