package com.staff.model;

import java.util.List;


public interface I_StaffDAO {
	    void insert(StaffVO staff);
	    void update(StaffVO staff);
	    void delete(int STAFF_NO);
	    StaffVO findByStaff_no(int STAFF_NO);
	    public List<StaffVO> findByStaff_name(String STAFF_NAME);
	    public List<StaffVO> findByStaff_phone(int STAFF_PHONE);
	    List<StaffVO> getAll();
}
