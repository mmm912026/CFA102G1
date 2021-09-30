<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="com.appraisal_case_images.model.*" %>
<%@ page import="com.appraisal_case.model.*" %>

<!DOCTYPE html>
<html>
<head>
<!--*******************	Start Include CSS File ******************* -->
<%@ include file="../back_include_page/CSS_link.jsp"%>
<!--*******************	End Include CSS File ******************* -->
<meta charset="UTF-8">
<title>估價案件圖片</title>
<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<section class="section">
	<div class="card">
		<div class="card-body">
<c:if test="${not empty errorMsgs }">
	<font style="color:red">請修正以下錯誤：</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
<table class="table table-striped" id="table1">

	<c:forEach var="appraisalCaseImagesVO" items="${appraisalCaseImagesVO}">
		<tr>
			<th>圖片編號:${appraisalCaseImagesVO.aci_no}</th>
			<th>估價圖片</th>
			<th><img width="120" height="120" src="<%=request.getContextPath()%>/back_end/appraisal_case_images/appraisal_case_images.do?aci_no=${appraisalCaseImagesVO.aci_no}&action=showIMG"></th>
			<th>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/appraisal_case_images/appraisal_case_images.do" style="margin-bottom: 0px;">
					<input type="submit" value="刪除">
					<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
					<input type="hidden" name="aci_no" value="${appraisalCaseImagesVO.aci_no}">
					<input type="hidden" name="aca_no" value="${appraisalCaseImagesVO.aca_no}">
					<input type="hidden" name="action" value="delete">
				</FORM>
			</th>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="5">
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/appraisal_case_images/appraisal_case_images.do" style="margin-bottom: 0px;" enctype="multipart/form-data">
   				<div id="preview_progressbarTW_imgs"></div>
				<input type="file" name="aci_img" accept="image/*" id="progressbarTWInput" multiple >
				<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
				<input type="hidden" name="aca_no" value="${aca_no}">
				<input type="hidden" name="action" value="insert"> 
				<input type="submit" value="新增圖片">
			</FORM>
			</td>
		</tr>
</table>
</div>
</div>
</section>
<!--*******************Start Include JS File******************* -->
<%@ include file="../back_include_page/JavaScript_Include.jsp"%>
<!--*******************End Include JS File******************* -->
</body>
<script>
$("#progressbarTWInput").change(function(){
  $("#preview_progressbarTW_imgs").html(""); // 清除預覽
  readURL(this);
});

function readURL(input){
  if (input.files && input.files.length >= 0) {
    for(var i = 0; i < input.files.length; i ++){
      var reader = new FileReader();
      reader.onload = function (e) {
        var img = $("<img width='120' height='120'>").attr('src', e.target.result);
        $("#preview_progressbarTW_imgs").append(img);
      }
      reader.readAsDataURL(input.files[i]);
    }
  }
}
</script>
</html>