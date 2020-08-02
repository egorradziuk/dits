<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table>
    <tr>
        <th> Question name</th>
        <th> Correct</th>
        <th> Recommend literature</th>
        <th> Recommend link on literature</th>
    </tr>
    <c:forEach items="${statistic}" var="stat">
        <tr>
            <td> ${stat.getQuestionY().getDescription()}</td>
            <td> ${stat.isCorrect()}</td>
            <td> ${stat.getQuestionY().getLiteratureY().getDescription()}</td>
            <td> ${stat.getQuestionY().getLiteratureY().getLinkY().getLink()}</td>
        </tr>
    </c:forEach>
</table>

<form action="/goHome">
    <input type="submit" value="Home page">
</form>