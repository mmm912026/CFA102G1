<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.rentalProductImages.model.*"%>

<%
	RentalProductImagesVO rpiVO = (RentalProductImagesVO) request.getAttribute("rpiVO"); 
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�קﯲ��ӫ~�Ϥ�</title>
<%@ include file="../back_include_page/CSS_link.jsp"%>
<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<style>
  form { display: inline; }
  table#table-1 {
	background-color: #ffcc99;
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
				<tr><td>
					 <h3>�קﯲ��ӫ~�Ϥ�</h3>
					 <h6><a href="<%=request.getContextPath()%>/back_end/rentalProductImages/listRpi.jsp">�^����</a></h6>
				</td></tr>
			</table>
			
			<h3>��ƭק�:</h3>
			
			<%-- ���~��C --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">�Эץ��H�U���~:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rpi/rpi.do" name="form1" enctype="multipart/form-data">
			<table>
				<tr>
					<td>����ӫ~�Ϥ��s��:<font color=red><b>*</b></font></td>
					<td><%=rpiVO.getRpi_no()%></td>
				</tr>
			
				<jsp:useBean id="rcSvc" scope="page" class="com.rentalClass.model.RentalClassService" />
				<tr>
					<td>����ӫ~���O:</td>
					<td><select size="1" name="rc_no">
						<c:forEach var="rcVO" items="${rcSvc.all}">
							<option value="${rcVO.rc_no}" ${(rpiVO.rc_no==rcVO.rc_no)?'selected':'' } >${rcVO.rc_no}.${rcVO.rc_name}
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>����ӫ~�Ϥ�:</td>
					<td>
						<input type="file" name="rpi_img">
					</td>
				</tr>
			</table>
			<p>
				���
			<p>
				<img src="<%=request.getContextPath()%>/rpi/DBGifReader?id=${rpiVO.rpi_no}" width="100px" height="auto">
			<p>
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="rpi_no" value="<%=rpiVO.getRpi_no()%>">
			<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>">
			<input type="hidden" name="whichPage"  value="<%=request.getParameter("whichPage")%>">			
			<input type="submit" value="�e�X">
			</FORM>		
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