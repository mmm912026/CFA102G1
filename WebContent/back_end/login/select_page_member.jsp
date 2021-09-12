<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>
<!DOCTYPE html>
<html>
<head>
<title>會員設定</title>

<style>
  table#table-1 {
	width: 300px;
	background-color: grey;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 50px;
    text-align: center;
  }

  h4 {
    color: blue;
    display: inline;
  }
  #nav{
  float: right;
  left: -50%;
  position: relative;
}
</style>
	<!--*******************	
		Start Include CSS File  
		******************* -->
        <%@ include file="../back_include_page/CSS_link.jsp"%>
	<!--*******************	
		End Include CSS File  
		******************* -->  
	<meta charset="UTF-8">
	<title>YSM-3C 後台管理</title>
	<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
															
</head>
<body>
	<!--*******************	
		Start Include sidebar File  
		******************* -->
        <%@ include file="../back_include_page/sidebar.jsp"%>
	<!--*******************	
		End Include sidebar File  
		******************* -->  
		
		
	<!--*******************	
		Start Include sidebar File  
		******************* -->
        <%@ include file="../back_include_page/JavaScript_Include.jsp"%>
	<!--*******************	
		End Include sidebar File  
		******************* -->
   		<div id="nav"> 
		<h3>會員資料查詢 :</h3>
	
<%-- 錯誤表列 --%>
 <c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<div>
	    <c:forEach var="message" items="${errorMsgs}">
			<div style="color:red">${message}</div>
		</c:forEach>
	</div>
</c:if>


<div>
 <div><a href="<%=request.getContextPath()%>/back_end/member/listAllMember.jsp">List</a> all Staff.  <br><br></div>
  
  
  <div>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" >
        <b>輸入會員編號 :</b>
        <input type="text" name="mem_no">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </div>
<br>
  <br>
  <jsp:useBean id="memberSvc" scope="page" class="com.member.model.MemberService" />
   
  <div>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" >
       <b>選擇會員編號 :</b>
       <select size="1" name="mem_no">
         <c:forEach var="memberVO" items="${memberSvc.all}" > 
          <option value="${memberVO.mem_no}">${memberVO.mem_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </div>
  <br>
  <br>
  <div>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" >
       <b>選擇會員姓名 :</b>
       <select size="1" name="mem_no">
         <c:forEach var="memberVO" items="${memberSvc.all}" > 
          <option value="${memberVO.mem_no}">${memberVO.mem_name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </div>
</div>
<br>


	</div>
    
</body>
</html>