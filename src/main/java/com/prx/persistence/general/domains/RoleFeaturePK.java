/*
 * @(#)RolFeaturePK.java.
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

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * RolFeaturePK.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
@Embeddable
public class RoleFeaturePK implements Serializable {

    @Serial
    private static final long serialVersionUID = 6017520908402540913L;

    @Column(name = "role_id")
    private UUID roleId;

    @Column(name = "feature_id")
    private UUID featureId;

    /**
     * Default constructor.
     */
    public RoleFeaturePK() {
        // Default constructor.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleFeaturePK that = (RoleFeaturePK) o;
        return roleId.equals(that.roleId) && featureId.equals(that.featureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, featureId);
    }

    public UUID getRoleId() {
        return this.roleId;
    }

    public UUID getFeatureId() {
        return this.featureId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public void setFeatureId(UUID featureId) {
        this.featureId = featureId;
    }

    @Override
    public String toString() {
        return "RoleFeaturePK{" +
                "role=" + roleId +
                ", feature=" + featureId +
                '}';
    }
}
