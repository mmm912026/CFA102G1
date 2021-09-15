<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sec_product_inform.model.*"%>
<%@ page import="com.sec_product_class.model.*"%>

<%@ page import="com.sec_order.model.*" %>

<%
	SecOrderService secOrderSvc = new SecOrderService();
	List<SecOrderVO> list = secOrderSvc.getAll();
	pageContext.setAttribute("order_list", list);
	
%>
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
			<div class="page-heading">
				<div class="page-title">
					<div class="row">
						<div class="col-12 col-md-6 order-md-1 order-last">
							<h3>
								<a href="<%=request.getContextPath()%>/back_end/secOrder/secOrder_select_page.jsp">管理二手訂單</a>
							</h3>
							<br> <br>
						</div>
					</div>
				</div>

				<!-- Table head options start -->
				<section class="section">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">二手訂單列表</h3>
						</div>

						<div class="card-body">
							<table class="table table-striped" id="table1">
								<thead>
									<tr>
										<th>訂單編號</th>
										<th>訂購時間</th>
										<th>會員編號</th>
										<th>訂單狀態</th>
										<th>付款狀態</th>
										<th>出貨狀態</th>
										<th>訂單總價</th>
										<th>訂單優惠價格</th>
										<th>查看詳情</th>
										<th>修改訂單</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="OrderVO" items="${order_list}">
										<tr>
											<td>${OrderVO.so_no}</td>
											<td>${OrderVO.so_purtime}</td>
											<td>${OrderVO.mem_no}</td>
											<td>${OrderVO.so_sta}</td>
											<td>${OrderVO.so_pay_sta}</td>
											<td>${OrderVO.so_ship_sta}</td>
											<td>${OrderVO.so_totalpri}</td>
											<td>${OrderVO.so_discount_price}</td>
											<td>
												<form
													action="<%=request.getContextPath()%>/secOrder/SecOrder.do"
													method="post">
													
													<input type="submit" class="btn btn-outline-secondary" value="查看詳情">
													<input type="hidden" name="so_no"value="${OrderVO.so_no}"> 
													<input type="hidden" name="action" value="getOneForDiplay">
												</form>
											</td>
											<td>
												<form
													action="<%=request.getContextPath()%>/secOrder/SecOrder.do""
													method="post">
													<input type="submit" class="btn btn-outline-secondary" value="修改">
													<input type="hidden" name="so_no" value="${OrderVO.so_no}">
													<input type="hidden" name="action" value="getOneForUpdate">
												</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</section>
				<!-- Table head options end -->
			</div>
		</div>
	</div>
	

	<!--*******************
		Start Include JS File
		******************* -->
	<%@ include file="../back_include_page/JavaScript_Include.jsp"%>
	<!--*******************
		End Include JS File
		******************* -->
		
	<script>
        // Simple Datatable
        let table1 = document.querySelector('#table1');
        let dataTable = new simpleDatatables.DataTable(table1);
    </script>
</body>
</html>