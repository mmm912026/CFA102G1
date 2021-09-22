package com.rentalOrder.model;

import java.util.List;

public interface I_RentalOrderDAO {
	public RentalOrderVO insert(RentalOrderVO RentalOrderVO);
	public void update(RentalOrderVO RentalOrderVO);
	public void delete(Integer ro_no);
	public RentalOrderVO findByPK(Integer ro_no);
	public List<RentalOrderVO> getAll();
	//找一個rc_no類別的待租商品/更改該待租商品狀態為預約
	public Integer findOneForRent(Integer rc_no);
	//更改未付款訂單狀態為整備完成,待出貨
	public void changeROToWaitDeliver(Integer ro_no);
	//更改未付款訂單狀態為租賃中/更改該待租商品狀態為租賃中
	public void changeROToOnRent(Integer ro_no,Integer rpl_no);
	//用狀態尋找訂單List
	public List<RentalOrderVO> findByRoStatus(String ro_status);
	//用會員編號尋找訂單List
	public List<RentalOrderVO> findByMem_no(Integer mem_no);
	//用商品編號跟訂單狀態尋找訂單
	public List<RentalOrderVO> findByRpl_noAndRoStatus (Integer rpl_no, String ro_status);
	
	
}
