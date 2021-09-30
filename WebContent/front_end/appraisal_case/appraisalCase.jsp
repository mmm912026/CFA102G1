<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.appraisal_case.model.*"%>
<%@page import="java.sql.Timestamp"%>

<%
	Appraisal_CaseVO appraisalCaseVO = (Appraisal_CaseVO) request.getAttribute("appraisalCaseVO");
%>
<!DOCTYPE html>
<html>
<head>
<head>
<!--******************* Start Include CSS File ******************* -->
<%@ include file="../front_include_page/CSS_link.jsp"%>
<!--******************* End Include CSS File ******************* -->

<title>YSM3C - 二手租賃商城</title>

<link rel="icon" type="image/png" href="../front_CSS_JS/assets/img/favicon.png">
</head>
<body>

	<!--******************* Start Top Head Area ******************* -->
		<%@ include file="../front_include_page/Top_head.jsp"%>
	<!--******************* End Top Head Area ******************* -->	

	<!--*******************	Start Navbar Area ******************* -->		
		<%@ include file="../front_include_page/navbar.jsp"%>
	<!--******************* End Navbar Area ******************* -->		
		
<!-- ************************下面開始塞你自己的頁面資訊************************ -->		
<!-- ************************下面開始塞你自己的頁面資訊************************ -->		


	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<div class="container px-5 my-5">
			<h3>請填寫估價表單</h3>
	<FORM METHOD="post" ACTION="<%= request.getContextPath()%>/back_end/appraisal_case/appraisal_case.do"id="contactForm" data-sb-form-api-token="API_TOKEN">
         <div class="mb-3">
            <label class="form-label" for="估價商品名稱">估價商品名稱</label>
            <input class="form-control" id="估價商品名稱" type="text" placeholder="估價商品名稱" data-sb-validations="required" />
            <div class="invalid-feedback" data-sb-feedback="估價商品名稱:required">估價商品名稱 is required.</div>
        </div>
        <div class="mb-3">
            <label class="form-label" for="估價商品內容規格">估價商品內容(規格)</label>
            <textarea class="form-control" id="估價商品內容規格" type="text" placeholder="估價商品內容(規格)" style="height: 10rem;" data-sb-validations=""></textarea>
        </div>
        <div class="mb-3">
            <label class="form-label" for="付款方式">付款方式</label>
            <select class="form-select" id="付款方式" aria-label="付款方式">
                <option value="現金">現金</option>
                <option value="轉帳">轉帳</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label" for="運送方式">運送方式</label>
            <select class="form-select" id="運送方式" aria-label="運送方式">
                <option value="自取、親送">自取、親送</option>
                <option value="超商取貨">超商取貨</option>
                <option value="宅配">宅配</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label" for="配送地址">配送地址</label>
            <input class="form-control" id="配送地址" type="text" placeholder="配送地址" data-sb-validations="required" />
            <div class="invalid-feedback" data-sb-feedback="配送地址:required">配送地址 is required.</div>
        </div>
        <div class="d-none" id="submitSuccessMessage">
            <div class="text-center mb-3">
                <div class="fw-bolder">Form submission successful!</div>
                <p>To activate this form, sign up at</p>
                <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
            </div>
        </div>
        <div class="d-none" id="submitErrorMessage">
            <div class="text-center text-danger mb-3">Error sending message!</div>
        </div>
        <div class="d-grid">
		<input type="hidden" name="action" value="insert"> 
		<input type="submit" class="btn btn-primary btn-lg disabled" id="submitButton" value="送出新增">
        </div>
    </form>
</div>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

	<!--******************* Start Footer Area ******************* -->			
		<%@ include file="../front_include_page/footer.jsp"%>
	<!--******************* End Footer Area ******************* -->	
	
	<!--******************* Start Go Top Area ******************* -->				
		<%@ include file="../front_include_page/startGoTop.jsp"%>
	<!--******************* End Go Top Area ******************* -->			

	<!--******************* Start Include JS File ******************* -->	
		<%@ include file="../front_include_page/JavaScript_Include.jsp"%>
	<!--******************* End Include JS File ******************* -->	
</body>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back_end/appraisal_case/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/back_end/appraisal_case/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/back_end/appraisal_case/datetimepicker/jquery.datetimepicker.full.js"></script>

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
//案件日期
	 $('.aca_date').datetimepicker({
	  format:'Y-m-d H:i:s',
	  value:new Date(),
	  onShow:function(){
	   this.setOptions({
	    maxDate:$('.aca_comp_date').val()?$('.aca_comp_date').val():false
	   })
	  },
	  timepicker:true,
	  step: 1
	 });
//門市收貨日期
	 $('.aca_recpt_date').datetimepicker({
	  format:'Y-m-d H:i:s',
	  value:new Date(),
	  onShow:function(){
	   this.setOptions({
		minDate:$('.aca_date').val()?$('.aca_date').val():false
	   })
	  },
	  timepicker:true,
	  step: 1
	 });
//完成日期
	 $('.aca_comp_date').datetimepicker({
	  format:'Y-m-d H:i:s',
	  onShow:function(){
	   this.setOptions({
	    minDate:$('.aca_recpt_date').val()?$('.aca_recpt_date').val():false
	   })
	  },
	  timepicker:true,
	  step: 1
	 });
});
</script>
</html>