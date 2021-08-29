package com.rentalClass.model;

import java.util.List;

public class RentalClassService {
	private I_RentalClassDAO dao;
	
	public RentalClassService() {
		dao = new RentalClassJDBCDAO();
	}
	
	public RentalClassVO insertRentalClass(String rc_name, String rc_item, String rc_detail, Integer rc_deposit, Integer rc_price) {
		
		RentalClassVO rentalClassVO = new RentalClassVO();
		
		rentalClassVO.setRc_name(rc_name);
		rentalClassVO.setRc_item(rc_item);
		rentalClassVO.setRc_detail(rc_detail);
		rentalClassVO.setRc_deposit(rc_deposit);
		rentalClassVO.setRc_price(rc_price);
		dao.insert(rentalClassVO);
		
		return rentalClassVO;
	}
	
	public RentalClassVO updateRentalClass(Integer rc_no,String rc_name, String rc_item, String rc_detail, Integer rc_deposit, Integer rc_price,Integer rc_total_count,Integer rc_total_score,Integer rc_storage,String rc_status) {

		RentalClassVO rentalClassVO = new RentalClassVO();

		rentalClassVO.setRc_no(rc_no);
		rentalClassVO.setRc_name(rc_name);
		rentalClassVO.setRc_item(rc_item);
		rentalClassVO.setRc_detail(rc_detail);
		rentalClassVO.setRc_deposit(rc_deposit);
		rentalClassVO.setRc_price(rc_price);
		rentalClassVO.setRc_total_count(rc_total_count);
		rentalClassVO.setRc_total_score(rc_total_score);
		rentalClassVO.setRc_storage(rc_storage);
		rentalClassVO.setRc_status(rc_status);
		dao.update(rentalClassVO);

		return rentalClassVO;
	}

	public void deleteRentalClass(Integer rc_no) {
		dao.delete(rc_no);
	}

	public RentalClassVO getOneRentalClass(Integer rc_no) {
		return dao.findByPK(rc_no);
	}

	public List<RentalClassVO> getAll() {
		return dao.getAll();
	}
}
