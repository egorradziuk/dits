<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th> Question name</th>
            <th> Correct</th>
            <th> Recommend literature</th>
            <th> Recommend link on literature</th>
        </tr>
        <c:forEach items="${statistic}" var="stat">
            <tr>
                <td> ${stat.getQuestion().getDescription()}</td>
                <td> ${stat.isCorrect()}</td>
                <td> ${stat.getQuestion().getLiterature().getDescription()}</td>
                <td> ${stat.getQuestion().getLiterature().getLink().getLink()}</td>
            </tr>
        </c:forEach>
    </table>

    <form action="/goHome">
        <input type="submit" value="Home page">
    </form>
</body>
</html>
