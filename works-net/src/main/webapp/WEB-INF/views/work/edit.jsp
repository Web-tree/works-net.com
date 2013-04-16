<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="helper" uri="http://works-net.com/tags/ViewHelper" %>

<c:set var="sideNav">
    <%@include file="../module/menu/subWork.jsp"%>
</c:set>

<c:set var="body">
    <f:form action="/work/save" modelAttribute="work">
        <f:hidden path="id"/>
        <f:hidden path="ownerId"/>
        <table>
            <tr>
                <td><tags:message code="work.name"/></td>
                <td><f:input path="name"/><f:errors path="name"/></td>
            </tr>
            <tr>
                <td><tags:message code="work.description"/></td>
                <td><f:input path="description"/><f:errors path="description"/></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>
        </table>
    </f:form>
</c:set>

<%@ include file="../../layouts/index.jsp" %>