<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: steph
  Date: 29-Mar-18
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>TEST-RESULTS:</title>
</head>
<body>
<div class="form">
    <h1>${errorTestPass}</h1>
    <h1>${testName}</h1>
    <h2>Result: ${result}%</h2>
        <a href="/redirect">
            <button class="user-button">Начать заново</button>
        </a>
</div>
       <table class="table table-striped">
        <tr>
            <th>Question</th>
            <th>Correct</th>
        </tr>
        <c:forEach items="${map}" var="entry">
        <tr>
            <td>${entry.key.getDescription()}</td>
            <td>${entry.value}</td>
        </tr>
        </c:forEach>
    </table border="1">
    <br>
    <table class="table table-striped">
        <tr>
            <th>Literature</th>
            <th>Links</th>
        </tr>
        <c:forEach items="${mapLink}" var="entry">
            <tr>
                <td>${entry.key.getDescription()}</td>
                <td>
                    <c:forEach items="${entry.value}" var="links">
                        ${links.getLink()}<br>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
