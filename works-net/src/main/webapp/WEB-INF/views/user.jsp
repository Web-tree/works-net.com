<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="body">
    <table>
            <%--@elvariable id="users" type="java.util.List<User>"--%>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.userName}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.birth}"/></td>
                <td><a href='<c:url value="user/${user.id}/edit"/>'>Edit</a></td>
                <td><a href='<c:url value="user/${user.id}/delete"/>'>Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <form:form action="/user" modelAttribute="user">
        <form:hidden path="id"/>
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
                <td>Birth</td>
                <td><form:input path="birth"/><form:errors path="birth"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form:form>

</c:set>

<%@ include file="../layouts/index.jsp" %>
