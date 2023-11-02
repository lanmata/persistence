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
package com.prx.persistence.general.domains;

import com.prx.commons.enums.types.IdentificationType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

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
@Table(name = "identification_document", schema = "general")
public class IdentificationDocumentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private UUID id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;
    @Column(name = "identification_type")
    private IdentificationType identificationType;
    @ManyToOne(cascade = REFRESH, fetch = LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
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

    public Integer getNumber() {
        return this.number;
    }

    public LocalDateTime getExpirationDate() {
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

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
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
