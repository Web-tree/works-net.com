package com.worksnet.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.Email;
import org.hibernate.validator.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 2:44 PM
 */
@Entity
@Table(name = "user")
public class User extends BaseModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    protected int id;

    @Column(name = "username", nullable = false, unique = true, length = 128)
    @Size(min = 3, max = 50)
    protected String userName;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Size(min = 6, max = 20)
    protected String password;

    @Column(name = "email", nullable = false, unique = true, length = 128)
    @NotEmpty
    @Email
    protected String email;

    @Column(name = "enabled", nullable = false)
    protected boolean enabled = false;

    @Column(name = "account_non_expired")
    protected boolean accountNonExpired = true;

    @Column(name = "account_non_locked")
    protected boolean accountNonLocked = true;

    @Column(name = "auth_role")
    protected int authRole = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                String authority;
                switch (authRole) {
                    case 1:
                        authority = "ROLE_USER";
                        break;
                    case 2:
                        authority = "ROLE_ADMIN";
                        break;
                    default:
                        authority = "ROLE_ANONYMOUS";
                }
                return authority;
            }
        });
        return auth;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getAuthRole() {
        return authRole;
    }

    public void setAuthRole(int authRole) {
        this.authRole = authRole;
    }
}
