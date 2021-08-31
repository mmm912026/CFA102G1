package com.maintence_case_img.model;

import java.util.List;

public class Maintence_Case_ImgService {
	
	private I_Maintence_Case_ImgDAO dao;
	
	public Maintence_Case_ImgService() {
		dao = new Maintence_Case_ImgJDBCDAO();
	}
	
	public Maintence_Case_ImgVO insertMaintenceCaseImg(Integer mca_no, byte[] mci_before_img,byte[] mci_after_img ) {
		
		Maintence_Case_ImgVO maintenceCaseImgVO = new Maintence_Case_ImgVO();
		
		maintenceCaseImgVO.setMca_no(mca_no);
		maintenceCaseImgVO.setMci_before_img(mci_before_img);
		maintenceCaseImgVO.setMci_after_img(mci_after_img);
		maintenceCaseImgVO = dao.insert(maintenceCaseImgVO);
		return maintenceCaseImgVO;
	}

	public Maintence_Case_ImgVO updateMaintenceCaseImg(Integer mci_no,Integer mca_no,byte[] mci_before_img,byte[] mci_after_img ) {
		
		Maintence_Case_ImgVO maintenceCaseImgVO = new Maintence_Case_ImgVO();
		
		maintenceCaseImgVO.setMci_no(mci_no);
		maintenceCaseImgVO.setMca_no(mca_no);
		maintenceCaseImgVO.setMci_before_img(mci_before_img);
		maintenceCaseImgVO.setMci_after_img(mci_after_img);
		dao.update(maintenceCaseImgVO);
		return maintenceCaseImgVO;
	}

	public void deleteMaintenceCaseImg(Integer mci_no) {
		dao.delete(mci_no);
	}

	public  Maintence_Case_ImgVO getOneMaintenceCaseImg(Integer mci_no) {
		return dao.findByPK(mci_no);
	}

	public List<Maintence_Case_ImgVO> getAll() {
		return dao.getAll();
	}
}
