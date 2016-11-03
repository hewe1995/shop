$(function() {
	// 自定义验证方法
	$.extend($.fn.validatebox.defaults.rules, {
		// 函数的名称：{函数的实现体(又是一个json对象，里面包括函数的实现，和错误消息的设置)}
		checkfile : {
			// 函数实现，如果返回为false，则验证失败
			validator : function(value, parm) {
				//alert(parm);
				var ext = value.substring(value.lastIndexOf('.') + 1);
				var arr = parm[0].split(",");
				
				for (var i = 0; i < arr.length; i++) {
					if (ext == arr[i]){
						
						return true;
					}
						
				}
				return false;
			},
			// 错误信息
			message : '必须为{0}文件'
		}
	});

	// 对类别的下拉列表框进行远程加载
	$("#cc").combobox({
		// 将请求发送给category/queryAll，这里需要将处理好的数据返回到这边来显示了
		// ，所以后台需要将数据打包成json格式发过来
		url : 'category/queryAll',
		valueField : 'c_id',
		textField : 'c_type', // 我们下拉列表中显示的是类别名
		panelHeight : 'auto', // 自适应高度
		panelWidth : 120,// 下拉列表是两个组件组成的
		width : 120, // 要同时设置两个宽度才行
		editable : false,// 下拉框不允许编辑
		required : true,
		missingMessage : '请选择所属类别'
	});
	$("input[name=p_name]").validatebox({ // 这里是“商品名称”的验证功能，如果用户没填好就提交的话，会有提示
		required : true,
		missingMessage : '请输入商品名称' // 提示的内容
	});
	$("input[name=p_price]").numberbox({  
        required:true,  
        missingMessage:'请输入商品价格',  
        min:0,  
        precision:2, //保留两位小数  
        prefix:'$'  
    }); 
	$("input[name='imagefile']").validatebox({  
        required:true,  
        missingMessage:'请上传商品图片',  
        //设置自定义方法  
        validType:"checkfile['gif,jpg,jpeg,png']"//中括号里面是参数  
    });
	$("textarea[name=p_remark]").validatebox({  
        required:true,  
        missingMessage:'请输入商品的简单描述'  
    });  
      
    $("textarea[name=p_xremark]").validatebox({  
        required:true,  
        missingMessage:'请输入商品的描述'  
    });
	// 窗体弹出默认是禁用验证，因为刚弹出的窗口，用户还没填就显示的话，太丑
	$("#ff").form("disableValidation");
	// 注册button的事件。即当用户点击“添加”的时候做的事
	$("#submit")
			.click(
					function() {
						// 开启验证
						$("#ff").form("enableValidation");
						// 如果验证成功，则提交数据
						if ($("#ff").form("validate")) {
							// 调用submit方法提交数据
							$("#ff")
									.form(
											'submit',
											{
												url : 'product/add', // 将请求提交给categoryAction中的save方法处理
												success : function() { // 成功后
													// 如果成功了，关闭当前窗口
													parent.$("#win_add")
															.window("close");
													// 刷新页面，刚刚添加的就显示出来了。
													// 获取aindex-->iframe-->datagrid
													parent
															.$("iframe[src='product/view']")[0].contentWindow
															.$("#dg").datagrid(
																	"reload");
												}
											});
						}
					});
	 //注册button的事件  
    $("#reset").click(function(){  
        $("#ff").form("disableValidation");//重置不需要表单验证  
        //重置当前表单数据  
        $("#ff").form("reset");  
    });
});