<%--@elvariable id="pageTitle" type="String"--%>
<%--@elvariable id="additionalHeaders" type="String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:choose >
    <c:when test="${param.layout == 1}">
        <div class="additionalHeaders">${additionalHeaders}</div>
        ${body}
    </c:when>
    <c:otherwise>
        <!DOCTYPE html>
        <html>
        <head>
            <title><c:if test="${!empty pageTitle}">${pageTitle} - </c:if>Works-Net.com</title>
            <base href="http://${helper:getBaseUrl()}/" />
            <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/bootstrap.min.css"/>"/>
            <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/bootstrap-responsive.min.css"/>"/>
            <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/main.css"/>"/>
            <script src="http://code.jquery.com/jquery.js"></script>
            <script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
            <script src="<c:url value="/static/js/modalLink.js"/>"></script>
            ${additionalHeaders}
        </head>
        <body>
        <div class="container">
            <header>
                <%@ include file="../views/module/header.jsp" %>
            </header>
            <c:if test="${!empty sideNav}">
                <div class="span3 bs-docs-sidebar">
                    <ul class="nav nav-tabs nav-stacked">
                        ${sideNav}
                    </ul>
                </div>
            </c:if>
            <div class="body span8">${body}</div>
            <footer></footer>
        </div>
        <div id="modal-window" role="dialog" class="modal hide fade">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3></h3>
            </div>
            <div class="modal-body">

            </div>
        </div>
        </body>
        </html>
    </c:otherwise>
</c:choose>
