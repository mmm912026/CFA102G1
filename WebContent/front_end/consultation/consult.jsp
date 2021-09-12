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

<title>YSM3C - �G�⯲��ӫ�</title>

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

	<!-- ************************�U���}�l��A�ۤv��������T************************ -->
	<!-- ************************�U���}�l��A�ۤv��������T************************ -->
	<!-- Start Main Slider Area ����차-->
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
	<!-- End Main Slider Area ����차-->
	<!-- Start Contact Area -->
	<section class="contact-area ptb-50">
		<div class="container">
			<div class="row">
				<div class="col-lg-7 col-md-12">
					<div class="contact-form">
						<div class="tile">
							<h3>���ڭ̯d��</h3>
							<p>�z���q�l�l�󤣷|�Q���}</p>
							<p>*��������</p>
						</div>

						<form id="contactForm">
							<div class="row">


								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label>�z���m�W*</label> <input type="text" name="name" id="name"
											class="form-control" required data-error="�ж�g�z���W�r">
										<div class="help-block with-errors"></div>
									</div>
								</div>

								<div class="col-lg-6 col-md-12">
									<div class="form-group">
										<label>���*</label> <input type="text" name="phone_number"
											id="phone_number" class="form-control" required
											data-error="�ж�g�z�����">
										<div class="help-block with-errors"></div>
									</div>
								</div>

								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<label>�q�l�l��*</label> <input type="email" name="email"
											id="email" class="form-control" required
											data-error="�ж�g�z���q�l�l��">
										<div class="help-block with-errors"></div>
									</div>
								</div>

								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<label>�d�����e*</label>

										<textarea name="message" id="message" cols="30" rows="5"
											required data-error="�ж�g�Ըߤ��e" class="form-control"></textarea>
										<div class="help-block with-errors"></div>
									</div>
								</div>

								<div class="col-lg-12 col-md-12">
									<button type="submit" class="default-btn">
										�o�e�T�� <span></span>
									</button>
									<div class="clearfix"></div>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="col-lg-5 col-md-12">
					<div class="contact-information">
						<h3>�Ӯa��T</h3>

						<ul class="contact-list">
							<li><i class='bx bx-map'></i> �a�}: <span>320��饫���c�ϴ_����46��9��</span></li>
							<li><i class='bx bx-phone-call'></i> �p���q��: <span>03-5578587</span></li>
							<li><i class='bx bx-envelope'></i> �q�l�l��: <span>YSM3C@gmail.com</span></li>
							<li><i class='bx bx-right-arrow-circle'></i> LINE��T: <span>@YSM3C</span></li>
						</ul>

						<h4>��~�ɶ�:</h4>
						<ul class="opening-hours">
							<li>�P���@: <span>08:00am-10:00pm</span></li>
							<li>�P���G: <span>08:00am-10:00pm</span></li>
							<li>�P���T: <span>08:00am-10:00pm</span></li>
							<li>�P���|: <span>08:00am-10:00pm</span></li>
							<li>�P����: <span>08:00am-10:00pm</span></li>
							<li>�P����: <span>08:00am-10:00pm</span></li>
							<li>�P����: <span>Closed</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Contact Area -->

	<!-- ************************�W����A�ۤv��������T***************************** -->
	<!-- ************************�W����A�ۤv��������T***************************** -->

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