<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.coupon_information.model.*"%>
<%@ page import="com.appraisal_class.model.*"%>

<%
Coupon_InformationVO couponInformationVO = (Coupon_InformationVO) request.getAttribute("couponInformationVO");
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

	<style>
		table {
			width: 1600px;
			background-color: white;
			margin-top: 5px;
			margin-bottom: 5px;
		}
		
		table, th, td {
			border: 1px solid #CCCCFF;
		}
		
		th, td {
			padding: 5px;
			text-align: center;
		}
	</style>

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
	

			<table id="table-1">
				<tr>
					<td>
						<h3>優惠券資訊資料</h3>
						<h4>
							<a href="<%= request.getContextPath()%>/back_end/coupon_information/select_page.jsp">回首頁</a>
						</h4>
					</td>
				</tr>
			</table>
		
			<table>
				<tr>
					<th>優惠券編號</th>
					<th>優惠券名稱</th>
					<th>編碼</th>
					<th>優惠券開始時間</th>
					<th>優惠券結束時間</th>
					<th>優惠券促銷折扣</th>
					<th>優惠券內容</th>
				</tr>
				<tr>
						<td>${couponInformationVO.ci_no }</td>
						<td>${couponInformationVO.ci_name }</td>
						<td>${couponInformationVO.ci_code }</td>
						<td><fmt:formatDate value="${couponInformationVO.ci_start_time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><fmt:formatDate value="${couponInformationVO.ci_end_time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${couponInformationVO.discount }</td>
						<td>${couponInformationVO.ci_content}</td>
				</tr>
			</table>
	
		</div> <!--id="main"-->
	</div> <!--id="app"-->

		<!--*******************
		Start Include JS File  
		******************* -->
		<%@ include file="../back_include_page/JavaScript_Include.jsp"%>
		<!--*******************	
		End Include JS File  
		******************* -->

</body>
</html>