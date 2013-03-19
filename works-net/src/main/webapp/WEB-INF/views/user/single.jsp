<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="helper" uri="http://works-net.com/tags/ViewHelper"  %>

<c:set var="body">
    <div class="work name">${user.userName}</div>
</c:set>

<%@ include file="../../layouts/index.jsp" %>