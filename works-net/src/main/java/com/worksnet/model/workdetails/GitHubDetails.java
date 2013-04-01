package com.worksnet.model.workdetails;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Max Levicky
 *         Date: 24.03.13
 *         Time: 13:02
 */
@Entity
public class GitHubDetails extends WorkDetail {
    @Column(name = "login")
    protected String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
