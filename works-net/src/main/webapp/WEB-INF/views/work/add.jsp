<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="body">
    <form:form action="/work/save" modelAttribute="work">
        <table>
            <tr>
                <td><tags:message code="work.name"/></td>
                <td><form:input path="name"/><form:errors path="name"/></td>
            </tr>
            <tr>
                <td><tags:message code="work.description"/></td>
                <td><form:textarea path="description"/><form:errors path="description"/></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form:form>
</c:set>

<%@ include file="../../layouts/index.jsp" %>