package com.appraisal_class.model;

import java.util.List;

public interface I_Appraisal_ClassDAO {

	public Appraisal_ClassVO insert(Appraisal_ClassVO appraisal_ClassVO);
	public void update(Appraisal_ClassVO appraisal_ClassVO);
	public void delete(Integer acl_no);
	public Appraisal_ClassVO findByPK(Integer acl_no);
	public List<Appraisal_ClassVO> getAll();
}