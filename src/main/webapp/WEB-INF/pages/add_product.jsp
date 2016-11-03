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
	src="${pageContext.request.contextPath }/public/js/add_product.js"></script>
</head>
<body>
	<form id="ff" title="添加商品" method="post" enctype="multipart/form-data">
		<div>
			<label>商品名称:</label> <input type="text" name="p_name" />
		</div>
		<div>
			<label>商品价格：</label> <input type="text" name="p_price" />
		</div>
		<div>
			<label>图片上传:</label> <input type="file" name="imagefile" />
		</div>
		<div>
			<label>所属类别：</label> <input id="cc" name="p_category.c_id" />
		</div>
		<div>
			<label>加入推荐:</label> 推荐:<input type="radio" name="p_commend"
				checked="checked" value="1" /> 不推荐:<input type="radio"
				name="p_commend" value="0" />
		</div>
		<div>
			<label>是否有效:</label> 上架:<input type="radio" name="p_open"
				checked="checked" value="1" /> 下架:<input type="radio" name="p_open"
				value="0" />

		</div>
		<div>
			<label>简单描述:</label>
			<textarea name="p_remark" cols="40" rows="4"></textarea>
		</div>
		<div>
			<label>详细描述:</label>
			<textarea name="p_xremark" cols="40" rows="8"></textarea>
		</div>
		<div>
			<a id="submit" href="javascript:void(0)" class="easyui-linkbutton">添
				加</a> <a id="reset" href="javascript:void(0)" class="easyui-linkbutton">重
				置</a>
		</div>
	</form>
</body>
</html>