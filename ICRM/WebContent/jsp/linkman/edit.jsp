<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>编辑联系人</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.post(
			"${pageContext.request.contextPath}/customer_findAll.action",
			function(result){
				$(result).each(function(i,n){
					$("#lkm_cust_id").append("<option value='"+n.cust_id+"'>"+n.cust_name+"</option>")
				})
				var oldVlaue = "${editLinkMan.lkm_cust_id.cust_id}"
				$("#lkm_cust_id").find("option[value='"+oldVlaue+"']").prop("selected","selected");
			},
			"json"
		)
		
	})
</script>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/linkMan_update" method=post>
		<input type="hidden" name="lkm_id" value="${editLinkMan.lkm_id}">
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"  height=20></TD>
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
								<TD class=manageHead>当前位置：联系人管理 &gt; 编辑联系人</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>所属客户：</td>
								<td colspan="3">
									<select id="lkm_cust_id" name="lkm_cust_id.cust_id" class="textbox" style="width: 140px; height: 21px;">
											<option value="">--请选择--</option>
									</select>
								</td>
							</tr>
							<TR>
								<td>联系人名称：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="lkm_name" value="${editLinkMan.lkm_name }">
								</td>
								<td>联系人性别：</td>
								<td>
									<input type="radio" value="1" name="lkm_gender" ${editLinkMan.lkm_gender=="1"?"checked":""}>男
									<input type="radio" value="2" name="lkm_gender" ${editLinkMan.lkm_gender=="2"?"checked":""}>女
								</td>
							</TR>
							<TR>
								<td>联系人办公电话 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="lkm_phone" value="${editLinkMan.lkm_phone }">
								</td>
								<td>联系人手机 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="lkm_mobile" value="${editLinkMan.lkm_mobile }">
								</td>
							</TR>
							<TR>
								<td>联系人邮箱 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="lkm_email" value="${editLinkMan.lkm_email }">
								</td>
								<td>联系人职位 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="lkm_position" value="${editLinkMan.lkm_position }">
								</td>
							</TR>
							<TR>
								<td>联系人简介 ：</td>
								<td >
									<textarea class=textbox id=sChannel2 style="WIDTH: 180px"  name="lkm_memo" >${editLinkMan.lkm_memo}</textarea>
								</td>
								<td>联系人QQ ：</td>
								<td >
									<textarea class=textbox id=sChannel2 style="WIDTH: 180px"  name="lkm_qq" >${editLinkMan.lkm_qq}</textarea>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
									<INPUT class=button id=sButton2 type=submit value="保存 ">
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
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
	<s:debug></s:debug>
</BODY>
</HTML>
