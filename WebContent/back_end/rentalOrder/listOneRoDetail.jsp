<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.rentalOrder.model.*"%>

<%
	RentalOrderVO roVO = (RentalOrderVO) request.getAttribute("roVO");
%>
<jsp:useBean id="rcSvc" scope="page" class="com.rentalClass.model.RentalClassService" />
<jsp:useBean id="rplSvc" scope="page" class="com.rentalProductList.model.RentalProductListService" />
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>����q��d��/�ק�</title>

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
</style>

<style>
  table {
	width: 500px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>����q�����</h3>
	</td></tr>
</table>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/ro/ro.do" name="form1">
<table id="ordertable">
	<tr>
		<th>�q�檬�A:</th>
		<td><%=roVO.getRo_status()%></td>
		<th>�|���s��:</th>
		<td><%=roVO.getMem_no()%></td>
	</tr>
	<tr>
		<th>�q��s��:<font color=red><b>*</b></font></th>
		<td><%=roVO.getRo_no()%></td>
		<th>����ӫ~�s��:</th>
		<td><%=roVO.getRpl_no()%></td>
	</tr>
	<tr>
		<th>����ӫ~���O:</th>
		<td colspan="2">${rcSvc.getOneRentalClass(rplSvc.getOneRentalProductList(roVO.rpl_no).rc_no).rc_name}</td>
		<td>${rcSvc.getOneRentalClass(rplSvc.getOneRentalProductList(roVO.rpl_no).rc_no).rc_item}</td>
	</tr>

	<tr>
		<th>�B�e�覡:</th>
		<td colspan="3">
			<%=roVO.getRo_ship_method()%>
		</td>
	</tr>
	<tr>
		<th>�t�e�a�}:</th>
		<td colspan="3">
		<%=roVO.getRo_ship_addrs()%>
		</td>
	</tr>
	<tr>
		<th>����}�l�ɶ�:</th>
		<td><%=roVO.getRo_starttime()%></td>
		<th>������ɶ�:</th>
		<td><%=roVO.getRo_endtime()%></td>
	</tr>
	<tr>
		<th>����Ѽ�:</th>
		<td><%=roVO.getRo_day()%> ��	</td>
		<th>�������/�C��:</th>
		<td><%=roVO.getRo_price()%> ��</td>

	</tr>
	<tr>
		<th>�q����B:</th>
		<td><%=roVO.getRo_totalprice()%> ��</td>
		<th>���:</th>
		<td><%=roVO.getRo_deposit()%> ��</td>
	</tr>
	<tr>
		<th>�ӫ~���A:</th>
		<td><%=(roVO.getRo_product_status()==null?"":roVO.getRo_product_status())%></td>
		<th>������A:</th>
		<td><%=(roVO.getRo_deposit_status()==null?"":roVO.getRo_deposit_status())%></td>
	</tr>
	<tr>
		<th>����k�ٮɶ�:</th>
		<td colspan="3">${(roVO.ro_return_date=="1970-01-01")?"":roVO.ro_return_date}</tr>

	<tr>
		<th>�k�٪��A:</th>
		<td><%=(roVO.getRo_return_status()==null?"":roVO.getRo_return_status())%></td>
		<th>�O��(���e)�Ѽ�:</th>
		<td><%=(roVO.getRo_delay_days()==0?"":roVO.getRo_delay_days())%></td>
	</tr>
	<tr>
		<th>���l�����B:</th>
		<td><%=(roVO.getRo_repaircost()==0?"":roVO.getRo_repaircost())%></td>
		<th>����k�٩��:</th>
		<td><%=(roVO.getRo_return_deposit()==0?"":roVO.getRo_return_deposit())%></td>
	</tr>
</table>
<br>
<%if(!(roVO.getRo_status().equals("����")||roVO.getRo_status().equals("����")||roVO.getRo_status().equals("����-�ӫ~���l")||roVO.getRo_status().equals("����-�ӫ~��"))){ %>
<input type="hidden" name="action" value="getOne_For_Update">
<input type="hidden" name="ro_no" value="<%=roVO.getRo_no()%>">
<input type="submit" value="�ק�">
<%} %>
</FORM>
<FORM>
<input onclick="window.close();" value="��������" type="button">
</FORM>
<font style="color:red">(�D���n�Ф��H�N�ק�)</font>
<script src="<%=request.getContextPath()%>/back_end/back_CSS_JS/assets/vendors/jquery/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('input').attr('autocomplete', 'off');
	});
</script>
</body>
</html>