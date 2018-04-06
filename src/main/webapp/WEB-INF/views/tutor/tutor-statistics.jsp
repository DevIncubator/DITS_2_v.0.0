<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistics</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<form:form method="POST" action="/tutor" modelAttribute="topic">
    <div class="login-page">
        <div class="form">
            <h1>Choose statistic page</h1>
            <form class="button">

                <button formaction="/tutor/tutor-statistics-test">Tests statistics</button>
                <br><br>

                <button formaction="/tutor/tutor-statistics-user">User statistics</button>
                <br><br>

                <button formaction="/tutor/tutor-statistics-questions">Question statistics</button>
                <br><br>

                <button formaction="/tutor/tutor-main-page">Back</button>
                <br><br>


            </form>
        </div>
    </div>
</form:form>
</body>
</html>
