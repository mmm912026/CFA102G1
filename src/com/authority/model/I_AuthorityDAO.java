package com.authority.model;

import java.util.List;

public interface I_AuthorityDAO {
	public void insert(AuthorityVO authouity);
	public void delete(int AUTHORITY_NO);
	public void update(AuthorityVO authouity);
	public AuthorityVO findByAuthority_no(int AUTHORITY_NO);
	public List<AuthorityVO> getAll();
	   
}
