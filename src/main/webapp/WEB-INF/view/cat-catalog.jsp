<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="resources/css/styles.css" type="text/css" rel="stylesheet" />
    <title>Cat catalog</title>
</head>
<body>
<%--<jsp:include page="header.jsp" />--%>
<div id="body-div">
    <table class ="table">
        <tr>
            <th width="16%">Photo</th>
            <th width="20%">Name</th>
            <th width="16%">Age</th>
            <th width="16%">Breed</th>
            <th width="16%">Gender</th>
            <th width="16%"></th>
        </tr>
        <c:forEach items="${catList}" var="cat">
            <c:url var="moreLink" value="/cat/showCatInfo">
                <c:param name="catId" value="${cat.id}" />
            </c:url>
            <tr>
<%--                <td><img src='${cat.document.path}' style="width:70px;height:90px;"/> </td>--%>
                <td>${cat.document.path}</td>
                <td>${cat.name}</td>
                <td>${cat.age}</td>
                <td>${cat.breed.title}</td>
                <td>${cat.gender.title}</td>
                <td>
                    <a href="${moreLink}">More...</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>