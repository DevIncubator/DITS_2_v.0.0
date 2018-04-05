<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Choose test</title>
    <meta charset="utf-8">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<h1>Test: ${testName} </h1>
<form action="/user/getTestResults" method="post">
            <c:forEach items="${map}" var="entry">
                <br>
            Question:
                <c:out value="${entry.key.getDescription()}"/><br>
                    <c:forEach items="${entry.value}" var="answers">
                            <%--<form:checkbox path="map" value="${answers.getDescription()}"/> ${answers.getDescription()}<br>--%>
                        <input type="checkbox" name="checkedAnswers" value="${answers.getAnswerId()}">${answers.getDescription()}
                        <br>
                    </c:forEach>
                <hr><br>
            </c:forEach>
    <input type="hidden" name="testName" value="${testName}">
    <input type="hidden" name="questionListSize" value="${questionListSize}">
    <button class="user-button">Submit</button>
</form>

</body>
</html>
