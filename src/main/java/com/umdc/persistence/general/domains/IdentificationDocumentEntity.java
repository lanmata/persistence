/*
 *  @(#)IdentificationDocument.java
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
package com.umdc.persistence.general.domains;

import com.umdc.commons.constants.types.IdentificationType;
import com.umdc.persistence.general.util.ConstantPersistenceApp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import static com.umdc.persistence.general.util.ConstantPersistenceApp.PG_UUID_FUNCTION;
import static jakarta.persistence.CascadeType.REFRESH;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * IdentificationDocument.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 * @version 1.0.2.20200904-01, 2020-10-25
 */
@Entity
@Table(name = ConstantPersistenceApp.IDENTIFICATION_DOCUMENT_TABLE_NAME, schema = ConstantPersistenceApp.SCHEMA_NAME)
public class IdentificationDocumentEntity implements Serializable {

    @Id
    @Column(name = ConstantPersistenceApp.ID_CN)
    @ColumnDefault(PG_UUID_FUNCTION)
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    @NotNull
    @Size(max = 16)
    @Column(name = "number", nullable = false, length = 16)
    private String number;

    @NotNull
    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "identification_type", nullable = false)
    private IdentificationType identificationType;

    @NotNull
    @ManyToOne(cascade = REFRESH, fetch = LAZY, optional = false)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private PersonEntity person;

    /**
     * Default constructor.
     */
    public IdentificationDocumentEntity() {
        // Default constructor.
    }

    public UUID getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public IdentificationType getIdentificationType() {
        return this.identificationType;
    }

    public PersonEntity getPerson() {
        return this.person;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "IdentificationDocumentEntity{" +
                "id=" + id +
                ", number=" + number +
                ", expirationDate=" + expirationDate +
                ", identificationType=" + identificationType +
                ", person=" + person +
                '}';
    }
}
