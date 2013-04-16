package com.worksnet.model.oauth;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 23:28
 */
@Entity
public class GitHubAuth extends BaseOAuth {
    @Column(name = "github_login")
    protected String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
