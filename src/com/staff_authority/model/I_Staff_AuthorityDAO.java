package com.staff_authority.model;

import java.util.List;


public interface I_Staff_AuthorityDAO {
	void insert(Staff_AuthorityVO staff_authouity);
	Staff_AuthorityVO findByStaff_no(int STAFF_NO);
    List<Staff_AuthorityVO> getAll();
}
