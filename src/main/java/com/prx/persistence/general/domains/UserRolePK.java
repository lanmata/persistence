/*
 * @(#)UserRolPK.java.
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

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * UserRolPK.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
@Embeddable
public class UserRolePK implements Serializable {

    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "role_id")
    private UUID roleId;

    /**
     * Default constructor.
     */
    public UserRolePK() {
        // Default constructor.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRolePK userRolePK = (UserRolePK) o;
        return userId.equals(userRolePK.userId) && roleId.equals(userRolePK.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }

    public UUID getUserId() {
        return this.userId;
    }

    public UUID getRoleId() {
        return this.roleId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRolePK{" +
                "user=" + userId +
                ", role=" + roleId +
                '}';
    }
}
