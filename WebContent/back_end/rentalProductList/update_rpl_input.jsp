<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.rentalProductList.model.*"%>

<%
	RentalProductListVO rplVO = (RentalProductListVO) request.getAttribute("rplVO"); 
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�קﯲ��ӫ~</title>
<%@ include file="../back_include_page/CSS_link.jsp"%>
<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<style>
  form { display: inline; }
  table#table-1 {
	background-color: #66b3ff;
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
					 <h3>�קﯲ��ӫ~</h3>
					 <h6><a href="<%=request.getContextPath()%>/back_end/rentalProductList/listRpl.jsp">�^����</a></h6>
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
			
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rpl/rpl.do" name="form1">
			<table>
			<jsp:useBean id="rcSvc" scope="page" class="com.rentalClass.model.RentalClassService" />
				<tr>
					<td>�ӫ~�s��:<font color=red><b>*</b></font></td>
					<td><%=rplVO.getRpl_no()%></td>
				</tr>
				<tr>
					<td>����ӫ~���O:</td>
					<td><select size="1" name="rc_no">
						<c:forEach var="rcVO" items="${rcSvc.all}">
							<option value="${rcVO.rc_no}" ${(rplVO.rc_no==rcVO.rc_no)?'selected':'' } >${rcVO.rc_no}.${rcVO.rc_name}
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>���~�Ǹ�:</td>
					<td><input type="TEXT" name="rpl_serialnum" size="30"	value="<%=rplVO.getRpl_serialnum()%>" /></td>
				</tr>
				<tr>
					<td>�Ƶ�:</td>
					<td><input type="TEXT" name="rpl_note" size="30"	value="<%=rplVO.getRpl_note()%>" /></td>
				</tr>
				<tr>
					<td>�����:</td>
					<td>
					<%=rplVO.getRpl_rentcount()%>
					<input type="hidden" name="rpl_rentcount" value="<%=rplVO.getRpl_rentcount()%>" />
					</td>
				</tr>
				<tr>
					<td>�s�W���:</td>
					<td>
					<%=rplVO.getRpl_jointtime()%>
					<input type="hidden" name="rpl_jointtime" value="<%=rplVO.getRpl_jointtime()%>" />
					</td>
				</tr>
				<tr>
					<td>����ӫ~���A:</td>
					<td>
						<select size="1" name="rpl_status">
						<option value="���" ${(rplVO.rpl_status=="���")?'selected':'' } >���
						<option value="�ݯ�" ${(rplVO.rpl_status=="�ݯ�")?'selected':'' } >�ݯ�
						<option value="��" ${(rplVO.rpl_status=="��")?'selected':'' } >��
						<option value="�l��" ${(rplVO.rpl_status=="�l��")?'selected':'' } >�l��
						<option value="�O������" ${(rplVO.rpl_status=="�O������")?'selected':'' } >�O������
						</select>
					</td>
				</tr>
			
			</table>
			<br>
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="rpl_no" value="<%=rplVO.getRpl_no()%>">
			<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>">
			<input type="hidden" name="whichPage"  value="<%=request.getParameter("whichPage")%>">
			<input type="submit" value="�e�X">
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