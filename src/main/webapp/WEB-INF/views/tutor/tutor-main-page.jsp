<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<form:form method="POST" action="/tutor-main-page" modelAttribute="topic">
    <div class="login-page">
        <div class="form">
            <form class="button">

                <button formaction="/tutor-edit-theme-test">Edit theme/test</button>
                <br><br>

                <button formaction="/tutor-theme-test-details">Theme/test details</button>
                <br><br>

                <button formaction="/tutor-statistic">Statistic</button>


            </form>
        </div>
    </div>
</form:form>
</body>
</html>
