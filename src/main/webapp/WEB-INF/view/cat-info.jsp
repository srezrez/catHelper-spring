<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta charset="utf-8">
    <link href="resources/css/styles.css" type="text/css" rel="stylesheet" />
</head>
<body>
<label>Name:</label><br/>
${cat.name}<br/>
<label>Age:</label><br/>
${cat.age}<br/>
<label>Breed:</label><br/>
${cat.breed.title}<br/>
<label>Gender:</label><br/>
${cat.gender.title}<br/>
<label>Description:</label><br/>
${cat.description}<br/>

<c:url var="sendRequest" value="/request/sendRequest">
    <c:param name="catId" value="${cat.id}" />
</c:url>

<a href="${sendRequest}">
    <button>
        <span>Send request</span>
    </button>
</a>
</body>
</html>
