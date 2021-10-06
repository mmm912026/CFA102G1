<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.coupon_information.model.*"%>

<%
	Coupon_InformationVO couponInformationVO = (Coupon_InformationVO) request.getAttribute("couponInformationVO");
%>
<!DOCTYPE html>
<html>
<head>
	<!--*******************	
	Start Include CSS File  
	******************* -->
	<%@ include file="../back_include_page/CSS_link.jsp"%>
	<!--*******************	
	End Include CSS File  
	******************* -->
	<meta charset="UTF-8">
	<title>YSM-3C ��x�޲z</title>
	<link rel="icon" type="image/png"
	href="../back_CSS_JS/assets/imgaes/logo/favicon.png">

</head>
<body>

	<div id="app">
		<!--*******************	
		Start Include sidebar File  
		******************* -->
		<%@ include file="../back_include_page/sidebar.jsp"%>
		<!--*******************	
		End Include sidebar File
		******************* -->
		<div id="main">
			<h3>�u�f���T��ƭק�</h3>
		<section class="section">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title"><a href="<%=request.getContextPath()%>/back_end/coupon_information/select_page.jsp">�^����</a></h3>
		
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">�Эץ��H�U���~:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			<div class="card-body">
			<FORM METHOD="post"	ACTION="<%= request.getContextPath()%>/back_end/coupon_information/coupon_information.do">
				<table class="table table-striped" id="table1">
					<tr>
						<td>�u�f��s��:<font color=red><b>*</b></font></td>
						<td><%=couponInformationVO.getCi_no() %></td>
					</tr>
					<tr>
						<td>�u�f��W��:<font color=red><b>*</b></font></td>
						<td><input type="text" name="ci_name" size="45"	value="<%=couponInformationVO.getCi_name()%>"></td>
					</tr>
					<tr>
						<td>�s�X:<font color=red><b>*</b></font></td>
						<td><input type="text" name="ci_code" size="45"	value="<%=couponInformationVO.getCi_code()%>"></td>
					</tr>
					<tr>
						<td>�u�f��}�l�ɶ�:<font color=red><b>*</b></font></td>
						<td><input type="text" name="ci_start_time" id="start_dateTime"></td>
					</tr>
					<tr>
						<td>�u�f�鵲���ɶ�:<font color=red><b>*</b></font></td>
						<td><input type="text" name="ci_end_time" id="end_dateTime"></td>
					</tr>
					<tr>
						<td>�u�f��P�P�馩:<font color=red><b>*</b></font></td>
						<td><input type="text" name="discount"size="45" value="<%=couponInformationVO.getDiscount()%>"></td>
					</tr>
					<tr>
						<td>�u�f�餺�e:<font color=red><b>*</b></font></td>
						<td><textarea rows="5" name="ci_content"><%=couponInformationVO.getCi_content()%></textarea></td>
					</tr>
				</table>
				<br> <input type="hidden" name="action" value="update"> 
				<input type="hidden" name="ci_no" value="<%=couponInformationVO.getCi_no()%>">
				<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--������e�X�ק諸�ӷ��������|��,�A�e��Controller�ǳ���椧��-->
	        <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>"><!--�u�Ω�:istAllEmp.jsp-->	
				<input type="submit" class="btn btn-secondary" value="�e�X�ק�">
			</FORM>
						</div>
					</div>
				</div>
			</section>
		</div> <!--id="main"-->
	</div> <!--id="app"-->
	
		<!--*******************
		Start Include JS File  
		******************* -->
		<%@ include file="../back_include_page/JavaScript_Include.jsp"%>
		<!--*******************	
		End Include JS File  
		******************* -->
</body>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back_end/coupon_information/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/back_end/coupon_information/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/back_end/coupon_information/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>
<script>
	$.datetimepicker.setLocale('zh'); // kr ko ja en
	$(function(){
		 $('#start_dateTime').datetimepicker({
		  format:'Y-m-d H:i:s',
		  value:'<%=couponInformationVO.getCi_start_time()%>',
		  onShow:function(){
		   this.setOptions({
		    maxDate:$('#end_dateTime').val()?$('#end_dateTime').val():false
		   })
		  },
		  timepicker:true,
		  step: 1
		 });
		 
		 $('#end_dateTime').datetimepicker({
		  format:'Y-m-d H:i:s',
		  value:'<%=couponInformationVO.getCi_end_time()%>',
		  onShow:function(){
		   this.setOptions({
		    minDate:$('#start_dateTime').val()?$('#start_dateTime').val():false
		   })
		  },
		  timepicker:true,
		  step: 1
		 });
	});
</script>

</html>