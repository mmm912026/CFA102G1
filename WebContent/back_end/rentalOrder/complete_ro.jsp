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
<title>�q�槹��/����</title>

<style>
	form { display: inline; }
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
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
	margin-top: 1px;
	margin-bottom: 1px;
	text-align:center;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>
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

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>�q�槹��/����</h3>
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
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/ro/ro.do" id="form2">
	<table id="ordertable">
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
			<th>�q���`����:</th>
			<td><%=roVO.getRo_totalprice()%> ��</td>
			<th>���:</th>
			<td><%=roVO.getRo_deposit()%> ��</td>
		</tr>
		<tr>
			<th>�ӫ~���A:</th>
			<td>
				<select size="1" name="ro_product_status" id="ro_product_status">
				<option value="���`" ${(roVO.ro_product_status=="���`")?'selected':'' }>���`
				<option value="��" ${(roVO.ro_product_status=="��")?'selected':'' }>��
				<option value="���l" ${(roVO.ro_product_status=="���l")?'selected':'' }>���l
				</select>
			</td>
			<th>������A:</th>
			<td><%=(roVO.getRo_deposit_status()==null?"":roVO.getRo_deposit_status())%></td>
		</tr>
		<tr>
			<th>����k�ٮɶ�:</th>
			<td colspan="3">
			<input name="ro_return_date" id="return_date" type="text" >
			</td>
		</tr>
		<tr>
			<th>�k�٪��A:</th>
			<td><span id="returnstatus"></span>
			<input type="hidden" name="ro_return_status" id="return" value="">
			</td>
			<th>�O��(���e)�Ѽ�:</th>
			<td>
			<span id="showday"></span>
			<input type="hidden" name="ro_delay_days" id="returndays" value="0" size="1">
			</td>
		</tr>
		<tr>
			<th>���l�����B:</th>
			<td><input type=${(roVO.ro_product_status=="���l")?'text':'hidden'} name="ro_repaircost" size="5" id="ro_repaircost" value="0"/></td>
			<th>���k�٩��:</th>
			<td>
			<span id="returnmoney"></span>
			<input type="text" name="ro_return_deposit" size="1" id="ro_return_deposit" value="<%=roVO.getRo_deposit()%>"/>
			</td>
		</tr>
	</table>
	<br>
	<input type="hidden" name="action" value="Complete_RO">
	<input type="hidden" name="ro_no" value="<%=roVO.getRo_no()%>">
	<input type="submit" value="�����q��" id="send" >
	</FORM>
<FORM>
<input onclick="window.close();" value="��������" type="button">
</FORM>
<br>
<br>
<input type="checkbox" id="cancelcheck">�����q��
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/ro/ro.do" id="form1">
<input type="hidden" name="action" value="cancelRo">
<input type="hidden" name="ro_no" value="<%=roVO.getRo_no()%>">
<input type="hidden" value="�����q��" id="cancelsend" >
</FORM>
<script>
        $.datetimepicker.setLocale('zh'); 
        $('#return_date').datetimepicker({
           timepicker: false,  
	       format: 'Y-m-d',
        });
        
        $('#form2').on('change',function(){
			if ($('#ro_repaircost').val()>=0){
				$('#send').removeAttr("disabled");
				if($('#returndays').val()<=0){
	        		var money = <%=roVO.getRo_deposit()%>-$('#ro_repaircost').val();
	        		$('#returndays').val(Math.abs($('#returndays').val()));
	        	}
	        	else{
	        		var money = <%=roVO.getRo_deposit()%>-$('#ro_repaircost').val()-2*$('#returndays').val()*<%=roVO.getRo_price()%>;        		
	        	}
				if(money<0)
					money=0;
	        	$('#ro_return_deposit').val(money);
	        	document.getElementById("returnmoney").innerHTML = money + " ��";
			}
			else{
				document.getElementById("returnmoney").innerHTML = '<font color="red">'+"��J���~"+'</font>';
				$('#send').attr("disabled","disabled");
			}
        });
        
             
//         	�ھڰӫ~���A���ܿ�J����
        $('#ro_product_status').on('change',function(){
        	if($("#ro_product_status :selected").val()=="���l"){
        		productDamage();
        	}else if ($("#ro_product_status :selected").val()=="��"){
        		productLost();
        	}else {
        		productNormal();	
        	}
           	});	

        function productNormal(){
    		$('#return_date').attr("type","text");	//�٭��k�٤���ﶵ
    		$('#return_date').val("");					//�]�w����Ŧr��
    		$('#ro_repaircost').attr("type","hidden");	//��ܷ��l�ȿ�J
    		$('#ro_repaircost').val(0);					//�]�w���l��0
       		document.getElementById("showday").innerHTML = "";	//�٭�O���Ѽ���ܪ��
    		document.getElementById("returnstatus").innerHTML = "";	//�٭��k�٪��A��ܪ��
    		$('#returndays').val(0);	//�]�w�O���Ѽ�0
    		$('#return').val("");		//�]�w�k�٪��A�Ŧr��	
        };
        function productLost(){
        	$('#return_date').attr("type","hidden");	//�����k�٤���ﶵ
        	$('#ro_repaircost').attr("type","hidden");		//���÷��l�B
        	$('#return_date').val("");						//�]�w�k�٤��value
        	$('#returndays').val(0);						//�]�w�O���Ѽ�0
        	$('#return').val("��");							//�]�w�k�٪��A�Ŧr��	
        	$('#ro_repaircost').val(<%=roVO.getRo_deposit()%>);   	//�]�w���l���B������
    		document.getElementById("showday").innerHTML = "";
			document.getElementById("returnstatus").innerHTML = "��";
        };
        function productDamage(){
    		$('#return_date').attr("type","text");	//�٭��k�٤���ﶵ
    		$('#return_date').val("");					//�]�w����Ŧr��
    		$('#ro_repaircost').attr("type","text");	//��ܷ��l�ȿ�J
    		$('#ro_repaircost').val(0);					//�]�w���l��0
       		document.getElementById("showday").innerHTML = "";	//�٭�O���Ѽ���ܪ��
    		document.getElementById("returnstatus").innerHTML = "";	//�٭��k�٪��A��ܪ��
    		$('#returndays').val(0);	//�]�w�O���Ѽ�0
    		$('#return').val("");		//�]�w�k�٪��A�Ŧr��
        }; 			  
//         �ھڤ����ܧ���
        $('#return_date').on('change',function(){
        	if($('#return_date').val()==""){
        		document.getElementById("showday").innerHTML = "";
        		document.getElementById("returnstatus").innerHTML = "";
        		$('#returndays').val(0);
        		$('#return').val("");
        	}else{
        		var Days = parseInt((new Date($('#return_date').val())-new Date("<%=roVO.getRo_endtime()%>"))/(1000*60*60*24));
				if (Days<0){
					document.getElementById("showday").innerHTML = Math.abs(Days) + " ��";
					document.getElementById("returnstatus").innerHTML = "���e";
					$('#returndays').val(Days);
					$('#return').val("���e");				
	
				}else if (Days ==0){
					document.getElementById("showday").innerHTML = Math.abs(Days) + " ��";
					$('#returndays').val(Days);
					document.getElementById("returnstatus").innerHTML = "�Ǯ�";
					$('#return').val("�Ǯ�");
				}else{
					document.getElementById("showday").innerHTML = Days + " ��";
					$('#returndays').val(Days);
					document.getElementById("returnstatus").innerHTML = "�O��";
					$('#return').val("�O��");
				} 		
        	}
        });
                          		        		        		
         $('#cancelcheck').click(function(){
        	if($('#cancelcheck').prop("checked"))
        		$('#cancelsend').attr("type","submit");
        	else
        		$('#cancelsend').attr("type","hidden");
         });  
         
         <c:if test="${closewindow!=null}">
	         window.onload=function (){
	        	 window.opener.location.reload();
	        	 window.close();
	        	 }    
         </c:if>
        
</script>
</body>
</html>