<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>
<%
  MemberVO memberVO = (MemberVO) request.getAttribute("memberVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<!doctype html>
    <html lang="zxx">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS --> 
     <%@ include file="../front_include_page/CSS_link.jsp"%>

        <title>會員資料修改|YSM3C</title>

        <link rel="icon" type="image/png" href="../front_CSS_JS/assets/img/favicon.png">
    </head>

    <body>

          <!-- Start Preloader Area -->
        <div class="preloader">
            <div class="loader">
                <div class="sbl-half-circle-spin">
                    <div></div>
                </div>
            </div>
        </div>
        <!-- End Preloader Area -->

   
       
        <!-- End Middle Header Area -->

        <!-- Start Navbar Area -->
      <%@ include file="../front_include_page/member_head.jsp"%>
        <!-- End Navbar Area -->

        <!-- Start Page Banner -->
        <div class="page-title-area">
            <div class="container">
                <div class="page-title-content">
                    <h2>會員資料修改</h2>


                    
                </div>
            </div>
        </div>
        <!-- End Page Banner -->

        <!-- Start Register Area -->
        <section class="register-area ptb-50">
            <div class="container">
                <div class="register-form">
                    <div class="contact-form">
                        <h2>修改個人資料</h2>
        
        
                             <div class="success">
								<%-- 成功表列 --%>
								<c:if test="${not empty success}">
										<c:forEach var="message" items="${success}">
											<h5><span style="color: green">${message}</span></h5><br>
										</c:forEach>
								</c:if>
						   </div>
	   
	   
	  						<div class="errorMegs">
								<%-- 錯誤表列 --%>
								<c:if test="${not empty errorMsgs}">
									<h5><font style="color: red">請修正以下錯誤:</font></h5>
										<c:forEach var="message" items="${errorMsgs}">
										<h5><span style="color: red">${message}</span></h5><br>
										</c:forEach>
								</c:if>
						   </div>
 
                       <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" name="form1">

                            <div class="form-group">
                                <input type="TEXT" name="mem_name" size="45" value="<%=memberVO.getMem_name()%>" />
                                <div class="help-block with-errors"></div>
                            </div>
                            <p>性別：</p>

                            <input type="radio" class="btn-check" name="mem_gender" id="option1" value="1" autocomplete="off" checked>
                            <label class="btn btn-light" for="option1">男</label>

                            <input type="radio" class="btn-check" name="mem_gender" id="option2" value="2" autocomplete="off">
                            <label class="btn btn-light" for="option2">女</label>
                            
                                                                               
                            
                            <div class="form-group">
                                <input type="date" class="form-control" placeholder="生日 :  西元年/月份/日期" required data-error="請輸入生日"> 
                                <div class="help-block with-errors"></div>
                            </div>
                            
                            
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="電話" required data-error="請輸入電話"> 
                                <div class="help-block with-errors"></div>
                            </div>

                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="電子郵件" required data-error="請輸入電子郵件"> 
                                <div class="help-block with-errors"></div>
                            </div>

                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="地址" required data-error="請輸入地址"> 
                                <div class="help-block with-errors"></div>
                            </div>

                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="帳戶" required data-error="請輸入帳戶"> 
                                <div class="help-block with-errors"></div>
                            </div>

                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="密碼" required data-error="請輸入密碼"> 
                                <div class="help-block with-errors"></div>
                            </div>

                                                                                      
                            

                            <button type="submit">現在修改</button>
                        </form>
                        </div>
                    </div>
                </div>
             </section>
        <!-- End Register Area -->

        <!-- Start Support Area -->
        <section class="support-area">
            <div class="container">
                <div class="support-inner-box">
                    <div class="row">
                        <div class="col-lg-3 col-md-6">
                            <div class="single-support">
                                <div class="icon">
                                    <i class="flaticon-free-shipping"></i>
                                </div>

                                <div class="support-content">
                                    <h3>Free Shipping Worldwide</h3>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6">
                            <div class="single-support">
                                <div class="icon">
                                    <i class="flaticon-return"></i>
                                </div>

                                <div class="support-content">
                                    <h3>30 Days Money Returns</h3>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6">
                            <div class="single-support">
                                <div class="icon">
                                    <i class="flaticon-security"></i>
                                </div>

                                <div class="support-content">
                                    <h3>100% Secure Payment</h3>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6">
                            <div class="single-support">
                                <div class="icon">
                                    <i class="flaticon-support"></i>
                                </div>

                                <div class="support-content">
                                    <h3>24/7 Customer Support</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Support Area -->

        <!-- Start Footer Area -->
        <section class="footer-area pt-50 pb-20">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="single-footer-widget">
                            <h2>Get in Touch</h2>

                            <ul class="footer-contact-info">
                                <li>
                                    <span>Address:</span> 
                                    <a href="#" target="_blank">4848 Hershell Hollow Road Bothell, WA 89076</a>
                                </li>
                                <li>
                                    <span>Phone:</span> 
                                    <a href="">+1 (514) 321-4567</a>
                                </li>
                                <li>
                                    <span>Email:</span> 
                                    <a href="mailto:hello@ejon.com">hello@ejon.com</a>
                                </li>
                            </ul>
                            <ul class="footer-social">
                                <li>
                                    <a href="#" target="_blank">
                                        <i class='bx bxl-facebook'></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">
                                        <i class='bx bxl-instagram'></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">
                                        <i class='bx bxl-pinterest-alt'></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">
                                        <i class='bx bxl-twitter'></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-sm-6">
                        <div class="single-footer-widget">
                            <h2>Policies</h2>

                            <ul class="quick-links">
                                <li>
                                    <a href="#">Shipping And Delivery</a>
                                </li>
                                <li>
                                    <a href="#">Payment Method</a>
                                </li>
                                <li>
                                    <a href="#">How to Shop</a>
                                </li>
                                <li>
                                    <a href="#">Terms And Conditions</a>
                                </li>
                                <li>
                                    <a href="#">Privacy Policy</a>
                                </li>
                                <li>
                                    <a href="#">Returns</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-sm-6">
                        <div class="single-footer-widget">
                            <h2>Support</h2>

                            <ul class="quick-links">
                                <li>
                                    <a href="#">My Account</a>
                                </li>
                                <li>
                                    <a href="#">Order Tracking</a>
                                </li>
                                <li>
                                    <a href="#">Contact Us</a>
                                </li>
                                <li>
                                    <a href="#">Customer Services</a>
                                </li>
                                <li>
                                    <a href="#">FAQs</a>
                                </li>
                                <li>
                                    <a href="#">Help Desk</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-sm-6">
                        <div class="single-footer-widget">
                            <h2>Join Our Newsletter</h2>

                            <div class="newsletter-item">
                                <div class="newsletter-content">
                                    <p>Subscribe to the newsletter for all the latest updates</p>
                                </div>   

                                <form class="newsletter-form" data-toggle="validator">
                                    <input type="email" class="input-newsletter" placeholder="Email address" name="EMAIL" required autocomplete="off">

                                    <button type="submit">Subscribe</button>
                                    <div id="validator-newsletter" class="form-result"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Footer Area -->

        <!-- Start Copy Right Area -->
        <div class="copyright-area">
            <div class="container">
                <div class="copyright-area-content">
                    <p>
                        Copyright @2020 Ejon. All Rights Reserved by
                        <a href="http://www.bootstrapmb.com/" target="_blank">EnvyTheme</a>
                    </p>
                </div>
            </div>
        </div>
        <!-- End Copy Right Area -->

        <!-- Start Go Top Area -->
        <div class="go-top">
            <i class='bx bx-up-arrow-alt'></i>
        </div>
        <!-- End Go Top Area -->

        <!-- Jquery Slim JS -->
       <%@ include file="../front_include_page/JavaScript_Include.jsp"%>
    </body>
    </html>

