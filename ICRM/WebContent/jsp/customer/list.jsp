<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<SCRIPT language=javascript>

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
		find("001", "#custIndustry","${cust_industry.dict_id}");
		find("002", "#custSource","${cust_source.dict_id}");
		find("006", "#custLevel","${cust_level.dict_id}");
		/* 异步加载负责人 */
		var value = "${cust_user_id.uid}"
		$.post("${pageContext.request.contextPath}/customer_findUser",
				function(data){
					$(data).each(function(i,n){
						$("#cust_user_id").append("<option value='"+n.uid+"' >"+n.nickname+"</option>")
					});
					$("#cust_user_id").find("option[value='"+value+"']").prop("selected","selected");
					
		},
		"json"
		);
		
	});

	/*删除客户  */
	function deleteCustomer(id) {
		if(confirm("您确定要删除此客户吗?")){
			location.href="${pageContext.request.contextPath }/customer_delete?cust_id="+id;
		}
	}
	
	
</SCRIPT>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm" action="${pageContext.request.contextPath }/customer_findByPage.action" method=post>	
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
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>客户名称：</TD>
													<TD><INPUT class=textbox id=sChannel2 style="WIDTH: 80px" maxLength=50 name="cust_name" value="${param.cust_name }"></TD>
													<!-- 客户级别 -->
													<TD>客户级别：</TD>
													<TD>
														<select name="cust_level.dict_id" class=textbox id="custLevel" style="WIDTH: 120px">
															<option value="" >---请选择---</option>
															
														</select>
													</TD>
													<!-- 客户来源 -->
													<TD>客户来源：</TD>
													<TD>
														<select name="cust_source.dict_id" class=textbox id="custSource" style="WIDTH: 120px">
															<option value="" >---请选择---</option>
														</select>
													</TD>
													<!--客户行业  -->
													<TD>客户行业：</TD>
													<TD>
														<select name="cust_industry.dict_id" class=textbox id="custIndustry" style="WIDTH: 120px">
															<option value="" >---请选择---</option>
															
														</select>
													</TD>
													<!-- 电话 -->
													<TD>电话：</TD>
													<TD><INPUT class=textbox id="cust_phone" style="WIDTH: 80px" maxLength=50 name="cust_phone" value="${param.cust_phone }"></TD>
													<!-- 负责人 -->
													<TD>负责人：</TD>
													<TD>
														<select name="cust_user_id.uid" class=textbox id="cust_user_id" style="WIDTH: 120px">
															<option value="" >---请选择---</option>
															
														</select>
													</TD>
													
													<TD><INPUT class=button id=sButton2 type=submit value=" 筛选 " ></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=grid style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc" cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>所属行业</TD>
													<TD>联系地址</TD>
													<TD>联系电话</TD>
													<TD>创建人</TD>
													<TD>负责人</TD>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${pageBean.list}" var="customer">
												<TR style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${customer.cust_name }</TD>
													<TD>${customer.cust_level.dict_item_name }</TD>
													<TD>${customer.cust_source.dict_item_name }</TD>
													<TD>${customer.cust_industry.dict_item_name }</TD>
													<TD>${customer.cust_address }</TD>
													<TD>${customer.cust_phone }</TD>
													
													<TD>${customer.cust_create_id.nickname }</TD>
													<TD>${customer.cust_user_id.nickname }</TD>
													
													<TD>
													<a href="${pageContext.request.contextPath }/customer_edit?cust_id=${customer.cust_id}">修改</a>
													&nbsp;&nbsp;
													<a href="javascript:deleteCustomer('${customer.cust_id }')">删除</a>
													</TD>
												</TR>	
												</c:forEach>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<%@ include file="/page.jsp" %>
								
							</TBODY>
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
					<TD align=middle width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
