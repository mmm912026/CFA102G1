package com.staff_authority.model;

import java.util.List;


public interface I_Staff_AuthorityDAO {
	public void insert(Staff_AuthorityVO staff_authouity);
	public Staff_AuthorityVO findByStaff_no(int STAFF_NO);
	public List<Staff_AuthorityVO> getAll();
}
