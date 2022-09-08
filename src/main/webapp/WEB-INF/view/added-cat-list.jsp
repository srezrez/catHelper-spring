<%--
  Created by IntelliJ IDEA.
  User: srezrez
  Date: 07.09.2022
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
</head>
<body>
<h2>Hello in added catList</h2>
<table class ="table">
    <tr>
        <th width="25%">Name</th>
        <th width="20%">Age</th>
        <th width="25%">Breed</th>
        <th width="25%">Active request amount</th>
        <th width="30%"></th>
    </tr>
    <c:forEach items="${addedCatList}" var="cat">
        <c:url var="moreLink" value="/cat/showCatInfo">
            <c:param name="catId" value="${cat.cat.id}" />
        </c:url>
        <tr>
            <td>${cat.cat.name}</td>
            <td>${cat.age}</td>
            <td>${cat.cat.breed.title}</td>
            <td>${cat.activeRequestsAmount}</td>
            <td>
                <c:if test="${cat.activeRequestsAmount > 0}">
                    <a href="${moreLink}">More...</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
