<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv=“Content-Type” content=“text/html;charset=UTF-8”>
<title>Insert title here</title>

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

	<!-- body -->
	<div class="row">
		<table cellspacing="0" border="1" style="width:80%;margin: 30px;border-collapse:collapse;">
			<tr>
				<th>Product in cart: ${sessionScope.cart == null ? 0 : sessionScope.cart.size()}</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Amount</th>
			</tr>
			
			<c:if test="${sessionScope.cart != null}">
				<c:forEach var="item" items="${sessionScope.cart.getItems()}">
					<tr>
						<td>
							<div style="padding: 5px 0;">${item.name}</div>
							<div style="padding: 5px 0;">ID: ${item.id}</div>
						</td>
						<td>($) ${item.price}</td>
						<td> 
							${item.number} 
							<a href="/PRJASM3/addToCart?id=${item.id}&action=add" class="decor">+</a>
							<a href="/PRJASM3/addToCart?id=${item.id}&action=sub" class="decor">-</a>
							<a href="/PRJASM3/addToCart?id=${item.id}&action=delete" class="decor">x</a>
						</td>
						<c:set var="idd" value="${item.id}"></c:set>
						<td>${sessionScope.cart.getAmountById(idd)}</td>
					</tr>
				</c:forEach>
			</c:if>
			
			<tr>
                <th colspan="4" style="text-align: right;">Total :${sessionScope.cart == null ? 0 : sessionScope.cart.getAmount()}</th>
            </tr>
            
		</table>

		<div style="padding: 30px;">
			<div style="padding: 20px">
				<span>Customer name</span> 
				<span style="margin-left: 215px; border: 1px solid black; width: 300px; display: inline-block; text-align: center;">
					${sessionScope.user.name}
				</span>
			</div>
			<div style="padding: 20px">
				<span>Customer address</span> 
				<span style="margin-left: 200px; border: 1px solid black; width: 300px; display: inline-block; text-align: center;">
					${sessionScope.user.addres}
				</span>
			</div>
		</div>
		
		
		<div>
            <form action="/PRJASM3/PayController" method="post" style="padding: 30px 40px 0;">
                <input type="hidden" name="name" value="${sessionScope.user.name}">
                <input type="hidden" name="address" value="${sessionScope.user.addres}">
                <button type="submit" style="width:150px;height: 40px;background-color: rgb(212, 248, 7);">submit</button>
            </form>
        </div>
        
        
        
		<div style="text-align: right;">
            <a href="/PRJASM3/Logout" class="decor" style="width: 100px;height:40px;padding-top: 10px;">LOG OUT</a>
        </div>
	</div>


	<!-- footer -->
	<c:import url="/footer.jsp"></c:import>
	<!-- footer -->
</body>
</html>