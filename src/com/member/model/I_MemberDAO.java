package com.member.model;

import java.util.List;

public interface I_MemberDAO {
	public void insert(MemberVO member);
	public void update(MemberVO member);
	public void delete(int MEM_NO);
	public MemberVO findByMem_no(int MEM_NO);
    public List<MemberVO> findByMem_name(String MEM_NAME);
    public List<MemberVO> findByMem_phone(int MEM_PHONE);
    public List<MemberVO> getAll();
}
