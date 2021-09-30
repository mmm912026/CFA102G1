<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.appraisal_case.model.*"%>
<%@ page import="com.appraisal_class.model.*"%>

<%
	Appraisal_CaseVO appraisalCaseVO = (Appraisal_CaseVO) request.getAttribute("appraisalCaseVO");
%>

<jsp:useBean id="appraisalClassSvc" scope="page" class="com.appraisal_class.model.Appraisal_ClassService" />

<!DOCTYPE html>
<html>
<head>
<!--*******************	Start Include CSS File ******************* -->
<%@ include file="../back_include_page/CSS_link.jsp"%>
<!--*******************	End Include CSS File ******************* -->
<meta charset="UTF-8">
<title>�����ץ���</title>
<link rel="icon" type="image/png" href="../back_CSS_JS/assets/imgaes/logo/favicon.png">

</head>
<body>
<section class="section">
	<div class="card">
		<div class="card-body">
	<table class="table table-striped" id="table1">
    <tr>
        <td>�����ץ�s��</td>
        <td>${appraisalCaseVO.aca_no }</td>
    </tr>
    <tr>
        <td>�|���s��</td>
        <td>${appraisalCaseVO.mem_no }</td>
    </tr>
    <tr>
        <td>�����ӫ~�W��</td>
        <td>${appraisalCaseVO.aca_itm_id }</td>
    </tr>
    <tr>
        <td>�������O</td>
        <td>
            <!--�d�ߦ������O�W�� -->
            ${appraisalClassSvc.getOneA_Class(appraisalCaseVO.acl_no).acl_id }
        </td>
    </tr>
    <tr>
        <td>�����ӫ~���e(�W��)</td>
        <td>${appraisalCaseVO.aca_itm_spec }</td>
    </tr>
    <tr>
        <td>�ץ���</td>
        <td><fmt:formatDate value="${appraisalCaseVO.aca_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>�ר����A</td>
        <td>${appraisalCaseVO.aca_itm_mode }</td>
    </tr>
    <tr>
        <td>����</td>
        <td>${appraisalCaseVO.aca_first_p }</td>
    </tr>
    <tr>
        <td>�������f���</td>
        <td><fmt:formatDate value="${appraisalCaseVO.aca_recpt_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>�����</td>
        <td>${appraisalCaseVO.aca_final_p }</td>
    </tr>
    <tr>
        <td>�X�f���</td>
        <td><fmt:formatDate value="${appraisalCaseVO.aca_shipment_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>���f���</td>
        <td><fmt:formatDate value="${appraisalCaseVO.aca_pickup_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>�I�ڤ覡</td>
        <td>${appraisalCaseVO.aca_pay }</td>
    </tr>
    <tr>
        <td>�������</td>
        <td><fmt:formatDate value="${appraisalCaseVO.aca_comp_date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>�B�e�覡</td>
        <td>${appraisalCaseVO.aca_cod }</td>
    </tr>
    <tr>
        <td>�t�e�a�}</td>
        <td>${appraisalCaseVO.aca_adrs }</td>
    </tr>
    
</table>
</div>
</div>
</section>
<!--*******************Start Include JS File******************* -->
<%@ include file="../back_include_page/JavaScript_Include.jsp"%>
<!--*******************End Include JS File******************* -->
</body>
</html>