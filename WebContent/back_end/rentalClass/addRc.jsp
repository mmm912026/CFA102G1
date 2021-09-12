<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.rentalClass.model.*"%>

<%
	RentalClassVO rcVO = (RentalClassVO) request.getAttribute("rcVO");
%>
<html>
<head>
<title>新增租賃商品類別</title>
<%@ include file="../back_include_page/CSS_link.jsp"%>
<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<style>
  form { display: inline; }
  table#table-1 {
	background-color: #CCFFCC;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h3 {
    color: black;
    display: block;
    margin: 5px;
  }
  table {
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
			   <tr><td><h3>新增租賃商品類別</h3>
			   <h6><a href="<%=request.getContextPath()%>/back_end/rentalClass/listRc.jsp">回首頁</a></h6>
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
				
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rc/rc.do" name="form1">
			<table>
				<tr>
					<td>商品類別名稱:</td>
					<td><input type="TEXT" name="rc_name" size="45" 
					value="<%= (rcVO==null)? "MacBook Pro 16吋" : rcVO.getRc_name()%>" /></td>
				</tr>
				<tr>
					<td>種類:</td>
					<td><input type="TEXT" name="rc_item" size="45"	
					value="<%= (rcVO==null)? "NB" : rcVO.getRc_item()%>"  /></td>
				</tr>
				<tr>
					<td>詳細資訊:</td>
					<td><input type="TEXT" name="rc_detail" size="45"	
					value="<%= (rcVO==null)? "" : rcVO.getRc_detail()%>"  /></td>
				</tr>
				<tr>
					<td>押金:</td>
					<td><input type="TEXT" name="rc_deposit" size="45" 
					value="<%= (rcVO==null)? "100000" : rcVO.getRc_deposit()%>"  /></td>
				</tr>
				<tr>
					<td>價格/天:</td>
					<td><input type="TEXT" name="rc_price" size="45" 
					value="<%= (rcVO==null)? "1000" : rcVO.getRc_price()%>"  /></td>
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