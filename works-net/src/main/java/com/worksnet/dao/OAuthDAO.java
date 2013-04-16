package com.worksnet.dao;

import com.worksnet.model.oauth.BaseOAuth;
import com.worksnet.model.oauth.GitHubAuth;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 23:41
 */
public class OAuthDAO extends BaseDAO<BaseOAuth> {


    public void addGitHubAuth(GitHubAuth gitHubAuth) {
        db.save(gitHubAuth);
    }

    @Override
    protected Class<BaseOAuth> getClassType() {
        return BaseOAuth.class;
    }

    @Override
    protected String getAllQuery() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
