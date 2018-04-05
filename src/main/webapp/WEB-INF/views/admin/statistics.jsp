<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistics</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<h1>Choose statistic page</h1>
<form action="/admin/statistics-test">
    <button class="admin-button">Tests statistics</button>
</form>
<form action="/admin/statistics-user">
    <button class="admin-button">User statistics</button>
</form>
<form action="/admin/statistics-questions">
    <button class="admin-button">Question statistics</button>
</form>
<form action="/admin-home">
    <button class="admin-button">Back</button>
</form>
</body>
</html>
