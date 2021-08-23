package com.staff_authority.model;


//Table Name : STAFF_AUTHORITY(員工權限)
public class Staff_AuthorityVO implements java.io.Serializable{
	   private Integer STAFF_NO;
	   private Integer AUTHORITY_NO;
	public Staff_AuthorityVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff_AuthorityVO(Integer sTAFF_NO, Integer aUTHORITY_NO) {
		super();
		this.STAFF_NO = sTAFF_NO;
		this.AUTHORITY_NO = aUTHORITY_NO;
	}
	public Integer getSTAFF_NO() {
		return STAFF_NO;
	}
	public void setSTAFF_NO(Integer sTAFF_NO) {
		this.STAFF_NO = sTAFF_NO;
	}
	public Integer getAUTHORITY_NO() {
		return AUTHORITY_NO;
	}
	public void setAUTHORITY_NO(Integer aUTHORITY_NO) {
		this.AUTHORITY_NO = aUTHORITY_NO;
	}
	   
	}

