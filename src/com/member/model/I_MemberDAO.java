package com.member.model;

import java.util.List;

public interface I_MemberDAO {
    void insert(MemberVO member);
    void update(MemberVO member);
    void delete(int MEM_NO);
    MemberVO findByMem_no(int MEM_NO);
    public List<MemberVO> findByMem_name(String MEM_NAME);
    public List<MemberVO> findByMem_phone(int MEM_PHONE);
    List<MemberVO> getAll();
}
