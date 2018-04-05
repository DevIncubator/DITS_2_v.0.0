<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Choose test</title>
    <meta charset="utf-8">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<h1>${userName}'s статистика</h1>
<a href="redirect">
    <button class="user-button">Вернуться</button>
</a>
<hr>
<table>
    <tr>
        <th>Test</th>
        <th>Date</th>
        <th>Question</th>
        <th>Correct</th>
    </tr>
        <c:forEach items="${statList}" var="statistic">
            <tr>
                <td>${statistic.getQuestion().getTest().getName()}</td>
                <td>${statistic.getDate()}</td>
                <td>${statistic.getQuestion().getDescription()}</td>
                <td>${statistic.isCorrect()}</td>

            </tr>
        </c:forEach>

</table>
</body>
</html>
