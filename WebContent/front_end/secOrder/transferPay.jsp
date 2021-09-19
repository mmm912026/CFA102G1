<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sec_product_inform.model.*"%>
<%@ page import="java.util.*" %>

<!-- 前台_轉帳付款頁面 -->
<!DOCTYPE html>
<html>
<head>
	<!--*******************	
		Start Include CSS File  
		******************* -->
        <%@ include file="../front_include_page/CSS_link.jsp"%>
	<!--*******************	
		End Include CSS File  
		******************* -->        
		
		<style>
		.card{
			display:inline; 
 			text-align:center;/*信用卡卡號文字置中 */
		}
		
		</style>
        
        <title>YSM3C - 二手租賃商城</title>

        <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/front_end/front_CSS_JS/assets/img/favicon.png">
</head>
<body>
	    <!-- Start Preloader Area 載入畫面(圈圈)-->
        <div class="preloader">
            <div class="loader">
                <div class="sbl-half-circle-spin">
                    <div></div>
                </div>
            </div>
        </div>
        <!-- End Preloader Area 載入畫面(圈圈)-->	
		
	


	<!--*******************	
		Start Top Head Area  
		******************* -->
		<%@ include file="../front_include_page/Top_head.jsp"%>
	<!--*******************	
		End Top Head Area  
		******************* -->	

	<!--*******************	
		Start Navbar Area  
		******************* -->		
		<%@ include file="../front_include_page/navbar.jsp"%>
	<!--*******************	
		End Navbar Area  
		******************* -->



	 <!-- Start Page Banner -->
        <div class="page-title-area">
            <div class="container">
                <div class="page-title-content">
                    <h2>付款頁面</h2>
                </div>
            </div>
        </div>
        <!-- End Page Banner -->

        <!-- Start Login Area -->
        <section class="login-area ptb-50">
            <div class="container">
                <div class="login-form">
                    <h2>匯款資訊</h2>

                    <form method="post" action="<%=request.getContextPath()%>/secOrder/SecOrder.do">
						<div class="form-group">
                        	<h4>訂單成立</h4>
                        	<h5>訂單編號 : ${secOrderVO.so_no}</h5>
                        </div>                 
                    	<hr>
                    	<div class="form-group">
                        	<h4>收款人:陳信輔</h4>
                        </div>
                        <hr>
                    	<div class="form-group">
                        	<h4>台灣銀行</h4>
                            <h5>銀行代號:004</h5>
                        </div>
                    	<hr>
                        <div class="form-group">
                        	<h4>收款帳號</h4>
                            <h5>091-004-603172</h5>
                        </div>
                        <hr>
                        <div class="form-group">
                        	<h4>轉帳金額</h4>
                            <h5>$${secOrderVO.so_discount_price}</h5>
                        </div>
                        <hr>
                        <div class="form-group">
                        	<h4>匯款帳號末5碼</h4>
							<input type="text"  maxlength="5">
                        </div>
                        
                        	
                        <button type="submit">確認</button>
                        <input type="hidden" name="action" value="confirmPay">
                        <input type="hidden" name="so_no" value="${secOrderVO.so_no}">
                    </form>
                </div>
            </div>
        </section>
        <!-- End Login Area -->

	<!--*******************	
		Start Footer Area  
		******************* -->			
		<%@ include file="../front_include_page/footer2.jsp"%>
	<!--*******************	
		End Footer Area  
		******************* -->	
	
	<!--*******************	
		Start Go Top Area  
		******************* -->				
		<%@ include file="../front_include_page/startGoTop.jsp"%>
	<!--*******************	
		End Go Top Area  
		******************* -->			

	<!--*******************	
		Start Include JS File  
		******************* -->	
		<%@ include file="../front_include_page/JavaScript_Include.jsp"%>
	<!--*******************	
		End Include JS File  
		******************* -->	
</body>
</html>