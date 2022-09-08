<%--
  Created by IntelliJ IDEA.
  User: srezrez
  Date: 08.09.2022
  Time: 14:46
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
<jsp:include page="header.jsp" />
<table class ="table">
    <c:url var="approveRequest" value="/request/approveRequest">
        <c:param name="requestId" value="${request.id}" />
    </c:url>
    <c:url var="rejectRequest" value="/request/rejectRequest">
        <c:param name="requestId" value="${request.id}" />
    </c:url>
    <tr>
        <th width="25%">Active requests amount</th>
        <th width="20%">Current requester</th>
        <th width="25%">Contact email</th>
        <th width="25%">Decision</th>
    </tr>
    <tr>
        <td>${request.activeRequestAmount}</td>
        <td>${request.requester.name} ${request.requester.surname}</td>
        <td>${request.requester.email}</td>
        <td>
            <a href="${approveRequest}"> <button> <span>Approve request </span> </button> </a>
            <a href="${rejectRequest}"> <button> <span>Reject request </span> </button> </a>
        </td>
    </tr>
</table>
</body>
</html>
