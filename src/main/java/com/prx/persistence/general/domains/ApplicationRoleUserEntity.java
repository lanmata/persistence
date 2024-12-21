/*
 *
 *  @(#)ApplicationRoleUserEntity.java
 *
 *  Copyright (c) Luis Antonio Mata Mata. All rights reserved.
 *
 *   All rights to this product are owned by Luis Antonio Mata Mata and may only
 *  be used under the terms of its associated license document. You may NOT
 *  copy, modify, sublicense, or distribute this source file or portions of
 *  it unless previously authorized in writing by Luis Antonio Mata Mata.
 *  In any event, this notice and the above copyright must always be included
 *  verbatim with this file.
 *
 */
package com.prx.persistence.general.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import static com.prx.persistence.general.util.ConstantPersistenceApp.APPLICATION_ROLE_USER_TABLE_NAME;
import static com.prx.persistence.general.util.ConstantPersistenceApp.SCHEMA_NAME;

/**
 * Represents the association between an application, a role, and a user.
 * This entity is mapped to the database table "application_role_user" in the "general" schema.
 * It contains information about the user, role, application, and active status.
 * The primary key is a composite key represented by {@link ApplicationRoleUserEntityId}.
 *
 * @version 1.0
 */
@Entity
@Table(name = APPLICATION_ROLE_USER_TABLE_NAME, schema = SCHEMA_NAME)
public class ApplicationRoleUserEntity {

    /** The composite primary key for the entity. */
    @EmbeddedId
    private ApplicationRoleUserEntityId id;

    /** The user associated with the role and application. */
    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    /** The role associated with the user and application. */
    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    /** The application associated with the user and role. */
    @MapsId("applicationId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private ApplicationEntity application;

    /** The active status of the association. */
    @NotNull
    @ColumnDefault("false")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    /**
     * Default constructor.
     */
    public ApplicationRoleUserEntity() {
        // Default constructor
    }

    /**
     * Gets the composite primary key for the entity.
     *
     * @return the composite primary key.
     */
    public ApplicationRoleUserEntityId getId() {
        return id;
    }

    /**
     * Sets the composite primary key for the entity.
     *
     * @param id the composite primary key.
     */
    public void setId(ApplicationRoleUserEntityId id) {
        this.id = id;
    }

    /**
     * Gets the user associated with the role and application.
     *
     * @return the user.
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * Sets the user associated with the role and application.
     *
     * @param user the user.
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }

    /**
     * Gets the role associated with the user and application.
     *
     * @return the role.
     */
    public RoleEntity getRole() {
        return role;
    }

    /**
     * Sets the role associated with the user and application.
     *
     * @param role the role.
     */
    public void setRole(RoleEntity role) {
        this.role = role;
    }

    /**
     * Gets the application associated with the user and role.
     *
     * @return the application.
     */
    public ApplicationEntity getApplication() {
        return application;
    }

    /**
     * Sets the application associated with the user and role.
     *
     * @param application the application.
     */
    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }

    /**
     * Gets the active status of the association.
     *
     * @return the active status.
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the active status of the association.
     *
     * @param active the active status.
     */
    public void setActive(Boolean active) {
        this.active = active;
    }
}
