<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="helper" uri="http://works-net.com/tags/ViewHelper"  %>

<c:set var="body">
    <div class="work name">${work.name}</div>
    <div class="work description">${work.description}</div>
    <c:if test="${helper:checkCurrentUser(work.ownerId)}">
        <a href="<c:url value="/work/${work.id}/edit"/>"><tags:message code="work.edit"/></a>
    </c:if>
</c:set>

<%@ include file="../../layouts/index.jsp" %>