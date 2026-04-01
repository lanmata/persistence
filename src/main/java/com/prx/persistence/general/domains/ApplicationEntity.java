/*
 *  @(#)ApplicationEntity.java
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
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import static com.prx.persistence.general.util.ConstantPersistenceApp.PG_UUID_FUNCTION;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * Represents an application entity in the persistence layer.
 * This entity is mapped to the database table defined by {@link ConstantPersistenceApp#APPLICATION_TABLE_NAME}.
 * It contains information about the application such as its ID, name, description, service type ID, and active status.
 * It also maintains a set of associated {@link ApplicationRoleUserEntity} entities.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 * @version 1.0.2.20200904-01, 2020-10-25
 */
@Entity
@Table(name = ConstantPersistenceApp.APPLICATION_TABLE_NAME, schema = ConstantPersistenceApp.SCHEMA_NAME)
public class ApplicationEntity implements Serializable {

    /** The unique identifier for the application. */
    @Id
    @Column(name = ConstantPersistenceApp.ID_CN)
    @ColumnDefault(PG_UUID_FUNCTION)
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    /** The name of the application. */
    @Column(name = ConstantPersistenceApp.NAME_CN)
    private String name;

    @Column(name = "code_name")
    private String codeName;

    /** The description of the application. */
    @Column(name = ConstantPersistenceApp.DESCRIPTION_CN)
    private String description;

    /** The service type ID associated with the application. */
    @Column(name = "service_type_id")
    private UUID serviceTypeId;

    /** The set of application role user entities associated with the application. */
    @OneToMany(mappedBy = "application", fetch = EAGER, cascade = {
            CascadeType.PERSIST
    })
    private Set<ApplicationRoleUserEntity> applicationRoleUser;

    /** The active status of the application. */
    @Column(name = ConstantPersistenceApp.ACTIVE_CN)
    private boolean active;

    /**
     * Default constructor.
     */
    public ApplicationEntity() {
        // ServiceEntity default constructor.
    }

    /**
     * Gets the unique identifier for the application.
     *
     * @return the unique identifier for the application.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Gets the name of the application.
     *
     * @return the name of the application.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the code name of the application.
     *
     * @return the code name of the application.
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * Gets the description of the application.
     *
     * @return the description of the application.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the service type ID associated with the application.
     *
     * @return the service type ID associated with the application.
     */
    public UUID getServiceTypeId() {
        return serviceTypeId;
    }

    /**
     * Gets the active status of the application.
     *
     * @return the active status of the application.
     */
    public boolean isActive() {
        return this.active;
    }

    /**
     * Sets the unique identifier for the application.
     *
     * @param id the unique identifier for the application.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Sets the name of the application.
     *
     * @param name the name of the application.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the code name of the application.
     *
     * @param codeName the code name to set for the application.
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * Sets the description of the application.
     *
     * @param description the description of the application.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the service type ID associated with the application.
     *
     * @param serviceTypeId the service type ID associated with the application.
     */
    public void setServiceTypeId(UUID serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    /**
     * Sets the active status of the application.
     *
     * @param active the active status of the application.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets the set of application role user entities associated with the application.
     *
     * @return the set of application role user entities associated with the application.
     */
    public Set<ApplicationRoleUserEntity> getApplicationRoleUser() {
        return applicationRoleUser;
    }

    /**
     * Sets the set of application role user entities associated with the application.
     *
     * @param applicationRoleUserEntities the set of application role user entities associated with the application.
     */
    public void setApplicationRoleUser(Set<ApplicationRoleUserEntity> applicationRoleUserEntities) {
        this.applicationRoleUser = applicationRoleUserEntities;
    }

    /**
     * Returns a string representation of the application entity.
     *
     * @return a string representation of the application entity.
     */
    @Override
    public String toString() {
        return "ServiceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", codeName='" + codeName + '\'' +
                ", description='" + description + '\'' +
                ", serviceTypeId=" + serviceTypeId +
                ", active=" + active +
                ", applicationRoleUser=" + applicationRoleUser +
                '}';
    }
}
