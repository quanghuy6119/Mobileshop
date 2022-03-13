<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv=“Content-Type” content=“text/html;charset=UTF-8”>
<title>Product</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/CSS/index.css"
	rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<!-- header -->
	<c:import url="/header.jsp"></c:import>
	<!-- header -->

	<div class="row" style="background-color: white">
		<div
			style="border-bottom: solid 1px black; font-size: 30px; padding: 30px; color: red;">${product.name}</div>
		<div class="card">
			<div class="fakeimg">
				<img src="${product.sourceImg}" alt="dead">
			</div>
		</div>

		<div
			style="position: relative; top: -250px; left: 100px; display: inline-block; background-color: white; width: 300px; height: 400px; padding: 30px">
			<h1 style="font-size: 50px; color: red">$${product.price}</h1>
			<h3 style="font-size: 30px; color: gray;text-transform: uppercase; ">${product.type}</h3>
			<div style="font-size: 20px">${product.description}</div>
			<div>
				<form style="padding: 30px 0" action="/PRJASM3/addToCart" method="post">
					<input type="hidden" name="id" value="${product.id}">
					<input type="hidden" name="action" value="add">
					<button style="width: 100%;height: 50px;border-radius: 20px;background-color: red;
						cursor: pointer;color:white;font-size: 25px">ADD TO CART</button>
				</form>
			</div>
		</div>
	</div>

	<!-- footer -->
	<c:import url="/footer.jsp"></c:import>
	<!-- footer -->
</body>
</html>