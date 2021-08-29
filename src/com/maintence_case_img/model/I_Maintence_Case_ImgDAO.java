package com.maintence_case_img.model;

import java.util.List;

public interface I_Maintence_Case_ImgDAO {
	
	public Maintence_Case_ImgVO insert(Maintence_Case_ImgVO maintenceCaseimgvo);
	public void update(Maintence_Case_ImgVO maintenceCaseimgvo);
	public void delete(Integer mci_no);
	public Maintence_Case_ImgVO findByPK(Integer mci_no);
	public List<Maintence_Case_ImgVO> getAll();

}
