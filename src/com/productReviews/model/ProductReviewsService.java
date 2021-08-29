package com.productReviews.model;

import java.util.List;

public class ProductReviewsService {
	private I_ProductReviewsDAO dao;
	
	public ProductReviewsService() {
		dao = new ProductReviewsJDBCDAO();
	}
	
	public ProductReviewsVO insertProductReviews(Integer rc_no, Integer ro_no, String pr_content, byte[] pr_images,
			Integer pr_score, String pr_status) {
		
		ProductReviewsVO productReviewsVO = new ProductReviewsVO();
		
		productReviewsVO.setRc_no(rc_no);
		productReviewsVO.setRo_no(ro_no);
		productReviewsVO.setPr_content(pr_content);
		productReviewsVO.setPr_images(pr_images);
		productReviewsVO.setPr_score(pr_score);
		productReviewsVO.setPr_status(pr_status);

		dao.insert(productReviewsVO);
		
		return productReviewsVO;
	}
	
	public ProductReviewsVO updateProductReviews(Integer pr_no, Integer rc_no, Integer ro_no, String pr_content, byte[] pr_images,
			Integer pr_score, String pr_status) {

		ProductReviewsVO productReviewsVO = new ProductReviewsVO();

		productReviewsVO.setPr_no(pr_no);
		productReviewsVO.setRc_no(rc_no);
		productReviewsVO.setRo_no(ro_no);
		productReviewsVO.setPr_content(pr_content);
		productReviewsVO.setPr_images(pr_images);
		productReviewsVO.setPr_score(pr_score);
		productReviewsVO.setPr_status(pr_status);
		
		dao.update(productReviewsVO);

		return productReviewsVO;
	}

	public void deleteProductReviews(Integer pr_no) {
		dao.delete(pr_no);
	}

	public ProductReviewsVO getOneProductReviews(Integer pr_no) {
		return dao.findByPK(pr_no);
	}

	public List<ProductReviewsVO> getAll() {
		return dao.getAll();
	}
}
