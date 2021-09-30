<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.productReviews.model.*"%>
<%@ page import="com.rentalClass.model.*"%>
<%@ page import="com.reportProductReviews.model.*"%>
<%
	ProductReviewsVO prVO = (ProductReviewsVO) request.getAttribute("prVO");
	ReportProductReviewsVO repVO = (ReportProductReviewsVO) request.getAttribute("repVO");
	RentalClassService rcSvc = new RentalClassService();
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>����ӫ~����</title>
<%@ include file="../back_include_page/CSS_link.jsp"%>
<style>
  form { display: inline; }
  table {
	width: 500px;
	background-color: white;
	margin: 10px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
    width:400px;
  }
  th, td {
    padding: 1px;
    text-align: center;
  }
  img {
  	max-width:100%;
  }
</style>
</head>
<body bgcolor='white'>

<table id="prtable">
	<tr>
		<th>�����s��:</th>
		<td><%=prVO.getPr_no()%></td>
		<th>���O�s��:</th>
		<td><%=prVO.getRc_no()%></td>
	</tr>
	<tr>
		<th>�ӫ~���O:</th>
		<td colspan="3"><%=rcSvc.getOneRentalClass(prVO.getRc_no()).getRc_name()%></td>
	</tr>
	<tr>
		<th>��������:</th>
		<td><%=prVO.getPr_score()%></td>
		<th>�������A:</th>
		<td><%=prVO.getPr_status()%></td>
	</tr>
	<tr>
		<th>�������e:</th>
		<td colspan="3"><%=prVO.getPr_content()%></td>
	</tr>
	<tr>
		<th>�����Ϥ�:</th>
		<td colspan="3">
		<c:if test="${prVO.pr_images!=null}">
			<img src="<%=request.getContextPath()%>/back_end/pr/pr.do?action=showPrImg&pr_no=${prVO.pr_no}">	
		</c:if>	
		</td>
	</tr>	
</table>
<c:if test="${repVO.rep_status=='���B�z'}">
&nbsp;&nbsp;<b>���|</b>
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rep/rep.do" >
<input type="submit" value="�q�L" class="btn btn-sm btn-danger">
<input type="hidden" name="rep_no" value="${repVO.rep_no}"> 
<input type="hidden" name="action" value="passReport">
<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
<input type="hidden" name="fromListOnePrDetail" value="true">                  
</FORM>
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rep/rep.do" >
<input type="submit" value="���q�L" class="btn btn-sm btn-success">
<input type="hidden" name="rep_no" value="${repVO.rep_no}">
<input type="hidden" name="action" value="notPassReport">
<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
<input type="hidden" name="fromListOnePrDetail" value="true">           
</FORM>	
</c:if>

<script src="<%=request.getContextPath()%>/back_end/back_CSS_JS/assets/vendors/jquery/jquery.min.js"></script>
<script>
<c:if test="${closewindow!=null}">
window.onload=function (){
	 window.opener.location.reload();
	 window.close();
	 }    
</c:if>
	$(document).ready(function(){
		$('input').attr('autocomplete', 'off');
	});

</script>
</body>
</html>