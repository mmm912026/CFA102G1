<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<!--*******************	
		Start Include CSS File  
		******************* -->
<%@ include file="../back_include_page/CSS_link.jsp"%>
<!--*******************	
		End Include CSS File  
		******************* -->
<meta charset="UTF-8">
<title>YSM-3C 後台管理</title>
<link rel="icon" type="image/png"
	href="../back_CSS_JS/assets/imgaes/logo/favicon.png">

</head>
<body>
	<div id="app">
		<!--*******************	
		Start Include sidebar File  
		******************* -->
		<%@ include file="../back_include_page/sidebar.jsp"%>
		<!--*******************	
		End Include sidebar File  
		******************* -->

		<div id="main">
            <div class="page-title">
                <div class="row">
                    <div class="col-12 col-md-6 order-md-1 order-last">
                        <h3>管理二手商品</h3>
                        <br>
                    </div>
                </div>
            </div>			
		
			<!-- Table head options start 二手商品-->
			<section class="section">
				<div class="row" id="table-head">
					<div class="col-12">
						<div class="card">
							<div class="card-content">
								<!-- table head dark -->
								<div class="table-responsive">
									<table class="table mb-0">
										<thead class="thead-dark">
																					
											<tr>
												<th>
													<h4>查詢二手商品</h4>
													
													<!--錯誤訊息顯示 -->
													<c:if test="${not empty errorMsgs}">
														<c:forEach var="message" items="${errorMsgs}">
															<h5 style="color:red">${message}</h5>
														</c:forEach>
													</c:if>
													
													<!--錯誤訊息顯示 -->
													
												    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/secProductInfo/ProductInfo.do" >
												        <b>輸入商品編號 : </b>
												        <input type="text" name="spi_no">
												        <input type="hidden" name="action" value="FindByPK">
												        <input type="submit" class="btn btn-secondary" value="送出">
    												</FORM>
    												<br>
    												<FORM METHOD="post" ACTION="*" >
												        <b>輸入商品編號 : </b>
												        <input type="text" name="empno">
												        <input type="hidden" name="action" value="getOne_For_Display">
												        <input type="submit" class="btn btn-secondary" value="送出">
    												</FORM>
												</th>
											</tr>
											
											<tr>
												<th><a href="<%=request.getContextPath()%>/back_end/secProductInfo/listAllSecProductInfo.jsp" class="btn btn-secondary"> 顯示所有二手商品 </a></th>
											</tr>
											
											<tr>
												<th><a href="<%=request.getContextPath()%>/back_end/secProductInfo/addSecProductInfo.jsp" class="btn btn-secondary"> 新增二手商品 </a></th>
											</tr>	
																						
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- Table head options end 二手商品-->
			
			
						<!-- Table head options start 二手商品類別-->
			<section class="section">
				<div class="row" id="table-head">
					<div class="col-12">
						<div class="card">
							<div class="card-content">
								<!-- table head dark -->
								<div class="table-responsive">
									<table class="table mb-0">
										<thead class="thead-dark">
																					
											<tr>
												<th>
													<h4>查詢二手商品類別</h4>
													
													<!--錯誤訊息顯示 -->
													<c:if test="${not empty errorMsgs_class}">
														<c:forEach var="message" items="${errorMsgs_class}">
															<h5 style="color:red">${message}</h5>
														</c:forEach>
													</c:if>
													
													<!--錯誤訊息顯示 -->
													
												    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/secProductClass/ProductClass.do">
												        <b>輸入類別編號 : </b>
												        <input type="text" name="spc_no">
												        <input type="hidden" name="action" value="FindByPK">
												        <input type="submit" class="btn btn-secondary" value="送出">
    												</FORM>
    												<br>
												</th>
											</tr>
											
											<tr>
												<th><a href="<%=request.getContextPath()%>/back_end/secProductClass/listAllProductClass.jsp" class="btn btn-secondary"> 顯示所有商品類別 </a></th>
											</tr>
											
											<tr>
												<th><a href="<%=request.getContextPath()%>/back_end/secProductClass/addSecProductClass.jsp" class="btn btn-secondary"> 新增商品類別 </a></th>
											</tr>	
																						
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- Table head options end 二手商品類別-->

		</div>



		<!--*******************
		Start Include JS File  
		******************* -->
		<%@ include file="../back_include_page/JavaScript_Include.jsp"%>
		<!--*******************	
		End Include JS File  
		******************* -->
	</div>
</body>
</html>