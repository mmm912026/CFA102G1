<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.appraisal_class.model.*"%>

<%
	Appraisal_ClassVO appraisalClassVO = (Appraisal_ClassVO) request.getAttribute("appraisalClassVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�������O���</title>

<style>
table {
	width: 600px;
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
<body>

	<table id="table-1">
		<tr>
			<td>
				<h3>�������O���</h3>
				<h4>
					<a href="<%= request.getContextPath()%>/back_end/appraisal_class/select_page.jsp">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>�������O�s��</th>
			<th>�������O�W��</th>
		</tr>
		<tr>
			<td>${appraisalClassVO.acl_no }</td>
			<td>${appraisalClassVO.acl_id }</td>
		</tr>
	</table>

</body>
</html>