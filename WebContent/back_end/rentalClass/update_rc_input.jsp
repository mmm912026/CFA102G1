<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.rentalClass.model.*"%>

<%
	RentalClassVO rcVO = (RentalClassVO) request.getAttribute("rcVO"); 
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�������O�ק�</title>
<%@ include file="../back_include_page/CSS_link.jsp"%>
<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<style>
  form { display: inline; }
  table#table-1 {
	background-color: #CCFFCC;
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
					 <h3>�������O�ק�</h3>
					 <h6><a href="<%=request.getContextPath()%>/back_end/rentalClass/listRc.jsp">�^����</a></h6>
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
			
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rc/rc.do" name="form1">
			<table>
				<tr>
					<td>���O�s��:<font color=red><b>*</b></font></td>
					<td><%=rcVO.getRc_no()%></td>
				</tr>
				<tr>
					<td>�ӫ~���O�W��:</td>
					<td><input type="TEXT" name="rc_name" size="30" value="<%=rcVO.getRc_name()%>" /></td>
				</tr>
				<tr>
					<td>����:</td>
					<td><input type="TEXT" name="rc_item" size="30"	value="<%=rcVO.getRc_item()%>" /></td>
				</tr>
				<tr>
					<td>�ԲӸ�T:</td>
					<td><input type="TEXT" name="rc_detail" size="30"	value="<%=rcVO.getRc_detail()%>" /></td>
				</tr>
				<tr>
					<td>���:</td>
					<td><input type="TEXT" name="rc_deposit" size="30" value="<%=rcVO.getRc_deposit()%>" /></td>
				</tr>
				<tr>
					<td>����/��:</td>
					<td><input type="TEXT" name="rc_price" size="30" value="<%=rcVO.getRc_price()%>" /></td>
				</tr>
				<tr>
					<td>�����`�H��:</td>
					<td>
						<%=rcVO.getRc_total_count()%>
						<input type="hidden" name="rc_total_count" value="<%=rcVO.getRc_total_count()%>" />
					</td>
				</tr>
				<tr>
					<td>�����`��:</td>
					<td>
						<%=rcVO.getRc_total_score()%>
						<input type="hidden" name="rc_total_score" value="<%=rcVO.getRc_total_score()%>" />
					</td>
				</tr>
				<tr>
					<td>�w�s:</td>
					<td>
						<%=rcVO.getRc_storage()%>
						<input type="hidden" name="rc_storage" value="<%=rcVO.getRc_storage()%>" />
					</td>
				</tr>
				<tr>
					<td>���O���A:</td>
					<td><select size="1" name="rc_status">
						<option value="�W�[" ${(rcVO.rc_status=="�W�[")?'selected':'' } >�W�[
						<option value="�U�[" ${(rcVO.rc_status=="�U�[")?'selected':'' } >�U�[
					</select></td>
				</tr>
			
			</table>
			<br>
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="rc_no" value="<%=rcVO.getRc_no()%>">
			<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>">
			<input type="hidden" name="whichPage"  value="<%=request.getParameter("whichPage")%>">
			<input type="submit" value="�e�X�ק�">
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