<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<form:form method="POST" action="/create-test" modelAttribute="test">
<form:input path="role" type="text" list="roles" placeholder="choose or create topic"/>
<datalist id="roles">
    <c:forEach items="${roleList}" var="role">
    <option>${role}</option>
    </c:forEach>
        <form:input path="firstName" type="text" placeholder="input firstName"/>
        <form:input path="lastName" type="text" placeholder="input lastName"/>
        <form:input path="login" type="text" placeholder="input login"/>
        <form:input path="password" type="text" placeholder="input password"/>
        <input type="submit">
    </form:form>
</body>
</html>
