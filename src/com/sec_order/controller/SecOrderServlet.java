package com.sec_order.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;

import com.sec_order.model.SecOrderService;
import com.sec_order.model.SecOrderVO;
import com.sec_order_list.model.SecOrderListService;
import com.sec_order_list.model.SecOrderListVO;
import com.sec_product_inform.model.ProductInformVO;

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
		
		if("insert".equals(action)) {
			HttpSession session = req.getSession();
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			//取得購物車內的商品
			Vector<ProductInformVO> productInformList = (Vector<ProductInformVO>) session.getAttribute("shoppingCart_sec");
			//取得商品購買數量
			Map<Integer, Integer> Quamap = (Map<Integer, Integer>) session.getAttribute("Quamap");

			/****1.取得參數****/
			System.out.println("Enter sec order insert!!!"); 
			String so_prodel = req.getParameter("so_prodel"); //運送方式 >> 自取or宅配
			String so_deladrs = req.getParameter("so_deladrs");//配送地址 >>需要檢查此欄位!!!
			String so_paymthd = req.getParameter("so_paymthd");//付款方式 >> 匯款or信用卡
			
			//檢查配送地址是否為空
			if(so_deladrs.trim().length()==0) {
				errorMsgs.add("請輸入配送地址!!");
			}
			
			//檢查購物車內是否有商品
			if( !(productInformList!=null && productInformList.size()>0) ) {
				errorMsgs.add("請加入要購買的商品");
			}
			
			req.setAttribute("so_prodel", so_prodel);
			req.setAttribute("so_deladrs", so_deladrs);
			req.setAttribute("so_paymthd", so_paymthd);
			
			if(!errorMsgs.isEmpty()) {				
				RequestDispatcher failView =
						req.getRequestDispatcher("/front_end/secOrder/checkOut.jsp");
				failView.forward(req, res);
				return;
			}
										
			/****2.給予初始值****/
			Timestamp so_purtime = new Timestamp(System.currentTimeMillis());  //訂購時間 >>預設為下單當下時間
			Integer mem_no = new Integer(1); //會員編號 >> 目前先死，之後直接抓登入的會員編號
			String so_sta = "備貨中";	//訂單狀態 >> 預設為備貨中
			String so_pay_sta = "待付款"; //付款狀態 >> 先寫死!!
			String so_ship_sta = "未出貨"; //出貨狀態 >> 預設為未出貨
			Integer ci_no = new Integer(1); // 優惠券編號 >> 先寫死(還未解決空值問題)
			Timestamp so_shipdate = null; //出貨日期 >> 預設為空
			Integer so_delcost = new Integer( so_prodel.equals("自取")?"0":"100" ); //配送費用 >> 自取運費為0，宅配100
			Integer so_totalpri = Quamap.get(999) + so_delcost; //訂單總價格 >> 商品費用+配送費用
			Integer so_discount_price = so_totalpri ;//訂單優惠價格 >> 訂單總價格-優惠券折扣費用
				
			/****3.將購物車內商品加入"商品明細"中****/
			List<SecOrderListVO> secOrderListVOs = new LinkedList<SecOrderListVO>();
			SecOrderListVO secOrderVO = null;
			for(ProductInformVO productInformVO :productInformList) {
				secOrderVO = new SecOrderListVO();
				Integer Spi_no = productInformVO.getSpi_no();//取得商品編號
				secOrderVO.setSpi_no(Spi_no); //加入商品編號
				secOrderVO.setSol_proamot(Quamap.get(Spi_no));//加入商品數量
				
				//計算商品明細總價(商品價格 * 購買數量)
				Integer sol_pri = productInformVO.getSpi_pri() * Quamap.get(Spi_no);
				secOrderVO.setSol_pri(sol_pri);
				secOrderListVOs.add(secOrderVO);
			}
			
			try {
				/****4.開始新增商品訂單、商品明細****/
				SecOrderService secOrderSvc = new SecOrderService();
				SecOrderVO secOrderVO2 = null;
				secOrderVO2 = secOrderSvc.insertSecOrderWithList(so_purtime, mem_no, so_sta, so_pay_sta, so_ship_sta, ci_no, 
											so_totalpri, so_prodel, so_deladrs, so_paymthd, so_shipdate, 
											so_delcost, so_discount_price, secOrderListVOs);
				
				req.setAttribute("secOrderVO", secOrderVO2);
							
			} catch (Exception e) {
				errorMsgs.add("結帳失敗");
				RequestDispatcher failView =
						req.getRequestDispatcher("/front_end/secOrder/checkOut.jsp");
				failView.forward(req, res);
				return;
			}finally {
				//結帳完成，清空購物車內商品
				productInformList.removeAllElements();
				Quamap.clear();
				
				session.setAttribute("Quamap", Quamap);
				session.setAttribute("shoppingCart_sec", productInformList);
				
				String str = null;
				if(so_paymthd.equals("信用卡")) {
					str = "/front_end/secOrder/creditCardPay.jsp";
				}else {
					str = "/front_end/secOrder/transferPay.jsp";
				}
				
				RequestDispatcher successView = 
						req.getRequestDispatcher(str);
				successView.forward(req, res);
			}
			return;
		}
		
		if("confirmPay".equals(action)) {
			/*預設皆為付款成功*/
			
			/****1.取得訂單編號****/
			Integer so_no = new Integer(req.getParameter("so_no"));
			
			/****2.查詢訂單****/
			SecOrderService secOrderSvc = new SecOrderService();
			SecOrderVO secOrderVO = secOrderSvc.getOneSecOrder(so_no);
			
			/****3.修改訂單狀態 (待付款更改為已付款)****/
			secOrderVO.setSo_pay_sta("已付款");
			
			/****4.更新訂單****/
			secOrderSvc.updateSecOrder( secOrderVO.getSo_no(),		secOrderVO.getSo_purtime(),	 secOrderVO.getMem_no(), 
										secOrderVO.getSo_sta(),		secOrderVO.getSo_pay_sta(),	 secOrderVO.getSo_ship_sta(), 
										secOrderVO.getCi_no(),		secOrderVO.getSo_totalpri(), secOrderVO.getSo_prodel(), 
										secOrderVO.getSo_deladrs(),	secOrderVO.getSo_paymthd(),  secOrderVO.getSo_shipdate(), 
										secOrderVO.getSo_delcost(),	secOrderVO.getSo_discount_price() );
			
			/****5.轉向至付款成功頁面****/
			req.setAttribute("secOrderVO", secOrderVO);

			RequestDispatcher successView = 
					req.getRequestDispatcher("/front_end/secOrder/paymentSuccess.jsp");
			successView.forward(req, res);
			return;
		}
		
	}
	
	
}
