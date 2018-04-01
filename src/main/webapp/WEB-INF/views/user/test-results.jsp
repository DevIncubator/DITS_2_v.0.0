<%--
  Created by IntelliJ IDEA.
  User: steph
  Date: 29-Mar-18
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST-RESULTS:</title>
</head>
<body>
    <h1>Test name: ${testName}</h1>
    <h2>Result: ${result}%</h2>
   <table>
    <tr>
        <td>All answers: </td>
        <td>Right answers: </td>
    </tr>
       <tr>
           <td>${answerQuantity}</td>
           <td>${userCorrectAnswers}</td>
       </tr>


   </table>
    <br>


</body>
</html>
