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

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * Service.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 * @version 1.0.2.20200904-01, 2020-10-25
 */
@Entity
@Table(name = "person", schema = "general")
public class PersonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1884786506064757115L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private UUID id;
    @NotNull
    @Size(min = 2, max = 12)
    @Column(name = "first_name")
    private String name;
    @Column(name = "middle_name")
    private String middleName;
    @NotNull
    @Size(min = 2, max = 12)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 1)
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthdate")
    private LocalDate birthdate;

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

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
