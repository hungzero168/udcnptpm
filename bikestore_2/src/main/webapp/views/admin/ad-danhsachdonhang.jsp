<%@page import="dao.UserDAO"%>
<%@page import="models.User"%>
<%@page import="models.Order"%>
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
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/include/css/style.css">
<script
	src="${pageContext.request.contextPath}/views/include/js/script.js"></script>
</head>
<body>
	<%@ include file="ad-header.jsp"%>
	<h1>Danh sách đơn hàng</h1>
	<table>

		<tr>
			<th>Mã đơn</th>
			<th>Tên khách hàng</th>
			<th>Trạng thái</th>
			<th>Hành động</th>
		</tr>
		<c:forEach items="${orderList}" var="order">
			<tr>
			<% Order order=(Order) pageContext.getAttribute("order");
			int trangthai=Integer.parseInt(order.getState());
			String tt="";
			if(trangthai==2){
				tt="Chưa xác nhận".toString();
			}
			if(trangthai==3){
				tt="Đã xác nhận".toString();
			}
			if(trangthai==0){
				tt="Đã bị hủy".toString();
			}
			UserDAO userDAO=new UserDAO();
			User khachhang=userDAO.findUSerByUserName(order.getUsername());
			%>
				<td>${order.code}</td>
				<td><%= khachhang.getFullname()%></td>
				<td><%= tt %></td>
				<td><a href="" >Xác nhận</a></td>
				<td><a href="" >Hủy</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>