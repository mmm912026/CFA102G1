package com.authority.model;

import java.util.List;

public interface I_AuthorityDAO {
	    void insert(AuthorityVO authouity);
	    void delete(int AUTHORITY_NO);
	    void update(AuthorityVO authouity);
	    AuthorityVO findByAuthority_no(int AUTHORITY_NO);
	    List<AuthorityVO> getAll();
	   
}
