<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="body">
    <%--@elvariable id="errorMessage" type="java.lang.String"--%>
    <c:if test="${empty errorMessage}">
       <tags:message code="error.unknown"/>
    </c:if>
    <c:otherwise>
        ${errorMessage}
    </c:otherwise>
</c:set>

<%@ include file="../../layouts/index.jsp" %>