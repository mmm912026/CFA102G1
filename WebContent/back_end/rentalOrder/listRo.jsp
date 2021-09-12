<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rentalOrder.model.*"%>
<%@ page import="com.rentalClass.model.*"%>
<%@ page import="com.rentalProductList.model.*"%>
<% 	
	RentalOrderService roSvc = new RentalOrderService();
	List<RentalOrderVO> list = (List<RentalOrderVO>) request.getAttribute("list");
	if(list==null)
		list = roSvc.getAll();
	pageContext.setAttribute("list",list);
	
	String roStatusSelect = (String) request.getAttribute("roStatusSelect");
	pageContext.setAttribute("roStatusSelect",roStatusSelect);
%>

<html>
<head>
<title>租賃訂單資訊</title>
<%@ include file="../back_include_page/CSS_link.jsp"%>
<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">
<style>
  form { display: inline; }
  table#table-1 {
	background-color: #CCCCFF;
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
					 <h3>租賃訂單資訊</h3>
					 <h4></h4>
				</td></tr>
			</table>
			<table>
				<tr>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rentalOrder/listRo.jsp" >
				       		<input type="submit" value="顯示全部">
			     		</FORM>
					</td>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/ro/ro.do" >
					        <b>訂單編號 :</b>
					        <input type="text" name="ro_no" size="2">
					        <input type="hidden" name="action" value="getOne_For_Display">
					        <input type="submit" value="查詢">
				        </FORM>
					</td>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/ro/ro.do" >
					        <b>訂單狀態 :</b>
					        <select name="ro_status" >
					        	<option value="未付款" ${('未付款'eq roStatusSelect)?'selected':''} >未付款</option>
					        	<option value="已付款,未出貨" ${('已付款,未出貨'eq roStatusSelect)?'selected':''} >已付款,未出貨</option>
					            <option value="租賃中" ${('租賃中' eq roStatusSelect)?'selected':''} >租賃中</option>
					            <option value="完成" ${('完成' eq roStatusSelect)?'selected':''} >完成</option>
					            <option value="取消" ${('取消'eq roStatusSelect)?'selected':''} >取消</option>
					        </select>
					        <input type="hidden" name="action" value="getOneRoStatus_For_Display">
					        <input type="submit" value="查詢">
				        </FORM>
					</td>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/ro/ro.do" >
					        <b>電話(未完成) :</b>
					        <input type="text" name="mem_phone" size="5">
					        <input type="hidden" name="action" value="getRObyPhone_For_Display">
					         <input type="submit" value="查詢">
				        </FORM>
					</td>			
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/rentalClass/listRc.jsp" >
				       		 <input type="submit" value="新增訂單">
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
			
			<c:if test="${not empty Msgs}">
				<ul>
					<c:forEach var="message" items="${Msgs}">
						<li style="color:blue">${Msgs}</li>
					</c:forEach>
				</ul>
			</c:if>
			
			<table>
				<tr>
					<th colspan="6">訂單</th>
					<th colspan="3">歸還狀態</th>
				</tr>
				<tr>
					<th>編號</th>
					<th>會員編號</th>
					<th>商品編號</th>
					<th>狀態</th>
					<th>開始時間</th>
					<th>結束時間</th>
					<th>歸還狀態</th>
					<th>實際歸還時間</th>
					<th width="120">訂單選項</th>
				</tr>
			<%@ include file="page1.file"%> 
				<c:forEach var="roVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>" varStatus="s">
					<tr 
					<c:if test="${empty errorMsgs}">
					${(roVO.ro_no==param.ro_no) ? 'bgcolor=#CCCCFF':''}
					</c:if>
					>
						<td><A href="javascript:showDetail(${roVO.ro_no})">${roVO.ro_no}</A></td>
						<td>${roVO.mem_no}</td>
						<td>${roVO.rpl_no}</td>
						<td><span class="ro_status">${roVO.ro_status}</span></td>
						<td>${roVO.ro_starttime}</td>
						<td>${roVO.ro_endtime}</td>
						<td>${roVO.ro_return_status}</td>
						<td>${(roVO.ro_return_date=="1970-01-01")?"":roVO.ro_return_date}</td>
						<td>
							<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/ro/ro.do" style="margin-bottom: 0px;">
						     <input type="submit" ${(roVO.ro_status=="已付款,待出貨")?"":"disabled"} value="出貨">
						     <input type="hidden" name="ro_no"  value="${roVO.ro_no}">
						     <input type="hidden" name="action"	value="deliver">
						     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
						     <input type="hidden" name="whichPage"	value="<%=whichPage%>">   
						    </FORM>
						    <input type="submit" value="結束" ${(roVO.ro_status=="完成")?"disabled":""} ${(roVO.ro_status=="取消")?"disabled":"" }
						    onclick="showEnd(${roVO.ro_no})">
					</tr>
				</c:forEach>
			</table>
			<%@ include file="page2.file"%>
			
			
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/ro/ro.do" >
					        <b>訂單編號 :</b>
					        <input type="text" name="ro_no">
					        <input type="submit" value="付款">
					        <input type="hidden" name="action" value="payOneRO"> 
					        <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
						    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               
			</FORM>
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
    function showDetail(data){
    	document.open('<%=request.getContextPath()%>/back_end/ro/ro.do?ro_no='+data+'&action=getOne_For_DisplayDetail', '' ,'height=700,width=800,left=150,top=130,resizable=yes,scrollbars=yes');
   	}
    function showEnd(data){
        document.open('<%=request.getContextPath()%>/back_end/ro/ro.do?ro_no='+data+'&action=getOne_For_End', '' ,'height=810,width=800,left=150,top=130,resizable=yes,scrollbars=yes');
    }
       
</script>
</body>
</html>