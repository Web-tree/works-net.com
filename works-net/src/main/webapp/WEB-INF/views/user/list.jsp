<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="body">
    <%--@elvariable id="users" type="java.util.List<User>"--%>
    <c:forEach items="${users}" var="user">
        <div class="user">
            <a href="<c:url value="/user/${user.id}"/>"><c:out value="${user.userName}"/></a>
        </div>
    </c:forEach>
</c:set>

<%@ include file="../../layouts/index.jsp" %>