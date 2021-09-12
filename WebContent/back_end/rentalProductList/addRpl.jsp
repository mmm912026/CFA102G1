<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.rentalProductList.model.*"%>

<%
	RentalProductListVO rplVO = (RentalProductListVO) request.getAttribute("rplVO");
%>
<html>
<head>
<title>新增租賃商品</title>
<%@ include file="../back_include_page/CSS_link.jsp"%>
<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<style>
  form { display: inline; }
  table#table-1 {
	background-color: #66b3ff;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h3 {
    color: black;
    display: block;
    margin: 5px;
  }
  table {
 	color:black;
	width: 900px;
	margin: 5px;
	border: 1px solid black;
  }
  table, th, td {
    border: 1px solid black;
  }
  th, td {
    padding: 1px;
    text-align: center;
  }
  button#control{
  	margin: 5px;
  }
</style>
</head>
<body>
	<!--*******************	
		Start Include sidebar File  
		******************* -->
        <%@ include file="../back_include_page/sidebar.jsp"%>
	<!--*******************	
		End Include sidebar File  
		******************* --> 
	<div id="app">
		<div id="main">
			<table id="table-1">
			   <tr><td><h3>新增租賃商品</h3>
			   <h6><a href="<%=request.getContextPath()%>/back_end/rentalProductList/listRpl.jsp">回首頁</a></h6>
			   </td></tr>
			</table>
			
			<p>
			
			<h3>資料新增:</h3>
			
			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>	
			
			<jsp:useBean id="rcSvc" scope="page" class="com.rentalClass.model.RentalClassService" />
				
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rpl/rpl.do" name="form1">
			<table>
				<tr>
					<td>商品類別:</td>
					<td>
						<select size="1" name="rc_no">
			         	<c:forEach var="rcVO" items="${rcSvc.all}" > 
			         	<option value="${rcVO.rc_no}">${rcVO.rc_no}.${rcVO.rc_name}
			         	</c:forEach>
			         	</select>
					</td>
				</tr>
				<tr>
					<td>產品序號:</td>
					<td><input type="TEXT" name="rpl_serialnum" size="45"	
					value="<%= (rplVO==null)? "XXXAAXXBBXCC123" : rplVO.getRpl_serialnum()%>"  /></td>
				</tr>
				<tr>
					<td>備註:</td>
					<td><input type="TEXT" name="rpl_note" size="45"	
					value="<%= (rplVO==null)? "" : rplVO.getRpl_note()%>"  /></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="action" value="insert">
			<input type="submit" value="送出新增"></FORM>	
		
		</div>
	
	</div>
<!--*******************	
		Start Include sidebar File  
		******************* -->
        <%@ include file="../back_include_page/JavaScript_Include.jsp"%>
	<!--*******************	
		End Include sidebar File  
		******************* --> 
</body>
</html>