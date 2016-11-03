<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/public/head.jspf"%>
<base href="<%=basePath%>" />
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#dg").datagrid(
				{
					url : 'test1',
					loadMsg : 'loading...',
					queryParams : {
						type : ''
					},//参数  
					fitColumns : true,//水平自动展开，如果设置此属性，则不会有水平滚动条，演示冻结列时，该参数不要设置  
					//页码显示
					pagination : true,
					//显示斑马线  
					striped : true,
					//当数据多的时候不换行  
					nowrap : true,
					singleSelect : true, //如果为真，只允许单行显示，全显功能失效 
					//设置每页显示的记录数，默认是10个  
					pageSize : 5,
					//设置可选的每页记录数，供用户选择，默认是10,20,30,40...  
					pageList : [ 5, 10, 15, 20 ],
					idField : 'id',//指定id为标识字段，在删除，更新的时候有用，如果配置此字段，在翻页时，换页不会影响选中的项
					//工具栏
					toolbar : [
							{
								iconCls : 'icon-add',
								text : '添加类别',
								handler : function() {
									alert('--加添类别--');
								}
							},
							'-',
							{
								iconCls : 'icon-edit',
								text : '更新类别',
								handler : function() {
									alert('--更新类别--');
								}
							},
							'-',
							{
								iconCls : 'icon-remove',
								text : '删除类别',
								handler : function() {
									//判断是否有选中行记录，使用getSelections获取选中的所有行  
									var rows = $("#dg").datagrid(
											"getSelections");
									//返回被选中的行，如果没有任何行被选中，则返回空数组  
									if (rows.length == 0) {
										//弹出提示信息  
										$.messager.show({ //语法类似于java中的静态方法，直接对象调用  
											title : '错误提示',
											msg : '至少要选择一条记录',
											timeout : 2000,
											showType : 'slide',
										});
									} else {
										//提示是否确认删除，如果确认则执行删除的逻辑  
										$.messager.confirm('删除的确认对话框',
												'您确定要删除此项吗？', function(r) {
													if (r) {
														// 退出操作;  
														alert("--删除操作--")
													}
												});
									}
								}
							}, '-', { //查询按钮不是LinkButton，它有语法，但是也支持解析HTML标签  
								text : "<input id='ss' name='serach' />"
							} ],
					frozenColumns : [ [ {
						field : 'checkbox',
						checkbox : true
					}, {
						field : 'id',
						title : '编号',
						width : 200
					} ] ],
					columns : [ [ {
						field : 'type',
						title : '类型',
						width : 80
					}, {
						field : 'account.id',
						title : '所属用户',
						width : 200,
						formatter : function(value, row, index) {
							if (row.account != null && row.account.id != null) {
								return row.account.id; //如果登录名不为空，显示登录名  
							} else {
								return "此类别没有管理员";
							}
						}
					} ] ]
				});
		//把普通的文本框转化为查询搜索文本框  
		$('#ss').searchbox({
			//触发查询事件  
			searcher : function(value, name) { //value表示输入的值  
				$('#dg').datagrid('load', {
					type : value //字段的值
				}); //查询操作  
			},
			prompt : '请输入搜索关键字' //默认的显示  
		});
	});
</script>
</head>
<body>
	<table id="dg"></table>
</body>
</html>