<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create test</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
<h1>Create Answer</h1>

<div class="form">
    <div>
        <input type="text" id="answerInput" name="answer" list="answer_list">
        <datalist id="answer_list">
            <c:forEach items="${answerList}" var="answer">
                <option>${answer.getDescription()}</option>
            </c:forEach>
        </datalist>
        <div><input type="checkbox" id="correct" /><label><span></span> correct? </label></div>

        <%--<div id="addAnswer">--%>
            <%--<a class="text-primary" onclick="addAnswerButton()">Добавить ответ</a>--%>
        <%--</div>--%>

            <button class="user-button" id="addAnswer" onclick="addAnswerButton()">Submit</button>

        <form action="/tutor/tutor-main-page">
            <button class="user-button">Back</button>
        </form>
    </div>
</div>

<script>
    function addAnswerButton() {
        var answerName = $("#answerInput").val();
        var link = window.location.search.split('=');
        var link1 = link[1].split('&');
        var questionName = link1[0];
        var correct = $('#correct').is(':checked');
        if (answerName != '') {
            $.ajax({
                type: "get",
                url: "/tutor/checkAnswer",
                data: {answerName: answerName},
                contentType:
                    "application/json; charset=utf-8",
                success: function (data) {
                        if(!data){
                            $.ajax({
                            type: "get",
                            url: "/tutor/addAnswer",
                            data: {answerName: answerName, correct: correct},
                            contentType:
                                "application/json; charset=utf-8",
                            success: function (data) {
                                $("#answerInput").val('');
                                var item = $('<datalist id="answer_list"></datalist>');
                                for (var i = 0; i < data.length; i++) {
                                    item.append("<option>" + data[i].description + "</option>");
                                }
                                $("#answer_list").replaceWith(item);
                                alert(answerName + "was added");
                            }
                            });

                        } else {
                            alert("Such answer doesn't exist")
                        }
                    }


            });
        }
        else
            alert("input answer not null");
    }
</script>
<%--<script>--%>
    <%--function addAnswerButton() {--%>
        <%--questionName = ($("#choose_question").val());--%>
        <%--if (questionName != '') {--%>
            <%--var item = $('<div id="addAnswer"></div>');--%>
            <%--item.append('<input type="text" id="answer">');--%>
            <%--item.append('<a class="btn btn-success" onclick="saveAnswer()">Сохранить</a>');--%>
            <%--item.append('<div><input type="checkbox" id="correct" /><label for="c1"><span></span> correct? </label></div>');--%>
            <%--$("#addAnswer").replaceWith(item);--%>
        <%--}--%>
        <%--else--%>
            <%--alert("please select your question");--%>
    <%--}--%>
    <%--function saveAnswer() {--%>
        <%--try {--%>
            <%--var answer = $("#answer").val();--%>
            <%--var question = $("#choose_question").val();--%>
            <%--var test = $("#choose_test").val();--%>
            <%--var correct = $('#correct').is(':checked');--%>
        <%--} catch (e) {--%>
        <%--}--%>
        <%--if (answer != '' && question != '') {--%>
            <%--$.ajax({--%>
                <%--type: "get",--%>
                <%--url: "/tutor/createAnswer",--%>
                <%--data: {answer: answer, question: question, correct: correct, test: test},--%>
                <%--contentType:--%>
                    <%--"application/json; charset=utf-8",--%>
                <%--success: function () {--%>
                    <%--alert(question + " was updated");--%>
                    <%--getQuestions();--%>
                    <%--getAnswers();--%>
                    <%--changeAnswerField();--%>
                <%--},--%>
                <%--error: function () {--%>

                <%--}--%>
            <%--});--%>
        <%--}--%>
    <%--}--%>
<%--</script>--%>
</body>
</html>
