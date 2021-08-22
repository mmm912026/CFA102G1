package com.sec.product_class.model;

import java.util.List;

public interface I_ProductClassDAO {
	public void insert(ProductClassVO productClassVO);
	public void update(ProductClassVO productClassVO);
	public void delete(Integer spc_no);
	public ProductClassVO findByPK(Integer spc_no);
	public List<ProductClassVO> getAll();
}
