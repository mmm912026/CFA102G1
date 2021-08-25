package com.appraisal_case.model;

import java.util.List;

public interface I_Appraisal_CaseDAO {
	
	public void insert(Appraisal_CaseVO appraisal_CaseVO);
	public void update(Appraisal_CaseVO appraisal_CaseVO);
	public void delete(Integer aca_no);
	public Appraisal_CaseVO findByPK(Integer aca_no);
	public List<Appraisal_CaseVO> getAll();

}