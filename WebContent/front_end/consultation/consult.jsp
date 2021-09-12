<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
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

<link rel="icon" type="image/png"
	href="../front_CSS_JS/assets/img/favicon.png">
</head>
<body>

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

	<!-- ************************下面開始塞你自己的頁面資訊************************ -->
	<!-- ************************下面開始塞你自己的頁面資訊************************ -->
	<!-- Start Main Slider Area 旋轉木馬-->
	<div class="main-slider-area">
		<div class="container">
			<div class="home-slides-two owl-carousel owl-theme">
				<div class="main-slider-item-box">
					<div class="main-slider-content">
						<b>Big Sale Offer</b>
						<h1>Get the Best Deals on Headphone</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>

						<div class="slider-btn">
							<a href="#" class="default-btn"> <i
								class="flaticon-shopping-cart"></i> Shop Now <span></span>
							</a>
						</div>
					</div>
				</div>

				<div class="main-slider-item-box item-two">
					<div class="main-slider-content">
						<b>Popular in 2020</b>
						<h1>New Arrivals CCTV Camera</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>

						<div class="slider-btn">
							<a href="#" class="default-btn"> <i
								class="flaticon-shopping-cart"></i> Shop Now <span></span>
							</a>
						</div>
					</div>
				</div>

				<div class="main-slider-item-box item-three">
					<div class="main-slider-content">
						<b>Big Sale Offer</b>
						<h1>High-Quality Product Camera</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>

						<div class="slider-btn">
							<a href="#" class="default-btn"> <i
								class="flaticon-shopping-cart"></i> Shop Now <span></span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Main Slider Area 旋轉木馬-->
	<!-- Start Contact Area -->
	<section class="contact-area ptb-50">
		<div class="container">
			<div class="row">
				<div class="col-lg-7 col-md-12">
					<div class="contact-form">
						<div class="tile">
							<h3>給我們留言</h3>
							<p>您的電子郵件不會被公開</p>
							<p>*為必填資料</p>
						</div>

						<form id="contactForm">
							<div class="row">


								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label>您的姓名*</label> <input type="text" name="name" id="name"
											class="form-control" required data-error="請填寫您的名字">
										<div class="help-block with-errors"></div>
									</div>
								</div>

								<div class="col-lg-6 col-md-12">
									<div class="form-group">
										<label>手機*</label> <input type="text" name="phone_number"
											id="phone_number" class="form-control" required
											data-error="請填寫您的手機">
										<div class="help-block with-errors"></div>
									</div>
								</div>

								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<label>電子郵件*</label> <input type="email" name="email"
											id="email" class="form-control" required
											data-error="請填寫您的電子郵件">
										<div class="help-block with-errors"></div>
									</div>
								</div>

								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<label>留言內容*</label>

										<textarea name="message" id="message" cols="30" rows="5"
											required data-error="請填寫諮詢內容" class="form-control"></textarea>
										<div class="help-block with-errors"></div>
									</div>
								</div>

								<div class="col-lg-12 col-md-12">
									<button type="submit" class="default-btn">
										發送訊息 <span></span>
									</button>
									<div class="clearfix"></div>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="col-lg-5 col-md-12">
					<div class="contact-information">
						<h3>商家資訊</h3>

						<ul class="contact-list">
							<li><i class='bx bx-map'></i> 地址: <span>320桃園市中壢區復興路46號9樓</span></li>
							<li><i class='bx bx-phone-call'></i> 聯絡電話: <span>03-5578587</span></li>
							<li><i class='bx bx-envelope'></i> 電子郵件: <span>YSM3C@gmail.com</span></li>
							<li><i class='bx bx-right-arrow-circle'></i> LINE資訊: <span>@YSM3C</span></li>
						</ul>

						<h4>營業時間:</h4>
						<ul class="opening-hours">
							<li>星期一: <span>08:00am-10:00pm</span></li>
							<li>星期二: <span>08:00am-10:00pm</span></li>
							<li>星期三: <span>08:00am-10:00pm</span></li>
							<li>星期四: <span>08:00am-10:00pm</span></li>
							<li>星期五: <span>08:00am-10:00pm</span></li>
							<li>星期六: <span>08:00am-10:00pm</span></li>
							<li>星期日: <span>Closed</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Contact Area -->

	<!-- ************************上面塞你自己的頁面資訊***************************** -->
	<!-- ************************上面塞你自己的頁面資訊***************************** -->

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