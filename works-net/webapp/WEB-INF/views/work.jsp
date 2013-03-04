<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<table>
    <%--@elvariable id="works" type="java.util.List<Work>"--%>
    <c:forEach items="${works}" var="work">
        <tr>
            <td><c:out value="${work.name}"/></td>
            <td><a href='<c:url value="user/${work.id}/edit"/>'>Edit</a></td>
            <td><a href='<c:url value="user/${work.id}/delete"/>'>Delete</a></td>
        </tr>
    </c:forEach>
</table>

<form:form action="/work" modelAttribute="work">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/><form:errors path="name"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"></td>
        </tr>
    </table>
</form:form>