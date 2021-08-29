package com.member.model;

import java.util.List;

public interface I_MemberDAO {
	public MemberVO insert(MemberVO member);
	public void update(MemberVO member);
	public void delete(Integer mem_no);
	public MemberVO findByMem_no(Integer mem_no);
    public List<MemberVO> findByMem_name(String mem_name);
    public List<MemberVO> findByMem_phone(Integer mem_phone);
    public List<MemberVO> getAll();
}
