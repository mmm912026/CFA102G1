package com.staff.model;

import java.util.List;
import java.util.stream.Collectors;

public class StaffService {
	private I_StaffDAO dao;
	
	public StaffService() {
		dao = new StaffJDBCDAO();
	}
public StaffVO addStaff(
		String staff_name, String staff_gender, Integer staff_phone,String staff_email,
		String staff_address, String staff_account, String staff_password,
		String staff_sta) {
	StaffVO staff = new StaffVO();
	
	staff.setStaff_name(staff_name);
	staff.setStaff_gender(staff_gender);
	staff.setStaff_phone(staff_phone);
	staff.setStaff_email(staff_email);
	staff.setStaff_address(staff_address);
	staff.setStaff_account(staff_account);
	staff.setStaff_password(staff_password);
	staff.setStaff_sta(staff_sta);
	
	staff = dao.insert(staff);
	return staff;
	};
public StaffVO updateStaff(
		Integer staff_no, String staff_name, String staff_gender, Integer staff_phone,String staff_email,
		String staff_address, String staff_account, String staff_password,
		String staff_sta
		) {
	StaffVO staff = new StaffVO();
	
	staff.setStaff_no(staff_no);
	staff.setStaff_name(staff_name);
	staff.setStaff_gender(staff_gender);
	staff.setStaff_phone(staff_phone);
	staff.setStaff_email(staff_email);
	staff.setStaff_address(staff_address);
	staff.setStaff_account(staff_account);
	staff.setStaff_password(staff_password);
	staff.setStaff_sta(staff_sta);
	
	dao.update(staff);
	return staff;
}
public void deleteStaff(Integer staff_no) {
	dao.delete(staff_no);
}
public StaffVO getOneStaff(Integer staff_no) {
	return dao.findByStaff_no(staff_no);
	}
public List<StaffVO> getName(String staff_name){
	return dao.getAll().stream().filter(e -> e.getStaff_name().equals(staff_name)).collect(Collectors.toList());
	}
public List<StaffVO> getPhone(Integer staff_phone){
	return dao.getAll().stream().filter(e -> e.getStaff_phone().equals(staff_phone)).collect(Collectors.toList());
    }
public List<StaffVO> getAll(){
	return dao.getAll();
	}
}
