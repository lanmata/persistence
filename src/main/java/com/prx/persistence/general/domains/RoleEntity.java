/*
 * @(#)RolEntity.java.
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;

/**
 * Represents a role entity in the persistence layer.
 * This entity is mapped to the database table defined by {@link ConstantPersistenceApp#ROLE_TABLE_NAME}.
 * It contains information about the role such as its ID, name, description, and active status.
 * It also maintains a set of associated {@link ApplicationRoleUserEntity} and {@link RoleFeatureEntity} entities.
 *
 * @version 1.0.3.20200904-01, 18-01-2021
 */
@Entity
@Table(name = ConstantPersistenceApp.ROLE_TABLE_NAME, schema = ConstantPersistenceApp.SCHEMA_NAME)
public class RoleEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2457876775820934879L;

    /** The unique identifier for the role. */
    @Id
    @Column(name = ConstantPersistenceApp.ID_CN)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /** The name of the role. */
    @Size(min = 2, max = 20)
    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = ConstantPersistenceApp.NAME_CN, nullable = false)
    private String name;

    /** The description of the role. */
    @Size(min = 2, max = 250)
    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = ConstantPersistenceApp.DESCRIPTION_CN, nullable = false)
    private String description;

    /** The set of application role user entities associated with the role. */
    @OneToMany(mappedBy = "role", fetch = EAGER, cascade = {
            CascadeType.PERSIST
    })
    private Set<ApplicationRoleUserEntity> applicationRoleUser;

    /** The set of role feature entities associated with the role. */
    @OneToMany(mappedBy = ConstantPersistenceApp.ROLE_TABLE_NAME,
            fetch = EAGER,
            cascade = {
                    CascadeType.PERSIST
            })
    private Set<RoleFeatureEntity> roleFeatures;

    /** The active status of the role. */
    @Column(name = ConstantPersistenceApp.ACTIVE_CN)
    private boolean active;

    /**
     * Default constructor.
     */
    public RoleEntity() {
        // Default constructor.
    }

    /**
     * Gets the unique identifier for the role.
     *
     * @return the unique identifier for the role.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Gets the name of the role.
     *
     * @return the name of the role.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the description of the role.
     *
     * @return the description of the role.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the set of application role user entities associated with the role.
     *
     * @return the set of application role user entities associated with the role.
     */
    public Set<ApplicationRoleUserEntity> getApplicationRoleUser() {
        return this.applicationRoleUser;
    }

    /**
     * Gets the set of role feature entities associated with the role.
     *
     * @return the set of role feature entities associated with the role.
     */
    public Set<RoleFeatureEntity> getRoleFeatures() {
        return this.roleFeatures;
    }

    /**
     * Gets the active status of the role.
     *
     * @return the active status of the role.
     */
    public boolean isActive() {
        return this.active;
    }

    /**
     * Sets the unique identifier for the role.
     *
     * @param id the unique identifier for the role.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Sets the name of the role.
     *
     * @param name the name of the role.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of the role.
     *
     * @param description the description of the role.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the set of application role user entities associated with the role.
     *
     * @param applicationRoleUserEntities the set of application role user entities associated with the role.
     */
    public void setApplicationRoleUser(Set<ApplicationRoleUserEntity> applicationRoleUserEntities) {
        this.applicationRoleUser = applicationRoleUserEntities;
    }

    /**
     * Sets the set of role feature entities associated with the role.
     *
     * @param roleFeatures the set of role feature entities associated with the role.
     */
    public void setRoleFeatures(Set<RoleFeatureEntity> roleFeatures) {
        this.roleFeatures = roleFeatures;
    }

    /**
     * Sets the active status of the role.
     *
     * @param active the active status of the role.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Returns a string representation of the role entity.
     *
     * @return a string representation of the role entity.
     */
    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", applicationRoleUser=" + applicationRoleUser +
                ", roleFeatures=" + roleFeatures +
                ", active=" + active +
                '}';
    }
}
