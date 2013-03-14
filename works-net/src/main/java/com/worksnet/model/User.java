package com.worksnet.model;

import javax.persistence.*;
import java.util.Date;


/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 2:44 PM
 */
@Entity
@Table(name = "users")
public class User extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int id;

    @Column(name = "username", nullable = false, unique = true, length = 128)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true, length = 128)
    private String email;

    @Column(name = "birth", nullable = false)
    private Date birth;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User user = (User) object;
        return user.getId() == getId()
                && user.getEmail().equals(getEmail())
                && user.getName().equals(getName())
                && user.getBirth().equals(getBirth());
    }
}
