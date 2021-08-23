package com.staff.model;

import java.util.List;


public interface I_StaffDAO {
	public void insert(StaffVO staff);
	public void update(StaffVO staff);
	public void delete(int STAFF_NO);
	public StaffVO findByStaff_no(int STAFF_NO);
	public List<StaffVO> findByStaff_name(String STAFF_NAME);
	public List<StaffVO> findByStaff_phone(int STAFF_PHONE);
	public List<StaffVO> getAll();
}
