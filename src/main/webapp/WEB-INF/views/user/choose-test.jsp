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
<h1>Choose test</h1>

<label for="choose_test">Select Test:</label>
<form action="/user/start-test">
<select name="test" id="choose_test" list="test_list">
    <datalist id="test_list">

        <option value="0">- chooseTest -</option>
        <c:forEach items="${testList}" var="test">
            <option>${test.getName()}</option>
        </c:forEach>
    </datalist>
</select>
    <form>
        <button class="user-button">Submit</button>
    </form>
</form>
<form action="/user/getUserTopics">
    <button class="user-button">Back</button>
</form>
</body>
</html>
