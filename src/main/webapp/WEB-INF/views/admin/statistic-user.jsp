<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistics User</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<table>

    <tr>
        <th>User FIO</th>
        <th>Answers</th>
        <th>Correct</th>
        <th>Incorrect</th>
    </tr>

    <c:forEach var="stat" items="${stat}">
        <tr>
            <td>${stat.fio}</td>
            <td>${stat.sumAnswers}</td>
            <td>${stat.sumCorrectQuestion}</td>
            <td>${stat.sumIncorrectQuestion}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
