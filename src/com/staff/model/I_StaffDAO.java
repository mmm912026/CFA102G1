package com.staff.model;

import java.util.List;


public interface I_StaffDAO {
	public StaffVO insert(StaffVO staff);
	public void update(StaffVO staff);
	public void delete(Integer stff_no);
	public StaffVO findByStaff_no(Integer staff_no);
	public List<StaffVO> findByStaff_name(String staff_name);
	public List<StaffVO> findByStaff_phone(Integer staff_phone);
	public List<StaffVO> getAll();
}
