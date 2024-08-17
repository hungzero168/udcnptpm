<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chi tiết sản phẩm</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/include/css/style.css">
<script
	src="${pageContext.request.contextPath}/views/include/js/script.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
.product-detail .wrapper {
	display: flex;
	margin-top: 20px;
}

.product-detail .preview-pic img {
	width: 100%;
	max-height: 400px;
	object-fit: cover;
}

.product-detail .preview-thumbnail img {
	max-width: 100px;
	max-height: 100px;
	cursor: pointer;
}

.product-detail .details {
	padding: 20px;
}

.product-detail .stars {
	color: #f0ad4e;
}

.product-detail .price span {
	color: #28a745;
	font-size: 1.5rem;
	font-weight: bold;
}

.product-detail .action {
	margin-top: 20px;
}

.product-detail .action .btn {
	margin-right: 10px;
}
</style>
</head>
<body>
	<%-- <%@ include file="/views/include/header.jsp"%> --%>

	<%@ include file="cs-header.jsp"%>
	<!-- Error and Success Messages -->
	<%
	String errorMessage = (String) session.getAttribute("errorMessageCart");
	if (errorMessage != null) {
	%>
	<div class="alert alert-danger">
		<%=errorMessage%>
	</div>
	<%
	session.removeAttribute("errorMessageCart"); // Remove the message after displaying
	}

	String sucssMessageCart = (String) session.getAttribute("sucssMessageCart");
	if (sucssMessageCart != null) {
	%>
	<div class="alert alert-success">
		<%=sucssMessageCart%>
	</div>
	<%
	session.removeAttribute("sucssMessageCart"); // Remove the message after displaying
	}
	%>


	<main role="main">
		<div class="container mt-4">
			<div id="thongbao" class="alert alert-danger d-none face"
				role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>

			<div class="card product-detail">
				<div class="container-fluid">
					<form method="post"
						action="${pageContext.request.contextPath}/themvaogiohang">
						<div class="wrapper row">
							<div class="preview col-md-6">
								<div class="preview-pic tab-content">
									<c:forEach items="${DSBike}" var="bike">
										<div class="tab-pane active" id="pic-1">
											<img src="${bike.imagelink }" alt="Product Image">
										</div>
									</c:forEach>
								</div>
								<ul class="preview-thumbnail nav nav-tabs">
									<c:forEach items="${DSBike}" var="bike">
										<li class="active"><a data-target="#pic-1"
											data-toggle="tab"> <img src="${bike.imagelink }"
												alt="Thumbnail">
										</a></li>
									</c:forEach>
								</ul>
							</div>
							<div class="details col-md-6">
								<h3 class="product-title">${category.name}</h3>
								<h4 class="price">
									Giá: <span>${category.price} vnđ</span>
								</h4>
								<p class="vote">
									<strong>100%</strong> hàng <strong>Chất lượng</strong>, đảm bảo
									<strong>Uy tín</strong>!
								</p>
								<h5 class="sizes">
									Màu :<br />
									<c:forEach var="bike" items="${DSBike}">
										<label> <input class="product-select" type="radio"
											name="bikeColor" value="${bike.color}"
											data-bikecode="${bike.bikecode}"
											onchange="updateBikeCode(this)"
											data-bikeamount="${bike.amount }"> ${bike.color}
										</label>
										<br />
									</c:forEach>
								</h5>

								<div class="form-group">
									<label for="soluong">Số lượng đặt mua:</label> <input
										type="number" class="form-control" id="soluong" name="soluong"
										min="1" value="1" onchange="updateQuantity(this)">

								</div>
								<div class="action">
									<button type="submit" class="add-to-cart btn btn-success"
										id="btnThemVaoGioHang"
										<%if (session.getAttribute("user") == null) {%> disabled <%}%>>Thêm
										vào giỏ hàng</button>
								</div>
								<%
								if (session.getAttribute("user") == null) {
									%>
									<p>Vui lòng đăng nhập để thêm sản phẩm vảo giỏ hàng.</p>
									<%
								}
								%>
							</div>
						</div>

						<!-- Hidden input fields -->
						<input type="hidden" name="bikeCode" id="bikeCode"> <input
							type="hidden" name="sp_soluong" id="sp_soluong" value="1">
						<input type="hidden" name="categorycode" id="categorycode"
							value="${category.code}">


					</form>
				</div>
			</div>
		</div>
	</main>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		var amount;
		function updateBikeCode(radio) {
			var bikeCode = radio.getAttribute("data-bikecode");
			document.getElementById("bikeCode").value = bikeCode;
			amount = radio.getAttribute("data-bikeamount");

		}
		function updateQuantity(input) {
			var quantity = input.value;
			console.log("Số lượng cập nhật:", quantity);
			document.getElementById("sp_soluong").value = quantity;

			const so1 = parseInt(quantity, 10);
			const so2 = parseInt(amount, 10);

			if (so1 > so2) {
				alert("Số lượng trong kho không đủ")
				document.getElementById("btnThemVaoGioHang").disabled = true;

			} else {
				document.getElementById("btnThemVaoGioHang").disabled = false;
			}

		}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".main_nav_menu").hide();
			$(".wishlist").hide();

		});
	</script>
</body>
</html>
