<%@ taglib prefix="helper" uri="http://works-net.com/tags/ViewHelper" %>
<a href="https://github.com/login/oauth/authorize?client_id=${helper:getConfParam("github.clientId")}&scope=user:email">
    <img alt="GitHub" src="/static/img/oauth/github_32.png"/>
</a>