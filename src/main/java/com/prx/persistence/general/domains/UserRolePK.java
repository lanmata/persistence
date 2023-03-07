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

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * UserRolPK.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
@Embeddable
public class UserRolePK implements Serializable {
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleEntity role;

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
        return user.equals(userRolePK.user) && role.equals(userRolePK.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, role);
    }

    public UserEntity getUser() {
        return this.user;
    }

    public RoleEntity getRole() {
        return this.role;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRolePK{" +
                "user=" + user +
                ", role=" + role +
                '}';
    }
}
