package com.rentalClass.model;

import java.util.List;

public interface I_RentalClassDAO {
	public void insert(RentalClassVO RentalClassVO);
	public void update(RentalClassVO RentalClassVO);
	public void delete(Integer rc_no);
	public RentalClassVO findByPK(Integer rc_no);
	public List<RentalClassVO> getAll();
}
