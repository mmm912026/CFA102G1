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
<title>�������O��ƭק�</title>



</head>
<body>

<table>
	<tr><td>
		 <h3>�������O��ƭק�</h3>
		 <h4><a href="<%= request.getContextPath()%>/back_end/appraisal_class/select_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<h3>��ƭק�:</h3>

<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/appraisal_class/appraisal_class.do">
<table>
	<tr>
		<td>�������O�s���G<font color=red><b>*</b></font></td>
		<td>${appraisalClassVO.acl_no}</td>
	</tr>
	<tr>
		<td>�������O�W�١G</td>	
		<td><input type="text" name="acl_id" size="45" value="<%= appraisalClassVO.getAcl_id()%>"></td>	
	</tr>
</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="acl_no" value="<%= appraisalClassVO.getAcl_no()%>">
<input type="submit" value="�e�X�ק�">

</FORM>
</body>
</html>