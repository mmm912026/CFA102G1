<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.consultation.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  ConsultVO consultVO = (ConsultVO) request.getAttribute("consultVO"); //ConsultServlet.java(Controller), 存入req的consultVO物件
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
<title>諮詢表單資料 - listOneConsult.jsp</title>

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
	<tr><td>
		 <h3>諮詢表單資料 - ListOneConsult.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/back_end/consultation/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>諮詢單編號</th>
		<th>諮詢人姓名</th>
		<th>諮詢人手機</th>
		<th>諮詢人EMAIL</th>
		<th>諮詢內容</th>
		<th>員工編號</th>
		<th>回覆狀態</th>
	</tr>
	<tr>
		<td><%=consultVO.getConsult_no()%></td>
		<td><%=consultVO.getConsultant()%></td>
		<td><%=consultVO.getConsult_phone()%></td>
		<td><%=consultVO.getConsult_email()%></td>
		<td><%=consultVO.getConsult_content()%></td>
		<td><%=consultVO.getStaff_no()%></td>
		<td><%=consultVO.getConsult_sta()%></td>
	</tr>
</table>
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