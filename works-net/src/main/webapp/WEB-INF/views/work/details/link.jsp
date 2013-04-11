<%@ taglib prefix="helper" uri="http://works-net.com/tags/ViewHelper" %>

<%--@elvariable id="detail" type="com.worksnet.model.workdetails.LinkDetails"--%>
<div class="workdetails link">
    <p>
        <tags:message code="work.workDetails.link.url"/>: <a href="http://${detail.link}">http://${detail.link}</a>
        <c:if test="${helper:getCurrentUser()}"
    </p>
</div>