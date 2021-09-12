<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.consultation.model.*"%>

<%
	ConsultVO consultVO = (ConsultVO) request.getAttribute("consultVO");
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
	<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>諮詢表單新增 - addConsult.jsp</title>

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
				<h3>諮詢表單新增 - addConsult.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="<%=request.getContextPath()%>/back_end/consultation/select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>表單新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="consult.do" name="form1">
		<table>
			<tr>
				<td>諮詢人姓名:</td>
				<td><input type="TEXT" name="consultant" size="45"
					value="<%=(consultVO == null) ? "" : consultVO.getConsultant()%>" /></td>
			</tr>
			<tr>
				<td>諮詢人手機:</td>
				<td><input type="TEXT" name="consult_phone" size="45"
					value="<%=(consultVO == null) ? "" : consultVO.getConsult_phone()%>" /></td>
			</tr>
			<tr>
				<td>諮詢人EMAIL:</td>
				<td><input type="TEXT" name="consult_email" size="45"
					value="<%=(consultVO == null) ? "" : consultVO.getConsult_email()%>" /></td>
			</tr>
			<tr>
				<td>諮詢內容:</td>
				<td><input type="TEXT" name="consult_content" size="45"
					value="<%=(consultVO == null) ? "" : consultVO.getConsult_content()%>" /></td>
			</tr>
			<tr>
				<td>員工編號:</td>
				<td><input type="TEXT" name="staff_no" size="45"
					value="<%=(consultVO == null) ? "" : consultVO.getStaff_no()%>" /></td>
			</tr>
			<tr>
				<td>回覆狀態:</td>
				<td><input type="TEXT" name="consult_sta" size="45"
					value="<%=(consultVO == null) ? "" : consultVO.getConsult_sta()%>" /></td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
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