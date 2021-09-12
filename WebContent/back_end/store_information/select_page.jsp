<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>YSM3C</title>
<style type="text/css">
h1 {
	text-align: center;
}


</style>
</head>
<body>
<div id="app">
	<!--*******************	
		Start Include sidebar File  
		******************* -->
        <%@ include file="../back_include_page/sidebar.jsp"%>
	<!--*******************	
		End Include sidebar File  
		******************* -->  
		
		<div id="main">
	<h1>STORE_INFOFMATION �Ӯa��T</h1>
	<hr>
	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	<div>
		<h3>�Ӯa��T�d��:</h3>
		<nav>
			<a href='<%=request.getContextPath()%>/back_end/store_information/listAllSi.jsp'>�Ҧ�</a> �Ӯa��T. <br> <br>
		</nav>

		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/store_information/si.do">
			<b>��J�Ӯa�s�� (�p1):</b> 
			<input type="text" name="si_no"> 
			<input type="hidden" name="action" value="getOne_For_Display">
			<input type="submit" value="�e�X">
		</FORM>

		<jsp:useBean id="siSvc" scope="page" class="com.store_information.model.SiService" />
			
		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/store_information/si.do">
			<b>��ܰӮa�s��:</b> <select size="1" name="si_no">
				<c:forEach var="siVO" items="${siSvc.all}">
					<option value="${siVO.si_no}">${siVO.si_no}
				</c:forEach>
			</select> <input type="hidden" name="action" value="getOne_For_Display">
			<input type="submit" value="�e�X">
		</FORM>

		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/store_information/si.do">
			<b>��ܪ����a�}:</b> <select size="1" name="si_no">
				<c:forEach var="siVO" items="${siSvc.all}">
					<option value="${siVO.si_no}">${siVO.si_address}
				</c:forEach>
			</select> <input type="hidden" name="action" value="getOne_For_Display">
			<input type="submit" value="�e�X">
		</FORM>

		<h3>�Ӯa��T�޲z</h3>

		<nav>
			<a href='addSi.jsp'>�s�W</a> �Ӯa��T.
		</nav>

	</div>
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