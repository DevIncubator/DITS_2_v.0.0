<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create test</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<h1>Create Test</h1>
<div class="form">
    <form:form class="login-form" method="POST" action="/create-test" modelAttribute="topicTestDTO">
        <form:input path="topic.name" type="text" list="topics" placeholder="choose or create topic" required="true"/>
        <datalist id="topics">
            <c:forEach items="${topicList}" var="topic">
                <option>${topic}</option>
            </c:forEach>
        </datalist>
        <form:input path="test.description" type="text" placeholder="input topic description" required="true"/>
        <form:input path="test.name" type="text" placeholder="input test name" required="true"/>

        <input type="submit" value="Submit"/>

    </form:form>
</div>
</body>
</html>
