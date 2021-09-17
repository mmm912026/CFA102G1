<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>新增租賃商品圖片</title>
<%@ include file="../back_include_page/CSS_link.jsp"%>
<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<style>
  form { display: inline; }
  table#table-1 {
	background-color: #ffcc99;
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
			   <tr><td><h3>新增租賃商品圖片</h3>
			   <h6><a href="<%=request.getContextPath()%>/back_end/rentalProductImages/listRpi.jsp">回首頁</a></h6>
			   </td></tr>
			</table>
			
			<p>
			
			<h3>圖片上傳:</h3>
			
			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			
			<ul>
			
			  <jsp:useBean id="rcSvc" scope="page" class="com.rentalClass.model.RentalClassService" />
			   
			  <li>
			     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rpi/rpi.do" enctype="multipart/form-data">
			       <b>選擇租賃產品類別:</b>
			       <select size="1" name="rc_no">
			         <c:forEach var="rcVO" items="${rcSvc.all}" > 
			          <option value="${rcVO.rc_no}">${rcVO.rc_no}.${rcVO.rc_name}
			         </c:forEach>   
			       </select>
			       <input type="hidden" name="action" value="insert">
			       <input type="submit" value="送出">
			       <p>
			       <input type="file" accept="image/*" name="img1" id="img1input" >
			       <br><br>
			       <img id="img1show" src="" />       
			       <p>
			       <input type="file" accept="image/*" name="img2" id="img2input">
			       <br><br>
			       <img id="img2show" src="" />  
			       <p>
			       <input type="file" accept="image/*" name="img3" id="img3input">
			       <br><br>
			       <img id="img3show" src="" />  
			       <p>
			    </FORM>
			  </li>  
			</ul>		
		</div>
	</div>
<!--*******************	
		Start Include sidebar File  
		******************* -->
        <%@ include file="../back_include_page/JavaScript_Include.jsp"%>
	<!--*******************	
		End Include sidebar File  
		******************* --> 
<script>
img1input.onchange = evt => {
	  const [file] = img1input.files
	  if (file) {
		  img1show.src = URL.createObjectURL(file)
	  }
	}
img2input.onchange = evt => {
	  const [file] = img2input.files
	  if (file) {
		  img2show.src = URL.createObjectURL(file)
	  }
	}
img3input.onchange = evt => {
	  const [file] = img3input.files
	  if (file) {
		  img3show.src = URL.createObjectURL(file)
	  }
	}



</script>
		
</body>
</html>