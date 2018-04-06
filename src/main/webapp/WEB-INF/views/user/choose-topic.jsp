<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create test</title>
    <meta charset="utf-8">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="form">
<h1>Choose topic</h1>

<label for="choose_topic">Select Topic:</label>
<form action="/user/getTestByTopicId">
<select  name="topic" id="choose_topic" list="topic_list">
    <datalist id="topic_list">
        <option  value="0">-chooseTopic-</option>
        <c:forEach items="${topicList}" var="topic">
            <option >${topic.getName()}</option>
        </c:forEach>
    </datalist>
</select>
    <form>
        <button class="user-button">Submit</button>
    </form>
</form>

<%--<form action="/user-home">
    <button class="user-button">Back</button>
</form>--%>
<%--
<script>
    function getTests() {
        var topiccc = $("#choose_topic").val();

        /*var item = $('<form action="/getTests" id="btnForm">\n' +
            '    <button class="user-button">Submit</button>\n' +
            '</form>');*/
    }




</script>--%>
</div>
</body>
</html>
