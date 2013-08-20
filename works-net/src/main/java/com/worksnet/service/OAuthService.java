package com.worksnet.service;

import com.worksnet.dao.OAuthDAO;
import com.worksnet.model.User;
import com.worksnet.model.oauth.BaseOAuth;
import com.worksnet.model.oauth.GitHubAuth;
import com.worksnet.system.Conf;
import com.worksnet.system.Log;
import com.worksnet.utils.HttpUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 20:34
 */
@Service
@Transactional
public class OAuthService {

    @Autowired
    private OAuthDAO dao;

    private enum GitHubUrls {
        ACCESS_TOKEN("https://github.com/login/oauth/access_token"),
        USER_INFO("https://api.github.com/user");

        private String getUrl() {
            return url;
        }

        private GitHubUrls(String url) {
            this.url = url;
        }

        private String url;
    }

    public static String generateLogin(BaseOAuth oAuth) {
        return oAuth.getOAuthId() + "@" + oAuth.getProvider();
    }

    @Transactional
    public User userByGitHubAuth(GitHubAuth gitHubAuth) {
        return dao.getUserByGitHubAuth(gitHubAuth);
    }

    public User addGitHubAuthWithNewUser(GitHubAuth gitHubAuth) {
        return dao.addGitHubAuthWithNewUser(gitHubAuth);
    }

    public int addGitHubAuth(GitHubAuth gitHubAuth) {
        return dao.addGitHubAuth(gitHubAuth);
    }

    public void updateGitHubAuth(GitHubAuth gitHubAuth) {
        dao.update(gitHubAuth);
    }

    public boolean checkGitHubAuthExists(GitHubAuth gitHubAuth) {
        return dao.isModelExists(gitHubAuth.getId());
    }

    public GitHubAuth getGitHubLoginByCode(String code) throws OAuthError {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", Conf.get("github.clientId"));
        params.put("client_secret", Conf.get("github.clientSecret"));
        params.put("code", code);

        Logger log = Log.getLogger(OAuthService.class);

        try {
            String url = GitHubUrls.ACCESS_TOKEN.getUrl();
            Map<String, String> result = HttpUtils.parseHttpParams(HttpUtils.sendPostRequest(url, params));
            if (result.containsKey("error")) {
                log.error("Git hub auth error: {}", result.get("error"));
                throw new OAuthError();
            } else if (result.containsKey("access_token")) {
                params.clear();
                params.put("access_token", result.get("access_token"));
                String gitHubUser = HttpUtils.sendGetRequest(GitHubUrls.USER_INFO.getUrl(), params);
                log.debug("Github user: {}", gitHubUser);
                return new ObjectMapper().readValue(gitHubUser, GitHubAuth.class);
            }
        } catch (IOException e) {
            log.error("GitHub get request error.", e);
            throw new OAuthError();
        }
        throw new OAuthError();
    }

    public static class OAuthError extends Exception {
    }
}
