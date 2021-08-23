package com.rentalProductList.model;

import java.util.List;

public interface I_RentalProductListDAO {
	public void insert(RentalProductListVO RentalProductListVO);
	public void update(RentalProductListVO RentalProductListVO);
	public void delete(Integer rpl_no);
	public RentalProductListVO findByPK(Integer rpl_no);
	public List<RentalProductListVO> getAll();
}
