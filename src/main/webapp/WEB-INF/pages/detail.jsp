<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>详情</title>
<%@ include file="/public/chead.jspf"%>
</head>
<body>
	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="col-sm-4 world">
					<ul>
						<li>中国</li>
					</ul>
				</div>
				<div class="col-sm-4 logo">
					<a href="${pageContext.request.contextPath }/index.jsp"><img
						src="${pageContext.request.contextPath }/public/model/images/logo.png"
						alt=""></a>
				</div>

				<div class="col-sm-4 header-left">
					<c:if test="${empty customer }">
						<p class="log">
							<a href="${pageContext.request.contextPath }/login.jsp">登录</a> <span>or</span><a
								href="account.html">注册</a>
						</p>
					</c:if>
					<c:if test="${not empty customer }">
						<p class="log">
							<a href="javascript:void(0)">${customer.c_name }</a>
						</p>
					</c:if>
					<div class="cart box_1">
						<a href="${pageContext.request.contextPath }/cart/showCart">
							<h3>
								<img
									src="${pageContext.request.contextPath }/public/model/images/cart.png"
									alt="" />
							</h3>
						</a>
						<p>
							<a href="${pageContext.request.contextPath }/cart/showCart">我的购物车</a>
						</p>

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>272489473</span>
				</div>
				<div class="col-sm-8 h_menu4">
					<ul class="memenu skyblue">
						<li class=" grid"><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
						<li><a href="#">所有类别</a>
							<div class="mepanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<h4>All Clothing</h4>
											<ul>
												<c:forEach items="${cateList }" var="item">

													<li><a href="products.html">${item.c_type }</a></li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
							</div></li>
						<li class="grid"><a href="#"> 热卖</a>
							<div class="mepanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<h4>All Clothing</h4>
											<ul>

											</ul>
										</div>
									</div>
								</div>
							</div></li>
						<li><a href="typo.html">Blog</a></li>
						<li><a class="color6" href="contact.html">Conact</a></li>
					</ul>
				</div>
				<div class="col-sm-2 search">
					<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i
						class="glyphicon glyphicon-search"> </i> </a>
				</div>
				<div class="clearfix"></div>
				<div id="small-dialog" class="mfp-hide">
					<div class="search-top">
						<div class="login">
							<input type="submit" value=""> <input type="text"
								value="Type something..." onFocus="this.value = '';"
								onBlur="if (this.value == '') {this.value = '';}">
						</div>
						<p>Shopping</p>
					</div>
				</div>
				<!---->
			</div>
		</div>
	</div>
	<div class="single">

		<div class="container">
			<div class="col-md-9">
				<div class="col-md-5 grid">
					<div class="flexslider">
						<ul class="slides">
							<li
								data-thumb="${pageContext.request.contextPath }/public/model/images/si.jpg">
								<div class="thumb-image">
									<img
										src="${pageContext.request.contextPath }/public/model/images/si.jpg"
										data-imagezoom="true" class="img-responsive">
								</div>
							</li>
							<li
								data-thumb="${pageContext.request.contextPath }/public/model/images/si1.jpg">
								<div class="thumb-image">
									<img
										src="${pageContext.request.contextPath }/public/model/images/si1.jpg"
										data-imagezoom="true" class="img-responsive">
								</div>
							</li>
							<li
								data-thumb="${pageContext.request.contextPath }/public/model/images/si2.jpg">
								<div class="thumb-image">
									<img
										src="${pageContext.request.contextPath }/public/model/images/si2.jpg"
										data-imagezoom="true" class="img-responsive">
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-md-7 single-top-in">
					<div class="single-para simpleCart_shelfItem">
						<h1>${product.p_name }</h1>
						<p>${product.p_remark }</p>
						<div class="star-on">
							<ul>
								<li><a href="#"><i class="glyphicon glyphicon-star">
									</i></a></li>
								<li><a href="#"><i class="glyphicon glyphicon-star">
									</i></a></li>
								<li><a href="#"><i class="glyphicon glyphicon-star">
									</i></a></li>
								<li><a href="#"><i class="glyphicon glyphicon-star">
									</i></a></li>
								<li><a href="#"><i class="glyphicon glyphicon-star">
									</i></a></li>
							</ul>
							<div class="review">
								<a href="#"> 3 人看过 </a>
							</div>
							<div class="clearfix"></div>
						</div>

						<label class="add-to item_price">${product.p_price }</label>

						<div class="available">
							<h6>选择 :</h6>
							<ul>

								<li>Size:<select>
										<option>Large</option>
										<option>Medium</option>
										<option>small</option>
										<option>Large</option>
										<option>small</option>
								</select></li>
							</ul>
						</div>
						<a
							href="${pageContext.request.contextPath }/cart/addToCart/${product.p_id}"
							class="cart item_add">加入购物车</a>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="content-top1">
					<div class="col-md-4 col-md3">
						<div class="col-md1 simpleCart_shelfItem">
							<a href="single.html"> <img class="img-responsive"
								src="${pageContext.request.contextPath }/public/model/images/pi6.png"
								alt="" />
							</a>
							<h3>
								<a href="single.html">Jeans</a>
							</h3>
							<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-md3">
						<div class="col-md1 simpleCart_shelfItem">
							<a href="single.html"> <img class="img-responsive"
								src="${pageContext.request.contextPath }/public/model/images/pi7.png"
								alt="" />
							</a>
							<h3>
								<a href="single.html">Tops</a>
							</h3>
							<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"></div>
							</div>

						</div>
					</div>
					<div class="col-md-4 col-md3">
						<div class="col-md1 simpleCart_shelfItem">
							<a href="single.html"> <img class="img-responsive"
								src="${pageContext.request.contextPath }/public/model/images/pi.png"
								alt="" />
							</a>
							<h3>
								<a href="single.html">Tops</a>
							</h3>
							<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"></div>
							</div>

						</div>
					</div>

					<div class="clearfix"></div>
				</div>
			</div>
			<!----->
			<div class="col-md-3 product-bottom">
				<!--categories-->
				<div class=" rsidebar span_1_of_left">
					<h3 class="cate">Categories</h3>
					<ul class="menu-drop">
						<li class="item1"><a href="#">Men </a>
							<ul class="cute">
								<li class="subitem1"><a href="single.html">Cute Kittens
								</a></li>
								<li class="subitem2"><a href="single.html">Strange
										Stuff </a></li>
								<li class="subitem3"><a href="single.html">Automatic
										Fails </a></li>
							</ul></li>
						<li class="item2"><a href="#">Women </a>
							<ul class="cute">
								<li class="subitem1"><a href="single.html">Cute Kittens
								</a></li>
								<li class="subitem2"><a href="single.html">Strange
										Stuff </a></li>
								<li class="subitem3"><a href="single.html">Automatic
										Fails </a></li>
							</ul></li>
						<li class="item3"><a href="#">Kids</a>
							<ul class="cute">
								<li class="subitem1"><a href="single.html">Cute Kittens
								</a></li>
								<li class="subitem2"><a href="single.html">Strange
										Stuff </a></li>
								<li class="subitem3"><a href="single.html">Automatic
										Fails</a></li>
							</ul></li>
						<li class="item4"><a href="#">Accesories</a>
							<ul class="cute">
								<li class="subitem1"><a href="single.html">Cute Kittens
								</a></li>
								<li class="subitem2"><a href="single.html">Strange
										Stuff </a></li>
								<li class="subitem3"><a href="single.html">Automatic
										Fails</a></li>
							</ul></li>

						<li class="item4"><a href="#">Shoes</a>
							<ul class="cute">
								<li class="subitem1"><a href="single.html">Cute Kittens
								</a></li>
								<li class="subitem2"><a href="single.html">Strange
										Stuff </a></li>
								<li class="subitem3"><a href="single.html">Automatic
										Fails </a></li>
							</ul></li>
					</ul>
				</div>
				<!--initiate accordion-->
				<script type="text/javascript">
					$(function() {
						var menu_ul = $('.menu-drop > li > ul'), menu_a = $('.menu-drop > li > a');
						menu_ul.hide();
						menu_a.click(function(e) {
							e.preventDefault();
							if (!$(this).hasClass('active')) {
								menu_a.removeClass('active');
								menu_ul.filter(':visible').slideUp('normal');
								$(this).addClass('active').next().stop(true,
										true).slideDown('normal');
							} else {
								$(this).removeClass('active');
								$(this).next().stop(true, true).slideUp(
										'normal');
							}
						});

					});
				</script>
				<!--//menu-->
				<!--seller-->
				<div class="product-bottom">
					<h3 class="cate">Best Sellers</h3>
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="single.html"><img class="img-responsive "
								src="${pageContext.request.contextPath }/public/model/images/pr.jpg"
								alt=""></a>
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2">
								<a href="single.html">Lorem ipsum dolor sitamet consectetuer
								</a>
							</h6>
							<span class=" price-in1"> $40.00</span>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="single.html"><img class="img-responsive "
								src="${pageContext.request.contextPath }/public/model/images/pr1.jpg"
								alt=""></a>
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2">
								<a href="single.html">Lorem ipsum dolor sitamet consectetuer
								</a>
							</h6>
							<span class=" price-in1"> $40.00</span>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="single.html"><img class="img-responsive "
								src="${pageContext.request.contextPath }/public/model/images/pr2.jpg"
								alt=""></a>
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2">
								<a href="single.html">Lorem ipsum dolor sitamet consectetuer
								</a>
							</h6>
							<span class=" price-in1"> $40.00</span>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="single.html"><img class="img-responsive "
								src="${pageContext.request.contextPath }/public/model/images/pr3.jpg"
								alt=""></a>
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2">
								<a href="single.html">Lorem ipsum dolor sitamet consectetuer
								</a>
							</h6>
							<span class=" price-in1"> $40.00</span>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>

				<!--//seller-->
				<!--tag-->
				<div class="tag">
					<h3 class="cate">Tags</h3>
					<div class="tags">
						<ul>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-top">
				<div class="col-md-4 top-footer1">
					<h2>Newsletter</h2>
					<form>
						<input type="text" value="" onFocus="this.value='';"
							onBlur="if (this.value == '') {this.value ='';}"> <input
							type="submit" value="SUBSCRIBE">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="col-sm-3 footer-bottom-cate">
					<h6>Categories</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>

					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate">
					<h6>Feature Projects</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>

					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate">
					<h6>Top Brands</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>

					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate cate-bottom">
					<h6>Our Address</h6>
					<ul>
						<li>Aliquam metus dui.</li>
						<li>orci, ornareidquet</li>
						<li>ut,DUI.</li>
						<li>nisi, dignissim</li>
						<li>gravida at.</li>
						<li class="phone">PH : 6985792466</li>
					</ul>
				</div>
				<div class="clearfix"></div>
				<p class="footer-class">
					Copyright &copy; 2015.Company name All rights reserved.<a
						target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
				</p>
			</div>
		</div>
	</div>
	<!--//footer-->
	<!-- slide -->
	<script
		src="${pageContext.request.contextPath }/public/model/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/public/model/js/imagezoom.js"></script>
	<!-- start menu -->
	<link
		href="${pageContext.request.contextPath }/public/model/css/memenu.css"
		rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/public/model/js/memenu.js"></script>
	<script>
		$(document).ready(function() {
			$(".memenu").memenu();
		});
	</script>
	<script
		src="${pageContext.request.contextPath }/public/model/js/simpleCart.min.js">
		
	</script>
	<!--initiate accordion-->
	<script type="text/javascript">
		$(function() {
			var menu_ul = $('.menu-drop > li > ul'), menu_a = $('.menu-drop > li > a');
			menu_ul.hide();
			menu_a.click(function(e) {
				e.preventDefault();
				if (!$(this).hasClass('active')) {
					menu_a.removeClass('active');
					menu_ul.filter(':visible').slideUp('normal');
					$(this).addClass('active').next().stop(true, true)
							.slideDown('normal');
				} else {
					$(this).removeClass('active');
					$(this).next().stop(true, true).slideUp('normal');
				}
			});

		});
	</script>
	<!-- FlexSlider -->
	<script defer
		src="${pageContext.request.contextPath }/public/model/js/jquery.flexslider.js"></script>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath }/public/model/css/flexslider.css"
		type="text/css" media="screen" />

	<script>
		// Can also be used with $(document).ready()
		$(window).load(function() {
			$('.flexslider').flexslider({
				animation : "slide",
				controlNav : "thumbnails"
			});
		});
	</script>
	<!---pop-up-box---->
	<link
		href="${pageContext.request.contextPath }/public/model/css/popuo-box.css"
		rel="stylesheet" type="text/css" media="all" />
	<script
		src="${pageContext.request.contextPath }/public/model/js/jquery.magnific-popup.js"
		type="text/javascript"></script>
	<!---//pop-up-box---->
	<script>
		
	</script>
</body>
</html>