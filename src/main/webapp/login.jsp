<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link href='https://fonts.googleapis.com/css?family=Montserrat'rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath}/CSS/login.css"rel="stylesheet" type="text/css" media="all" />
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/Script/login.js"></script>	
</head>
<body>
	<div class="login">
		<h2 class="active">sign in</h2>
		<form action="/PRJASM3/Login" method="POST">

			<span>username</span> <input type="text" class="text" name="username" required 
									<% if(request.getCookies() != null){ 
 										  Cookie[] cookies = request.getCookies();
 											for(Cookie cookie : cookies){
												if(cookie.getName().equals("rememberID")){
 													String value = cookie.getValue();
												out.print("value='"+ value + "'");
 												}
 											}
 										}
									%> 
								   >

			<br> <br> 
			<span>password</span> <input type="password" class="text" name="password" required
										<% if(request.getCookies() != null){
											Cookie[] cookies = request.getCookies();
										   		for(Cookie cookie : cookies){
													if(cookie.getName().equals("rememberPass")){
														String value = cookie.getValue();
														out.print("value='"+ value + "' ");
													}
												}
											}
										%>
								  > 
								  
<!-- 		    the thong bao loi -->
			<% 
			String error = (String) session.getAttribute("error");
			if(error != null){
				out.println("<span class='fail'>" +error + "</span>");
			};
			%>
<!-- 		    the thong bao loi -->

			<br> 
			<input type="checkbox" id="checkbox-1-1" class="custom-checkbox" name="remember" value="remember"/> 
			<label for="checkbox-1-1">Remember Me</label>
			<button class="signin" type="submit" value="submit">Sign In</button>
			<hr>
			<a href="#">Forgot Password?</a> 
			<a href="/PRJASM3/index.jsp" class="cancel">Cancel</a>
		</form>
	</div>
</body>
</html>