<%--
  Created by IntelliJ IDEA.
  User: Yahor
  Date: 10.07.2020
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/nextTestPage" method="get">
        <div>${questions}</div>
        <br>
        <c:forEach items="${answers}" var="answer">
            <input type="radio" name="choosenAns"
                   value="${answer.id}">
            ${answer.description}<br>
        </c:forEach>
        <br>
        <input type="submit" value="next">
    </form>
    <a href="<c:url value="/logout"/>">Exit</a>
</body>
</html>
