/*
 *  @(#)ContactEntity.java
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

import java.io.Serializable;
import java.util.UUID;

import static jakarta.persistence.CascadeType.REFRESH;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * ContactEntity.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 * @version 1.0.2.20200904-01, 2020-10-25
 */
@Entity
@Table(name = "contact", schema = "general")
public class ContactEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private UUID id;
    @Column(name = "content")
    private String content;
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "contact_type_id", referencedColumnName = "id")
    private ContactTypeEntity contactType;
    @Column(name = "active")
    private Boolean active;
    @ManyToOne(cascade = REFRESH, fetch = LAZY)
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    /**
     * Default constructor.
     */
    public ContactEntity() {
        // Default constructor.
    }

    public UUID getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public ContactTypeEntity getContactType() {
        return this.contactType;
    }

    public Boolean getActive() {
        return this.active;
    }

    public PersonEntity getPerson() {
        return this.person;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContactType(ContactTypeEntity contactType) {
        this.contactType = contactType;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contactType=" + contactType +
                ", active=" + active +
                ", person=" + person +
                '}';
    }
}
