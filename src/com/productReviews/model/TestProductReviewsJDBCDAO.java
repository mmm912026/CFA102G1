package com.productReviews.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TestProductReviewsJDBCDAO {
	public static void main(String[] args) throws IOException {
		I_ProductReviewsDAO dao = new ProductReviewsJDBCDAO();
		ProductReviewsVO pr1 = new ProductReviewsVO();
		
		//新增
		pr1.setRc_no(6);
		pr1.setRo_no(12);
		pr1.setPr_content("hihi");
		byte[] pic = getPictureByteArray("C:/images/1.jpg");
		pr1.setPr_images(pic);
		pr1.setPr_score(5);
		pr1.setPr_status("123");
		pr1 = dao.insert(pr1);
		System.out.println(pr1.getPr_no());
		//修改
//		pr1.setPr_no(5);
//		pr1.setRc_no(7);
//		pr1.setRo_no(3);
//		pr1.setPr_content("update");
//		byte[] pic = getPictureByteArray("C:/images/1.jpg");
//		pr1.setPr_images(pic);
//		pr1.setPr_score(5);
//		pr1.setPr_status("update");
//		dao.update(pr1);
		
		//刪除
//		dao.delete(7);
		
		//查詢
//		ProductReviewsVO pr1 = dao.findByPK(5);
//		System.out.println(pr1.getPr_content());
		//查詢全部
//		List<ProductReviewsVO> list = dao.getAll();
//		for(ProductReviewsVO pr1 : list ) 
//			System.out.println(pr1.getPr_content());
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}
	
}
