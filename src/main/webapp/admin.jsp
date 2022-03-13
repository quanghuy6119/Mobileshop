<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>admin</title>
<link href="${pageContext.request.contextPath}/CSS/admin.css"
	rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div class="container">
		<div class="dashboard">
			<div class="dashboard-nav dashboard-option">
				<a href="index.jsp" >Trang chủ</a>
			</div>
			<div class="dashboard-nav dashboard-topnav">
				<%
				Model.Account acc = (Model.Account) session.getAttribute("user");
				if (acc != null) {
					out.print("Welcome "+acc.getUser());
				}
				%>
			</div>
			<div class="dashboard-nav dashboard-option">Dashboard</div>
			<div class="dashboard-nav dashboard-option">Staff Manager</div>
			<div class="dashboard-nav dashboard-out">
				<a href="/PRJASM3/Logout" class="">LOG OUT</a>
			</div>
		</div>
		<div class="content">
			<div class="content-img">
				<img
					src="https://anhnendep.net/wp-content/uploads/2015/07/hinh-nen-hoang-hon-dep-full-hd-3.jpg"
					alt="">
			</div>
			<table cellspacing="0">
				<tr>
					<th class="tit" colspan="4">Member of the teams</th>
				</tr>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>Student ID</th>
					<th>Class</th>
				</tr>
				<tr>
					<td>1</td>
					<td>Member 1</td>
					<td>Member code 1</td>
					<td>Class 1</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Member 2</td>
					<td>Member code 2</td>
					<td>Class 2</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>