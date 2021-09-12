package com.rentalOrder.model;

import java.util.List;

public interface I_RentalOrderDAO {
	public RentalOrderVO insert(RentalOrderVO RentalOrderVO);
	public void update(RentalOrderVO RentalOrderVO);
	public void delete(Integer ro_no);
	public RentalOrderVO findByPK(Integer ro_no);
	public List<RentalOrderVO> getAll();
	//��@��rc_no���O���ݯ��ӫ~/���ӫݯ��ӫ~���A���w��
	public Integer findOneForRent(Integer rc_no);
	//��良�I�ڭq�檬�A����Ƨ���,�ݥX�f
	public void changeROToWaitDeliver(Integer ro_no);
	//��良�I�ڭq�檬�A�����/���ӫݯ��ӫ~���A�����
	public void changeROToOnRent(Integer ro_no,Integer rpl_no);
	
	public List<RentalOrderVO> findByRoStatus(String ro_status);
	
}
