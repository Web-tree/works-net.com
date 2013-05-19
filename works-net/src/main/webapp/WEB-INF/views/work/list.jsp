<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="sideNav">
    <%@include file="../module/menu/subWork.jsp" %>
</c:set>

<c:set var="body">
    <%--@elvariable id="works" type="java.util.List<Work>"--%>
    <c:forEach items="${works}" var="work">
        <div class="work">
            <a href="/work/${work.id}">${work.name}</a>
        </div>
    </c:forEach>
</c:set>

<%@ include file="../../layouts/index.jsp" %>