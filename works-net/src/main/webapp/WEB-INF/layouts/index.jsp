<%--@elvariable id="pageTitle" type="String"--%>
<%--@elvariable id="additionalHeaders" type="String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${pageTitle} - Works-Net.com</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/bootstrap-responsive.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/main.css"/>"/>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
    ${additionalHeaders}
</head>
<body>
<div class="container">
    <header>
        <%@ include file="../views/module/header.jsp" %>
    </header>
    <div class="body">${body}</div>
    <footer></footer>
</div>
</body>
</html>