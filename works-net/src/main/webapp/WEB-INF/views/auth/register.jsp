<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="name"><tags:message code="reg.name"/></c:set>
<c:set var="email"><tags:message code="reg.email"/></c:set>
<c:set var="pass"><tags:message code="reg.pass"/></c:set>
<c:set var="submit"><tags:message code="reg.submit"/></c:set>


<c:set var="body">
    <form:form cssClass="form-horizontal" method="POST" action="/register" modelAttribute="user">
        <c:set var="errorName"><form:errors path="userName"/></c:set>
        <c:set var="errorEmail"><form:errors path="email"/></c:set>
        <c:set var="errorPass"><form:errors path="password"/></c:set>

        <div class="control-group<c:if test="${not empty errorName}"> error</c:if>">
            <label class="control-label" for="regName">${name}</label>
            <div class="controls">
                <form:input id="regName" placeholder="${name}" path="userName"/>
                <span class="help-inline">${errorName}</span>
            </div>
        </div>
        <div class="control-group<c:if test="${not empty errorEmail}"> error</c:if>">
            <label class="control-label" for="regEmail">${email}</label>
            <div class="controls">
                <form:input id="regEmail" placeholder="${email}" path="email"/>
                <span class="help-inline">${errorEmail}</span>
            </div>
        </div>
        <div class="control-group<c:if test="${not empty errorPass}"> error</c:if>">
            <label class="control-label" for="regPass">${pass}</label>
            <div class="controls">
                <form:input id="regPass" placeholder="${pass}" path="password"/>
                <span class="help-inline">${errorPass}</span>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <form:button>${submit}</form:button>
            </div>
        </div>
    </form:form>
</c:set>

<%@ include file="../../layouts/index.jsp" %>