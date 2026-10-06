/*
 * @(#)FeatureEntity.java.
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

package com.umdc.persistence.general.domains;

import com.umdc.persistence.general.util.ConstantPersistenceApp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import static com.umdc.persistence.general.util.ConstantPersistenceApp.PG_UUID_FUNCTION;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * FeatureEntity.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
@Entity
@Table(name = ConstantPersistenceApp.FEATURE_TABLE_NAME, schema = ConstantPersistenceApp.SCHEMA_NAME)
public class FeatureEntity implements Serializable {

    @Id
    @Column(name = ConstantPersistenceApp.ID_CN)
    @ColumnDefault(PG_UUID_FUNCTION)
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    @Size(min = 2, max = 20)
    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = ConstantPersistenceApp.NAME_CN, nullable = false)
    private String name;

    @Size(max = 250)
    @Column(name = ConstantPersistenceApp.DESCRIPTION_CN)
    private String description;

    @Column(name = ConstantPersistenceApp.ACTIVE_CN, nullable = false)
    private Boolean active = false;

    @OneToMany(mappedBy = ConstantPersistenceApp.FEATURE_TABLE_NAME,
        fetch = EAGER,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    private transient Set<RoleFeatureEntity> rolFeatures;

    /**
     * Default constructor.
     */
    public FeatureEntity() {
        // Default constructor.
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Set<RoleFeatureEntity> getRolFeatures() {
        return this.rolFeatures;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setRolFeatures(Set<RoleFeatureEntity> rolFeatures) {
        this.rolFeatures = rolFeatures;
    }

    @Override
    public String toString() {
        return "FeatureEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", rolFeatures=" + rolFeatures +
                '}';
    }
}
