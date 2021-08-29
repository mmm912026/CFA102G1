package com.rentalOrder.model;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

public class TestRentalOrderJDBCDAO {
	public static void main(String[] args) {
		I_RentalOrderDAO dao = new RentalOrderJDBCDAO();
		
		//新增
		RentalOrderVO ro1 = new RentalOrderVO();
		Date date = new Date();
		Timestamp stamp = new Timestamp(date.getTime());
		ro1.setMem_no(4);
		ro1.setRpl_no(4);
		ro1.setRo_status("1");
		ro1.setRo_pay_status("1");
		ro1.setRo_pay_method("11");
		ro1.setRo_ship_method("123");
		ro1.setRo_ship_status("123");
		ro1.setRo_ship_addrs("232");
		ro1.setRo_starttime(stamp);
		ro1.setRo_endtime(stamp);				
		ro1.setRo_oncerentendtime(stamp);				
		ro1.setRo_return_date(stamp);				
		ro1.setRo_day(15);				
		ro1.setRo_price(20);				
		ro1.setRo_totalprice(2);				
		ro1.setRo_deposit(100);				
		ro1.setRo_deposit_status("123");				
		ro1.setRo_return_status("123");				
		ro1.setRo_return_method("123");				
		ro1.setRo_product_status("123");				
		ro1.setRo_repaircost(22222);				
		ro1.setRo_delay_days(14);				
		ro1.setRo_return_deposit(222);
		ro1 = dao.insert(ro1);
		System.out.println(ro1.getRo_no());
		//修改
//		RentalOrderVO ro1 = new RentalOrderVO();
//		Date date = new Date();
//		Timestamp stamp = new Timestamp(date.getTime());
//		ro1.setRo_no(8);
//		ro1.setMem_no(4);
//		ro1.setRpl_no(1);
//		ro1.setRo_status("update");
//		ro1.setRo_pay_status("update");
//		ro1.setRo_pay_method("update");
//		ro1.setRo_ship_method("update");
//		ro1.setRo_ship_status("update");
//		ro1.setRo_ship_addrs("update");
//		ro1.setRo_starttime(stamp);
//		ro1.setRo_endtime(stamp);				
//		ro1.setRo_oncerentendtime(stamp);				
//		ro1.setRo_return_date(stamp);				
//		ro1.setRo_day(15);				
//		ro1.setRo_price(20);				
//		ro1.setRo_totalprice(2);				
//		ro1.setRo_deposit(100);				
//		ro1.setRo_deposit_status("123");				
//		ro1.setRo_return_status("123");				
//		ro1.setRo_return_method("123");				
//		ro1.setRo_product_status("123");				
//		ro1.setRo_repaircost(22222);				
//		ro1.setRo_delay_days(14);				
//		ro1.setRo_return_deposit(222);
//		dao.update(ro1);
		//刪除
		dao.delete(11);
		//查詢
//		RentalOrderVO ro1 = dao.findByPK(1);
//		System.out.println(ro1.getRo_pay_method());
		//查詢全部
//		List<RentalOrderVO> list = dao.getAll();
//		for(RentalOrderVO item:list)
//			System.out.println(item.getRo_pay_method());
	}
}
