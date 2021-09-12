<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<title>Consultation</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
</style>

</head>
<body bgcolor='white'>
<div id="app">
<!--*******************	
		Start Include sidebar File  
		******************* -->
        <%@ include file="../back_include_page/sidebar.jsp"%>
	<!--*******************	
		End Include sidebar File  
		******************* -->  
<div id="main">
<table id="table-1">
   <tr><td><h3>Consultation</h3></td></tr>
</table>


<h3>�Ըߪ���Ƭd��:</h3>
<hr>
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='<%=request.getContextPath()%>/back_end/consultation/listAllConsult.jsp'>List</a> all Consults.		  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/consultation/consult.do" >
        <b>��J�Ը߳�s�� (�p1):</b>
        <input type="text" name="consult_no">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="consultSvc" scope="page" class="com.consultation.model.ConsultService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/consultation/consult.do" >
       <b>��ܿԸ߳�s��:</b>
       <select size="1" name="consult_no">
         <c:forEach var="consultVO" items="${consultSvc.all}" > 
          <option value="${consultVO.consult_no}">${consultVO.consult_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/consultation/consult.do" >
       <b>��ܿԸߤH�m�W:</b>
       <select size="1" name="consult_no">
         <c:forEach var="consultVO" items="${consultSvc.all}" > 
          <option value="${consultVO.consult_no}">${consultVO.consultant}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>


<h3>�Ըߪ��޲z</h3>

<ul>
  <li><a href='addConsult.jsp'>Add</a> a new Consult.</li>
</ul>
<!--*******************	
		Start Include sidebar File  
		******************* -->
        <%@ include file="../back_include_page/JavaScript_Include.jsp"%>
	<!--*******************	
		End Include sidebar File  
		******************* -->
		</div>
</div>
</body>
</html>