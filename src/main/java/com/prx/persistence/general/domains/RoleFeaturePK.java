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

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * RolFeaturePK.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
@Embeddable
public class RoleFeaturePK implements Serializable {
    private Long role;
    private Long feature;

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
        return role.equals(that.role) && feature.equals(that.feature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, feature);
    }

    public Long getRole() {
        return this.role;
    }

    public Long getFeature() {
        return this.feature;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public void setFeature(Long feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        return "RoleFeaturePK{" +
                "role=" + role +
                ", feature=" + feature +
                '}';
    }
}
