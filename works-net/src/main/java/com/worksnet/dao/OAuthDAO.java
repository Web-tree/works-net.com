package com.worksnet.dao;

import com.worksnet.model.User;
import com.worksnet.model.oauth.BaseOAuth;
import com.worksnet.model.oauth.GitHubAuth;
import com.worksnet.service.OAuthService;
import com.worksnet.service.UserService;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 23:41
 */
public class OAuthDAO extends BaseDAO<BaseOAuth> {

    @Autowired
    protected UserDAO userDAO;

    public int addGitHubAuth(GitHubAuth gitHubAuth) {
        return db.save(gitHubAuth);
    }

    public User getUserByGitHubAuth(GitHubAuth gitHubAuth) {
        return (User) db.createQuery("SELECT user FROM BaseOAuth WHERE oauthid = :id AND dtype = 'GitHubAuth'")
                .setParameter("id", gitHubAuth.getOAuthId())
                .uniqueResult();
    }

    public void addGitHubAuthWithNewUser(GitHubAuth gitHubAuth) {
        User user = UserService.createNewUser(OAuthService.generateLogin(gitHubAuth));
        user.setEnabled(true);
        Transaction transaction = db.beginTransaction();
        try {
            user.setId(userDAO.add(user));
            gitHubAuth.setUser(user);
            gitHubAuth.setId(addGitHubAuth(gitHubAuth));
            transaction.commit();
        } catch (Throwable e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    protected Class<BaseOAuth> getModelType() {
        return BaseOAuth.class;
    }

    @Override
    protected String getAllQuery() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
