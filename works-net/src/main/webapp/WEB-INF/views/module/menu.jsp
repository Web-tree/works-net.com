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
                        <li><a href="<c:url value="/work"/>"><tags:message code="menu.works.all"/></a></li>
                        <li><a href="<c:url value="/work/my"/>"><tags:message code="menu.works.my"/></a></li>
                    </ul>
                </c:if>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" href="<c:url value="/user"/>"><tags:message code="menu.users"/></a>
            </li>
        </ul>
        <ul class="nav pull-right">
            <li>
                <c:choose>
                    <c:when test="${helper:isAuthorized()}">
                        <a href="<c:url value="/user/${helper:getCurrentUser().id}"/>">${helper:getCurrentUser().userName}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value="/login"/>"><tags:message code="login.login"/></a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>

</div>