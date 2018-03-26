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
    <form action="/create-test">
        <button class="admin-button">Create test</button>
    </form>
    <form action="/create-user">
        <button class="admin-button">Create user</button>
    </form>
    <form action="/statistic">
        <button class="admin-button">Statistics</button>
    </form>
</body>
</html>
