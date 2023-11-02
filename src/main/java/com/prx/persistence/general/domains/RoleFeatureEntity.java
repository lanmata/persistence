/*
 * @(#)RolFeatureEntity.java.
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
 * RolFeatureEntity.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
@Entity
@Table(name = "role_feature", schema = "general")
public class RoleFeatureEntity implements Serializable {

    @EmbeddedId
    private RoleFeaturePK roleFeaturePK;

    @ManyToOne
    @MapsId("role")
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToOne
    @MapsId("feature")
    @JoinColumn(name = "feature_id")
    private FeatureEntity feature;

    @Column(name = "active")
    private Boolean active;

    /**
     * Default constructor.
     */
    public RoleFeatureEntity() {
        // Default constructor.
    }

    public RoleFeaturePK getRoleFeaturePK() {
        return roleFeaturePK;
    }

    public void setRoleFeaturePK(RoleFeaturePK roleFeaturePK) {
        this.roleFeaturePK = roleFeaturePK;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public FeatureEntity getFeature() {
        return feature;
    }

    public void setFeature(FeatureEntity feature) {
        this.feature = feature;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "RoleFeatureEntity{" +
                "role=" + role +
                ", feature=" + feature +
                ", active=" + active +
                '}';
    }
}
