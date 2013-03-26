package com.worksnet.model.workdetails;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Max Levicky
 *         Date: 24.03.13
 *         Time: 13:02
 */
@Entity
@DiscriminatorValue(value = "2")
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
