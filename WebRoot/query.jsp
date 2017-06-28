<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<% 
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询数据</title>
<script type="text/javascript" src="${path }/js/jquery.1.8.1.js"></script>


<script type="text/javascript">

	$(document).ready(function(){
		
		
		$("#selectPage").change(function(){
			document.location.href="user_query.do?model.page="+$(this).val();
		});
		
		//获取当前页定位
		$("option[value='${model.page}']").attr("selected","selected");
		
		$("#linkTo").click(function(){
			document.location.href="user_query.do?model.page="+$("#goTo").val();
		});
		
		//单击回车,前往输入页面
		document.onkeydown = function(e){ 
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) { //回车
		    	document.location.href="user_query.do?model.page="+$("#goTo").val();
		     };
		};
		
	});

</script>
</head>
<body>



	<table style="margin:0 auto;width:1100px;text-align:center">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>银行卡号</th>
			<th>电话号码</th>
			<th>邮箱</th>
			<th>备注</th>



		</tr>

		<s:iterator var="x" value="#attr.model.list">
			<tr>
				<td>${x.tuid }</td>
				<td>${x.name }</td>
				<td>${x.card }</td>
				<td>${x.phone }</td>
				<td>${x.mail }</td>
				<td>${x.remark }</td>

			</tr>

		</s:iterator>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr class="trTitle">
			<td class="tdTitle" colspan="5"
				style="background-color:#FFFFFF;text-align:center"><a
				href="user_query.do?model.page=1">首页</a> &nbsp; <a
				href="user_query.do?model.page=${model.page-1 }">上一页</a> &nbsp; <a
				href="user_query.do?model.page=${model.page+1 }">下一页</a> &nbsp; <a
				href="user_query.do?model.page=${model.lastPage}">尾页</a> &nbsp; <select
				id="selectPage">
					<s:iterator var="i" begin="1" end="model.lastPage">
						<option value="${i }" selected="selected">第${i }页</option>
					</s:iterator>
			</select> &nbsp;&nbsp; 前往第&nbsp;<input id="goTo" style="width:30px" onkeyup='this.value=this.value.replace(/\D/gi,"")'/>&nbsp;页&nbsp;
				<a href="javascript:void(0)" id="linkTo">Go!</a>&nbsp;
				当前第${model.page}页&nbsp;共${model.lastPage}页&nbsp;${model.count}条记录
			</td>
			
			每页显示的数目:<select onchange="loadPageSize('${fenyePage.page}',this.value)">
		<c:choose>
			<c:when test="${fenyePage.pageSize==10}">
				<option value="10" selected="selected">10条</option>
				<option value="30">30条</option>
				<option value="50">50条</option>
				<option value="100">100条</option>
			</c:when>
			<c:when test="${fenyePage.pageSize==30}">
				<option value="10">10条</option>
				<option value="30" selected="selected">30条</option>
				<option value="50">50条</option>
				<option value="100">100条</option>
			</c:when>
			<c:when test="${fenyePage.pageSize==50}">
				<option value="10">10条</option>
				<option value="30" >30条</option>
				<option value="50" selected="selected">50条</option>
				<option value="100">100条</option>
			</c:when>
			<c:when test="${fenyePage.pageSize==100}">
				<option value="10">10条</option>
				<option value="30" >30条</option>
				<option value="50" >50条</option>
				<option value="100" selected="selected">100条</option>
			</c:when>
		</c:choose>
		
	</select>
		</tr>
	</table>


	<form action="user_query.do" method="post">
		姓名:<input type="text" name="name" /><br /> 邮箱:<input type="text"
			name="mail" /><br /> <input type="submit" value="查询" />
	</form>
	<br />





	<jsp:include page="index.jsp"></jsp:include>

</body>
</html>