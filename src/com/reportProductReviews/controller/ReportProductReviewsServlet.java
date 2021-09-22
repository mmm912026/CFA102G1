package com.reportProductReviews.controller;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;
import com.productReviews.model.*;
import com.reportProductReviews.model.*;

public class ReportProductReviewsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		//�e�x�s�W�������|
		if ("insert".equals(action)) {
					
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			
			try {
				Integer pr_no = new Integer(req.getParameter("pr_no"));
				Integer rep_contentnum = new Integer(req.getParameter("rep_contentnum"));
				String rep_content = null;
				
				if(rep_contentnum==1)
					rep_content = "�������";
				else if (rep_contentnum==2)
					rep_content = "���A���e";
				else if (rep_contentnum==3) {
					rep_content = req.getParameter("message");
				}
				
				ReportProductReviewsService repSvc = new ReportProductReviewsService();
				repSvc.insertReportProductReviews(pr_no, 1 , rep_content);
				
				out.println("<div style=\"text-align:center;vertical-align:middle;line-height: 150px;\" >");
				out.println("<h3>�ڭ̤w�������|�A�N�|�ɳt�B�z�A����!</h3>");
				out.println("<button onclick=\"window.close();\">��������</button>");
				out.println("</div>");
			} catch (Exception e) {
				throw new ServletException(e);
			}		
		}
		
		
		//�e�x��ܵ������|����
		if ("showRepPage".equals(action)) {
			try {
				Integer pr_no = new Integer(req.getParameter("pr_no"));
				ProductReviewsService prSvc = new ProductReviewsService();
				ProductReviewsVO prVO = prSvc.getOneProductReviews(pr_no);
				req.setAttribute("prVO", prVO);
				RequestDispatcher successView = req
						.getRequestDispatcher("/front_end/rental/reportProductReviewsPage.jsp");
				successView.forward(req, res);
				
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		
		//��x�s������
		if ("getOnePr_For_DisplayDetail".equals(action)) {
			
			try {

				Integer pr_no = new Integer(req.getParameter("pr_no"));
				Integer rep_no = new Integer(req.getParameter("rep_no"));
				
				ProductReviewsService prSvc = new ProductReviewsService();
				ProductReviewsVO prVO = prSvc.getOneProductReviews(pr_no);
				ReportProductReviewsService repSvc = new ReportProductReviewsService();
				ReportProductReviewsVO repVO = repSvc.getOneReportProductReviews(rep_no);
				
				req.setAttribute("prVO", prVO);
				req.setAttribute("repVO", repVO);
				
				RequestDispatcher successView = req
						.getRequestDispatcher("/back_end/reportProductReviews/listOnePrDetail.jsp");
				successView.forward(req, res);
				return;

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		
		//��x�̿z��q�檬�A���
		if("getOneRepStatus_For_Display".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				ReportProductReviewsService repSvc = new ReportProductReviewsService();
				List<ReportProductReviewsVO> listAll = repSvc.getAll();
				
				String rep_status = req.getParameter("rep_status");
				List<ReportProductReviewsVO> list = listAll.stream()
				        .filter(e -> e.getRep_status().equals(rep_status))
				        .collect(Collectors.toList());
				
				req.setAttribute("list", list);
				
				String url = "/back_end/reportProductReviews/listRprbyStatus.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);
				
				
			} catch (Exception e){
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/reportProductReviews/listRpr.jsp");
				failureView.forward(req, res);
			}	
		}
		
		
		//�������|�q�L,�U�[����
		if("passReport".equals(action)) {
					
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
				
			try {
				Integer rep_no = new Integer(req.getParameter("rep_no"));
					
				ReportProductReviewsService repSvc = new ReportProductReviewsService();
				ReportProductReviewsVO repVO = repSvc.getOneReportProductReviews(rep_no);
				repVO.setRep_status("�q�L");
				repSvc.updateReportProductReviews(repVO);
						
				ProductReviewsService prSvc = new ProductReviewsService();
				ProductReviewsVO prVO = prSvc.getOneProductReviews(repVO.getPr_no());
				prVO.setPr_status("�U�[");
				prSvc.updateProductReviews(prVO);
				
				req.setAttribute("repVO", repVO);
				req.setAttribute("prVO", prVO);
						
				String url = "/back_end/reportProductReviews/listRpr.jsp";
				String requestURL = req.getParameter("requestURL");
				
				if(requestURL.equals("/back_end/reportProductReviews/listRprbyStatus.jsp")){
					url = "/back_end/reportProductReviews/listRprbyStatus.jsp";
					List<ReportProductReviewsVO> listAll = repSvc.getAll();
					List<ReportProductReviewsVO> list = listAll.stream()
					        .filter(e -> e.getRep_status().equals("���B�z"))
					        .collect(Collectors.toList());							
					req.setAttribute("list", list);
				}
				
				String fromListOnePrDetail = req.getParameter("fromListOnePrDetail");
				if("true".equals(fromListOnePrDetail)) {
					url = "/back_end/reportProductReviews/listOnePrDetail.jsp";
					req.setAttribute("closewindow", true);
				}
				
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);
						
			} catch (Exception e){
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/reportProductReviews/listRpr.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		//�������|���q�L
		if("notPassReport".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				Integer rep_no = new Integer(req.getParameter("rep_no"));
				
				ReportProductReviewsService repSvc = new ReportProductReviewsService();
				ReportProductReviewsVO repVO = repSvc.getOneReportProductReviews(rep_no);
				repVO.setRep_status("���q�L");
				repSvc.updateReportProductReviews(repVO);
				ProductReviewsService prSvc = new ProductReviewsService();
				ProductReviewsVO prVO = prSvc.getOneProductReviews(repVO.getPr_no());
				
				req.setAttribute("repVO", repVO);
				req.setAttribute("prVO", prVO);
				
				String url = "/back_end/reportProductReviews/listRpr.jsp";
				String requestURL = req.getParameter("requestURL");
				
				if(requestURL.equals("/back_end/reportProductReviews/listRprbyStatus.jsp")) {
					url = "/back_end/reportProductReviews/listRprbyStatus.jsp";
					List<ReportProductReviewsVO> listAll = repSvc.getAll();
					List<ReportProductReviewsVO> list = listAll.stream()
					        .filter(e -> e.getRep_status().equals("���B�z"))
					        .collect(Collectors.toList());							
					req.setAttribute("list", list);
				}
						
				String fromListOnePrDetail = req.getParameter("fromListOnePrDetail");
				if("true".equals(fromListOnePrDetail)) {
					url = "/back_end/reportProductReviews/listOnePrDetail.jsp";
					req.setAttribute("closewindow", true);
				}
				
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);
				
			}catch (Exception e){
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/reportProductReviews/listRpr.jsp");
				failureView.forward(req, res);
			}
		}
		
		//��x��ܤ@�ӵ������|
		if("getOne_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				String str = req.getParameter("rep_no");
				if(str==null||(str.trim()).length()==0) {
					errorMsgs.add("�п�J�����s��");
				}
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = 
							req.getRequestDispatcher("/back_end/reportProductReviews/listRpr.jsp");
					failureView.forward(req, res);
					return;
				}
				
				Integer rep_no = null;
				try {
					rep_no = new Integer(str);
				} catch(Exception e) {
					errorMsgs.add("�s�������Ʀr");
				}
						
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = 
							req.getRequestDispatcher("/back_end/reportProductReviews/listRpr.jsp");
					failureView.forward(req, res);
					return;
				}
				
				ReportProductReviewsService repSvc = new ReportProductReviewsService();
				ReportProductReviewsVO repVO = repSvc.getOneReportProductReviews(rep_no);
				if (repVO == null) {
					errorMsgs.add("�d�L���");
				}
				
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = 
							req.getRequestDispatcher("/back_end/reportProductReviews/listRpr.jsp");
					failureView.forward(req, res);
					return;
				}
				
				List<ReportProductReviewsVO> list = new ArrayList<ReportProductReviewsVO>();
				list.add(repVO);
				req.setAttribute("list", list);
				
				String url = "/back_end/reportProductReviews/listRpr.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);
					
			}catch (Exception e){
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/reportProductReviews/listRpr.jsp");
				failureView.forward(req, res);
			}
		}
		
		
	}
}
