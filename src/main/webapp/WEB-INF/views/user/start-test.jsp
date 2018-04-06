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
<div class="form">
<h1>Test: ${testName} </h1>
<form action="/user/getTestResults" method="post" id="thisForm" onsubmit="return checkedd();">
            <c:forEach items="${map}" var="entry">
                <br>
           <h3> <b>Question:</b>
                <c:out value="${entry.key.getDescription()}"/><br><br>
           </h3>
                    <c:forEach items="${entry.value}" var="answers">
                            <%--<form:checkbox path="map" value="${answers.getDescription()}"/> ${answers.getDescription()}<br>--%>
                        ${answers.getDescription()}
                        <input type="checkbox" name="checkedAnswers" value="${answers.getAnswerId()}" id="checkedAnswers">
                        <br>
                    </c:forEach>
                <hr><br>
            </c:forEach>
    <input type="hidden" name="testName" value="${testName}">
    <input type="hidden" name="questionListSize" value="${questionListSize}">
    <button class="user-button" onclick="validateTerms()">Submit</button>
</form>
</div>

<script>
  function checkedd() {
      var check = $("input:checkbox:checked");
      if(check.length == 0){
          alert("ВЫ НЕ ВЫБРАЛИ НИ ОДНОГО ОТВЕТА");
          return false;
      }
  }
</script>

</body>
</html>
