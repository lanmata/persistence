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
@IdClass(RoleFeaturePK.class)
@Table(name = "role_feature", schema = "general")
public class RoleFeatureEntity implements Serializable {

    @Id
    @Column(name = "role_id")
    private Long role;
    @Id
    @Column(name = "feature_id")
    private Long feature;
    @Column(name = "active")
    private Boolean active;

    /**
     * Default constructor.
     */
    public RoleFeatureEntity() {
        // Default constructor.
    }

    public Long getRole() {
        return this.role;
    }

    public Long getFeature() {
        return this.feature;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public void setFeature(Long feature) {
        this.feature = feature;
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
