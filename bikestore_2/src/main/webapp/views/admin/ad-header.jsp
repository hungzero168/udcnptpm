<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
								<div>
									<a href="${pageContext.request.contextPath}/login">${sessionScope.user.fullname}</a>
								</div>
								<div>
									<a href="#">Đăng xuất</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Main Navigation -->

		<nav class="main_nav">
			<div class="container">
				<div class="row">
					<div class="col">

						<div class="main_nav_content d-flex flex-row">

							<!-- Categories Menu -->



							<!-- Main Nav Menu -->

							<div class="main_nav_menu">
								<ul class="standard_dropdown main_nav_dropdown">
									<li><a href="danhsachdonhang">Quản lý đơn hàng<i class="fas fa-chevron-down"></i></a></li>
								
									<li><a href="blog.html">Quản lý danh mục<i
											class="fas fa-chevron-down"></i></a></li>
									<li><a href="contact.html">Quản lý kho<i
											class="fas fa-chevron-down"></i></a></li>
									<li><a href="contact.html">Phân quyền tài khoản<i
											class="fas fa-chevron-down"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</nav>

		<!-- Menu -->
	</header>