<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv=“Content-Type” content=“text/html;charset=UTF-8”>
<title>Register</title>
<link href="${pageContext.request.contextPath}/CSS/register.css" rel="stylesheet" type="text/css" media="all" /> 
</head>

<body>
<form action="/PRJASM3/RegisterController" method="post">
        <div class="container">
            <h1>Form Đăng Ký</h1>
            <p>Xin hãy nhập biểu mẫu bên dưới để đăng ký.</p>
            
			<c:if test="${error != null }">
				<div class="fail">${error}</div>
			</c:if>
			
            <hr>
            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Nhập Email" name="email" required>

            <label for="userName"><b>Name</b></label>
            <input type="text" placeholder="Nhập User" name="userName" required>

            <label for="psw"><b>Mật Khẩu</b></label>
            <input type="password" placeholder="Nhập Mật Khẩu" name="psw" required>

            <label for="psw-repeat"><b>Nhập Lại Mật Khẩu</b></label>
            <input type="password" placeholder="Nhập Lại Mật Khẩu" name="psw-repeat" required>

            <label for="adress"><b>Adress</b></label>
            <input type="text" placeholder="Nhập adress" name="adress" required>

            <label for="phone"><b>Phone</b></label>
            <input type="text" placeholder="Nhập Phone" name="phone" required>

            <div class="clearfix">
                <button type="submit" class="signupbtn">Sign Up</button>
            </div>
        </div>
    </form>
    <div class="clearfix">
        <button  class="cancelbtn"><a href='/PRJASM3/index.jsp' class="cancel">Cancel</a></button>
    </div>
</body>
</html>