package com.rentalClass.model;

import java.util.List;

public interface I_RentalClassDAO {
	public RentalClassVO insert(RentalClassVO RentalClassVO);
	public void update(RentalClassVO RentalClassVO);
	public void delete(Integer rc_no);
	public RentalClassVO findByPK(Integer rc_no);
	public List<RentalClassVO> getAll();
	
	//一鍵更改上下架狀態
	public void changeRc_status(Integer rc_no ,String rc_status);
	//回傳現有rc_item種類(Desktop,NB,MINIPC)
	public List<String> getAllRc_Item();
	//利用rc_item查詢
	public List<RentalClassVO> findByRc_item(String rc_item);
}
