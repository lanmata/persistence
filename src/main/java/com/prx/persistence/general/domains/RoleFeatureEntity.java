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

import com.prx.persistence.general.util.ConstantPersistenceApp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

/**
 * RolFeatureEntity.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
@Entity
@Table(name = ConstantPersistenceApp.ROLE_FEATURE_TABLE_NAME, schema = ConstantPersistenceApp.SCHEMA_NAME)
public class RoleFeatureEntity {
    @EmbeddedId
    private RoleFeaturePK roleFeaturePK;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    @MapsId("featureId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "feature_id", nullable = false)
    private FeatureEntity feature;

    @NotNull
    @ColumnDefault("false")
    @Column(name = ConstantPersistenceApp.ACTIVE_CN, nullable = false)
    private Boolean active = false;

    public RoleFeatureEntity() {
        // Default Constructor
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
