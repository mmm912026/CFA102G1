package com.rentalProductList.model;

import java.sql.Timestamp;
import java.util.List;

public class RentalProductListService {
	private I_RentalProductListDAO dao;
	
	public RentalProductListService() {
		dao = new RentalProductListJDBCDAO();
	}
	
	public RentalProductListVO insertRentalProductList(Integer rc_no, String rpl_serialnum,String rpl_note) {
		
		RentalProductListVO rentalProductListVO = new RentalProductListVO();
		
		rentalProductListVO.setRc_no(rc_no);
		rentalProductListVO.setRpl_serialnum(rpl_serialnum);
		rentalProductListVO.setRpl_note(rpl_note);
		dao.insert(rentalProductListVO);
		
		return rentalProductListVO;
	}
	
	public RentalProductListVO updateRentalProductList(Integer rpl_no, Integer rc_no, String rpl_serialnum, String rpl_note, String rpl_status,
			Integer rpl_rentcount, Timestamp rpl_jointtime) {

		RentalProductListVO rentalProductListVO = new RentalProductListVO();

		rentalProductListVO.setRpl_no(rpl_no);
		rentalProductListVO.setRc_no(rc_no);
		rentalProductListVO.setRpl_serialnum(rpl_serialnum);
		rentalProductListVO.setRpl_note(rpl_note);
		rentalProductListVO.setRpl_status(rpl_status);
		rentalProductListVO.setRpl_rentcount(rpl_rentcount);
		rentalProductListVO.setRpl_jointtime(rpl_jointtime);
		dao.update(rentalProductListVO);

		return rentalProductListVO;
	}

	public void deleteRentalProductList(Integer rpl_no) {
		dao.delete(rpl_no);
	}

	public RentalProductListVO getOneRentalProductList(Integer rpl_no) {
		return dao.findByPK(rpl_no);
	}

	public List<RentalProductListVO> getAll() {
		return dao.getAll();
	}
}
