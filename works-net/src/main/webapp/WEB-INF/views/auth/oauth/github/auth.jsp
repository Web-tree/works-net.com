<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="body">
    <p>Well, hello there!</p>
    <p>We're going to now talk to the GitHub API. Ready? <a href="https://github.com/login/oauth/authorize?client_id=${clientId}">Click here</a> to begin!</p>
    <p>If that link doesn't work, remember to provide your own <a href="http://developer.github.com/v3/oauth/#web-application-flow">Client ID</a>!</p>
</c:set>

<%@ include file="../../../../layouts/index.jsp" %>