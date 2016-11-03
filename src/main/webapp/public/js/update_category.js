$(function() {
	// 获取datagrid对象
	var dg = parent.$("iframe[src='category/view']")[0].contentWindow.$("#dg");

	$("input[name=c_type]").validatebox({ // 这里是“类别名称”的验证功能，如果用户没填好就提交的话，会有提示
		required : true,
		missingMessage : '请输入类别名称' // 提示的内容
	});

	// 对管理员的下拉列表框进行远程加载
	$("#cc").combobox({
		// 将请求发送给accountAction中的query方法处理，这里需要将处理好的数据返回到这边来显示了
		// ，所以后台需要将数据打包成json格式发过来
		url : 'account/queryAll',
		valueField : 'a_id',
		textField : 'a_login', // 我们下拉列表中显示的是管理员的登录名
		panelHeight : 'auto', // 自适应高度
		panelWidth : 120,// 下拉列表是两个组件组成的
		width : 120, // 要同时设置两个宽度才行
		editable : false
	// 下拉框不允许编辑
	});

	// 数据回显
	var rows = dg.datagrid("getSelections");
	// 将拿到的那一行对应的数据字段加载到表单里，实现回显
	$("#ff").form('load', {
		c_id : rows[0].c_id,
		c_type : rows[0].c_type,
		c_hot : rows[0].c_hot,
		'c_account.a_id' : rows[0].c_account.a_id
	// EasyUI不支持account.id这种点操作，所以要加个引号
	});

	// 窗体弹出默认是禁用验证，因为刚弹出的窗口，用户还没填就显示的话，太丑
	$("#ff").form("disableValidation");
	// 注册button的事件。即当用户点击“添加”的时候做的事
	$("#btn").click(function() {
		// 开启验证
		$("#ff").form("enableValidation");
		// 如果验证成功，则提交数据
		if ($("#ff").form("validate")) {
			// 调用submit方法提交数据
			$("#ff").form('submit', {
				url : 'category/update', // 将请求提交给categoryAction中的save方法处理
				success : function() { // 成功后
					// 如果成功了，关闭当前窗口
					parent.$("#win_update").window("close");
					// 刷新页面，刚刚添加的就显示出来了。
					dg.datagrid("reload");
				}
			});
		}
	});
});