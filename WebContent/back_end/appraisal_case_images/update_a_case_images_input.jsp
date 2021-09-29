<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.appraisal_case_images.model.*" %>

<%
	Appraisal_Case_ImagesVO appraisalCaseImagesVO = (Appraisal_Case_ImagesVO)request.getAttribute("appraisalCaseImagesVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�����Ӥ���ƭק�</title>

</head>
<body>

	<table>
		<tr><td><h3>�����Ӥ���ƭק�</h3>
				<h4><a href="<%=request.getContextPath()%>/back_end/appraisal_case_images/select_page.jsp">�^����</a></h4></td>
		</tr>
	</table>

	<h3>��ƭק�:</h3>

	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post"ACTION="<%= request.getContextPath()%>/back_end/appraisal_case_images/appraisal_case_images.do"enctype="multipart/form-data">
		<table>
			<tr>
				<td>�����ץ�Ϥ��s��:<font color=red><b>*</b></font></td>
				<td><%=appraisalCaseImagesVO.getAci_no()%></td>
			</tr>
			<tr>
				<td>�����ץ�s��:<font color=red><b>*</b></font></td>
				<td><input type="hidden" name="aca_no"value="<%=appraisalCaseImagesVO.getAca_no()%>"><%=appraisalCaseImagesVO.getAca_no()%></td>
			</tr>
			<tr>
				<td>�����ӫ~�Ϥ�:</td>
				<td>
					<td>
					<input type="file" name="aci_img" accept="image/*" onchange="loadFile(event)">
 					<img id="imgDisplay" width="120"height="120"src="<%=request.getContextPath()%>/back_end/appraisal_case_images/appraisal_case_images.do?aci_no=${appraisalCaseImagesVO.aci_no}&action=showIMG">
				</td>
			</tr>
		</table>
		<br>
		 <input type="hidden" name="action" value="update">
		 <input type="hidden" name="aci_no" value="<%=appraisalCaseImagesVO.getAci_no()%>">
		 <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>">
		 <input type="submit" value="�e�X�ק�">
	</FORM>
	
<script>
var loadFile = function(event) {
var output = document.getElementById('imgDisplay');
output.src = URL.createObjectURL(event.target.files[0]);
output.onload = function() {
	URL.revokeObjectURL(output.src) // free memory
	}
};
</script>
</body>

</html>