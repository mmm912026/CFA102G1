<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.consultation.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    ConsultService consultSvc = new ConsultService();
    List<ConsultVO> list = consultSvc.getAll();
    pageContext.setAttribute("list",list);
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
<title>所有諮詢表單 - listAllConsult.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
</style>

<style>
  table {
	width: 1265px;
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
						<h3>所有諮詢表單資料 - listAllConsult.jsp</h3>
						<h4>
							<a
								href="<%=request.getContextPath()%>/back_end/consultation/select_page.jsp">回首頁</a>
						</h4>
					</td>
				</tr>
			</table>

			<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<table>
	<tr>
		<th>諮詢單編號</th>
		<th>諮詢人姓名</th>
		<th>諮詢人手機</th>
		<th>諮詢人EMAIL</th>
		<th>諮詢內容</th>
		<th>員工編號</th>
		<th>回覆狀態</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="consultVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${consultVO.consult_no}</td>
			<td>${consultVO.consultant}</td>
			<td>${consultVO.consult_phone}</td>
			<td>${consultVO.consult_email}</td>
			<td>${consultVO.consult_content}</td>
			<td>${consultVO.staff_no}</td> 
			<td>${consultVO.consult_sta}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/consultation/consult.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="consult_no"  value="${consultVO.consult_no}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/consultation/consult.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="consult_no"  value="${consultVO.consult_no}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>
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