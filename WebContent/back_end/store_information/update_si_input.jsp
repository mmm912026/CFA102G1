<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.store_information.model.*"%>

<%
	SiVO siVO = (SiVO) request.getAttribute("siVO"); //SiServlet.java (Controller) �s�Jreq��siVO���� (�]�A�������X��siVO, �]�]�A��J��ƿ��~�ɪ�siVO����)
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
<title>YSM-3C ��x�޲z</title>
<link rel="icon" type="image/png"
	href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�Ӯa��T�ק� - update_si_input.jsp</title>
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
						<h3>���u��ƭק� update_si_input.jsp</h3>
						<h4>
							<a href="select_page.jsp">�^����</a>
						</h4>
					</td>
				</tr>
			</table>

			<%-- ���~��C --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">�Эץ��H�U���~:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>

			<FORM METHOD="post" ACTION="si.do" name="form1">
				<table>
					<tr>
						<td>�Ӯa�s��:<font color=red><b>*</b></font></td>
						<td><%=siVO.getSi_no()%></td>
					</tr>
					<tr>
						<td>�����a�}:</td>
						<td><input type="TEXT" name="si_address" size="45"
							value="<%=siVO.getSi_address()%>" /></td>
					</tr>
					<tr>
						<td>��~�ɶ�:</td>
						<td><input type="TEXT" name="si_open" size="45"
							value="<%=siVO.getSi_open()%>" /></td>
					</tr>
					<tr>
						<td>�p���q��:</td>
						<td><input type="TEXT" name="si_phone" size="45"
							value="<%=siVO.getSi_phone()%>" /></td>
					</tr>
					<tr>
						<td>�q�l�l��:</td>
						<td><input type="TEXT" name="si_email" size="45"
							value="<%=siVO.getSi_email()%>" /></td>
					</tr>
					<tr>
						<td>LINE��T:</td>
						<td><input type="TEXT" name="si_line" size="45"
							value="<%=siVO.getSi_line()%>" /></td>
					</tr>

				</table>
				<br> <input type="hidden" name="action" value="update">
				<input type="hidden" name="si_no" value="<%=siVO.getSi_no()%>">
				<input type="submit" value="�e�X�ק�">
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