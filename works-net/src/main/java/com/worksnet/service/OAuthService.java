package com.worksnet.service;

import com.worksnet.dao.OAuthDAO;
import com.worksnet.model.oauth.GitHubAuth;
import com.worksnet.system.Conf;
import com.worksnet.system.Log;
import com.worksnet.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 20:34
 */
@Service
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


    public void addGitHubAuth(GitHubAuth gitHubAuth) {
        dao.addGitHubAuth(gitHubAuth);
    }

    public String getGitHubLoginByCode(String code) throws OAuthError {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", Conf.get("github.clientId"));
        params.put("client_secret", Conf.get("github.clientSecret"));
        params.put("code", code);

        try {
            String url = GitHubUrls.ACCESS_TOKEN.getUrl();
            Map<String, String> result = HttpUtils.parseHttpParams(HttpUtils.getPostResult(url, params));
            if (result.containsKey("error")) {
                Log.log("Git hub auth error: " + result.get("error"));
                throw new OAuthError();
            } else if (result.containsKey("access_token")) {
                params.clear();
                params.put("access_token", result.get("access_token"));
                String gitHubUser = HttpUtils.getPostResult(GitHubUrls.USER_INFO.getUrl(), params);
                System.out.print(gitHubUser);
                return gitHubUser;
            }
        } catch (IOException e) {
            Log.log("GitHub get request error.", e);
            throw new OAuthError();
        }
        throw new OAuthError();
    }

    public static class OAuthError extends Exception {
    }
}