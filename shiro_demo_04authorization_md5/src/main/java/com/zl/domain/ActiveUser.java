package com.zl.domain;

import java.util.List;

public class ActiveUser {
    private User user;
    private List<String> roles;
    private List<String> permissions;

    public ActiveUser(User user, List<String> roles, List<String> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermission(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "ActiveUser{" +
                "user=" + user +
                ", roles=" + roles +
                ", permission=" + permissions +
                '}';
    }
}
