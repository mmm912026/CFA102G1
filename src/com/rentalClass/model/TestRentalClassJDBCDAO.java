package com.rentalClass.model;

import java.util.List;

public class TestRentalClassJDBCDAO {
	public static void main(String[] args) {
		I_RentalClassDAO dao = new RentalClassJDBCDAO();
		
		//更改狀態
		dao.changeRc_status(1, "下架");
		//新增
		RentalClassVO rc1 = new RentalClassVO("Apple Mac Mini 2022","MINIPC","",15000,150);
		rc1 = dao.insert(rc1);
		System.out.println(rc1.getRc_no());


		//修改
//		RentalClassVO rc1 = new RentalClassVO("Apple Mac Mini 2015","MINIPC","GOOD",15000,150,0,0,10,"上架");
//		rc1.setRc_no(1);
//		dao.update(rc1);
		
		//刪除
//		dao.delete(4);
		
		//查詢
//		RentalClassVO rc1 = dao.findByPK(1);
//		System.out.println(rc1.getRc_name());
//		System.out.println(rc1.getRc_deposit());
		
		//查詢全部
//		List<RentalClassVO> list = dao.getAll();
//		for(RentalClassVO item:list)
//			System.out.println(item.getRc_name());
	}
}
