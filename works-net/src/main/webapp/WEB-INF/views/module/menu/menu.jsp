<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="helper" uri="http://works-net.com/tags/ViewHelper" %>

<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="<c:url value="/"/>">Works-Net</a>
        <ul class="nav">
            <li class="dropdown">
                <a class="dropdown-toggle" href="<c:url value="/work"/>"><tags:message code="menu.works"/></a>
                <c:if test="${helper:isAuthorized()}">
                    <ul class="dropdown-menu">
                        <%@ include file="subWork.jsp" %>
                    </ul>
                </c:if>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" href="<c:url value="/user"/>"><tags:message code="menu.users"/></a>
            </li>
        </ul>
        <ul class="nav pull-right">
            <c:choose>
                <c:when test="${helper:isAuthorized()}">
                    <li>
                        <a href="<c:url value="/user/${helper:getCurrentUser().id}"/>">${helper:getCurrentUser().userName}</a>
                    </li>
                    <li><a href="<c:url value="/logout"/>"><tags:message code="login.logout"/></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="<c:url value="/login"/>"><tags:message code="login.login"/></a></li>
                    <li><a href="<c:url value="/register"/>"><tags:message code="reg.registration"/></a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>

</div>