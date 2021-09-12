<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.store_information.model.*"%>

<%
	SiVO siVO = (SiVO) request.getAttribute("siVO"); //SiServlet.java (Controller) 存入req的siVO物件 (包括幫忙取出的siVO, 也包括輸入資料錯誤時的siVO物件)
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
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>商家資訊修改 - update_si_input.jsp</title>
<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
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
						<h3>員工資料修改 update_si_input.jsp</h3>
						<h4>
							<a href="select_page.jsp">回首頁</a>
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

			<FORM METHOD="post" ACTION="si.do" name="form1">
				<table>
					<tr>
						<td>商家編號:<font color=red><b>*</b></font></td>
						<td><%=siVO.getSi_no()%></td>
					</tr>
					<tr>
						<td>門市地址:</td>
						<td><input type="TEXT" name="si_address" size="45"
							value="<%=siVO.getSi_address()%>" /></td>
					</tr>
					<tr>
						<td>營業時間:</td>
						<td><input type="TEXT" name="si_open" size="45"
							value="<%=siVO.getSi_open()%>" /></td>
					</tr>
					<tr>
						<td>聯絡電話:</td>
						<td><input type="TEXT" name="si_phone" size="45"
							value="<%=siVO.getSi_phone()%>" /></td>
					</tr>
					<tr>
						<td>電子郵件:</td>
						<td><input type="TEXT" name="si_email" size="45"
							value="<%=siVO.getSi_email()%>" /></td>
					</tr>
					<tr>
						<td>LINE資訊:</td>
						<td><input type="TEXT" name="si_line" size="45"
							value="<%=siVO.getSi_line()%>" /></td>
					</tr>

				</table>
				<br> <input type="hidden" name="action" value="update">
				<input type="hidden" name="si_no" value="<%=siVO.getSi_no()%>">
				<input type="submit" value="送出修改">
			</FORM>
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