package com.rentalProductList.model;

import java.util.List;

public interface I_RentalProductListDAO {
	public RentalProductListVO insert(RentalProductListVO RentalProductListVO);
	public void update(RentalProductListVO RentalProductListVO);
	public void delete(Integer rpl_no);
	public RentalProductListVO findByPK(Integer rpl_no);
	public List<RentalProductListVO> getAll();
	
	public List<RentalProductListVO> findbyRc_no(Integer rc_no);
	public List<RentalProductListVO> findbyRc_item(String rc_item);
	public void changeRpl_status(Integer rpl_no,String rpl_status,String rpl_status2);
}
