<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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