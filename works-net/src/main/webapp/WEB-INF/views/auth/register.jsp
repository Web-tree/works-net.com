<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="body">
    <form:form method="POST" action="/register" modelAttribute="user">
        <table>
            <tr>
                <td>Name</td>
                <td><form:input path="userName"/><form:errors path="userName"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><form:input path="email"/><form:errors path="email"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:input path="password"/><form:errors path="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form:form>
</c:set>

<%@ include file="../../layouts/index.jsp" %>