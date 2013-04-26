package com.worksnet.model.oauth;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 23:28
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubAuth extends BaseOAuth {
    @Column(name = "github_login")
    protected String login;

    @Column
    @JsonProperty("avatar_url")
    protected String avatarUrl;

    @Column
    @JsonProperty("gravatar_id")
    protected String gravatarId;

    @Column
    @JsonProperty("url")
    protected String url;

    @Column
    @JsonProperty("name")
    protected String name;

    @Column
    @JsonProperty("email")
    protected String email;

    @Override
    public String getProvider() {
        return "github.com";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
