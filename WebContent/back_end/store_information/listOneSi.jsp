<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.store_information.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
  SiVO siVO = (SiVO) request.getAttribute("siVO"); //SiServlet.java(Controller), �s�Jreq��siVO����
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
	<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<title>�Ӯa��T - listOneSi.jsp</title>

<style>
  table#table-1 {
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
		 <h3>�Ӯa��T - ListOneSi.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/back_end/store_information/select_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�Ӯa�s��</th>
		<th>�����a�}</th>
		<th>��~�ɶ�</th>
		<th>�p���q��</th>
		<th>�q�l�l��</th>
		<th>LINE��T</th>
	</tr>
	<tr>
		<td><%=siVO.getSi_no()%></td>
		<td><%=siVO.getSi_address()%></td>
		<td><%=siVO.getSi_open()%></td>
		<td><%=siVO.getSi_phone()%></td>
		<td><%=siVO.getSi_email()%></td>
		<td><%=siVO.getSi_line()%></td>
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