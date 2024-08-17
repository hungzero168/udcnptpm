<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ XeDapPho</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/include/css/style.css">
<script
	src="${pageContext.request.contextPath}/views/include/js/script.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
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
									<a href="${pageContext.request.contextPath}/login">Đăng
										nhập</a>
								</div>
								<div>
									<a href="#">Đăng ký</a>
								</div>
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

				</div>
			</div>
		</div>
		
		
		
		
		</header>
		<div class="container">
		<div id="content" class="my-5">
			<div id="products">
				<div class="row mx-0">
					<c:forEach var="category" items="${categories}">
						<div class="col-lg-4 col-md-6 mb-4">
							<a href="${pageContext.request.contextPath}/categoryDetail?code=${category.code}" class="text-decoration-none text-dark">

								<div class="card d-flex flex-column align-items-center">
									<div class="card-img">
										<c:set var="bike"
											value="${demo.getBikeByCategoryCode(category.code)}"
											scope="page" />
										<img src="<c:out value="${bike.imagelink}"></c:out>"
											class="img-fluid">

									</div>
									<div class="card-body text-center">
										<h5 class="card-title">${category.name}</h5>
										<p class="card-text font-weight-bold text-primary">${category.price}
											VNĐ</p>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	
	
</body>
</html>
