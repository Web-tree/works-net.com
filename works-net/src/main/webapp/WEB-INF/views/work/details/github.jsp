<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="helper" uri="http://works-net.com/tags/ViewHelper" %>


<%--@elvariable id="detail" type="com.worksnet.model.workdetails.GitHubDetails"--%>
<div class="workdetails github">
    <p>
        <tags:message code="work.workDetails.githubLogin"/>: ${detail.login}
    </p>
</div>