package com.appraisal_case_images.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.appraisal_case.model.Appraisal_CaseService;
import com.appraisal_case.model.Appraisal_CaseVO;
import com.appraisal_case_images.model.Appraisal_Case_ImagesService;
import com.appraisal_case_images.model.Appraisal_Case_ImagesVO;


public class Appraisal_Case_ImagesServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
//		圖片查詢
		try {
			String str = req.getParameter("aci_no");
			Integer aci_no = new Integer(str);
			
			Appraisal_Case_ImagesService appraisalCaseImagesSvc = new Appraisal_Case_ImagesService();
			Appraisal_Case_ImagesVO appraisalCaseImagesVO = appraisalCaseImagesSvc.getOneA_Case_Image(aci_no);
//			圖片用byte[]，所以我用byteArrayInputStream處理
			ByteArrayInputStream bais = new ByteArrayInputStream(appraisalCaseImagesVO.getAci_img());
			
			if(bais.available() != 0) {
				BufferedInputStream in = new BufferedInputStream(bais);
				byte[] buf = new byte[4*1024];
				int len;
				while((len= in.read(buf))!=-1) {
					out.write(buf,0,len);
				}
				in.close();
				bais.close();
			}else {
				InputStream in = getServletContext().getResourceAsStream("/back_end/appraisal_case_images/images/none2.jpg");
				byte[] b = new byte[in.available()];
				in.read(b);
				out.write(b);
				in.close();
			}
		}catch(Exception e) {
			InputStream in = getServletContext().getResourceAsStream("/back_end/appraisal_case_images/images/none2.jpg");
			byte[] b = new byte[in.available()];
			in.read(b);
			out.write(b);
			in.close(); 
		}
		doPost(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, IllegalStateException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("getOne_For_Display".equals(action)) {// 來自select_page.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("aci_no");
				Integer aci_no = new Integer(str);
				
				/***************************2.開始查詢資料*****************************************/
				Appraisal_Case_ImagesService appraisalCaseImagesSvc = new Appraisal_Case_ImagesService();
				Appraisal_Case_ImagesVO appraisalCaseImagesVO = appraisalCaseImagesSvc.getOneA_Case_Image(aci_no);
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("appraisalCaseImagesVO", appraisalCaseImagesVO);// 資料庫取出的appraisalCaseImagesVO物件,存入req
				String url = "/back_end/appraisal_case_images/listOneA_Case_Images.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res); 
				
				/***************************其他可能的錯誤處理*************************************/
			}catch(Exception e) {
				errorMsgs.add("無法取得資料:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/appraisal_case_images/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		if("getOne_For_Update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer aci_no = new Integer(req.getParameter("aci_no"));
				
				/***************************2.開始查詢資料*****************************************/
				Appraisal_Case_ImagesService appraisalCaseImagesSvc = new Appraisal_Case_ImagesService();
				Appraisal_Case_ImagesVO appraisalCaseImagesVO = appraisalCaseImagesSvc.getOneA_Case_Image(aci_no);
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("appraisalCaseImagesVO", appraisalCaseImagesVO);// 資料庫取出的appraisalCaseImagesVO物件,存入req
				String url = "/back_end/appraisal_case_images/update_a_case_images_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res); 
				
				/***************************其他可能的錯誤處理*************************************/
			}catch(Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/appraisal_case_images/listAllA_Case_Images.jsp");
				failureView.forward(req, res);
			}
		}
		
		if("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer aci_no = new Integer(req.getParameter("aci_no"));
				
				Integer aca_no = new Integer(req.getParameter("aca_no").trim());
				
				byte[] aci_img = null;
				
				/***************************2.開始修改資料*****************************************/

				Appraisal_Case_ImagesService appraisalCaseImagesSvc = new Appraisal_Case_ImagesService();
				Appraisal_Case_ImagesVO appraisalCaseImagesVO = appraisalCaseImagesSvc.getOneA_Case_Image(aci_no);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("appraisalCaseImagesVO", appraisalCaseImagesVO);// 資料庫取出的appraisalCaseImagesVO物件,存入req
				String url = "/back_end/appraisal_case_images/listOneA_Case_Images.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res); 
				
				/***************************其他可能的錯誤處理*************************************/
			}catch(Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/appraisal_case_images/update_a_case_images_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		if("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				
				Integer aca_no = new Integer(req.getParameter("aca_no"));
				
				byte[] aci_img = null;
				Part part = req.getPart("aci_img");
				InputStream is = part.getInputStream();
				aci_img = new byte[is.available()];
				is.read(aci_img);
				is.close();
				
				Appraisal_Case_ImagesVO appraisalCaseImagesVO = new Appraisal_Case_ImagesVO();
				appraisalCaseImagesVO.setAca_no(aca_no);
				appraisalCaseImagesVO.setAci_img(aci_img);
				/***************************2.開始新增資料*****************************************/
				//查詢有無估價案件才可以再新增照片
				Appraisal_CaseService appraisalCaseSvc = new Appraisal_CaseService();
				Appraisal_CaseVO appraisalCaseVO = appraisalCaseSvc.getOneA_Case(aca_no);
				if(appraisalCaseVO == null) {
					errorMsgs.add("查無此案件，請輸入現有案件");
				}
				//開始新增
				Appraisal_Case_ImagesService appraisalCaseImagesSvc = new Appraisal_Case_ImagesService();
				appraisalCaseImagesVO = appraisalCaseImagesSvc.addA_Case_Image(aca_no, aci_img);
				
				/***************************3.新增完成,準備轉交(Send the Success view)*************/
				req.setAttribute("appraisalCaseImagesVO", appraisalCaseImagesVO);// 資料庫取出的appraisalCaseImagesVO物件,存入req
				String url = "/back_end/appraisal_case_images/listAllA_Case_Images.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res); 
				
				/***************************其他可能的錯誤處理*************************************/
			}catch(Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/appraisal_case_images/addA_Case_Images.jsp");
				failureView.forward(req, res);
			}
		}
		
		if("delete".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
			/***************************1.接收請求參數***************************************/
				Integer aci_no = new Integer(req.getParameter("aci_no"));
				
			/***************************2.開始刪除資料***************************************/	
				Appraisal_Case_ImagesService appraisalCaseImagesSvc = new Appraisal_Case_ImagesService();
				appraisalCaseImagesSvc.deleteA_Case_Image(aci_no);
				
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back_end/appraisal_case_images/listAllA_Case_Images.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
				
			/***************************其他可能的錯誤處理**********************************/
			}catch(Exception e) {
				errorMsgs.add("刪除失敗:"+e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/appraisal_case_images/listAllA_Case_Images.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
