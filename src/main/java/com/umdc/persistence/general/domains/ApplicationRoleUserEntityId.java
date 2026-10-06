
/*
 *
 *  @(#)ApplicationRoleUserEntityId.java
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
package com.umdc.persistence.general.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents the composite primary key for the ApplicationRoleUserEntity.
 * This class is embeddable and contains the user ID, role ID, and application ID.
 * It implements Serializable for persistence purposes.
 */
@Embeddable
public class ApplicationRoleUserEntityId implements Serializable {
    @Serial
    private static final long serialVersionUID = 5847441516417564088L;

    /** The user ID associated with the role and application. */
    @NotNull
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    /** The role ID associated with the user and application. */
    @NotNull
    @Column(name = "role_id", nullable = false)
    private UUID roleId;

    /** The application ID associated with the user and role. */
    @NotNull
    @Column(name = "application_id", nullable = false)
    private UUID applicationId;

    /**
     * Default constructor.
     */
    public ApplicationRoleUserEntityId() {
        // Default constructor
    }

    /**
     * Gets the user ID associated with the role and application.
     *
     * @return the user ID.
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Sets the user ID associated with the role and application.
     *
     * @param userId the user ID.
     */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /**
     * Gets the role ID associated with the user and application.
     *
     * @return the role ID.
     */
    public UUID getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID associated with the user and application.
     *
     * @param roleId the role ID.
     */
    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the application ID associated with the user and role.
     *
     * @return the application ID.
     */
    public UUID getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the application ID associated with the user and role.
     *
     * @param applicationId the application ID.
     */
    public void setApplicationId(UUID applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Checks if this object is equal to another object.
     * Two ApplicationRoleUserEntityId objects are considered equal if their user ID, role ID, and application ID are the same.
     *
     * @param o the object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ApplicationRoleUserEntityId entity = (ApplicationRoleUserEntityId) o;
        return Objects.equals(this.roleId, entity.roleId) &&
                Objects.equals(this.applicationId, entity.applicationId) &&
                Objects.equals(this.userId, entity.userId);
    }

    /**
     * Returns the hash code of this object.
     * The hash code is computed based on the user ID, role ID, and application ID.
     *
     * @return the hash code of this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(roleId, applicationId, userId);
    }
}
