<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.store_information.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	SiService siSvc = new SiService();
	List<SiVO> list = siSvc.getAll();
	pageContext.setAttribute("list", list);
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
<title>所有商家資訊 - listAllSi.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table {
	width: 1265px;
	margin-top: 5px;
	margin-bottom: 5px;
}


</style>
</head>
<body bgcolor='white'>
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
						<h3>所有商家資訊</h3>
						<br>
						<h4>
							<a
								href="<%=request.getContextPath()%>/back_end/store_information/select_page.jsp">回首頁</a>
						</h4>
					</td>
				</tr>
			</table>
			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			<div class="container">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>商家編號</th>
							<th>門市地址</th>
							<th>營業時間</th>
							<th>聯絡電話</th>
							<th>電子郵件</th>
							<th>LINE資訊</th>
							<th>修改</th>
							<th>刪除</th>
						</tr>
					</thead>
					<%@ include file="page1.file"%>
					<c:forEach var="siVO" items="${list}" begin="<%=pageIndex%>"
						end="<%=pageIndex+rowsPerPage-1%>">
						<tbody>
							<tr>
								<td>${siVO.si_no}</td>
								<td>${siVO.si_address}</td>
								<td>${siVO.si_open}</td>
								<td>${siVO.si_phone}</td>
								<td>${siVO.si_email}</td>
								<td>${siVO.si_line}</td>
								<td>
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/back_end/store_information/si.do"
										style="margin-bottom: 0px;">
										<input type="submit" value="修改"> <input type="hidden"
											name="si_no" value="${siVO.si_no}"> <input
											type="hidden" name="action" value="getOne_For_Update">
									</FORM>
								</td>
								<td>
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/back_end/store_information/si.do"
										style="margin-bottom: 0px;">
										<input type="submit" value="刪除"> <input type="hidden"
											name="si_no" value="${siVO.si_no}"> <input
											type="hidden" name="action" value="delete">
									</FORM>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
			<%@ include file="page2.file"%>
		</div>
		<!--*******************	
		Start Include sidebar File  
		******************* -->
		<%@ include file="../back_include_page/JavaScript_Include.jsp"%>
		<!--*******************	
		End Include sidebar File  
		******************* -->
	</div>
</body>
</html>