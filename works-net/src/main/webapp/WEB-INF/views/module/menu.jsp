<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="helper" uri="http://works-net.com/tags/ViewHelper" %>

<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="<c:url value="/"/>">Works-Net</a>
        <ul class="nav">
            <li class="dropdown">
                <a class="dropdown-toggle" href="<c:url value="/work/all"/>"><tags:message code="menu.works"/></a>
                <c:if test="${helper:isAuthorized()}">
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/work/my"/>"><tags:message code="menu.works.my"/></a></li>
                        <li><a href="<c:url value="/work/all"/>"><tags:message code="menu.works.all"/></a></li>
                    </ul>
                </c:if>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" href="<c:url value="/user"/>"><tags:message code="menu.users"/></a>
            </li>
        </ul>
    </div>
</div>