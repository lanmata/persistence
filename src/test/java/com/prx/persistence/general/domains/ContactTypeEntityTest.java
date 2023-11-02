/*
 * @(#)TestContactTypeEntity.java.
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * TestContactTypeEntity.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
class ContactTypeEntityTest {

    @Test
    void gettersAndSetters() {
        final var contactTypeEntity = new ContactTypeEntity();
        contactTypeEntity.setId(UUID.fromString("072b1d5c-993e-43b3-b084-4c9ec4b3aa79"));
        contactTypeEntity.setName("Contact type 0001");
        contactTypeEntity.setDescription("Contact type description");
        contactTypeEntity.setActive(true);

        Assertions.assertAll("Test Getters And Setters",
                () -> Assertions.assertNotNull(contactTypeEntity.getId()),
                () -> Assertions.assertNotNull(contactTypeEntity.getName()),
                () -> Assertions.assertNotNull(contactTypeEntity.getDescription()),
                () -> Assertions.assertNotNull(contactTypeEntity.toString()),
                () -> Assertions.assertTrue(contactTypeEntity.isActive()),
                () -> Assertions.assertNotEquals(1, contactTypeEntity.hashCode()),
                () -> Assertions.assertNotEquals(new ContactTypeEntity(), contactTypeEntity)
        );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ContactTypeEntity}
     *   <li>{@link ContactTypeEntity#setActive(boolean)}
     *   <li>{@link ContactTypeEntity#setDescription(String)}
     *   <li>{@link ContactTypeEntity#setId(UUID)}
     *   <li>{@link ContactTypeEntity#setName(String)}
     *   <li>{@link ContactTypeEntity#toString()}
     *   <li>{@link ContactTypeEntity#getDescription()}
     *   <li>{@link ContactTypeEntity#getId()}
     *   <li>{@link ContactTypeEntity#getName()}
     *   <li>{@link ContactTypeEntity#isActive()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ContactTypeEntity actualContactTypeEntity = new ContactTypeEntity();
        actualContactTypeEntity.setActive(true);
        actualContactTypeEntity.setDescription("The characteristics of someone or something");
        actualContactTypeEntity.setId(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"));
        actualContactTypeEntity.setName("Name");
        String actualToStringResult = actualContactTypeEntity.toString();
        assertEquals("The characteristics of someone or something", actualContactTypeEntity.getDescription());
        assertEquals(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"), actualContactTypeEntity.getId());
        assertEquals("Name", actualContactTypeEntity.getName());
        assertTrue(actualContactTypeEntity.isActive());
        assertEquals("ContactTypeEntity{id=849a7d96-5fda-413c-9926-41f660078e76, name='Name', description='The characteristics of someone or something',"
                + " active=true}", actualToStringResult);
    }

}
