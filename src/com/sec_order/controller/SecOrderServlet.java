package com.sec_order.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec_order.model.SecOrderService;
import com.sec_order.model.SecOrderVO;
import com.sec_order_list.model.SecOrderListService;
import com.sec_order_list.model.SecOrderListVO;

import oracle.net.aso.s;

public class SecOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println("action" + action);
		
		if("getOneForDiplay".equals(action)) {
			
			/****1.取得參數****/
			Integer so_no = new Integer(req.getParameter("so_no"));
			
			/****2.開始查詢****/
			
			/****查詢訂單****/
			SecOrderService secOrderSvc = new SecOrderService();
			SecOrderVO secOrderVO = secOrderSvc.getOneSecOrder(so_no);
			req.setAttribute("secOrderVO", secOrderVO);
			
			/****查詢訂單明細****/
			SecOrderListService secOrderListSvc = new SecOrderListService();
			List<SecOrderListVO> secOrderListVOs = secOrderListSvc.getAll()
																  .stream()
																  .filter(s -> s.getSo_no().equals(so_no)) /*篩選出此訂單的明細*/
																  .collect(Collectors.toList());
			req.setAttribute("secOrderListVOs", secOrderListVOs);
			
			/****3.頁面轉向****/
			RequestDispatcher successView = 
					req.getRequestDispatcher("/back_end/secOrder/listOneOrder.jsp");
			successView.forward(req, res);
			return;
			
		}
		
	}
	
	
}
