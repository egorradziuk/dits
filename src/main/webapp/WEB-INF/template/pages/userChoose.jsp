<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>--%>

<form action="/goTest" >
    <select id="themes" name="themes">
        <c:forEach items="${topics}" var="topic">
            <option value="" selected disabled hidden>Choose topic</option>
            <option>${topic.name}</option>
        </c:forEach>
    </select>
    <br>
    <select id="tests" name="testName">
        <option>...some thing...</option>
    </select>
    <br>
    <input type="submit" value="пройти тестирование">
</form>


