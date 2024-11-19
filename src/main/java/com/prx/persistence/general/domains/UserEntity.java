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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;

/**
 * UserEntity.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 * @version 1.0.2.20200904-01, 2020-10-25
 */
@Entity
@Table(name = ConstantPersistenceApp.USER_TABLE_NAME, schema = ConstantPersistenceApp.SCHEMA_NAME)
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = ConstantPersistenceApp.ID_CN)
    private UUID id;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 5, max = 12)
    @Column(name = "alias", nullable = false, unique = true)
    private String alias;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 5, max = 250)
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = ConstantPersistenceApp.ACTIVE_CN, nullable = false)
    private Boolean active = false;

    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonEntity person;

    @OneToMany(mappedBy = ConstantPersistenceApp.USER_TABLE_NAME)
    private Set<UserRoleEntity> userRole;

    /**
     * Default constructor.
     */
    public UserEntity() {
        // Empty constructor
    }

    public UUID getId() {
        return this.id;
    }

    public @NotNull @Size(max = 12) String getAlias() {
        return this.alias;
    }

    public @NotNull @Size(max = 250) String getPassword() {
        return this.password;
    }

    public @NotNull Boolean getActive() {
        return this.active;
    }

    public PersonEntity getPerson() {
        return this.person;
    }

    public Set<UserRoleEntity> getUserRole() {
        return this.userRole;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAlias(@NotNull @Size(max = 12) String alias) {
        this.alias = alias;
    }

    public void setPassword(@NotNull @Size(max = 250) String password) {
        this.password = password;
    }

    public void setActive(@NotNull Boolean active) {
        this.active = active;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public void setUserRole(Set<UserRoleEntity> userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", person=" + person +
                ", userRole=" + userRole +
                '}';
    }
}
