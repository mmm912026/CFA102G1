<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.appraisal_class.model.*"%>

<%
	Appraisal_ClassVO appraisalClassVO = (Appraisal_ClassVO) request.getAttribute("appraisalClassVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>估價類別資料新增</title>

</head>
<body>

	<table>
		<tr>
			<td><h3>估價類別資料新增</h3></td>
			<td><h4><a href="<%= request.getContextPath() %>/back_end/select_page.jsp">回首頁</a></h4></td>
		</tr>
	</table>

	<h3>資料新增:</h3>

	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="<%= request.getContextPath() %>/back_end/appraisal_class/appraisal_class.do">
		<table>
			<tr>
				<td>估價類別名稱：</td>
				<td><input type="text" name="acl_id" size="45"
					value="<%= (appraisalClassVO == null) ? "電腦" : appraisalClassVO.getAcl_id()%>"></td>
			</tr>
		</table>
		<br> 
		<input type="hidden" name="action" value="insert"> 
		<input type="submit" value="送出新增">
	</FORM>

</body>
</html>