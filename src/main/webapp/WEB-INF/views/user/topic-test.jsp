<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create test</title>
</head>
<body>

<h1>Create Test</h1>


<%--@elvariable id="topic" type=""--%>
<form:form method="POST" action="/create-test" modelAttribute="topic">
    <form:select path="name">
        <form:options items="${topicList}"/>
    </form:select>
    <form:input path="description"/>
    <input type="submit" value="Submit"/>
</form:form>

<%--@elvariable id="test" type=""--%>
<%--<form:form method="POST" action="/test-test" modelAttribute="test">--%>
    <%--<form:select path="name2">--%>
        <%--<form:option value="NONE">--SELECT TEST--</form:option>--%>
        <%--<form:options items="${testList}"/>--%>
    <%--</form:select>--%>
    <%--<input type="submit" value="Submit2"/>--%>
<%--</form:form>--%>

</body>
</html>



