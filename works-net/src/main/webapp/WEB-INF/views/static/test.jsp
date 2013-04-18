<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="additionalHeaders">
    <script>
        $(document).ready(function(){
            $(".send").click(function(){
                $.ajax({
                    url: $(".requestUrl").text(),
                    context: document.body,
                    method: "post"
                }).done(function(result) {
                    $(".result").html(result);
                });
            });
        });
    </script>
</c:set>

<c:set var="body">
    <label>
        <input class="requestUrl" placeholder="url" type="text"/>
    </label>

    <input class="send btn" type="button" value="send">

    <div class="result"></div>
</c:set>

<%@ include file="../../layouts/index.jsp" %>