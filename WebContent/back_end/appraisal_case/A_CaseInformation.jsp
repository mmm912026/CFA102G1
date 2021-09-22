<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.appraisal_case.model.*"%>
<%@ page import="com.appraisal_class.model.*"%>
<%@ page import="com.appraisal_case_images.model.*" %>

<%
	Appraisal_CaseVO appraisalCaseVO = (Appraisal_CaseVO) request.getAttribute("appraisalCaseVO");
%>

<jsp:useBean id="appraisalClassSvc" scope="page" class="com.appraisal_class.model.Appraisal_ClassService" />
<jsp:useBean id="appraisalCaseImages" scope="page" class="com.appraisal_case_images.model.Appraisal_Case_ImagesService" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>估價案件資料</title>

<style>
table {
	
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body>

<table>
    <tr>
        <td>估價案件編號</td>
        <td>${appraisalCaseVO.aca_no }</td>
    </tr>
    <tr>
        <td>會員編號</td>
        <td>${appraisalCaseVO.mem_no }</td>
    </tr>
    <tr>
        <td>估價商品名稱</td>
        <td><input type="text" value="${appraisalCaseVO.aca_itm_id }" disabled></td>
    </tr>
    <tr>
        <td>估價類別</td>
        <td>
            <!-- 					查詢估價類別名稱 -->
            ${appraisalClassSvc.getOneA_Class(appraisalCaseVO.acl_no).acl_id }

        </td>
    </tr>
    <tr>
        <td>估價商品內容(規格)</td>
        <td>${appraisalCaseVO.aca_itm_spec }</td>
    </tr>
    <tr>
        <td>案件日期</td>
        <td><fmt:formatDate value="${appraisalCaseVO.aca_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>案見狀態</td>
        <td>${appraisalCaseVO.aca_itm_mode }</td>
    </tr>
    <tr>
        <td>報價</td>
        <td>${appraisalCaseVO.aca_first_p }</td>
    </tr>
    <tr>
        <td>門市收貨日期</td>
        <td><fmt:formatDate value="${appraisalCaseVO.aca_recpt_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>成交價</td>
        <td>${appraisalCaseVO.aca_final_p }</td>
    </tr>
    <tr>
        <td>出貨日期</td>
        <td><fmt:formatDate value="${appraisalCaseVO.aca_shipment_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>取貨日期</td>
        <td><fmt:formatDate value="${appraisalCaseVO.aca_pickup_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>付款方式</td>
        <td>${appraisalCaseVO.aca_pay }</td>
    </tr>
    <tr>
        <td>完成日期</td>
        <td><fmt:formatDate value="${appraisalCaseVO.aca_comp_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>運送方式</td>
        <td>${appraisalCaseVO.aca_cod }</td>
    </tr>
    <tr>
        <td>配送地址</td>
        <td>${appraisalCaseVO.aca_adrs }</td>
    </tr>
    <tr>
    	<td>估價圖片</td>
    	<td>
	    	<c:forEach var="appraisalCaseImagesVO" items="${appraisalCaseImagesSvc.all }">
	    		<img width="100" height="100" src="<%=request.getContextPath()%>/back_end/appraisal_case_images/appraisal_case_images.do?aci_no=${appraisalCaseImagesVO.aci_no}">
	    		${appraisalCaseImagesSvc.getOneA_Case_Image(appraisalCaseImagesVO.aci_no).aci_img }
	    	</c:forEach>
		</td>
    </tr>

    <tr>
    <td>修改</td>
        <td>
            <FORM METHOD="post" ACTION="<%= request.getContextPath()%>/back_end/appraisal_case/appraisal_case.do"style="margin-bottom: 0px;">
                <input type="submit" value="修改">
                <input type="hidden" name="aca_no" value="${appraisalCaseVO.aca_no}">
                <input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
                <input type="hidden" name="action" value="getOne_For_Update">
            </FORM>
        </td>
    </tr>
</table>
</body>
</html>