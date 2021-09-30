<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <div class="navbar-area">
            <div class="main-responsive-nav">
                <div class="container">
                    <div class="main-responsive-menu">
                        <div class="logo">
                            <a href="index.html">
                                <img src="../front_CSS_JS/assets/img/logo-2.png" alt="logo">
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="main-navbar">
                <div class="container">
                    <nav class="navbar navbar-expand-md navbar-light">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/front_end/index.jsp">
                            <img src="<%=request.getContextPath()%>/front_end/front_CSS_JS/assets/img/logo.png" style="height:35px;width:92px;" alt="image">
                        </a>

                        <div class="collapse navbar-collapse mean-menu">
                            <ul class="navbar-nav">
                            
                            
                            <li class="nav-item">
                                    <a href="<%=request.getContextPath()%>/front_end/index.jsp" class="nav-link">
                                                                                                                        首頁
                                        
                                    </a>
                                    
                                </li>
                                <li class="nav-item">
                                    <a href="#" class="nav-link">
                                                                                                                       訂單管理 
                                        <i class='bx bx-chevron-down'></i>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item">
                                            <a href="index.html" class="nav-link">查看購物訂單</a>
                                        </li>

                                        <li class="nav-item">
                                            <a href="index-2.html" class="nav-link">查看租賃訂單</a>
                                        </li>
                                        
                                        <li class="nav-item">
                                            <a href="index-3.html" class="nav-link">查看估價案件</a>
                                        </li>

                                        <li class="nav-item">
                                            <a href="index-4.html" class="nav-link">查看維修案件</a>
                                        </li>
                                    </ul>
                                </li>

                                <li class="nav-item megamenu">
                                    <a href="#" class="nav-link ">
                                                                                                                               優惠券管理 
                                       
                                    </a>
                                  
                                </li>

                                <li class="nav-item">
                                    <a href="#" class="nav-link">
                                                                                                                                訊息總攬
                                        
                                    </a>
                                    
                                </li>

                                <li class="nav-item">
                                    <a href="<%=request.getContextPath()%>/front_end/member/memberInfo.jsp" class="nav-link">
                                                                                                                            查看會員資料
                                        
                                    </a>
                                   
                                </li>

                                
                            </ul>

                            <div class="others-option d-flex align-items-center">
                                <div class="option-item">
                                    
                                </div>
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
                                        <a href="">(+1) 654 567 – 6789</a>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>