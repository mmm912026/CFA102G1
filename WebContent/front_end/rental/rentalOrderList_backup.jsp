<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rentalOrder.model.*"%>
<jsp:useBean id="today" class="java.util.Date" scope="page" />
<jsp:useBean id="rcSvc" scope="page" class="com.rentalClass.model.RentalClassService" />
<jsp:useBean id="rplSvc" scope="page" class="com.rentalProductList.model.RentalProductListService" />
<jsp:useBean id="prSvc" scope="page" class="com.productReviews.model.ProductReviewsService" />
<% 	
	//取得會員相關訂單
	Integer mem_no = 1;
	RentalOrderService roSvc = new RentalOrderService();
	List<RentalOrderVO> list = roSvc.getListByMem_no(mem_no);
	pageContext.setAttribute("list",list);
	
%>
<!DOCTYPE html>
<html>
<head>
	<!--*******************	
		Start Include CSS File  
		******************* -->
        <%@ include file="../front_include_page/CSS_link.jsp"%>
	<!--*******************	
		End Include CSS File  
		******************* -->        
        
        <title>YSM3C - 二手租賃商城</title>

        <link rel="icon" type="image/png" href="../front_CSS_JS/assets/img/favicon.png"> 
<style>
	div.container {
		margin-bottom:20px;
		padding-top:10px;
	}
</style>            
</head>
<body>

	<!--*******************	
		Start Top Head Area  
		******************* -->
		<%@ include file="../front_include_page/Top_head.jsp"%>
	<!--*******************	
		End Top Head Area  
		******************* -->	

	<!--*******************	
		Start Navbar Area  
		******************* -->		
		<%@ include file="../front_include_page/navbar.jsp"%>
	<!--*******************	
		End Navbar Area  
		******************* -->		
		
<!-- ************************下面開始塞你自己的頁面資訊************************ -->		
<!-- ************************下面開始塞你自己的頁面資訊************************ -->		

<section class="checkout-area ptb-50">
	<c:forEach var="roVO" items="${list}">
	<div class="container" style="background-color:white">
		<div class="row">
			<div class="col-lg-2 col-md-12">
				<h5>訂單編號:#${roVO.ro_no}</h5> 
			</div>
			<div class="col-lg-3 col-md-12">
				<h5>狀態:&nbsp;${roVO.ro_status}</h5> 
			</div>	
		</div>
		<br>
		<div class="row justify-content-center">
			<div class="col-lg-2 col-md-12 align-self-center">
				<img src="<%=request.getContextPath()%>/rpi/DBGifReader?action=showRcFirstImg&id=${rplSvc.getOneRentalProductList(roVO.rpl_no).rc_no}" alt="image"
                style="max-width:100%" >
			</div>
			<div class="col-lg-5 col-md-12">
				<table class="table table-striped">
					<tr>
						<th>租賃商品:</th><td>
						${rcSvc.getOneRentalClass(rplSvc.getOneRentalProductList(roVO.rpl_no).rc_no).rc_name}</td>
						<th>商品編號:</th><td>
						${roVO.rpl_no}</td>
					</tr>
					<tr>
						<th>租賃日期:</th><td colspan="5">${roVO.ro_starttime}&nbsp;&nbsp;-&nbsp;&nbsp;${roVO.ro_endtime}</td>
					</tr>
					<tr>
						<th>天數:</th><td>${roVO.ro_day} 天</td><th>價格:</th><td>${roVO.ro_price} 元/天</td>
					</tr>
					<tr>
						<th>押金:</th><td>${roVO.ro_deposit} 元</td><th>配送方式:</th><td>${roVO.ro_ship_method}</td>
					</tr>
					<tr>
						<th>配送地址:</th><td colspan="5">${roVO.ro_ship_addrs}</td>
					</tr>
				</table>
			</div>
			<div class="col-lg-5 col-md-12">
				<table class="table table-striped">
					<tr>
						<th>續租狀態:</th><td colspan="5">
						<c:choose>
							<c:when test="${roVO.ro_oncerentendtime=='1970-01-02'}">
								申請續租
							</c:when>
							<c:when test="${roVO.ro_oncerentendtime=='1970-01-01'}">					
							</c:when>
							<c:otherwise>
								續租成功
				            </c:otherwise>
						</c:choose>	
						</td>
					</tr>
					<tr>
						<th>歸還日期:</th><td colspan="5">
						<c:choose>
							<c:when test="${roVO.ro_return_date=='1970-01-01'}">
							</c:when>					
							<c:otherwise>
							${roVO.ro_return_date}
				            </c:otherwise>
						</c:choose>	
						</td>
					</tr>
					<tr>
						<th>歸還狀態:</th><td>${roVO.ro_return_status}</td><th>毀損扣除額:</th><td>${roVO.ro_repaircost==0?"":roVO.ro_repaircost}</td>
					</tr>
					<tr>
						<th>商品狀態:</th><td>${roVO.ro_product_status}</td><th>實際歸還押金:</th><td>${roVO.ro_return_deposit==0?"":roVO.ro_return_deposit}</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-12">
			</div>
			<div class="col-lg-3 col-md-12">
			<h4>訂單金額: ${roVO.ro_day * roVO.ro_price} 元</h4> 
			</div>
			<div class="col-lg-3 col-md-12" align="right">
			<c:if  test="${roVO.ro_status=='租賃中'&&roVO.ro_oncerentendtime=='1970-01-01'}">
				<button class="btn btn-outline-primary"
				onclick="location.href='<%=request.getContextPath()%>/back_end/ro/ro.do?action=getOne_For_Prolong&ro_no=${roVO.ro_no}'"
				>續租</button>
			</c:if> 
			<c:choose>
				<c:when test="${roVO.ro_status=='未付款'||roVO.ro_status=='續租-未付款'}">
					<button class="btn btn-outline-primary" 
					onclick="location.href='<%=request.getContextPath()%>/back_end/ro/ro.do?action=showRoPayPage&ro_no=${roVO.ro_no}'"
					>付款</button>
					<button class="btn btn-outline-primary"
					onclick="location.href='<%=request.getContextPath()%>/back_end/ro/ro.do?action=cancelRo&ro_no=${roVO.ro_no}&fromfront=true'"
					>取消訂單</button>	
				</c:when>
				<c:when test="${roVO.ro_status=='結束'&&(prSvc.getOneProductReviewsbyRo_no(roVO.ro_no))==null}">
					<c:if test="${((today.getTime()-roVO.ro_endtime.getTime())/(1000*24*60*60))<7}">
						<button class="btn btn-outline-primary"
						onclick="location.href='<%=request.getContextPath()%>/back_end/ro/ro.do?action=getOne_For_Pr&ro_no=${roVO.ro_no}'"
						>評價</button>
					</c:if>	
				</c:when>
				<c:when test="${roVO.ro_status=='取消'}">
				</c:when>
				<c:otherwise>
	            </c:otherwise>
			</c:choose> 				
			</div>
			
		</div>	
 	</div>
 	</c:forEach>
</section> 	
	                 	
       		
<!-- ************************上面塞你自己的頁面資訊***************************** -->	
<!-- ************************上面塞你自己的頁面資訊***************************** -->	

	<!--*******************	
		Start Footer Area  
		******************* -->			
		<%@ include file="../front_include_page/footer.jsp"%>
	<!--*******************	
		End Footer Area  
		******************* -->	
	
	<!--*******************	
		Start Go Top Area  
		******************* -->				
		<%@ include file="../front_include_page/startGoTop.jsp"%>
	<!--*******************	
		End Go Top Area  
		******************* -->			

	<!--*******************	
		Start Include JS File  
		******************* -->	
		<%@ include file="../front_include_page/JavaScript_Include.jsp"%>
	<!--*******************	
		End Include JS File  
		******************* -->	
</body>
</html>