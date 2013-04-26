package com.worksnet.model.oauth;

import com.worksnet.model.Model;
import com.worksnet.model.User;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 23:27
 */
@Entity
@Table(name = "oauth_data")
abstract public class BaseOAuth implements Model {
    @Id
    protected int id;

    //    @Column(nullable = false)
    @ManyToOne(targetEntity = User.class)
    protected int userId;

    @Column
    protected String OAuthId;

    abstract public String getProvider();

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

    @JsonProperty("id")
    public String getOAuthId() {
        return OAuthId;
    }

    @JsonProperty("id")
    public void setOAuthId(String OAuthId) {
        this.OAuthId = OAuthId;
    }
}
