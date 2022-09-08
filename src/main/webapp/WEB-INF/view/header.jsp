<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a href="<spring:url value="/"/>" class="navbar-brand">CatHelper</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="<spring:url value="/services/"/>">All cats</a></li>
            <li><a href="<spring:url value="/cat/addedCats" />">Added cats</a></li>
            <li><a href="<spring:url value="/schedule/" />">My requests</a></li>
            <li><a href="<spring:url value="/login/"/>">Add cat</a></li>
        </ul>
    </div>
</nav>
