<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rentalProductImages.model.*"%>

<jsp:useBean id="rpiSvc" scope="page" class="com.rentalProductImages.model.RentalProductImagesService" />
<% 	
	List<RentalProductImagesVO> list = (List<RentalProductImagesVO>) request.getAttribute("list");
	if(list==null)
		list = rpiSvc.getAll();
	pageContext.setAttribute("list",list); 
		
%>
<jsp:useBean id="rcSvc" scope="page" class="com.rentalClass.model.RentalClassService" />

<html>
<head>
<title>租賃商品圖片</title>
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
					 <h3>租賃商品類別圖片</h3>
				</td></tr>
			</table>
			
			<input type="button" class="menu" value="租賃商品類別" onclick="location.href='<%=request.getContextPath()%>/back_end/rentalClass/listRc.jsp'"  />
			<input type="button" class="menu" value="租賃商品清單" onclick="location.href='<%=request.getContextPath()%>/back_end/rentalProductList/listRpl.jsp'" />
			<input type="button" class="menu" value="租賃商品圖片" onclick="location.href='<%=request.getContextPath()%>/back_end/rentalProductImages/listRpi.jsp'" />
						
			<table>
				<tr>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rentalProductImages/listRpi.jsp" >
				       		<input type="submit" value="顯示全部">
			     		</FORM>
					</td>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rpi/rpi.do" >
					        <b>圖片編號 :</b>
					        <input type="text" name="rpi_no" size="1">
					        <input type="hidden" name="action" value="getOne_For_Display">
					        <input type="submit" value="查詢">
				        </FORM>
					</td>
					<td>
					     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rpi/rpi.do" >
					       <b>類別:</b>
					       <select size="1" name="rc_no">
					         <c:forEach var="rcVO" items="${rcSvc.all}" > 
					          <option value="${rcVO.rc_no}" ${rcVO.rc_no==selectrc_no?'selected':''} >${rcVO.rc_no}.${rcVO.rc_name}
					         </c:forEach>   
					       </select>
					       <input type="hidden" name="action" value="getOneClass_For_Display">
					       <input type="submit" value="查詢">
					     </FORM>
					</td>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rentalProductImages/addRpi.jsp" >
				       		<input type="submit" value="新增圖片">
			     		</FORM>
					</td>
				</tr>	
			</table>		
			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			
			<table>
				<tr>
					<th>圖片編號</th>
					<th>類別</th>
					<th>圖片</th>
					<th>修改</th>
					<th>刪除</th>
				</tr>
				
			<%@ include file="page1.file"%> 
			
			<c:forEach var="rpiVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
					<tr
					<c:if test="${empty errorMsgs}">
					${(rpiVO.rpi_no==param.rpi_no) ? 'bgcolor=#CCCCFF':''}
					</c:if>											
					>
						<td>${rpiVO.rpi_no}</td>
						<td>${rpiVO.rc_no}.${(rcSvc.getOneRentalClass(rpiVO.rc_no)).rc_name}</td>
						<td><img src="<%=request.getContextPath()%>/rpi/DBGifReader?id=${rpiVO.rpi_no}" width="100px" height="auto"></td>
						<td>
						  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rpi/rpi.do" style="margin-bottom: 0px;">
						     <input type="submit" value="修改">
						     <input type="hidden" name="rpi_no"  value="${rpiVO.rpi_no}">
						     <input type="hidden" name="action"	value="getOne_For_Update">
						     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
						     <input type="hidden" name="whichPage"	value="<%=whichPage%>">  						 
						  </FORM>
						</td>
						<td>
						  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rpi/rpi.do" style="margin-bottom: 0px;">
						     <input type="submit" value="刪除">
						     <input type="hidden" name="rpi_no"  value="${rpiVO.rpi_no}">
						     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
						     <input type="hidden" name="whichPage"	value="<%=whichPage%>">  
						     <input type="hidden" name="action" value="delete">
						  </FORM>
						</td>
					</tr>
				</c:forEach>
			</table>
			<%@ include file="page2.file"%>	
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