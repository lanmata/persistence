/*
 * @(#)UserRolPk.java.
 *
 * Copyright (c) Luis Antonio Mata Mata. All rights reserved.
 *
 * All rights to this product are owned by Luis Antonio Mata Mata and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by Luis Antonio Mata Mata.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.prx.persistence.general.domains;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * UserRolPk.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
@Entity
@Table(name = "user_role", schema = "general")
public class UserRoleEntity implements Serializable {

    @EmbeddedId
    private UserRolePK userRolePK;

    @ManyToOne
    @MapsId("user")
    private UserEntity user;

    @ManyToOne
    @MapsId("role")
    private RoleEntity role;

    @Column(name = "active")
    private Boolean active;

    /**
     *
     */
    public UserRoleEntity() {
        // Default constructor.
    }

    public UserRolePK getUserRolePK() {
        return userRolePK;
    }

    public void setUserRolePK(UserRolePK userRolePK) {
        this.userRolePK = userRolePK;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public RoleEntity getRole() {
        return this.role;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "userRolePK=" + userRolePK +
                "user=" + user +
                ", role=" + role +
                ", active=" + active +
                '}';
    }
}
