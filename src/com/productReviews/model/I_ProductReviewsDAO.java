package com.productReviews.model;

import java.util.List;

public interface I_ProductReviewsDAO {
	public ProductReviewsVO insert(ProductReviewsVO ProductReviewsVO);
	public void update(ProductReviewsVO ProductReviewsVO);
	public void delete(Integer pr_no);
	public ProductReviewsVO findByPK(Integer pr_no);
	public List<ProductReviewsVO> getAll();
	//�Q��rc_no���o�������O�Ҧ�����
	public List<ProductReviewsVO> getbyRc(Integer rc_no);
	//�Q��ro_no���o����
	public ProductReviewsVO findByRo_no(Integer ro_no);
}
