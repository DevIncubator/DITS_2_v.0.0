<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create test</title>
</head>
<body>

<h1>Create Test</h1>
<form:form method="POST" action="/create-test" modelAttribute="topicTestDTO">
    <form:input path="topic.name" type="text" list="topic_list" placeholder="choose or create topic"/>
    <datalist id="topic_list">
        <c:forEach items="${topicList}" var="topic">
            <option>${topic}</option>
        </c:forEach>
    </datalist>
    <br>
    <form:input path="test.name" type="text" placeholder="create test name"/>
    <input type="submit">
</form:form>
</body>
</html>