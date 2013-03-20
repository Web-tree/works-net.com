<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="body">
    <%--@elvariable id="works" type="java.util.List<Work>"--%>
    <c:forEach items="${works}" var="work">
        <div class="work">
            <a href="<c:url value="/work/${work.id}"/>"><c:out value="${work.name}"/></a>
        </div>
    </c:forEach>
</c:set>

<%@ include file="../../layouts/index.jsp" %>