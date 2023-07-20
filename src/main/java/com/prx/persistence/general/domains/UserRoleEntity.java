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
    @MapsId("user_id")
    private UserEntity userId;

    @ManyToOne
    @MapsId("role_id")
    private RoleEntity roleId;

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

    public UserEntity getUserId() {
        return this.userId;
    }

    public RoleEntity getRoleId() {
        return this.roleId;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public void setRoleId(RoleEntity roleId) {
        this.roleId = roleId;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "userRolePK=" + userRolePK +
                "user=" + userId +
                ", role=" + roleId +
                ", active=" + active +
                '}';
    }
}
