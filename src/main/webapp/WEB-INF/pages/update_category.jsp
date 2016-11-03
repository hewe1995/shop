<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/public/head.jspf"%>
<base href="<%=basePath%>" />
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/public/js/update_category.js"></script>
</head>
<body>
	<form id="ff" method="post">
		<div>
			<label for="c_name">商品名称:</label> <input type="text" name="c_type" />
		</div>
		<div>
			<label>所属管理员：</label> <input id="cc" name="c_account.a_id" />
		</div>
		<div>
			<label for="c_hot">热点:</label> 是<input type="radio" name="c_hot"
				value="true" /> 否 <input type="radio" name="c_hot" value="false" checked="checked"/>
		</div>
		<div>
			<a id="btn" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit'">更新</a>
		</div>
	</form>
</body>
</html>