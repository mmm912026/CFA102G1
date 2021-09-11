<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sec_product_inform.model.*"%>

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

        <!-- Start Shop Area -->
        <section class="shop-area bg-ffffff pt-50 pb-50">
            <div class="container">
                <div class="row">
                
					<!-- Start 顯示單個商品 -->
                	<c:forEach var="productList" items="${afterFiterProduct}">
                    <div class="col-lg-3 col-sm-6">
                        <div class="single-shop-products">
                        
                            <div class="shop-products-image">
                                <a href="<%=request.getContextPath()%>/front_end/secProductInfo/productDetail.jsp">
									<img src="<%=request.getContextPath()%>/secProductImg/ProductImg.do?spi_no=${productList.spi_no}&action=showShopImage" alt="image" >
                                </a>
                                <ul class="shop-action">
                                    <li>
                                        <a href="cart.html">
                                            <i class="flaticon-shopping-cart"></i>
                                        </a>
                                    </li>          
                                </ul>
                            </div>

                            <div class="shop-products-content">
                                <h3>
                                    <a href="<%=request.getContextPath()%>/front_end/secProductInfo/productDetail.jsp">
                                    	${productList.spi_name}
                                    </a>
                                </h3>                            
                                <span>${productList.spi_pri}</span>
                            </div>
                            
                        </div>
                    </div>
					</c:forEach>
 					<!-- End 顯示單個商品 -->      
					
					<!-- Start 分頁 -->
                    <div class="col-lg-12 col-md-12">
                        <div class="pagination-area">
                            <a href="#" class="prev page-numbers">
                                <i class='flaticon-left-arrow'></i>
                            </a>
                            <a href="#" class="page-numbers">1</a>
                            <span class="page-numbers current" aria-current="page">2</span>
                            <a href="#" class="page-numbers">3</a>
                            <a href="#" class="page-numbers">4</a>
                            <a href="#" class="next page-numbers">
                                <i class='flaticon-right-arrow'></i>
                            </a>
                        </div>
                    </div>
					<!-- End 分頁 -->           
                    
                </div>
            </div>
        </section>
        <!-- End Shop Area -->


	<!--*******************	
		Start Footer Area  
		******************* -->			
		<%@ include file="../front_include_page/footer.jsp"%>
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