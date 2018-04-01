<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Home</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<center>
    <h1>Choose</h1>
    <form action="/getTopics">
        <button class="user-button">Test</button>
    </form>

    <form action="/statistic">
        <button class="user-button">Statistics</button>
    </form>
</center>
</body>
</html>
