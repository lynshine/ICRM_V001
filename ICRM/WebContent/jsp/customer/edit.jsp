<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>编辑客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

	function find(code,node,val){
		$.post("${pageContext.request.contextPath}/baseDict_findByType",
				{"dict_type_code":code},
				function(data){
					$(data).each(function(i,ele){
						$(node).append("<option value='"+ele.dict_id+"' >"+ele.dict_item_name+"</option>")
					})
					$(node).find("option[value='"+val+"']").prop("selected","selected");
					
				},
				"json"
		);
		
	}

	$(function(){
		find("001", "#custIndustry","${editCustomer.cust_industry.dict_id}");
		find("002", "#custSource","${editCustomer.cust_source.dict_id}");
		find("006", "#custLevel","${editCustomer.cust_level.dict_id}");
		
		
	});
</script>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/customer_update" method=post>
		<input type="hidden" name="cust_id" value="${editCustomer.cust_id}">
		<input type="hidden" name="cust_user_id.uid" value="${editCustomer.cust_user_id.uid }">
		<input type="hidden" name="cust_create_id.uid" value="${editCustomer.cust_create_id.uid }">
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg" height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_022.jpg" border=0>
					</TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 编辑客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_name" value="${editCustomer.cust_name}">
								</td>
								<td>客户行业 ：</td>
								<td>
									<select name="cust_industry.dict_id" class=textbox id="custIndustry" style="WIDTH: 180px">
										<option value="">---请选择---</option>
										
									</select>
								</td>
							</TR>							
							<TR>	
								<td>客户来源 ：</td>
								<td>
									<select name="cust_source.dict_id" class=textbox id="custSource" style="WIDTH: 180px">
										<option value="">---请选择---</option>
										
									</select>
								</td>
								<td>客户级别：</td>
								<td>
									<select name="cust_level.dict_id" class=textbox id="custLevel" style="WIDTH: 180px">
										<option value="">---请选择---</option>
										
									</select>								
								</td>
							</TR>
							<TR>
								<td>联系地址 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_address" value="${editCustomer.cust_address}">
								</td>
								<td>联系电话 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_phone" value="${editCustomer.cust_phone}">
								</td>
							</TR>
							<TR>
								<td>客户资质 ：</td>
								<td>
									<img  src="${pageContext.request.contextPath }/${editCustomer.cust_image}" width="180px">
								</td>
								
							</TR>
							<tr>
								<td rowspan=2>
									<INPUT class=button id=sButton2 type=submit value=" 保存 " >
								</td>
							</tr>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg" border=0></TD>
					<TD align="center" width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"	border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
