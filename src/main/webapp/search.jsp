<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv=“Content-Type” content=“text/html;charset=UTF-8”>
<title>Trang chủ</title>

<!-- fontawesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<!-- css -->
<link href="${pageContext.request.contextPath}/CSS/index.css"
	rel="stylesheet" type="text/css" media="all" />
</head>

<body>

	<!-- header -->
	<c:import url="/header.jsp"></c:import>
	<!-- header -->

	<!-- body  -->
	<div class="row">
		<div class="leftcolumn">

			<c:choose>
				<c:when test="${results.size() == 0 }">
					<div class="card" style="width: 100%">
						<div class="fakeimg">
							<img src="${pageContext.request.contextPath}/MEDIA/notfound.jpg"
								alt="dead">
						</div>
						<p style="text-align: center; width: 100%">HIỆN KHÔNG CÓ SẢN
							PHẨM NÀY</p>
					</div>
				</c:when>

				<c:otherwise>
					<c:forEach var="i" begin="0" end="${results.size()-1}" step="1">

						<div class="card">
							<div class="fakeimg">
								<a href="inforProduct?id=${results.get(i).id}"> <img
									src="${results.get(i).sourceImg}" alt="dead"></a>
							</div>
							<p class="type">${results.get(i).type}</p>
							<p>${results.get(i).name}</p>
							<h2>$ ${results.get(i).price}</h2>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>


			<div class="pagination">
				<a class="active" href="search.jsp?page=1">1</a>
			</div>
		</div>





		<div class="rightcolumn">
			<div class="card">
				<h2>Shoping</h2>
				<div class="fakeimg" style="height: 200px;">
					<img
						src="${pageContext.request.contextPath}/MEDIA/shoppingcart.jpg"
						alt="dead">
				</div>
				<p>Cần đăng nhập</p>
			</div>

			<div class="card">
				<h3>Popular product</h3>
				<div class="fakeimg" style="height: 235px;">
					<img src="${pageContext.request.contextPath}/MEDIA/ip12.jpg "
						alt="dead ">
				</div>
				<div class="fakeimg" style="height: 250px;">
					<img src="${pageContext.request.contextPath}/MEDIA/ss51.png "
						alt="dead ">
				</div>
				<!-- 			<div class="fakeimg" style="height: 250px;"> -->
				<%-- 				<img src="${pageContext.request.contextPath}/MEDIA/opporeno6.jpg " --%>
				<!-- 					alt="dead "> -->
				<!-- 			</div> -->
			</div>
		</div>
	</div>

	<!-- footer -->
	<c:import url="/footer.jsp"></c:import>
	<!-- footer -->


</body>
</html>