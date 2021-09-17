<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%
	Map<Integer, Integer> Quamap2 = (Map<Integer, Integer>) session.getAttribute("Quamap"); 
	Boolean flag = false;
	if(Quamap2 != null && Quamap2.size() > 0){
		flag = true;
	}
%>


        <!-- Start 修改購物車顏色 -->
        <style>
            /* 購物車圖案顏色 */
            .middle-header-optional li a i {
                color: #292929;
            }
            
            /* 價格顏色 */
            .middle-header-optional li {
                color: #292929;
            }
        </style>
		<!-- End 修改購物車顏色 -->

        <!-- Start Navbar Area 導覽列-->
        <div class="navbar-area p-relative">
            <div class="main-responsive-nav">
                <div class="container">
                    <div class="main-responsive-menu">
                        <div class="logo">
                            <a href="#">
                                <img src="<%=request.getContextPath()%>/front_end/front_CSS_JS/assets/img/logo-2.png" alt="logo">
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="main-navbar">
                <div class="container">
                    <nav class="navbar navbar-expand-md navbar-light">
                        <a class="navbar-brand" href="index.html">
                            <img src="<%=request.getContextPath()%>/front_end/front_CSS_JS/assets/img/logo-2.png" alt="image">
                        </a>

                        <div class="collapse navbar-collapse mean-menu">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a href="#" class="nav-link active">首頁</a>
                                </li>

                                <li class="nav-item">
                                    <a href="#" class="nav-link">3C租賃</a>
                                </li>


                                <li class="nav-item">
                                    <a href="#" class="nav-link">
                                    	二手商城
                                    	<i class='bx bx-chevron-down'></i>
                                    </a>
                                    
                                    <ul class="dropdown-menu">
                                        <li class="nav-item">
                                            <a href="<%=request.getContextPath()%>/secProductInfo/ProductInfo.do?action=showAllProduct&spc_no=0" class="nav-link">所有商品</a>
                                        </li>

                                        <li class="nav-item">
                                            <a href="<%=request.getContextPath()%>/secProductInfo/ProductInfo.do?action=showAllProduct&spc_no=1" class="nav-link">桌上型電腦</a>
                                        </li>
                                        
                                        <li class="nav-item">
                                            <a href="#" class="nav-link">筆記型電腦</a>
                                        </li>

                                        <li class="nav-item">
                                            <a href="#" class="nav-link">
                                            	電腦零件
                                            	<i class='bx bx-chevron-down'></i>
                                            </a>
                                            
                                            <ul class="dropdown-menu">
                                            	<li class="nav-item">
                                            		<a href="#" class="nav-link">CPU-處理器</a>
                                       			</li>
                                       			
                                       			<li class="nav-item">
                                            		<a href="#" class="nav-link">RAM-記憶體</a>
                                       			</li>
                                       			
                                       			<li class="nav-item">
                                            		<a href="#" class="nav-link">HDD-傳統硬碟</a>
                                       			</li>
                                       			
                                       			<li class="nav-item">
                                            		<a href="#" class="nav-link">SSD-固態硬碟</a>
                                       			</li>
                                       			
                                       			<li class="nav-item">
                                            		<a href="#" class="nav-link">電源供應器</a>
                                       			</li>
                                       			
                                       			<li class="nav-item">
                                            		<a href="#" class="nav-link">顯示卡</a>
                                       			</li>
                                       			
                                       			<li class="nav-item">
                                            		<a href="#" class="nav-link">其他</a>
                                       			</li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>


                                <li class="nav-item">
                                    <a href="#" class="nav-link">電腦維修</a>
                                </li>

                                <li class="nav-item">
                                    <a href="#" class="nav-link">回收估價</a>
                                </li>

                                <li class="nav-item">
                                    <a href="#" class="nav-link">聯絡我們</a>
                                </li>
                            </ul>

                            <div class="others-option d-flex align-items-center">
								<ul class="middle-header-optional">
                                    <li>
                                        <a href="<%=request.getContextPath()%>/front_end/secProductInfo/cart.jsp">
                                        	<i class="flaticon-shopping-cart"></i>
                                        	
                                        	<span><%=flag?Quamap2.get(998):0%></span>
                                        </a>
                                    </li>
                                    <li>$<%=flag?Quamap2.get(999):0%></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>

            <div class="others-option-for-responsive">
                <div class="container">
                    <div class="dot-menu">
                        <div class="inner">
                            <div class="circle circle-one"></div>
                            <div class="circle circle-two"></div>
                            <div class="circle circle-three"></div>
                        </div>
                    </div>
                    
                    <div class="container">
                        <div class="option-inner">
                            <div class="others-option d-flex align-items-center">
                                <div class="option-item">
                                    <span>
                                        Hotline:
                                        <a href="">(03)397-1234</a>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Navbar Area 導覽列-->