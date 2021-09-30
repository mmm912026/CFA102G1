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
  h4 {
    color: blue;
    display: inline;
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

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/ro/ro.do" name="form1">
<table id="ordertable">
	<tr>
		<th>�q�檬�A:</th>
		<td><%=roVO.getRo_status()%>
		<input type="hidden" name="ro_status" value="<%=roVO.getRo_status()%>" />
		</td>
		<th>�|���s��:</th>
		<td><%=roVO.getMem_no()%>
		<input type="hidden" name="mem_no" value="<%=roVO.getMem_no()%>" />
		</td>
	</tr>
	<tr>
		<th>�q��s��:<font color=red><b>*</b></font></th>
		<td><%=roVO.getRo_no()%>
		<input type="hidden" name="ro_no" value="<%=roVO.getRo_no()%>" />
		
		</td>
		<th>����ӫ~�s��:</th>
		<td><%=roVO.getRpl_no()%>
		<input type="hidden" name="rpl_no" value="<%=roVO.getRpl_no()%>" />
		</td>
	</tr>
	<tr>
		<th>����ӫ~���O:</th>
		<td colspan="2">${rcSvc.getOneRentalClass(rplSvc.getOneRentalProductList(roVO.rpl_no).rc_no).rc_name}</td>
		<td>${rcSvc.getOneRentalClass(rplSvc.getOneRentalProductList(roVO.rpl_no).rc_no).rc_item}</td>
	</tr>

	<tr>
		<th>�B�e�覡:</th>
		<td colspan="3">
			<input type="radio" id="selftake" name="ro_ship_method" value="�ۨ�" ${(roVO.ro_ship_method=="�ۨ�")?'checked':'' } >
			<label for="selftake">�ۨ�</label>
			<input type="radio" id="delivery" name="ro_ship_method" value="�v�t" ${(roVO.ro_ship_method=="�v�t")?'checked':'' } >
			<label for="delivery">�v�t</label>
		</td>
	</tr>
	<tr>
		<th>�t�e�a�}:</th>
		<td colspan="3">
		<input type="TEXT" name="ro_ship_addrs" size="40" value="<%=roVO.getRo_ship_addrs()%>" />
		
		</td>
	</tr>
	<tr>
		<th>����}�l�ɶ�:</th>
		<td>
		<input type="TEXT" name="ro_starttime" size="7" value="<%=roVO.getRo_starttime()%>" id="start_date" />
		</td>
		<th>������ɶ�:</th>
		<td>
		<input type="TEXT" name="ro_endtime" size="7" value="<%=roVO.getRo_endtime()%>" id="end_date" />
		</td>
	</tr>
	<tr>
		<th>����Ѽ�:</th>
		<td>
		<span id="showroday"><%=roVO.getRo_day()%> ��</span>
		<input type="hidden" name="ro_day" value="<%=roVO.getRo_day()%>" id="ro_day" />
		</td>
		<th>�������/�C��:</th>
		<td>
		<input type="TEXT" name="ro_price" size="3" value="<%=roVO.getRo_price()%>" id="ro_price" /> ��
		</td>

	</tr>
	<tr>
		<th>�q����B:</th>
		<td>
		<span id="showrototalprice"><%=roVO.getRo_totalprice()%> ��</span>
		<input type="hidden" name="ro_totalprice" id="ro_totalprice" value="<%=roVO.getRo_totalprice()%>" />
		</td>
		<th>���:</th>
		<td>
		<input type="TEXT" name="ro_deposit" size="3" value="<%=roVO.getRo_deposit()%>" /> ��
		</td>
	</tr>
	<tr>
		<th>�ӫ~���A:</th>
		<td>
			<select size="1" name="ro_product_status" id="ro_product_status">
				<option value="" ${(roVO.ro_product_status=="null")?'selected':'' }>
				<option value="���`" ${(roVO.ro_product_status=="���`")?'selected':'' }>���`
				<option value="��" ${(roVO.ro_product_status=="��")?'selected':'' }>��
				<option value="���l" ${(roVO.ro_product_status=="���l")?'selected':'' }>���l
			</select>
		</td>
		<th>������A:</th>
		<td>
			<select size="1" name="ro_deposit_status" id="ro_deposit_status">
				<option value="" ${(roVO.ro_deposit_status=="null")?'selected':'' }>
				<option value="�w����" ${(roVO.ro_deposit_status=="�w����")?'selected':'' }>�w����
				<option value="�����h�^" ${(roVO.ro_deposit_status=="�����h�^")?'selected':'' }>�����h�^
				<option value="���B�h�^" ${(roVO.ro_deposit_status=="���B�h�^")?'selected':'' }>���B�h�^
				<option value="�S��" ${(roVO.ro_deposit_status=="�S��")?'selected':'' }>�S��
			</select>	
		</td>
	</tr>
	<tr>
		<th>����k�ٮɶ�:</th>
		<td colspan="3">
		<input type="TEXT" name="ro_return_date" id="ro_return_date" size="7"	value="<%=(roVO.getRo_return_date()==null?"":roVO.getRo_return_date())%>"  />
		</td>
	</tr>
	<tr>
		<th>�k�٪��A:</th>
		<td>
			<select size="1" name="ro_return_status" id="ro_return_status">
				<option value="" ${(roVO.ro_return_status=="null")?'selected':'' }>
				<option value="���e" ${(roVO.ro_return_status=="���e")?'selected':'' }>���e
				<option value="�Ǯ�" ${(roVO.ro_return_status=="�Ǯ�")?'selected':'' }>�Ǯ�
				<option value="�O��" ${(roVO.ro_return_status=="�O��")?'selected':'' }>�O��
				<option value="��" ${(roVO.ro_return_status=="��")?'selected':'' }>��
			</select>	
		</td>
		<th>�O��(���e)�Ѽ�:</th>
		<td>
		<input type="TEXT" name="ro_delay_days" id="ro_delay_days" size="1" value="<%=roVO.getRo_delay_days()%>" /></td>
	</tr>

	<tr>
		<th>���l�����B:</th>
		<td>
		<input type="TEXT" name="ro_repaircost" id="ro_repaircost" size="3" value="<%=roVO.getRo_repaircost()%>" />
		</td>
		<th>����k�٩��:</th>
		<td>
		<input type="TEXT" name="ro_return_deposit" id="ro_return_deposit" size="3" value="<%=roVO.getRo_return_deposit()%>" />
		</td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="ro_no" value="<%=roVO.getRo_no()%>">
<input type="submit" value="�e�X">
<input type="reset" value="�^�_�쪬">
</FORM>
<FORM>
<input onclick="window.close();" value="����" type="button">
</FORM>
<font style="color:red">(�D���n�Ф��H�N�ק�)</font>
</body>

<link   rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/front_end/front_CSS_JS/assets/css/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/front_end/front_CSS_JS/assets/css/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/front_end/front_CSS_JS/assets/css/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>
<script>
		<c:if test="${closewindow!=null}">
		window.onload=function (){
			 window.opener.location="<%=request.getContextPath()%>/back_end/rentalOrder/listRo.jsp";
			 window.close();
			 }    
		</c:if>


        $.datetimepicker.setLocale('zh'); // kr ko ja en
        $('#start_date').datetimepicker({
           format: 'Y-m-d',
           timepicker: false,   //timepicker: false,	       	       
        });
        $('#end_date').datetimepicker({
            format: 'Y-m-d',
            timepicker: false,   //timepicker: false,	   
         });

        $.datetimepicker.setLocale('zh'); 
        $('#ro_return_date').datetimepicker({
           timepicker: false,  
	       format: 'Y-m-d',
        });
        
     // ���w������,�p�⯲��Ѽ�
        $('#start_date').on('change',function(){
        	if($('#start_date').val()&&$('#end_date').val()){
        		var start = new Date($('#start_date').val());
        		var end = new Date($('#end_date').val());
        		var Days = parseInt(1+Math.abs(end - start)/(1000*60*60*24));
        		var str = Days
        		$('#ro_day').val(Days)
        		var price = $('#ro_price').val() * Days
        		$('#ro_totalprice').val(price);
        		document.getElementById("showroday").innerHTML = Days + " ��";
        		document.getElementById("showrototalprice").innerHTML = price + " ��";
        	}
        	
        });
        	
        $('#end_date').on('change',function(){
        	if($('#start_date').val()&&$('#end_date').val()){
        		var start = new Date($('#start_date').val());
        		var end = new Date($('#end_date').val());
        		var Days = parseInt(1+Math.abs(end - start)/(1000*60*60*24));
        		$('#ro_day').val(Days)
        		var price = $('#ro_price').val() * Days
        		$('#ro_totalprice').val(price);
        		document.getElementById("showroday").innerHTML = Days + " ��";
        		document.getElementById("showrototalprice").innerHTML = price + " ��";
        		
        	if($('#ro_return_date').val()==""){
            	$('#ro_delay_days').val(0);
            	$('#ro_return_status').val("");
            }else{
            	var delayDays = parseInt((new Date($('#ro_return_date').val())-new Date("<%=roVO.getRo_endtime()%>"))/(1000*60*60*24));
    			if (delayDays<0){
    				$('#ro_delay_days').val(Math.abs(delayDays));
    				$('#ro_return_status').val("���e");
    				var money = <%=roVO.getRo_deposit()%>-$('#ro_repaircost').val();	
    				$('#ro_return_deposit').val(money);
    			}else if (delayDays >0){
    				$('#ro_delay_days').val(delayDays);
    				$('#ro_return_status').val("�O��");
    			}else{
    				$('#ro_delay_days').val(0);
    				$('#ro_return_status').val("�Ǯ�");
    			}  	
            }    		
        }
        });
        $('#ro_return_date').on('change',function(){
        	if($('#ro_return_date').val()==""){
        		$('#ro_delay_days').val(0);
        		$('#ro_return_status').val("");
        	}else{
        		var Days = parseInt((new Date($('#ro_return_date').val())-new Date("<%=roVO.getRo_endtime()%>"))/(1000*60*60*24));
        		
        		if (Days<0){
					$('#ro_delay_days').val(Math.abs(Days));
					$('#ro_return_status').val("���e");		
					var money = <%=roVO.getRo_deposit()%>-$('#ro_repaircost').val();
					$('#ro_return_deposit').val(money);
				}else if (Days ==0){
					$('#ro_delay_days').val(0);
					$('#ro_return_status').val("�Ǯ�");
					var money = <%=roVO.getRo_deposit()%>-$('#ro_repaircost').val();
					$('#ro_return_deposit').val(money);
				}else{
					$('#ro_delay_days').val(Days);
					$('#ro_return_status').val("�O��");
					var money = <%=roVO.getRo_deposit()%>-$('#ro_repaircost').val()-2*<%=roVO.getRo_price()%>*$('#ro_delay_days').val();
						if(money<0)
							$('#ro_return_deposit').val(0);
						else
							$('#ro_return_deposit').val(money);
				}  	
        	}
        });
        
        $('#ro_repaircost').on('change',function(){
        	if($('#ro_return_deposit').val()){
				var money = <%=roVO.getRo_deposit()%>-$('#ro_repaircost').val()-<%=roVO.getRo_price()%>*$('#ro_delay_days').val();
        		if(money<0)
        			$('#ro_return_deposit').val(0);
        		else
        			$('#ro_return_deposit').val(money);
        	}	
        });
        
        	$(document).ready(function(){
        		$('input').attr('autocomplete', 'off');
        	});
</script>
</html>