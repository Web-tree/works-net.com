package com.worksnet.model;

import javax.persistence.*;

/**
 * User: maxim.levicky
 * Date: 4/18/13
 * Time: 3:37 PM
 */
@Entity
@Table(name = "persistent_logins")
public class PersistentLogin {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String username;

    @Column
    private String series;

    @Column
    private String token;

    @Column
    private String last_used;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLast_used() {
        return last_used;
    }

    public void setLast_used(String last_used) {
        this.last_used = last_used;
    }
}
