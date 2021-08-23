package com.sec_order_list.model;

import java.util.List;

public interface I_SecOrderListDAO {
	public void insert(SecOrderListVO secOrderList);
	public void update(SecOrderListVO secOrderList);
	public void delete(Integer sol_no);
	public SecOrderListVO findByPk(Integer sol_no);
	public List<SecOrderListVO> getAll();
}
