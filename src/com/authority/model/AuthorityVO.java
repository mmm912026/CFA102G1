package com.authority.model;

//Table Name : AUTHORITY(功能)

public class AuthorityVO implements java.io.Serializable{
	private Integer AUTHORITY_NO;
	private String AUTHORITY_NAME;
	public AuthorityVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorityVO(Integer aUTHORITY_NO, String aUTHORITY_NAME) {
		super();
		this.AUTHORITY_NO = aUTHORITY_NO;
		this.AUTHORITY_NAME = aUTHORITY_NAME;
	}
	public Integer getAUTHORITY_NO() {
		return AUTHORITY_NO;
	}
	public void setAUTHORITY_NO(Integer aUTHORITY_NO) {
		this.AUTHORITY_NO = aUTHORITY_NO;
	}
	public String getAUTHORITY_NAME() {
		return AUTHORITY_NAME;
	}
	public void setAUTHORITY_NAME(String aUTHORITY_NAME) {
		this.AUTHORITY_NAME = aUTHORITY_NAME;
	}
	
}