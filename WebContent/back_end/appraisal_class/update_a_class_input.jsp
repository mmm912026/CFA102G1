<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.appraisal_class.model.*" %>

<%
	Appraisal_ClassVO appraisalClassVO = (Appraisal_ClassVO) request.getAttribute("appraisalClassVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>估價類別資料修改</title>



</head>
<body>

<table>
	<tr><td>
		 <h3>估價類別資料修改</h3>
		 <h4><a href="<%= request.getContextPath()%>/back_end/appraisal_class/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/appraisal_class/appraisal_class.do">
<table>
	<tr>
		<td>估價類別編號：<font color=red><b>*</b></font></td>
		<td>${appraisalClassVO.acl_no}</td>
	</tr>
	<tr>
		<td>估價類別名稱：</td>	
		<td><input type="text" name="acl_id" size="45" value="<%= appraisalClassVO.getAcl_id()%>"></td>	
	</tr>
</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="acl_no" value="<%= appraisalClassVO.getAcl_no()%>">
<input type="submit" value="送出修改">

</FORM>
</body>
</html>