package com.member.model;

import java.util.List;
import java.util.stream.Collectors;

public class MemberService {
	private I_MemberDAO dao;
	
	public MemberService() {
		dao = new MemberJDBCDAO();
	}

	public MemberVO addMember(
		    String mem_name, String mem_gender, Integer mem_phone, String mem_email,
			String mem_address, String mem_account, String mem_password, String mem_birth, String mem_sta) {
		MemberVO member = new MemberVO();
		
		member.setMem_name(mem_name);
		member.setMem_gender(mem_gender);
		member.setMem_phone(mem_phone);
		member.setMem_email(mem_email);
		member.setMem_address(mem_address);
		member.setMem_account(mem_account);
		member.setMem_password(mem_password);
		member.setMem_birth(mem_birth);
		member.setMem_sta(mem_sta);
		
		member = dao.insert(member);
		return member;
	}
public MemberVO updateMember(
		Integer mem_no, String mem_name, String mem_gender, Integer mem_phone, String mem_email,
		String mem_address, String mem_account, String mem_password, String mem_birth, String mem_sta
		) {
	MemberVO member = new MemberVO();
	
	member.setMem_no(mem_no);
	member.setMem_name(mem_name);
	member.setMem_gender(mem_gender);
	member.setMem_phone(mem_phone);
	member.setMem_email(mem_email);
	member.setMem_address(mem_address);
	member.setMem_account(mem_account);
	member.setMem_password(mem_password);
	member.setMem_birth(mem_birth);
	member.setMem_sta(mem_sta);
	
	dao.update(member);
	return member;
    }
public void deleteMember(Integer mem_no) {
	dao.delete(mem_no);
    }
public MemberVO getOneMem(Integer mem_no) {
	return dao.findByMem_no(mem_no);
    }
public List<MemberVO> getName(String mem_name){
	return dao.getAll().stream().filter(i -> i.getMem_name().equals(mem_name)).collect(Collectors.toList());
	}
	
public List<MemberVO> getPhone(Integer mem_phone){
	return dao.getAll().stream().filter(i -> i.getMem_phone().equals(mem_phone)).collect(Collectors.toList());
    };
public List<MemberVO> getAll(){
	return dao.getAll();
    }
}
