package com.rentalClass.model;

import java.util.List;

public class RentalClassService {
	private I_RentalClassDAO dao;
	
	public RentalClassService() {
		dao = new RentalClassDAO();
	}
	
	public RentalClassVO insertRentalClass(String rc_name, String rc_item, String rc_detail, Integer rc_deposit, Integer rc_price) {
		
		RentalClassVO rentalClassVO = new RentalClassVO();
		
		rentalClassVO.setRc_name(rc_name);
		rentalClassVO.setRc_item(rc_item);
		rentalClassVO.setRc_detail(rc_detail);
		rentalClassVO.setRc_deposit(rc_deposit);
		rentalClassVO.setRc_price(rc_price);
		rentalClassVO = dao.insert(rentalClassVO);
		rentalClassVO.setRc_status("下架");
		rentalClassVO.setRc_storage(0);
		rentalClassVO.setRc_total_count(0);
		rentalClassVO.setRc_total_score(0);
		
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
	//一個按鍵更改類別狀態
	public void changeRentalClassStatus(Integer rc_no ,String rc_status) {
		dao.changeRc_status(rc_no ,rc_status);
	}
	//回傳全部種類
	public List<String> getAllRc_Item() {
		return dao.getAllRc_Item();
	}
	//用種類取回RC list
	public List<RentalClassVO> getOneRc_item(String rc_item) {
		return dao.findByRc_item(rc_item);
	}
}
