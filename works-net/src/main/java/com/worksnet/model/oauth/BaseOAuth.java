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
@DiscriminatorColumn(name = "dtype")
@Table(name = "oauth_data")
abstract public class BaseOAuth implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @PrimaryKeyJoinColumn
    protected User user;

    @Column
    protected String OAuthId;

    @Column(name = "dtype", nullable = false, insertable = false, updatable = false)
    protected String dtype;

    abstract public String getProvider();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("id")
    public String getOAuthId() {
        return OAuthId;
    }

    @JsonProperty("id")
    public void setOAuthId(String OAuthId) {
        this.OAuthId = OAuthId;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String type) {
        this.dtype = type;
    }
}
