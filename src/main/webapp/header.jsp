<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Header -->

<div class="header">
            <h1>Phone Store</h1>
            <div><img src="${pageContext.request.contextPath}/MEDIA/logo.png" alt="dead"></div>
        </div>

        <div class="topnav">
            <ul>
                <li class="topnav-list"><a href='/PRJASM3/index.jsp'>Home</a></li>
                <li class="topnav-list"><a href="#">Product</a></li>
                <li class="topnav-list"><a href="#">About us</a></li>
            </ul>

            <div class="topnav-search">
            	<div class="topnav-search-icon search">
                	<form action="/PRJASM3/searchProduct" method="post">
                    	<input type="text" name="search">
                    	<button type="submit"><i class="fas fa-search"></i></button>
                	</form>
                </div>
                
                <div class="topnav-search-icon"><a href="/PRJASM3/register.jsp"><span>Register</span></a></div>
                	
                <div class="topnav-search-icon">                         	
                	<c:choose>
                		<c:when test="${not empty sessionScope.user && not empty sessionScope.admin}">
                			<a href='/PRJASM3/admin.jsp'><i class='fas fa-user'></i> <span> ${sessionScope.user.getUser()} </span></a>
                		</c:when>
                		<c:when test="${not empty sessionScope.user}">
                			<a href='/PRJASM3/list.jsp'><i class='fas fa-user'></i> <span> ${sessionScope.user.getUser()} </span></a>
                		</c:when>
                		<c:otherwise>
                			<a href='/PRJASM3/login.jsp'><i class='fas fa-user'></i> <span>Login</span></a>
                		</c:otherwise>
                	</c:choose>
                </div>
                
            </div>
</div>