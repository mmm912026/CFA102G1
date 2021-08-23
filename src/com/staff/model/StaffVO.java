package com.staff.model;

//Table Name : STAFF(員工)

public class StaffVO implements java.io.Serializable{
	private Integer STAFF_NO;
	private String STAFF_NAME;
	private String STAFF_GENDER;
	private Integer STAFF_PHONE;
	private String STAFF_EMAIL;
	private String STAFF_ADDRESS;
	private String STAFF_ACCOUNT;
	private String STAFF_PASSWORD;
	private String STAFF_STA;
	
	public StaffVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public StaffVO(Integer sTAFF_NO, String sTAFF_NAME, String sTAFF_GENDER, Integer sTAFF_PHONE, String sTAFF_EMAIL,
			String sTAFF_ADDRESS, String sTAFF_ACCOUNT, String sTAFF_PASSWORD, String sTAFF_STA) {
		super();
		this.STAFF_NO = sTAFF_NO;
		this.STAFF_NAME = sTAFF_NAME;
		this.STAFF_GENDER = sTAFF_GENDER;
		this.STAFF_PHONE = sTAFF_PHONE;
		this.STAFF_EMAIL = sTAFF_EMAIL;
		this.STAFF_ADDRESS = sTAFF_ADDRESS;
		this.STAFF_ACCOUNT = sTAFF_ACCOUNT;
		this.STAFF_PASSWORD = sTAFF_PASSWORD;
		this.STAFF_STA = sTAFF_STA;
	}
	public Integer getSTAFF_NO() {
		return STAFF_NO;
	}
	public void setSTAFF_NO(Integer sTAFF_NO) {
		this.STAFF_NO = sTAFF_NO;
	}
	public String getSTAFF_NAME() {
		return STAFF_NAME;
	}
	public void setSTAFF_NAME(String sTAFF_NAME) {
		this.STAFF_NAME = sTAFF_NAME;
	}
	public String getSTAFF_GENDER() {
		return STAFF_GENDER;
	}
	public void setSTAFF_GENDER(String sTAFF_GENDER) {
		this.STAFF_GENDER = sTAFF_GENDER;
	}
	public Integer getSTAFF_PHONE() {
		return STAFF_PHONE;
	}
	public void setSTAFF_PHONE(Integer sTAFF_PHONE) {
		this.STAFF_PHONE = sTAFF_PHONE;
	}
	public String getSTAFF_EMAIL() {
		return STAFF_EMAIL;
	}
	public void setSTAFF_EMAIL(String sTAFF_EMAIL) {
		this.STAFF_EMAIL = sTAFF_EMAIL;
	}
	public String getSTAFF_ADDRESS() {
		return STAFF_ADDRESS;
	}
	public void setSTAFF_ADDRESS(String sTAFF_ADDRESS) {
		this.STAFF_ADDRESS = sTAFF_ADDRESS;
	}
	public String getSTAFF_ACCOUNT() {
		return STAFF_ACCOUNT;
	}
	public void setSTAFF_ACCOUNT(String sTAFF_ACCOUNT) {
		this.STAFF_ACCOUNT = sTAFF_ACCOUNT;
	}
	public String getSTAFF_PASSWORD() {
		return STAFF_PASSWORD;
	}
	public void setSTAFF_PASSWORD(String sTAFF_PASSWORD) {
		this.STAFF_PASSWORD = sTAFF_PASSWORD;
	}
	public String getSTAFF_STA() {
		return STAFF_STA;
	}
	public void setSTAFF_STA(String sTAFF_STA) {
		this.STAFF_STA = sTAFF_STA;
	}

}


