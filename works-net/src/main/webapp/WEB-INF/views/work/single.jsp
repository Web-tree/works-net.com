<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="helper" uri="http://works-net.com/tags/ViewHelper" %>

<c:set var="pageTitle" value="${work.name}"/>
<c:set var="isOwner" value="${helper:checkCurrentUser(work.ownerId)}"/>
<c:set var="additionalHeaders">
    <script src="<c:url value="/static/js/work.js"/>"></script>
</c:set>

<c:set var="body">
    <h1 class="work name">${work.name}</h1>

    <div class="work description">${work.description}</div>
    <c:if test="${isOwner}">
        <a href="<c:url value="/work/${work.id}/edit"/>"><tags:message code="work.edit"/></a>
    </c:if>

    <div class="workdetails>
    <c:forEach items="${work.details}" var="detail">
        <p>
        <c:choose>
            <c:when test="${detail.type == 'LinkDetails'}">
                <%--@elvariable id="detail" type="com.worksnet.model.workdetails.LinkDetails"--%>
                <tags:message code="work.workDetails.link.url"/>: <a href="<c:url
                    value="http://${detail.link}"/>">http://${detail.link}</a>
            </c:when>
            <c:when test="${detail.type == 'GitHubDetails'}">
                <%--@elvariable id="detail" type="com.worksnet.model.workdetails.GitHubDetails"--%>
                <tags:message code="work.workDetails.githubLogin"/>: ${detail.login}
            </c:when>
        </c:choose>
        </p>
    </c:forEach>
    </div>

    <c:if test="${isOwner}">
        <div class="control-group<c:if test="${not empty errorName}"> error</c:if>">
            <label for="detailsSelector"><tags:message code="work.workDetails.add"/></label>

            <div class="controls">
                <form class="addWorkDetails">
                    <select id="detailsSelector">
                        <option selected="selected" disabled="disabled">
                            <tags:message code="work.workDetails.selectDetails"/>
                        </option>
                        <option value="link"><tags:message code="work.workDetails.link"/></option>
                        <option value="gitHub"><tags:message code="work.workDetails.github"/></option>
                    </select>
                </form>
            </div>
        </div>

        <div class="workDetails link hidden">
            <f:form action="/work/details/save/link" modelAttribute="linkDetail">
                <f:hidden path="type" value="LinkDetails"/>
                <f:hidden path="workId" value="${work.id}"/>
                <label for="linkAddInput"><tags:message code="work.workDetails.link"/></label>
                <f:input id="linkAddInput" path="link"/><f:errors path="link"/>
                <f:button><tags:message code="add"/></f:button>
            </f:form>
        </div>

        <div class="workDetails gitHub hidden">
            <f:form action="/work/details/save/github" modelAttribute="githubDetail">
                <f:hidden path="type" value="GitHubDetails"/>
                <f:hidden path="workId" value="${work.id}"/>
                <label for="githubAddInput"><tags:message code="work.workDetails.githubLogin"/></label>
                <f:input id="githubAddInput" path="login"/><f:errors path="login"/>
                <f:button><tags:message code="add"/></f:button>

            </f:form>
        </div>
    </c:if>
</c:set>

<%@ include file="../../layouts/index.jsp" %>