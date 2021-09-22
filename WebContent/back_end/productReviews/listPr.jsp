<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.productReviews.model.*"%>
<% 	
	ProductReviewsService prSvc = new ProductReviewsService();
	List<ProductReviewsVO> listAll = prSvc.getAll();
	List<ProductReviewsVO> list = (List<ProductReviewsVO>) request.getAttribute("list");
	if(list==null)
		list = listAll;
	pageContext.setAttribute("list",list);	
%>

<html>
<head>
<title>租賃商品評價</title>
<%@ include file="../back_include_page/CSS_link.jsp"%>
<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
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
					 <h3>租賃商品評價</h3>
				</td></tr>
			</table>
			
			<input type="button" class="menu" value="租賃評價檢舉" onclick="location.href='<%=request.getContextPath()%>/back_end/reportProductReviews/listRpr.jsp'" />
			<input type="button" class="menu" value="租賃商品評價" onclick="location.href='<%=request.getContextPath()%>/back_end/productReviews/listPr.jsp'"/>
			
			<table>
				<tr>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/productReviews/listPr.jsp" >
				       		<input type="submit" value="顯示全部">
			     		</FORM>
					</td>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/pr/pr.do" >
					       <b>編號:</b>
						   <input type="text" name="pr_no" size="1">
					       <input type="hidden" name="action" value="getOne_For_Display">
					       <input type="submit" value="查詢">
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
					<th>評價編號</th>
					<th>類別編號</th>
					<th>租賃單號</th>
					<th>內容</th>
					<th>圖片</th>
					<th>評分</th>
					<th>狀態</th>
					<th>上下架</th>
				</tr>
			<%@ include file="page1.file"%> 
					<c:forEach var="prVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
					<tr
					<c:if test="${empty errorMsgs}">
					${(prVO.pr_no==param.pr_no) ? 'bgcolor=#CCCCFF':''}
					</c:if>
					>
						<td>${prVO.pr_no}</td>
						<td>${prVO.rc_no}</td>
						<td>${prVO.ro_no}</td>
						<td>${prVO.pr_content}</td>
						<td>
						<c:if test="${prVO.pr_images!=null}">
						<img src="<%=request.getContextPath()%>/back_end/pr/pr.do?action=showPrImg&pr_no=${prVO.pr_no}" 
                        style="height:70px" >	
							</c:if>
						</td>	
						<td>${prVO.pr_score}</td>
						<td>${prVO.pr_status}</td>
						<td>
							 <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/pr/pr.do" style="margin-bottom: 0px;">
						     <input type="submit" value=${prVO.pr_status=="上架"?"下架":"上架"}>
						     <input type="hidden" name="pr_no"  value="${prVO.pr_no}">
						     <input type="hidden" name="pr_status"  value=${prVO.pr_status=="上架"?"下架":"上架"}>
						     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
						     <input type="hidden" name="whichPage"	value="<%=whichPage%>"> 
						     <input type="hidden" name="action"	value="getOne_Change_Status"></FORM>
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