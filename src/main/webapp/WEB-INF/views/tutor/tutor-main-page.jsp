<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<form:form method="POST" action="/tutor" modelAttribute="topic">
    <div class="login-page">
        <div class="form">
            <form class="button">

                <button formaction="/tutor/tutor-create-test">Edit theme/test</button>
                <br><br>

                <button formaction="/tutor/tutor-choose-topic">Edit questions/answers</button>
                <br><br>

                <button formaction="/tutor/tutor-statistics">Statistics</button>
                <br><br>

                <button formaction="/logout">logout</button>
                <br><br>


            </form>
        </div>
    </div>
</form:form>
</body>
</html>
