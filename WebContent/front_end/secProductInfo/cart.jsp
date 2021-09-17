<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sec_product_inform.model.*"%>
<%@ page import="java.util.*" %>

<%Vector<ProductInformVO> productInformList = (Vector<ProductInformVO>) session.getAttribute("shoppingCart_sec"); %>
<%Map<Integer, Integer> Quamap = (Map<Integer, Integer>) session.getAttribute("Quamap"); %>
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

        <!-- Start Cart Area -->
		<section class="cart-area ptb-50">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-md-12">
                        <form>
                            <div class="cart-table table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">Product</th>
                                            <th scope="col">商品名稱</th>
                                            <th scope="col">單價</th>
                                            <th scope="col">數量</th>
                                            <th scope="col">Total</th>
                                        </tr>
                                    </thead>
        
                                    <tbody>
                                    
                                    <%if (productInformList != null && (productInformList.size() > 0)) {%>
                                    	<%
                                    	for(int index=0 ; index < productInformList.size() ; index++){
                                    		ProductInformVO order = productInformList.get(index);
                                    	%>
                                        <tr class="top-class">
                                            <td class="product-thumbnail">
                                                <a href="#" class="remove"><i class='bx bx-x'></i></a>

                                                <a href="#">
                                                    <img src="<%=request.getContextPath()%>/secProductImg/ProductImg.do?spi_no=<%=order.getSpi_no()%>&action=showShopImage" alt="item">
                                                </a>
                                            </td>
        
                                            <td class="product-name">
                                                <a href="products-details.html"><%=order.getSpi_name() %></a>
                                            </td>
        
                                            <td class="product-price">
                                                <span class="unit-amount">$<%=order.getSpi_pri() %></span>
                                            </td>
        
                                            <td class="product-quantity">
                                                <div class="input-counter">
<!--                                                     <span class="minus-btn"><i class='bx bx-minus'></i></span> -->
                                                    <input type="text" value="<%=Quamap.get(order.getSpi_no())%>">
<!--                                                     <span class="plus-btn"><i class='bx bx-plus'></i></span> -->
                                                </div>
                                                
                                            </td>
        
                                            <td class="product-subtotal">
                                                <span class="subtotal-amount">$<%=order.getSpi_pri()*Quamap.get(order.getSpi_no()) %></span>
                                            </td>
                                        </tr>
										<%} %>
									<%} %>
                                    </tbody>
                                </table>
                            </div>
        
                            <div class="cart-buttons">
                                <div class="row align-items-center">
                                    <div class="col-lg-7 col-sm-7 col-md-7">
                                        <div class="shopping-coupon-code">
                                            <input type="text" class="form-control" placeholder="Coupon code" name="coupon-code" id="coupon-code">
                                            <button type="submit">Apply Coupon</button>
                                        </div>
                                    </div>
        
                                    <div class="col-lg-5 col-sm-5 col-md-5 text-right">
                                        <a href="#" class="default-btn">
                                            Update Cart
                                            <span></span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="col-lg-4 col-md-12">
                        <div class="cart-totals">
                            <h3>Cart Totals</h3>
    
                            <ul>
                                <li>小計 <span>$<%=Quamap.get(999)%></span></li>
                                <li>優惠折扣 <span>$0.00</span></li>
                                <li>總計 <span>$<%=Quamap.get(999)%></span></li>
                            </ul>
    
                            <a href="#" class="default-btn">
                                	結帳
                                <span></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Cart Area -->


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