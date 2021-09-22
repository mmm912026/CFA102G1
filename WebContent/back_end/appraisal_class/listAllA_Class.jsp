<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.appraisal_class.model.*"%>

<%
	Appraisal_ClassService appraisalClassSvc = new Appraisal_ClassService();
	List<Appraisal_ClassVO> list = appraisalClassSvc.getAll();
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有估價類別</title>

<style>
table {
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
				<h3>所有估價類別資料</h3>
				<h4>
					<a href="<%=request.getContextPath()%>/back_end/appraisal_case/select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<table>
		<tr>
			<th>估價類別編號</th>
			<th>估價類別名稱</th>
			<th>修改</th>
			<th>查詢單一類別估價單</th>
		</tr>
<%-- 		<%@ include file="pages/page1.file" %> --%>
		<c:forEach var="appraisalClassVO" items="${list}">

			<tr>
				<td>${appraisalClassVO.acl_no }</td>
				<td>${appraisalClassVO.acl_id }</td>
				<td>
					<FORM METHOD="post"ACTION="<%= request.getContextPath()%>/back_end/appraisal_class/appraisal_class.do"style="margin-bottom: 0px;">
						<input type="submit" value="修改"> 
						<input type="hidden"name="acl_no" value="${appraisalClassVO.acl_no}">
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"ACTION="<%= request.getContextPath()%>/back_end/appraisal_class/appraisal_class.do"style="margin-bottom: 0px;">
						<input type="submit" value="送出查詢">
						<input type="hidden"name="acl_no" value="${appraisalClassVO.acl_no}"> 
						<input type="hidden" name="action" value="listCase_ByClass_B">
					</FORM>
				</td>
<!-- 				<td> -->
<!-- 					<FORM METHOD="post" -->
<%-- 						ACTION="<%= request.getContextPath()%>/back_end/appraisal_class/appraisal_class.do" --%>
<!-- 						style="margin-bottom: 0px;"> -->
<!-- 						<input type="submit" value="刪除"> <input type="hidden" -->
<%-- 							name="acl_no" value="${appraisalClassVO.acl_no}"> <input --%>
<!-- 							type="hidden" name="action" value="delete"> -->
<!-- 					</FORM> -->
<!-- 				</td> -->
			</tr>
		</c:forEach>
	</table>
	
	<%if (request.getAttribute("listCase_ByClass")!=null){ %>
		<jsp:include page="listCase_ByClass.jsp"></jsp:include>
	<%} %>
<%-- <%@ include file="pages/page2.file" %> --%>
</body>
</html>