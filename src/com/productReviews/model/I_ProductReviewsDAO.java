package com.productReviews.model;

import java.util.List;

public interface I_ProductReviewsDAO {
	public ProductReviewsVO insert(ProductReviewsVO ProductReviewsVO);
	public void update(ProductReviewsVO ProductReviewsVO);
	public void delete(Integer pr_no);
	public ProductReviewsVO findByPK(Integer pr_no);
	public List<ProductReviewsVO> getAll();
	//利用rc_no取得租賃類別所有評價
	public List<ProductReviewsVO> getbyRc(Integer rc_no);
	//利用ro_no取得評價
	public ProductReviewsVO findByRo_no(Integer ro_no);
}
