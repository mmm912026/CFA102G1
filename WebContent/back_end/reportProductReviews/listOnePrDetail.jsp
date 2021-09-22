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
<title>租賃商品評價</title>

<style>
  form { display: inline; }
  table#table-1 {
	background-color: #ffb6c1;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h3 {
    color: black;
    display: block;
    margin: 5px;
  }
</style>

<style>
  table {
	width: 500px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
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

<table id="table-1">
	<tr><td>
		 <h3>租賃商品評價</h3>
	</td></tr>
</table>


<table id="prtable">
	<tr>
		<th>評價編號:</th>
		<td><%=prVO.getPr_no()%></td>
		<th>類別編號:</th>
		<td><%=prVO.getRc_no()%></td>
	</tr>
	<tr>
		<th>商品類別:</th>
		<td colspan="3"><%=rcSvc.getOneRentalClass(prVO.getRc_no()).getRc_name()%></td>
	</tr>
	<tr>
		<th>評價分數:</th>
		<td><%=prVO.getPr_score()%></td>
		<th>評價狀態:</th>
		<td><%=prVO.getPr_status()%></td>
	</tr>
	<tr>
		<th>評價內容:</th>
		<td colspan="3"><%=prVO.getPr_content()%></td>
	</tr>
	<tr>
		<th>評價圖片:</th>
		<td colspan="3">
		<c:if test="${prVO.pr_images!=null}">
			<img src="<%=request.getContextPath()%>/back_end/pr/pr.do?action=showPrImg&pr_no=${prVO.pr_no}">	
		</c:if>	
		</td>
	</tr>	
</table>
<br>
<c:if test="${repVO.rep_status=='未處理'}">
<b>檢舉</b>
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rep/rep.do" >
<input type="submit" value="通過">
<input type="hidden" name="rep_no" value="${repVO.rep_no}"> 
<input type="hidden" name="action" value="passReport">
<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
<input type="hidden" name="fromListOnePrDetail" value="true">                  
</FORM>
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rep/rep.do" >
<input type="submit" value="不通過">
<input type="hidden" name="rep_no" value="${repVO.rep_no}">
<input type="hidden" name="action" value="notPassReport">
<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
<input type="hidden" name="fromListOnePrDetail" value="true">           
</FORM>	
</c:if>

<script>
<c:if test="${closewindow!=null}">
window.onload=function (){
	 window.opener.location.reload();
	 window.close();
	 }    
</c:if>
</script>
</body>
</html>