/*
 *  @(#)PersonEntity.java
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

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;

/**
 * Service.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 * @version 1.0.2.20200904-01, 2020-10-25
 */
@Entity
@Table(name = ConstantPersistenceApp.PERSON_TABLE_NAME, schema = ConstantPersistenceApp.SCHEMA_NAME)
public class PersonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1884786506064757115L;

    @Id
    @Column(name = ConstantPersistenceApp.ID_CN)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "first_name", nullable = false)
    private String name;

    @Size(max = 20)
    @NotNull
    @Column(name = "middle_name")
    private String middleName;

    @NotEmpty
    @NotNull
    @Size(max = 20)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "gender", nullable = false)
    private String gender;

    @Past
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @OneToMany(mappedBy = "person", fetch = EAGER,
            cascade = {
                    CascadeType.ALL
            })
    private List<ContactEntity> contacts;

    /**
     * Default constructor.
     */
    public PersonEntity() {
        // Default constructor.
    }

    public UUID getId() {
        return this.id;
    }

    public @NotNull @Size(min = 2, max = 12) String getName() {
        return this.name;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public @NotNull @Size(min = 2, max = 12) String getLastName() {
        return this.lastName;
    }

    public @Size(max = 1) String getGender() {
        return this.gender;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public List<ContactEntity> getContacts() {
        return contacts;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(@NotNull @Size(min = 2, max = 12) String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(@NotNull @Size(min = 2, max = 12) String lastName) {
        this.lastName = lastName;
    }

    public void setGender(@Size(max = 1) String gender) {
        this.gender = gender;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                (contacts != null ? ", contacts=" + contacts : "") +
                '}';
    }
}
