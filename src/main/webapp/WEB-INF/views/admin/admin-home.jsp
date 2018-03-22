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

    <button class="admin-button">
        <a href="/create-test">Create test</a>
    </button>
    <button class="admin-button">
        <a href="/create-user">Create user</a><br>
    </button>
    <button class="admin-button">
        <a href="/statistic">Statistic</a><br>
    </button>

</body>
</html>
