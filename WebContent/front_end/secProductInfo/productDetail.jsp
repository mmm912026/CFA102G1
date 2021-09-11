<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

        <link rel="icon" type="image/png" href="../front_CSS_JS/assets/img/favicon.png">
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

        <!-- Start Products Details Area -->
        <section class="products-details-area ptb-50">
            <div class="container">
                <div class="products-details-desc">

                    
                    <div class="row align-items-center">

                        <!-- Start 商品照片 -->
                        <div class="col-lg-6 col-md-6">
                            <div class="main-products-image">
                                <!-- Start 商品左側小圖 -->
                                <div class="slider slider-nav">
                                    <div><img src="../front_CSS_JS/assets/img/quick-view/quick-view-1.jpg" alt="image"></div>

                                    <div><img src="../front_CSS_JS/assets/img/quick-view/quick-view-2.jpg" alt="image"></div>

                                    <div><img src="../front_CSS_JS/assets/img/quick-view/quick-view-3.jpg" alt="image"></div>
                                </div>
                                <!-- End 商品左側小圖 -->

                                <!-- Start 商品大圖 -->
                                <div class="slider slider-for">
                                    <div><img src="../front_CSS_JS/assets/img/quick-view/quick-view-1.jpg" alt="image"></div>

                                    <div><img src="../front_CSS_JS/assets/img/quick-view/quick-view-2.jpg" alt="image"></div>

                                    <div><img src="../front_CSS_JS/assets/img/quick-view/quick-view-3.jpg" alt="image"></div>
                                </div>
                                <!-- Start 商品大圖 -->

                            </div>
                        </div>
                        <!-- End 商品照片 -->

                        <div class="col-lg-6 col-md-6">
                            <div class="product-content content-two">
                                <h3>Bluetooth Headphones</h3>

                                <div class="price">
                                    <!-- <span class="old-price">$150.00</span> -->
                                    <span class="new-price">$75.00</span>
                                </div>
                                <!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea com modo consequat.</p> -->

                                <ul class="products-info">
                                    <li><span>Availability:</span> <a href="#">In stock</a></li>
                                    <li><span>SKU:</span> <a href="#">L458-25</a></li>
                                </ul>

                                <div class="product-quantities">
                                    <span>Quantities:</span>

                                    <div class="input-counter">
                                        <span class="minus-btn">
                                            <i class='bx bx-minus'></i>
                                        </span>
                                        <input type="text" value="1">
                                        <span class="plus-btn">
                                            <i class='bx bx-plus'></i>
                                        </span>
                                    </div>
                                </div>

                                <div class="product-add-to-cart">
                                    <button type="submit" class="default-btn">
                                        <i class="flaticon-shopping-cart"></i>
                                        Add to cart
                                        <span></span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="products-details-tabs">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item"><a class="nav-link active" id="description-tab" data-toggle="tab" href="#description" role="tab" aria-controls="description">Description</a></li>
                    </ul>

                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="description" role="tabpanel">
                            <h2>Overview</h2>
                            
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea com modo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident.</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea com modo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore fugiat nulla pariatur.</p>

                            <ul>
                                <li>It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</li>
                                <li>Contrary to popular belief, Lorem Ipsum is not simply random text.</li>
                                <li>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters.</li>
                                <li>Various versions have evolved over the years, sometimes by accident sometimes on purpose.</li>
                                <li>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore fugiat nulla pariatur.</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Products Details Area -->


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