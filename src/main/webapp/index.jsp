<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>主页</title>
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
	<!--banner-->
	<div class="banner">
		<div class="col-sm-3 banner-mat">
			<img class="img-responsive"
				src="${pageContext.request.contextPath }/public/model/images/ba1.jpg"
				alt="">
		</div>
		<div class="col-sm-6 matter-banner">
			<div class="slider">
				<div class="callbacks_container">
					<ul class="rslides" id="slider">
						<li><img
							src="${pageContext.request.contextPath }/public/model/images/1.jpg"
							alt=""></li>
						<li><img
							src="${pageContext.request.contextPath }/public/model/images/2.jpg"
							alt=""></li>
						<li><img
							src="${pageContext.request.contextPath }/public/model/images/1.jpg"
							alt=""></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-sm-3 banner-mat">
			<img class="img-responsive"
				src="${pageContext.request.contextPath }/public/model/images/ba.jpg"
				alt="">
		</div>
		<div class="clearfix"></div>
	</div>
	<!--//banner-->

	<!--content-->
	<div class="content">
		<div class="container">
			<div class="content-top">
				<h1>新品</h1>
				<div class="content-top1">
					<c:forEach items="${recentProducts }" var="recentproduct">
						<div class="col-md-3 col-md2">
							<div class="col-md1 simpleCart_shelfItem">
								<a
									href="${pageContext.request.contextPath }/product/get/${recentproduct.p_id}">
									<img class="img-responsive"
									src="${pageContext.request.contextPath }/public/model/images/pi.png"
									alt="" />
								</a>
								<h3>
									<a
										href="${pageContext.request.contextPath }/product/get/${recentproduct.p_id}">${recentproduct.p_name }</a>
								</h3>
								<div class="price">
									<h5 class="item_price">¥${recentproduct.p_price }</h5>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--//content-->
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
</body>
</html>