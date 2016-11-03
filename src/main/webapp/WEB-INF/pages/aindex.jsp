<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/public/head.jspf"%>
<base href="<%=basePath%>" />
<link rel="stylesheet" type="text/css" href="public/css/aindex.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/public/js/aindex.js"></script>
<title>Insert title here</title>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'欢迎来到易购后台管理',split:true"
		style="height: 100px;"></div>
	<div data-options="region:'west',title:'系统操作',split:true"
		style="width: 200px;">
		<!-- 此处显示的是系统菜单 -->
		<div id="menu" class="easyui-accordion" data-options="fit:true">
			<div title="基本操作" data-options="iconCls:'icon-save'">
				<ul>
					<li><a href="javascript:void(0)" title="category/view">类别管理</a>
					<li><a href="javascript:void(0)" title="product/view">商品管理</a>
				</ul>
			</div>
			<div title="其他操作" data-options="iconCls:'icon-reload'">
				<ul>
					<li><a href="javascript:void(0)">类别管理</a>
					<li><a href="javascript:void(0)">商品管理</a>
				</ul>
			</div>
		</div>
	</div>
	<div data-options="region:'center',title:'后台操作页面'"
		style="padding: 1px; background: #eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="系统缺省页面" style="padding: 10px;">
				此处以后显示相应的系统信息（当前操作系统的类型，当前项目的域名，硬件的相关配置或者显示报表</div>

		</div>
	</div>
	<!-- 添加类别的对话框 -->
	<div id="win_add"
		data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>
	<div id="win_update"
		data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>
</body>
</html>