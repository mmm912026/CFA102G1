package com.rentalClass.model;

import java.util.List;

public interface I_RentalClassDAO {
	public RentalClassVO insert(RentalClassVO RentalClassVO);
	public void update(RentalClassVO RentalClassVO);
	public void delete(Integer rc_no);
	public RentalClassVO findByPK(Integer rc_no);
	public List<RentalClassVO> getAll();
	
	//�@����W�U�[���A
	public void changeRc_status(Integer rc_no ,String rc_status);
	//�^�ǲ{��rc_item����(Desktop,NB,MINIPC)
	public List<String> getAllRc_Item();
	//�Q��rc_item�d��
	public List<RentalClassVO> findByRc_item(String rc_item);
}
