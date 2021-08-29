package com.rentalOrder.model;

import java.sql.Timestamp;
import java.util.List;

public class RentalOrderService {
	private I_RentalOrderDAO dao;
	
	public RentalOrderService() {
		dao = new RentalOrderJDBCDAO();
	}
	
	public RentalOrderVO insertRentalClass(Integer mem_no, Integer rpl_no, String ro_pay_status, String ro_pay_method,
			String ro_ship_method, String ro_ship_status, String ro_ship_addrs, Timestamp ro_starttime,
			Timestamp ro_endtime, Timestamp ro_oncerentendtime, Timestamp ro_return_date, Integer ro_day,
			Integer ro_price, Integer ro_totalprice, Integer ro_deposit, String ro_deposit_status,
			String ro_return_status, String ro_return_method, String ro_product_status, Integer ro_repaircost,
			Integer ro_delay_days, Integer ro_return_deposit) {
		
		RentalOrderVO rentalOrderVO = new RentalOrderVO();
		
		rentalOrderVO.setMem_no(mem_no);
		rentalOrderVO.setRpl_no(rpl_no);
		rentalOrderVO.setRo_pay_status(ro_pay_status);
		rentalOrderVO.setRo_pay_method(ro_pay_method);
		rentalOrderVO.setRo_ship_method(ro_ship_method);
		rentalOrderVO.setRo_ship_status(ro_ship_status);
		rentalOrderVO.setRo_ship_addrs(ro_ship_addrs);
		rentalOrderVO.setRo_starttime(ro_starttime);
		rentalOrderVO.setRo_endtime(ro_endtime);
		rentalOrderVO.setRo_oncerentendtime(ro_oncerentendtime);
		rentalOrderVO.setRo_return_date(ro_return_date);
		rentalOrderVO.setRo_day(ro_day);
		rentalOrderVO.setRo_price(ro_price);
		rentalOrderVO.setRo_totalprice(ro_totalprice);
		rentalOrderVO.setRo_deposit(ro_deposit);
		rentalOrderVO.setRo_deposit_status(ro_deposit_status);
		rentalOrderVO.setRo_return_status(ro_return_status);
		rentalOrderVO.setRo_return_method(ro_return_method);
		rentalOrderVO.setRo_product_status(ro_product_status);
		rentalOrderVO.setRo_repaircost(ro_repaircost);
		rentalOrderVO.setRo_delay_days(ro_delay_days);
		rentalOrderVO.setRo_return_deposit(ro_return_deposit);
		
		dao.insert(rentalOrderVO);
		
		return rentalOrderVO;
	}
	
	public RentalOrderVO updateRentalClass(Integer ro_no, Integer mem_no, Integer rpl_no, String ro_status, String ro_pay_status, String ro_pay_method,
			String ro_ship_method, String ro_ship_status, String ro_ship_addrs, Timestamp ro_starttime,
			Timestamp ro_endtime, Timestamp ro_oncerentendtime, Timestamp ro_return_date, Integer ro_day,
			Integer ro_price, Integer ro_totalprice, Integer ro_deposit, String ro_deposit_status,
			String ro_return_status, String ro_return_method, String ro_product_status, Integer ro_repaircost,
			Integer ro_delay_days, Integer ro_return_deposit) {

		RentalOrderVO rentalOrderVO = new RentalOrderVO();

		rentalOrderVO.setRo_no(ro_no);
		rentalOrderVO.setMem_no(mem_no);
		rentalOrderVO.setRpl_no(rpl_no);
		rentalOrderVO.setRo_status(ro_status);
		rentalOrderVO.setRo_pay_status(ro_pay_status);
		rentalOrderVO.setRo_pay_method(ro_pay_method);
		rentalOrderVO.setRo_ship_method(ro_ship_method);
		rentalOrderVO.setRo_ship_status(ro_ship_status);
		rentalOrderVO.setRo_ship_addrs(ro_ship_addrs);
		rentalOrderVO.setRo_starttime(ro_starttime);
		rentalOrderVO.setRo_endtime(ro_endtime);
		rentalOrderVO.setRo_oncerentendtime(ro_oncerentendtime);
		rentalOrderVO.setRo_return_date(ro_return_date);
		rentalOrderVO.setRo_day(ro_day);
		rentalOrderVO.setRo_price(ro_price);
		rentalOrderVO.setRo_totalprice(ro_totalprice);
		rentalOrderVO.setRo_deposit(ro_deposit);
		rentalOrderVO.setRo_deposit_status(ro_deposit_status);
		rentalOrderVO.setRo_return_status(ro_return_status);
		rentalOrderVO.setRo_return_method(ro_return_method);
		rentalOrderVO.setRo_product_status(ro_product_status);
		rentalOrderVO.setRo_repaircost(ro_repaircost);
		rentalOrderVO.setRo_delay_days(ro_delay_days);
		rentalOrderVO.setRo_return_deposit(ro_return_deposit);
		
		dao.update(rentalOrderVO);

		return rentalOrderVO;
	}

	public void deleteRentalClass(Integer ro_no) {
		dao.delete(ro_no);
	}

	public RentalOrderVO getOneRentalClass(Integer ro_no) {
		return dao.findByPK(ro_no);
	}

	public List<RentalOrderVO> getAll() {
		return dao.getAll();
	}
}
