<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>

<SCRIPT language=javascript>
$(function(){
	
	$.post(
		"${pageContext.request.contextPath}/customer_findAll.action",
		function(result){
			var oldValue="${lkm_cust_id.cust_id}"
			$(result).each(function(i,n){
				$("#lkm_cust_id").append("<option value='"+n.cust_id+"' >"+n.cust_name+"</option>")
				
			})
			$("#lkm_cust_id").find("option[value='"+oldValue+"']").prop("selected","selected");
		},
		"json"
		
	)
	
	
});

function del(id) {
	if(confirm("您确定要删除此联系人吗")){
		location.href="${pageContext.request.contextPath}/linkMan_delete?lkm_id="+id;
	}
}
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm" action="${pageContext.request.contextPath }/linkMan_findByPage.action" method=post>		
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
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
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
													<TD>联系人名称：</TD>
													<TD><INPUT class=textbox id=sChannel2 style="WIDTH: 80px" maxLength=50 name="lkm_name" value="${lkm_name }"></TD>
													<TD>性别：</TD>
													<TD>
														<select name="lkm_gender" class=textbox id="lkm_gender" style="WIDTH: 120px">
															<option value="" >--请选择--</option>
															<option value="1" <c:if test="${lkm_gender==1 }">selected</c:if>>男</option>
															<option value="2" <c:if test="${lkm_gender==2 }">selected</c:if>>女</option>
															
														</select>							
													</TD>
													<TD>办公电话：</TD>
													<TD><INPUT class=textbox id=sChannel2 style="WIDTH: 80px" maxLength=50 name="lkm_phone" value="${lkm_phone }"></TD>
													<TD>手机：</TD>
													<TD><INPUT class=textbox id=sChannel2 style="WIDTH: 80px" maxLength=50 name="lkm_mobile" value="${lkm_mobile }"></TD>
													<TD>邮箱：</TD>
													<TD><INPUT class=textbox id=sChannel2 style="WIDTH: 80px" maxLength=50 name="lkm_email" value="${lkm_email }"></TD>
													<TD>所属客户：</TD>
													<TD>
														<select name="lkm_cust_id.cust_id" class=textbox id="lkm_cust_id" style="WIDTH: 120px">
															<option value="" >--请选择--</option>
														</select>							
													</TD>
													
													
													<TD><INPUT class=button id=sButton2 type=submit value=" 筛选 " name=sButton2></TD>
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
													<TD>联系人名称</TD>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>邮箱</TD>
													<TD>职位</TD>
													<TD>备注</TD>
													<TD>所属客户</TD>
													<TD>操作</TD>
												</TR>
												
												<c:forEach items="${pageBean.list }" var="linkman">
												<TR style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${linkman.lkm_name }</TD>
													<TD>${linkman.lkm_gender }</TD>
													<TD>${linkman.lkm_phone }</TD>
													<TD>${linkman.lkm_mobile }</TD>
													<TD>${linkman.lkm_email }</TD>
													<TD>${linkman.lkm_position }</TD>
													<TD>${linkman.lkm_memo }</TD>
													<TD>${linkman.lkm_cust_id.cust_name}</TD>
													<TD>
													<a href="${pageContext.request.contextPath }/linkMan_edit?lkm_id=${linkman.lkm_id}">修改</a>
													&nbsp;&nbsp;
													<a href="javascript:del('${linkman.lkm_id }')">删除</a>
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
					<TD align="center" width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
	<s:debug></s:debug>
</BODY>
</HTML>
