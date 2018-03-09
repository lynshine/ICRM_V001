<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		var currentPage = $("#page").val()
		if(Number(currentPage)<1){
			alert("没有此页")
			$("#page").val("1")
		}
		var totalPage = "${pageBean.totalPage}"
		if(Number(currentPage)>Number(totalPage)){
			alert("没有此页");
			$("#page").val(totalPage)
		}
		document.customerForm.submit();	
	}
	function change() {
		$("#customerForm").submit();
	}
</SCRIPT>
</head>
<body>
<TR>
	<TD>
		<SPAN id=pagelink>
			<DIV style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
				共[<B>${pageBean.count}</B>]条记录,[<B>${pageBean.totalPage}</B>]页
				,每页显示
				<select name="pageSize" onchange="change()">
				<option value="3" <c:if test="${pageBean.pageSize==3 }">selected</c:if>>3</option>
				<option value="5" <c:if test="${pageBean.pageSize==5 }">selected</c:if>>5</option>
				</select>
				条
				<c:if test="${pageBean.currentPage==1 }">
					[前一页]
				</c:if>
				
				<c:if test="${pageBean.currentPage!=1 }">
					[<A href="javascript:to_page(${pageBean.currentPage-1})">前一页</A>]
				</c:if>
				<B>${pageBean.currentPage}</B>
				<s:if test="#pageBean.currentPage == #pageBean.totalPage">
					[后一页] 
				</s:if>
				<s:else>
					[<A href="javascript:to_page(${pageBean.currentPage+1})">后一页</A>]
				</s:else>
				
				
				到
				<input type="text" size="3" id="page" name="currentPage" />
				页
				<input type="button" value="Go" onclick="to_page()"/>
			</DIV>
		</SPAN>
	</TD>
</TR>

</body>
</html>