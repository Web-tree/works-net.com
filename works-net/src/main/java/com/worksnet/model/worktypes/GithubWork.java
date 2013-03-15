package com.worksnet.model.worktypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.worksnet.model.BaseModel;

/**
 * @author maxim.levicky
 *         Date: 3/12/13
 *         Time: 11:18 AM
 */
@Entity
public class GithubWork extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "github_login")
    private String githubLogin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGithubLogin() {
        return githubLogin;
    }

    public void setGithubLogin(String githubLogin) {
        this.githubLogin = githubLogin;
    }
}
