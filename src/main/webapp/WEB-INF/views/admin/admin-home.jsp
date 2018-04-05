<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Home</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
    <h1>Hello, Admin! what will you do?</h1>
    <form action="admin/create-test">
        <button class="admin-button">Create test</button>
    </form>
    <form action="admin/create-user">
        <button class="admin-button">Create user</button>
    </form>
    <form action="admin/statistics">
        <button class="admin-button">Statistics</button>
    </form>
   <form action="/logout" method="POST">
        <button class="admin-button">logout</button>
    </form>

<%--    <div class="container">

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="/logout">
                <button class="admin-button">logout</button>
            </form>

            <h5>Welcome ${pageContext.request.userPrincipal.name} | <button onclick="document.forms['logoutForm'].submit()">Logout</button>
            </h5>

        </c:if>


    </div>--%>
</body>
</html>
