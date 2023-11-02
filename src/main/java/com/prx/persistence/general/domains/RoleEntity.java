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
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * RolEntity.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
@Entity
@Table(name = "role", schema = "general")
public class RoleEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2457876775820934879L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "role")
    private Set<UserRoleEntity> userRoleEntities;

    @OneToMany(mappedBy = "role",
            fetch = EAGER,
            cascade = {
                    CascadeType.PERSIST
            })
    private Set<RoleFeatureEntity> roleFeatures;

    @Column(name = "active")
    private boolean active;

    /**
     * Default constructor.
     */
    public RoleEntity() {
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

    public Set<UserRoleEntity> getUserRoleEntities() {
        return this.userRoleEntities;
    }

    public Set<RoleFeatureEntity> getRoleFeatures() {
        return this.roleFeatures;
    }

    public boolean isActive() {
        return this.active;
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

    public void setUserRoleEntities(Set<UserRoleEntity> userRoleEntities) {
        this.userRoleEntities = userRoleEntities;
    }

    public void setRoleFeatures(Set<RoleFeatureEntity> roleFeatures) {
        this.roleFeatures = roleFeatures;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userRoleEntities=" + userRoleEntities +
                ", roleFeatures=" + roleFeatures +
                ", active=" + active +
                '}';
    }
}
