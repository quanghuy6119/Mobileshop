
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- body  -->
<div class="row">
	<div class="leftcolumn">

		<c:choose>
			<c:when test="${param.page == null}">
				<c:set var="page" value="1"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="page" value="${param.page}"></c:set>
			</c:otherwise>
		</c:choose>


		<c:set var="product" value="${sessionScope.product}"></c:set>
		
		<c:forEach var="i" begin="${(page-1)*6 }"
			end="${product.size()>page*6-1 ? page*6-1 : product.size()-1}"
			step="1">

			<div class="card">
				<div class="fakeimg">
					<a href="inforProduct?id=${product.get(i).id}"><img src="${product.get(i).sourceImg}" alt="dead"></a>
				</div>
				<p class="type">${product.get(i).type}</p>
				<p>${product.get(i).name}</p>
				<h2>$ ${product.get(i).price}</h2>
			</div>
		</c:forEach>

		<div class="pagination">
			<a href="#">←</a>
			<c:forEach var="x" begin="1"
				end="${Math.ceil(product.size()/6)}">
				<c:choose>
					<c:when test="${page == x}">
						<a class="active" href="index.jsp?page=${x}">${x}</a>
					</c:when>
					<c:otherwise>
						<a href="index.jsp?page=${x}">${x}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<a href="#">→</a>
		</div>
	</div>





	<div class="rightcolumn">
		<div class="card">
			<h2>Shoping</h2>
			<div class="fakeimg" style="height: 200px;">
				<img src="${pageContext.request.contextPath}/MEDIA/shoppingcart.jpg"
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