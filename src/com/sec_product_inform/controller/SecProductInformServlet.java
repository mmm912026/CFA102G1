package com.sec_product_inform.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sec_product_images.model.SecProductImagesService;
import com.sec_product_images.model.SecProductImagesVO;
import com.sec_product_inform.model.*;

import oracle.net.aso.i;

import com.sec_product_class.model.*;
import com.sec_product_images.*;

@javax.servlet.annotation.MultipartConfig
public class SecProductInformServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("Action : " + action);
		
		if("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/****1.檢查輸入變數******/
			try {
				String name = req.getParameter("spi_name");
				if(name == null || name.trim().length()==0) {
					errorMsgs.add("請輸入商品名稱!!");
				}
				
				//此欄位無須檢查
				Integer productClass = new Integer(req.getParameter("spc_no").trim());
			
				String productContent = req.getParameter("spi_content");
				if(productContent == null || productContent.trim().length()==0) {
					errorMsgs.add("請輸入商品內容!!");
				}
				
				
				Integer productPrice=null;
				try {
					productPrice = new Integer(req.getParameter("spi_pri").trim());
				} catch (NumberFormatException e) {
					productPrice = 0;
					errorMsgs.add("商品價格請輸入數字!!");
				}
				
				Integer productStock=null;
				try {
					productStock = new Integer(req.getParameter("spi_stock").trim());
				} catch (NumberFormatException e) {
					productStock = 0;
					errorMsgs.add("商品庫存請輸入數字!!");
				}

				//此欄位無須檢查
				String productSta = req.getParameter("spi_sta");
				
				ProductInformVO productInformVO = new ProductInformVO();
				productInformVO.setSpi_name(name);
				productInformVO.setSpc_no(productClass);
				productInformVO.setSpi_content(productContent);
				productInformVO.setSpi_pri(productPrice);
				productInformVO.setSpi_stock(productStock);
				productInformVO.setSpi_sta(productSta);
				
				req.setAttribute("productInformVO", productInformVO);
				
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failView = 
							req.getRequestDispatcher("/back_end/secProductInfo/addSecProductInfo.jsp");
					failView.forward(req, res);
					return;
				}
				
				/****2.開始新增商品******/
				ProductInformService productInformSvc = new ProductInformService();
				ProductInformVO priInformVO = 
							productInformSvc.insertProductInform(name, productClass, productContent, productPrice, productStock, productSta);
				System.out.println("新增商品成功!!!");
				

				/****3.新增商品照片*/
				Collection<Part> parts = req.getParts();
				System.out.println("total parts : " + parts.size());

				for(Part part : parts) {
					InputStream in = part.getInputStream();
					if(in.available()!=0 && part.getContentType()!=null) {
						SecProductImagesService secProductImagesSvc = new SecProductImagesService();
						byte[] img = new byte[in.available()];
						in.read(img);
						in.close();
						secProductImagesSvc.insertSecProductImages(priInformVO.getSpi_no(), img);
					}
				}

				/****4.新增完成，頁面轉向***/
				RequestDispatcher successView = req.getRequestDispatcher("/back_end/secProductInfo/listAllSecProductInfo.jsp");
				successView.forward(req, res);
				
			} catch (Exception e) {
				/****5.新增失敗****/
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failView = 
							req.getRequestDispatcher("/back_end/secProductInfo/addSecProductInfo.jsp");
					failView.forward(req, res);
					return;
				}
			}
			
		}
		
		if("getOneForDiplay".equals(action)){
			System.out.println("Enter getOneForDiplay!!!");
			/****1.取值****/
			Integer spi_no = new Integer(req.getParameter("spi_no"));

			/****2.從資料庫取出****/
			ProductInformService productInformSvc = new ProductInformService();
			ProductInformVO productInformVO = productInformSvc.getOneProductInform(spi_no);
			
			/***取出圖片***/
			SecProductImagesService secProductImagesSvc = new SecProductImagesService();
			List<SecProductImagesVO> imagesList = secProductImagesSvc.getAll();
			
			List<SecProductImagesVO> filterImagesList= imagesList.stream()
																 .filter(i -> i.getSpi_no().intValue() == spi_no.intValue())
																 .collect(Collectors.toList());
			
			System.out.println("filterImagesList:" + filterImagesList.isEmpty());
			
			req.setAttribute("filterImagesList", filterImagesList);
			req.setAttribute("productInformVO", productInformVO);
			
			/****3.設定燈箱顯示****/
//			boolean openLightBox = true;
//			req.setAttribute("openLightBox", openLightBox);
//			
//			System.out.println("openLightBox : " + openLightBox);

			/****4.頁面轉向 ****/
			RequestDispatcher successView = req.getRequestDispatcher("/back_end/secProductInfo/listOneProductInfo.jsp");
			successView.forward(req, res);
			return;
			
		}
		
		if("getOneForUpdate".equals(action)) {
			
			System.out.println("enter getOneForUpdate!!");
			/****1.接收請求參數****/
			Integer spi_no = new Integer(req.getParameter("spi_no"));
			/****2.取得資料****/
			ProductInformService productInformSvc = new ProductInformService();
			ProductInformVO productInformVO = productInformSvc.getOneProductInform(spi_no);
			req.setAttribute("productInformVO", productInformVO);

			/****3.轉向至update頁面****/
			System.out.println("頁面轉向!!!");
			RequestDispatcher successView = req.getRequestDispatcher("/back_end/secProductInfo/updateProductInfo.jsp");
			successView.forward(req, res);
			return;
			
		}
		
		if("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/****1.檢查輸入變數******/
			try {
				String name = req.getParameter("spi_name");
				if(name == null || name.trim().length()==0) {
					errorMsgs.add("請輸入商品名稱!!");
				}
				
				Integer spi_no = new Integer(req.getParameter("spi_no"));
				
				//此欄位無須檢查
				Integer productClass = new Integer(req.getParameter("spc_no").trim());
			
				String productContent = req.getParameter("spi_content");
				if(productContent == null || productContent.trim().length()==0) {
					errorMsgs.add("請輸入商品內容!!");
				}
				
				
				Integer productPrice =null;
				try {
					productPrice = new Integer(req.getParameter("spi_pri").trim());
				} catch (NumberFormatException e) {
					errorMsgs.add("商品價格請輸入數字!!");
				}
				
				Integer productStock =null;
				try {
					productStock = new Integer(req.getParameter("spi_stock").trim());
				} catch (NumberFormatException e) {
					errorMsgs.add("商品庫存請輸入數字!!");
				}

				//此欄位無須檢查
				String productSta = req.getParameter("spi_sta");
				
				ProductInformVO productInformVO = new ProductInformVO();
				productInformVO.setSpi_no(spi_no);
				productInformVO.setSpi_name(name);
				productInformVO.setSpc_no(productClass);
				productInformVO.setSpi_content(productContent);
				productInformVO.setSpi_pri(productPrice);
				productInformVO.setSpi_stock(productStock);
				productInformVO.setSpi_sta(productSta);
				
				req.setAttribute("productInformVO", productInformVO);
				
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failView = 
							req.getRequestDispatcher("/back_end/secProductInfo/updateProductInfo.jsp");
					failView.forward(req, res);
					return;
				}
				
				/****2.開始新增商品****/
				ProductInformService productInformSvc = new ProductInformService();
				productInformSvc.updateProductInform(spi_no, name, productClass, productContent, productPrice, productStock, productSta);
				System.out.println("修改商品成功!!!");
												
				/****3.新增完成，頁面轉向***/
				RequestDispatcher successView = req.getRequestDispatcher("/back_end/secProductInfo/listAllSecProductInfo.jsp");
				successView.forward(req, res);
				
			} catch (Exception e) {
				errorMsgs.add("更新失敗!!!");
				/****4.更新失敗****/
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failView = 
							req.getRequestDispatcher("/back_end/secProductInfo/updateProductInfo.jsp");
					failView.forward(req, res);
					return;
				}
			}
		}
		
		if("FindByPK".equals(action)) {
			System.out.println("Enter FindByPK");
			System.out.println("action : " + action);
			System.out.println("spi_no : " + req.getParameter("spi_no"));
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);			
			try {
				
			/****1.檢查輸入參數****/
			Integer spi_no = new Integer(req.getParameter("spi_no"));
			
			
			/****2.查詢資料****/
			ProductInformService productInformSvc = new ProductInformService();
			ProductInformVO productInformVO = productInformSvc.getOneProductInform(spi_no);
			req.setAttribute("productInformVO", productInformVO);
			
			System.out.println("資料查詢成功!!");
			/**查詢圖片**/
			SecProductImagesService secProductImagesSvc = new SecProductImagesService();
			List<SecProductImagesVO> filterImagesList = secProductImagesSvc.getAll()
																		   .stream()
																		   .filter(i -> i.getSpi_no().intValue() == spi_no.intValue())
																		   .collect(Collectors.toList());
			req.setAttribute("filterImagesList", filterImagesList);
			
			/****3.頁面轉向****/
			RequestDispatcher successView = 
								req.getRequestDispatcher("/back_end/secProductInfo/listOneProductInfo.jsp");
			System.out.println("成功轉向!!");
			successView.forward(req, res);
			return;
			
			}catch (NumberFormatException e) {
				errorMsgs.add("請輸入數字!!");
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failView = 
							req.getRequestDispatcher("/back_end/secProductInfo/select_page.jsp");
					failView.forward(req, res);
					return;
				}
				
			}catch (Exception e) {
				errorMsgs.add(e.getMessage());
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher failView = req.getRequestDispatcher("/back_end/secProductInfo/select_page.jsp");
					failView.forward(req, res);
					return;
				}
			}
				
		}
		
		if("ExportImages".equals(action)) {
			res.setContentType("image/jpeg");
			Integer spim_no= new Integer(req.getParameter("spim_no"));
			System.out.println("Integer >> spim_no : " + spim_no);
			SecProductImagesService secProductImagesSvc = new SecProductImagesService();
			SecProductImagesVO secProductImagesVO = secProductImagesSvc.getOneSecProductImages(spim_no);
			byte[] imgArry = secProductImagesVO.getSpim_img();
			ServletOutputStream out = res.getOutputStream();
			out.write(imgArry);
			out.close();	
			return;
		}
		
		if("showAllProduct".equals(action)) {
			System.out.println("Enter show all prduct!!!");
			System.out.println("spc_no : " + req.getParameter("spc_no"));
			
			/****1.取得變數****/
			Integer spc_no = new Integer( req.getParameter("spc_no") );
			
			/****2.開始查詢****/
			ProductInformService productInformSvc = new ProductInformService();
			List<ProductInformVO> productInformVOs = productInformSvc.getAll();
			
			System.out.println("productInformVOs : " + productInformVOs.size());
			System.out.println("------------------------------------------------------");
			List<ProductInformVO> afterFiterProduct = null;
						
			/****3.過濾商品****/
			if(spc_no == 0) {
				/****spc_no=0 表示要查詢所有的商品，去除狀態為"下架"或庫存為0的商品****/
				afterFiterProduct = productInformVOs.stream()
													.filter(i -> i.getSpi_stock().intValue() > 0)
													.filter(i -> i.getSpi_sta().equals("上架"))
													.collect(Collectors.toList());
			}else {
				/****依據spc_no，開始過濾商品，並去除狀態為"下架"或庫存為0的商品****/
				afterFiterProduct = productInformVOs.stream()
													.filter(i -> i.getSpc_no().equals(spc_no))
													.filter(i -> i.getSpi_stock().intValue() > 0)
													.filter(i -> i.getSpi_sta().equals("上架"))
													.collect(Collectors.toList());	
			}
					
			req.setAttribute("afterFiterProduct", afterFiterProduct);
						
			/****4.頁面轉向****/
			RequestDispatcher successView = 
					req.getRequestDispatcher("/front_end/secProductInfo/productShopPage.jsp");
			successView.forward(req, res);
			return;
		}
		
		if("showProductDetail".equals(action)) {			
			/****1.取得參數****/
			Integer spi_no = new Integer(req.getParameter("spi_no"));
			
			/****2.開始查詢商品****/
			ProductInformService productInformSvc = new ProductInformService();
			ProductInformVO productInformVO = productInformSvc.getOneProductInform(spi_no);
			
			req.setAttribute("productInformVO", productInformVO);
			
			/****3.開始查詢商品圖片****/
			SecProductImagesService productImagesSvc = new SecProductImagesService();
			List<SecProductImagesVO> secProductImagesVOs = productImagesSvc.getAll();
			
			List<SecProductImagesVO> afterFilterImages = null;
			afterFilterImages = secProductImagesVOs.stream()
							 					   .filter(i -> i.getSpi_no().equals(spi_no))
							 					   .collect(Collectors.toList());
			req.setAttribute("afterFilterImages", afterFilterImages);
			
			/****4.頁面轉向****/
			RequestDispatcher successView = 
					 req.getRequestDispatcher("/front_end/secProductInfo/productDetail.jsp");
			successView.forward(req, res);
		}
		
	}

}
