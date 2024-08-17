<%@page import="models.OrderDetail"%>
<%@page import="dao.BikeDAO"%>
<%@page import="models.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
// Check if the user is not logged in
if (session.getAttribute("user") == null) {

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Giỏ hàng</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/include/css/style.css">
<script
	src="${pageContext.request.contextPath}/views/include/js/script.js"></script>
<style type="text/css">
@media ( min-width : 1025px) {
	.h-custom {
		height: 100vh !important;
	}
}
</style>
</head>
<body>

	<%@ include file="cs-header.jsp"%>

	<section class="h-100 gradient-custom">
		<div class="container py-5">
			<div class="row d-flex justify-content-center my-4">
				<div class="col-md-11">
					<div class="card mb-4">
						<div class="card-body">

							<!-- Single item -->

							<c:forEach items="${orderDetails}" var="orderdetail">
								<%
								BikeDAO demo = new BikeDAO();
								OrderDetail odtail = (OrderDetail) pageContext.getAttribute("orderdetail");
								Bike bike = demo.getBikeByCode(odtail.getBikecode());
								String color = bike.getColor();
								String img = bike.getImagelink();
								%>
								<div class="row">
									<div class="col-lg-3 col-md-12 mb-4 mb-lg-0">
										<!-- Image -->
										<div class="bg-image hover-overlay hover-zoom ripple rounded"
											data-mdb-ripple-color="light">
											<img src="<%=img%>" class="w-100" alt="Blue Jeans Jacket" />
											<a href="#!">
												<div class="mask"
													style="background-color: rgba(251, 251, 251, 0.2)"></div>
											</a>
										</div>
										<!-- Image -->
									</div>

									<div class="col-lg-5 col-md-6 mb-4 mb-lg-0">
										<!-- Data -->
										<p>
											<strong>${orderdetail.bikecode}</strong>
										</p>

										<p>
											Color:<%=color%></p>

										<!-- Data -->
									</div>

									<div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
										<!-- Quantity -->


										<div data-mdb-input-init class="form-outline">
											<input id="form1" min="0" name="quantity"
												value="${orderdetail.amount }" type="number"
												class="form-control" disabled /> <label class="form-label"
												for="form1">Số lượng</label>
										</div>

									</div>
									<!-- Quantity -->

								</div>
							</c:forEach>





							<hr class="my-4" />



							<div class="col-md-5">
								<div class="card mb-4">
									<div class="card-header py-3">
										<h5 class="mb-0">Tổng tiền</h5>
									</div>
									<div class="card-body">
										<ul class="list-group list-group-flush">

											<li
												class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
												<c:if test="${not empty tong}">
													<span><strong>${tong}</strong></span>
												</c:if>
											</li>
										</ul>
										<c:if test="${not empty ordercode}">

											<a href="dathang?ordercode=${ordercode }"> Đặt hàng </a>
										</c:if>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
	</section>

	<script type="text/javascript">
		
	</script>


</body>
</html>