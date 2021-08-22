package com.promotion.pro.model;

import java.util.List;

public interface I_PromotionDAO {
	public void insert(PromotionVO promotionVO);
	public void update(PromotionVO promotionVO);
	public void delete(Integer promotion_no);
	public PromotionVO findByPk(Integer promotion_no);
	public List<PromotionVO> getAll();
}
