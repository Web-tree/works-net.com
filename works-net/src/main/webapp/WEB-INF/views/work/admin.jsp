<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="body">
    <table>

            <%--@elvariable id="works" type="java.util.List<Work>"--%>
        <c:forEach items="${works}" var="work">
            <tr>
                <td><c:out value="${work.name}"/></td>
                <td><a href='<c:url value="/work/${work.id}/edit"/>'>Edit</a></td>
                <td><a href='<c:url value="/work/${work.id}/delete"/>'>Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <form:form action="/work" modelAttribute="work">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td><tags:message code="work.name"/></td>
                <td><form:input path="name"/><form:errors path="name"/></td>
            </tr>
            <tr>
                <td><tags:message code="work.description"/></td>
                <td><form:input path="description"/><form:errors path="description"/></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form:form>
</c:set>

<%@ include file="../../layouts/index.jsp" %>