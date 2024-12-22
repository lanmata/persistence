/*
 *  @(#)UserEntity.java
 *
 *  Copyright (c) Luis Antonio Mata Mata. All rights reserved.
 *
 *  All rights to this product are owned by Luis Antonio Mata Mata and may only
 *  be used under the terms of its associated license document. You may NOT
 *  copy, modify, sublicense, or distribute this source file or portions of
 *  it unless previously authorized in writing by Luis Antonio Mata Mata.
 *  In any event, this notice and the above copyright must always be included
 *  verbatim with this file.
 */
package com.prx.persistence.general.domains;

import com.prx.persistence.general.util.ConstantPersistenceApp;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;

/**
 * Represents a user entity in the persistence layer.
 * This entity is mapped to the database table defined by {@link ConstantPersistenceApp#USER_TABLE_NAME}.
 * It contains information about the user such as their ID, alias, password, email, active status, created date, and last update.
 * It also maintains a reference to the associated {@link PersonEntity} and a set of associated {@link ApplicationRoleUserEntity} entities.
 *
 * @version 1.0.2.20200904-01, 2020-10-25
 */
@Entity
@Table(name = ConstantPersistenceApp.USER_TABLE_NAME, schema = ConstantPersistenceApp.SCHEMA_NAME)
public class UserEntity implements Serializable {

    /** The unique identifier for the user. */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = ConstantPersistenceApp.ID_CN)
    private UUID id;

    /** The alias of the user. */
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 5, max = 12)
    @Column(name = "alias", nullable = false, unique = true)
    private String alias;

    /** The password of the user. */
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 5, max = 250)
    @Column(name = "password", nullable = false)
    private String password;

    /** The email account of the user. */
    @Email
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 5, max = 250)
    @Column(name = "email_account", nullable = false)
    private String email;

    /** The active status of the user. */
    @NotNull
    @Column(name = ConstantPersistenceApp.ACTIVE_CN, nullable = false)
    private Boolean active = false;

    /** The date when the user was created. */
    @NotNull
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    /** The date when the user was last updated. */
    @NotNull
    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    /** The person entity associated with the user. */
    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonEntity person;

    /** The set of application role user entities associated with the user. */
    @OneToMany(mappedBy = ConstantPersistenceApp.USER_TABLE_NAME)
    private Set<ApplicationRoleUserEntity> applicationRoleUser;

    /**
     * Default constructor.
     */
    public UserEntity() {
        // Empty constructor
    }

    /**
     * Gets the unique identifier for the user.
     *
     * @return the unique identifier for the user.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Gets the alias of the user.
     *
     * @return the alias of the user.
     */
    public @NotNull @Size(max = 12) String getAlias() {
        return this.alias;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user.
     */
    public @NotNull @Size(max = 250) String getPassword() {
        return this.password;
    }

    /**
     * Gets the date when the user was created.
     *
     * @return the date when the user was created.
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Gets the date when the user was last updated.
     *
     * @return the date when the user was last updated.
     */
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Gets the active status of the user.
     *
     * @return the active status of the user.
     */
    public @NotNull Boolean getActive() {
        return this.active;
    }

    /**
     * Gets the person entity associated with the user.
     *
     * @return the person entity associated with the user.
     */
    public PersonEntity getPerson() {
        return this.person;
    }

    /**
     * Gets the set of application role user entities associated with the user.
     *
     * @return the set of application role user entities associated with the user.
     */
    public Set<ApplicationRoleUserEntity> getApplicationRoleUser() {
        return this.applicationRoleUser;
    }

    /**
     * Sets the unique identifier for the user.
     *
     * @param id the unique identifier for the user.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Sets the alias of the user.
     *
     * @param alias the alias of the user.
     */
    public void setAlias(@NotNull @Size(max = 12) String alias) {
        this.alias = alias;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password of the user.
     */
    public void setPassword(@NotNull @Size(max = 250) String password) {
        this.password = password;
    }

    /**
     * Sets the date when the user was created.
     *
     * @param createdDate the date when the user was created.
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Sets the date when the user was last updated.
     *
     * @param lastUpdateDate the date when the user was last updated.
     */
    public void setLastUpdate(LocalDateTime lastUpdateDate) {
        this.lastUpdate = lastUpdateDate;
    }

    /**
     * Sets the active status of the user.
     *
     * @param active the active status of the user.
     */
    public void setActive(@NotNull Boolean active) {
        this.active = active;
    }

    /**
     * Sets the person entity associated with the user.
     *
     * @param person the person entity associated with the user.
     */
    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    /**
     * Sets the set of application role user entities associated with the user.
     *
     * @param userRole the set of application role user entities associated with the user.
     */
    public void setApplicationRoleUser(Set<ApplicationRoleUserEntity> userRole) {
        this.applicationRoleUser = userRole;
    }

    /**
     * Gets the email account of the user.
     *
     * @return the email account of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email account of the user.
     *
     * @param email the email account of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the user entity.
     *
     * @return a string representation of the user entity.
     */
    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", active=" + active +
                ", person=" + person +
                ", applicationRoleUser=" + applicationRoleUser +
                '}';
    }
}
