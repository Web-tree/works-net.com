package com.worksnet.model.oauth;

import com.worksnet.model.Model;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 23:27
 */
@Entity
@Table(name = "oauth_data")
public class BaseOAuth implements Model {
    @Id
    protected int id;

    @Column
    protected int userId;

    @Column
    @JsonProperty("id")
    protected String OAuthId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOAuthId() {
        return OAuthId;
    }

    public void setOAuthId(String OAuthId) {
        this.OAuthId = OAuthId;
    }
}
