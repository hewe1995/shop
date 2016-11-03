<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/public/head.jspf"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/public/js/simpleCart.js"></script>
<base href="<%=basePath%>" />
<title>Insert title here</title>
<style type="text/css">
.simpleCart_items table {
	border: 1px solid #ccc;
}

.simpleCart_items th {
	color: #333;
	text-align: left;
	padding: 10px 30px;
	border-bottom: 1px solid #ccc;
	background: #ededed;
	background: -moz-linear-gradient(top, #f7f7f7 0%, #ededed 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f7f7f7),
		color-stop(100%, #ededed));
	background: -webkit-linear-gradient(top, #f7f7f7 0%, #ededed 100%);
	background: -o-linear-gradient(top, #f7f7f7 0%, #ededed 100%);
	background: -ms-linear-gradient(top, #f7f7f7 0%, #ededed 100%);
	background: linear-gradient(top, #f7f7f7 0%, #ededed 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7f7f7',
		endColorstr='#ededed', GradientType=0);
}

.simpleCart_items td {
	padding: 10px 30px;
	vertical-align: middle;
	border-bottom: 1px solid #ccc;
}

.item-image, .item-image img {
	width: 72px;
}

.item-name {
	width: 50%;
}

.item-quantity, .item-quantity input {
	width: 30px;
	text-align: center;
}

.item-price, .item-subtotal {
	width: 50px;
}

.simpleCart_total_div {
	text-align: right;
	padding: 5px;
	border-bottom: 1px solid #ccc;
	font-size: 16px;
}

.simpleCart_total {
	margin-right: 20px;
}

.sp_left {
	float: left;
	margin-left: 10px;
}
</style>
<script type="text/javascript">
	simpleCart({
		shippingQuantityRate : 1,
		taxRate : 2,
		currency : "HKD", // set the currency to pounds sterling
		cartColumns : [ {
			attr : "thumb",
			label : "",
			view : "image"
		}, {
			attr : "name",
			label : "名称"
		}, {
			attr : "price",
			label : "价格",
			view : 'currency'
		}, {
			view : "decrement",
			label : false,
			text : "-"
		}, {
			attr : "quantity",
			label : "数量"
		}, {
			view : "increment",
			label : false,
			text : "+"
		}, {
			attr : "total",
			label : "总价",
			view : 'currency'
		}, {
			view : "remove",
			text : "移除",
			label : false
		} ],
		cartStyle : "table",
		checkout : {
			type : "custom",
			url : "product/getAll",
			method : "post",
			fn : function(opts) {
				var form = simpleCart.$create("form");
				form.attr('style', 'display:none;');
				form.attr('action', opts.url);
				form.attr('method', opts.method);
				simpleCart.each(function(val) {
					var id = val.get("id");
					var name = val.get("name");
					form.append(simpleCart.$create("input").attr("type",
							"hidden").attr("name", "id").val(id));
					form.append(simpleCart.$create("input").attr("type",
							"hidden").attr("name", "name").val(name));
				});
				simpleCart.$("body").append(form);
				form.el.submit();
				form.remove();
			}
		}
	});
	// log the total when simpleCart has initialized
	/* simpleCart.bind('ready', function() {
		console.log("simpleCart total: "
				+ simpleCart.toCurrency(simpleCart.total()));
	});
	// log the total when simpleCart has update
	simpleCart.bind('update', function() {
		console.log("Whoa, the cart total is now at "
				+ simpleCart.toCurrency(simpleCart.grandTotal()) + "! Nice!");
	});
	//保存之后触发
	simpleCart.bind('afterSave', function() {
		console.log('simpleCart just saved everything!');
	});
	//保存之前触发
	simpleCart.bind('beforeSave', function() {
		console.log("simpleCart is about to save some stuff!");
	});
	//加载本地cart
	simpleCart.bind('load', function() {
		console.log("simpleCart has loaded " + simpleCart.quantity()
				+ " items from from localStorage");
	}); 
	// simple callback example
	simpleCart.bind('beforeCheckout', function(data) {
		data.invoiceNumber = "ABC-123456789";
	});
	// simple callback example
	simpleCart.bind('beforeRemove', function(item) {
		console.log(item.get('name') + " was removed from the cart");
	});
	// basic callback example
	simpleCart.bind("afterAdd", function(item) {
		console.log(item.get("name") + " was added to the cart!");
	});*/
	// see if a new item has been added
	simpleCart.bind("afterAdd", function(item, isNew) {
		if (isNew) {
			alert("test");
			console.log("A brand new item called " + item.get('name')
					+ " was added to the cart");
		} else {
			console.log("isNew :" + isNew)

		}
	});
</script>
</head>
<body>
	<div class="simpleCart_shelfItem">
		<h2 class="item_name">Awesome T-shirt</h2>
		<select class="item_size">
			<option value="Small">Small</option>
			<option value="Medium">Medium</option>
			<option value="Large">Large</option>
		</select> <input type="text" value="1" class="item_Quantity"> <span
			class="item_price">$35.99</span> <a class="item_add"
			href="javascript:;"> Add to Cart </a>
	</div>
	<div class="simpleCart_shelfItem">
		<input type="hidden" value="23232332" class="item_id" /> <img
			class="item_thumb"
			src="${pageContext.request.contextPath }/public/model/images/pi3.png" />
		<h2 class="item_name">test</h2>
		<select class="item_size">
			<option value="Small">Small</option>
			<option value="Medium">Medium</option>
			<option value="Large">Large</option>
		</select> <input type="text" value="1" class="item_Quantity"> <span
			class="item_price">$20</span> <a class="item_add" href="javascript:;">
			Add to Cart </a>
	</div>
	<div class="simpleCart_shelfItem">
		<h2 class="item_name">test11</h2>
		<select class="item_size">
			<option value="Small">Small</option>
			<option value="Medium">Medium</option>
			<option value="Large">Large</option>
		</select> <input type="text" value="1" class="item_Quantity"> <span
			class="item_price">$10</span> <a class="item_add" href="javascript:;">
			Add to Cart </a>
	</div>
	<!-- create a checkout button -->
	<a href="javascript:;" class="simpleCart_checkout"></a>
	<!-- button to empty the cart -->
	<a href="javascript:;" class="simpleCart_empty"></a>
	<!-- show the cart -->
	<h3>items</h3>
	<!-- <div class="simpleCart_items"></div> -->

	<div class="simpleCart_items"></div>
	<div class="item-quantity"></div>

	<!-- cart total (ex. $23.11)-->
	<h3>cart total</h3>
	<div class="simpleCart_total"></div>
	<!-- cart quantity (ex. 3) -->
	<h3>quantity</h3>
	<div class="simpleCart_quantity"></div>
	<!-- tax cost (ex. $1.38) -->
	<h3>tax cost</h3>
	<div class="simpleCart_tax"></div>
	<!-- tax rate (ex. %0.6) -->
	<h3>tax rate</h3>
	<div class="simpleCart_taxRate"></div>
	<!-- shipping (ex. $5.00) -->
	<h3>shipping</h3>
	<div class="simpleCart_shipping"></div>
	<!-- grand total, including tax and shipping (ex. $28.49) -->
	<h3>grand total</h3>
	<div class="simpleCart_grandTotal"></div>
	<a href="javascript:;" class="simpleCart_checkout">checkout</a>
</body>
</html>