<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv=“Content-Type” content=“text/html;charset=UTF-8”>
<title>Trang chủ</title>

<!-- fontawesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<!-- css -->
<link href="${pageContext.request.contextPath}/CSS/index.css" rel="stylesheet" type="text/css" media="all" /> 
</head>

<body>

	<!-- header -->
	<c:import url="/header.jsp"></c:import>
	<!-- header -->

	<!-- body -->
	<c:import url="/body.jsp">
	</c:import>
	<!-- body -->

	<!-- footer -->
	<c:import url="/footer.jsp"></c:import>
	<!-- footer -->


</body>
</html>