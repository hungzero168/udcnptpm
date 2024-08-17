<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<header class="header">
	<!-- Top Bar -->

	<div class="top_bar">
		<div class="container">
			<div class="row">
				<div class="col d-flex flex-row">
					<div class="top_bar_content ml-auto">
						<div class="top_bar_user">
							<div class="user_icon">
								<img
									src="https://res.cloudinary.com/dxfq3iotg/image/upload/v1560918647/user.svg"
									alt="">
							</div>

							<div >
								<% if (session.getAttribute("user") == null) { %>
                                    <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                                <% } else { %>
                                	<a href="${pageContext.request.contextPath}/login">${sessionScope.user.fullname}</a>
                                    <%-- <a href="#"><%= session.getAttribute("user") %></a> --%>
                                    <form action="${pageContext.request.contextPath}/logout" method="post" style="display: inline;">
                                        <button type="submit" name="Logout" class="btn btn-link" style="padding: 0; margin-left: 10px;">Đăng xuất</button>
                                    </form>
                                <% } %>
							</div>
							<div >
								<% if (session.getAttribute("user") == null) { %>
                                    <a href="#">Đăng ký</a>
                                <% }%>
							</div>

							<div>
								<%-- <a href="${pageContext.request.contextPath}/login">${sessionScope.user.fullname}</a> --%>
							</div>
							<%-- <div>
								<form action="${pageContext.request.contextPath}/logout"
									method="post" style="display: inline;">
									<button type="submit" name="Logout" class="btn btn-link"
										style="padding: 0; margin-left: 10px;">Đăng xuất</button>
								</form>
								
							</div> --%>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="header_main">
		<div class="container">
			<div class="row">

				<!-- Logo -->
				<div class="col-lg-2 col-sm-3 col-3 order-1">
					<div class="logo_container">
						<div class="logo">
							<a href="${pageContext.request.contextPath}">XEDAPPHO</a>
						</div>
					</div>
				</div>

				<!-- Search -->
				<div
					class="col-lg-6 col-12 order-lg-2 order-3 text-lg-left text-right">
					<div class="header_search">
						<div class="header_search_content">
							<div class="header_search_form_container">
								<form action="#" class="header_search_form clearfix">
									<input type="search" required="required"
										class="header_search_input"
										placeholder="Search for products...">
									<div class="custom_dropdown" style="display: none;">
										<div class="custom_dropdown_list">
											<span class="custom_dropdown_placeholder clc">All
												Categories</span> <i class="fas fa-chevron-down"></i>
											<ul class="custom_list clc">
												<li><a class="clc" href="#">All Categories</a></li>
												<li><a class="clc" href="#">Computers</a></li>
												<li><a class="clc" href="#">Laptops</a></li>
												<li><a class="clc" href="#">Cameras</a></li>
												<li><a class="clc" href="#">Hardware</a></li>
												<li><a class="clc" href="#">Smartphones</a></li>
											</ul>
										</div>
									</div>
									<button type="submit" class="header_search_button trans_300"
										value="Submit">
										<img
											src="https://res.cloudinary.com/dxfq3iotg/image/upload/v1560918770/search.png"
											alt="">
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>

				<!-- Wishlist -->
				<div
					class="col-lg-4 col-9 order-lg-3 order-2 text-lg-left text-right">
					<div
						class="wishlist_cart d-flex flex-row align-items-center justify-content-end">
						<div
							class="wishlist d-flex flex-row align-items-center justify-content-end">
							<div class="wishlist_icon">
								<img
									src="https://res.cloudinary.com/dxfq3iotg/image/upload/v1560918681/heart.png"
									alt="">
							</div>
							<div class="wishlist_content">
								<div class="wishlist_text">
									<a href="#">Đơn hàng</a>
								</div>
							</div>
						</div>

						<!-- Cart -->
						<div class="cart">
							<div
								class="cart_container d-flex flex-row align-items-center justify-content-end">
								<div class="cart_icon">
									<img
										src="https://res.cloudinary.com/dxfq3iotg/image/upload/v1560918704/cart.png"
										alt="">
								</div>
								<div class="cart_content">
									<div class="cart_text">
										<a href="${pageContext.request.contextPath}/giohang">Giỏ
											hàng</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>