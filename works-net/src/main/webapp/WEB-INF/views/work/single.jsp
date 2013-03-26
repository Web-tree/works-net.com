<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="helper" uri="http://works-net.com/tags/ViewHelper" %>

<c:set var="additionalHeaders[]" value="qwe"/>

<c:set var="body">
    <div class="work name">${work.name}</div>
    <div class="work description">${work.description}</div>
    <c:if test="${helper:checkCurrentUser(work.ownerId)}">
        <a href="<c:url value="/work/${work.id}/edit"/>"><tags:message code="work.edit"/></a>
    </c:if>

    <c:forEach items="${work.details}" var="detail">
        <c:choose>
            <c:when test="${detail.type == 1}">
                <%@include file="details/link.jsp" %>
            </c:when>
            <c:when test="${detail.type == 2}">
                <%@include file="details/github.jsp" %>
            </c:when>
        </c:choose>
    </c:forEach>

    <c:if test="${helper:checkCurrentUser(work.ownerId)}">
        <tags:message code="work.workDetails.add"/>
        <f:form cssClass="addWorkDetails">
            <f:select path="/work/details/save">
                <f:option value="link"><tags:message code="work.workDetails.link"/></f:option>
                <f:option value="github"><tags:message code="work.workDetails.github"/></f:option>
            </f:select>

            <div class="workDetails link disabled">
                <f:form path="/work/details/save">
                    <f:hidden path="type" value="1"/>
                    <f:hidden path="workId"/>
                    <f:input path="link" disabled="true"/><f:errors path="link"/>

                </f:form>
            </div>

            <div class="workDetails link gitHub">
                <f:form path="/work/details/save">
                    <f:hidden path="type" value="2"/>
                    <f:hidden path="workId"/>
                    <f:input path="gitHub" disabled="true"/><f:errors path="gitHub"/>
                </f:form>
            </div>
        </f:form>
    </c:if>
</c:set>

<%@ include file="../../layouts/index.jsp" %>