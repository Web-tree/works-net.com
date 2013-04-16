<c:set var="currentPath">
    <%=request.getAttribute("javax.servlet.forward.request_uri")%>
</c:set>
<li class="<c:if test="${currentPath == '/work'}">active</c:if>"><a href="<c:url value="/work"/>"><tags:message code="menu.works.all"/></a></li>
<li class="<c:if test="${currentPath == '/work/add'}">active</c:if>"><a href="<c:url value="/work/add"/>"><tags:message code="menu.works.add"/></a></li>
<li class="<c:if test="${currentPath == '/work/my'}">active</c:if>"><a href="<c:url value="/work/my"/>"><tags:message code="menu.works.my"/></a></li>