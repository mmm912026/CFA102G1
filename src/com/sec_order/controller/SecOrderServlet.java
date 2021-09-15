package com.sec_order.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
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
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("action : " + action);
		
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
		
		if("getOneForUpdate".equals(action)) {
			/****1.取的參數****/
			Integer so_no = new Integer(req.getParameter("so_no"));
			
			/****2.開始查詢****/
			SecOrderService secOrderSvc = new SecOrderService();
			SecOrderVO secOrderVO = secOrderSvc.getOneSecOrder(so_no);
			req.setAttribute("secOrderVO", secOrderVO);
			
			/****3.頁面轉向****/
			RequestDispatcher successView = 
					req.getRequestDispatcher("/back_end/secOrder/updateSecOrder.jsp");
			successView.forward(req, res);
			return;
		}
		
		if("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/****1.取得參數****/
			Integer so_no = new Integer(req.getParameter("so_no"));//訂單編號
			String so_sta = req.getParameter("so_sta"); //訂單狀態
			String so_pay_sta = req.getParameter("so_pay_sta"); //付款狀態
			String so_ship_sta = req.getParameter("so_ship_sta"); //出貨狀態
			String so_prodel = req.getParameter("so_prodel"); //運送方式
			String str = req.getParameter("so_deladrs"); //配送地址
			System.out.println("so_shipdate : " + req.getParameter("so_shipdate"));
						
			Timestamp  so_shipdate = Timestamp.valueOf(new StringBuilder(req.getParameter("so_shipdate"))
																			.append(" 00:00:00.123")
																			.toString());  //出貨日期
			
			/**********************************************************/

			Timestamp  so_purtime = Timestamp.valueOf(req.getParameter("so_purtime")); //訂購日期
			
			Integer mem_no =new Integer(req.getParameter("mem_no")); //會員編號
			Integer ci_no =new Integer(req.getParameter("ci_no")); //優惠券編號
			Integer so_totalpri =new Integer(req.getParameter("so_totalpri")); //訂單總價格 
			String so_paymthd = req.getParameter("so_paymthd"); //付款方式 
			Integer so_delcost =new Integer(req.getParameter("so_delcost")); //運費
			Integer so_discount_price =new Integer(req.getParameter("so_discount_price")); //訂單總價格 
						
			if(str.trim().length()==0) {
				errorMsgs.add("請輸入配送地址!!!");
			}
			
			SecOrderService secOrderSvc_1 = new SecOrderService();
			SecOrderVO secOrderVO = secOrderSvc_1.getOneSecOrder(so_no);
			secOrderVO.setSo_sta(so_sta);
			secOrderVO.setSo_pay_sta(so_pay_sta);
			secOrderVO.setSo_ship_sta(so_ship_sta);
			secOrderVO.setSo_prodel(so_prodel);
			secOrderVO.setSo_deladrs(str);
			req.setAttribute("secOrderVO", secOrderVO);
			
			
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failView = 
						req.getRequestDispatcher("/back_end/secOrder/updateSecOrder.jsp");
				failView.forward(req, res);
				return;
			}
			
			String so_deladrs = str;
			
			/****2.更新資料****/
			SecOrderService secOrderSvc = new SecOrderService();
			secOrderSvc.updateSecOrder(so_no, so_purtime, mem_no, so_sta, so_pay_sta, so_ship_sta, ci_no, so_totalpri, 
										so_prodel, so_deladrs, so_paymthd, so_shipdate, so_delcost, so_discount_price);
			
			/****3.頁面轉向****/
			RequestDispatcher successView = 
					req.getRequestDispatcher("/back_end/secOrder/listAllSecOrder.jsp");
			successView.forward(req, res);
			return;
			
		}
		
	}
	
	
}
