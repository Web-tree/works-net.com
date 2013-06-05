<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="body">
    <c:if test="${not empty param.error}">
        <div class=".error"><tags:message code="login.loginerror"/>
            : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
    </c:if>
    <form class="form-inline" method="POST" action="/j_spring_security_check">
        <p>
            <input id="j_username" type="text" placeholder="<tags:message code="login.login"/>" name="j_username"/>
            <input id="j_password" type="password" placeholder="<tags:message code="login.password"/>"
                   name="j_password"/>
        </p>

        <p>
            <label class="checkbox" for="_spring_security_remember_me"><tags:message code="login.remember"/>
                <input id="_spring_security_remember_me" type="checkbox" name="_spring_security_remember_me"/>
            </label>
            <input class="btn" type="submit" value="<tags:message code="login.login"/>"/>
        </p>

        <p>
            <jsp:include page="oauth/buttons.jsp" />
        </p>


    </form>

</c:set>

<%@ include file="../../layouts/index.jsp" %>