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
<h1>Create Question</h1>


<div class="form">
    <form action="/tutor/createAnswer">
        ${newQuestion}
        Выберете существующий или введите новый вопрос:
        <input type="text" name="question" list="question_list">
        <datalist id="question_list">
            <c:forEach items="${questionList}" var="question">
                <option>${question.getDescription()}</option>
            </c:forEach>
        </datalist>
        <input type="hidden" name="testName" value="${test.name}" }>
        <%-- <ol id = "answers">
             &lt;%&ndash;<c:forEach items="${answerList}" var="answer">
                 <li>${answer.getDescription()}</li>
             </c:forEach>&ndash;%&gt;
         </ol>--%>


        <form>
            <button class="user-button">Submit</button>
        </form>
        <form action="/tutor/tutor-main-page">
            <button class="user-button">Back</button>
        </form>
    </form>
</div>

</body>
</html>
