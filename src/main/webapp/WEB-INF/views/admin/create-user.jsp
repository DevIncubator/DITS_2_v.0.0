<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<h1>Create User</h1>

<div class="form">
    <form:form class="login-form" method="POST" action="/create-user" modelAttribute="usermodel">
        Role: <form:select path="role" items="${roleNames}" required="true"/>
        First name: <form:input path="firstName" type="text"/>
        Last name: <form:input path="lastName" type="text"/>
        Login: <form:input path="login" type="text" required="true"/>
        Password: <form:password path="password" required="true"/>
        <input type="submit" />
    </form:form>
</div>

<form action="/admin-home">
    <button class="admin-button">Back</button>
</form>
</body>
</html>
