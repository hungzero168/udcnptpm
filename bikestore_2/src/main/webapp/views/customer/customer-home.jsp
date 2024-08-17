<%@page import="models.Bike"%>
<%@page import="dao.BikeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Trang chủ xe đạp phố</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/include/css/style.css">
<script
	src="${pageContext.request.contextPath}/views/include/js/script.js"></script>

</head>
<body>
	<%@ include file="cs-header.jsp"%>
	<div class="container">
		<div id="content" class="my-5">
			<div id="products">
				<div class="row mx-0">
					<c:forEach var="category" items="${categories}">
						<div class="col-lg-4 col-md-6 mb-4">
							<a
								href="${pageContext.request.contextPath}/categoryDetail?code=${category.code}"
								class="text-decoration-none text-dark">
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

	<script type="text/javascript">
		$(document).ready(function() {
			$(".main_nav_menu").hide();
			$(".wishlist").hide();
			$(".cart").hide();
		});
	</script>
</body>
</html>
