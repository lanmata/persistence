/*
 * @(#)ServiceTypeEntityTest.java.
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
package com.umdc.persistence.general.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ServiceTypeEntityTest.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
class ServiceTypeEntityTest {

    @Test
    void gettersAndSetters() {
        final var serviceTypeEntity = new ServiceTypeEntity();
        serviceTypeEntity.setId(UUID.fromString("072b1d5c-993e-43b3-b084-4c9ec4b3aa79"));
        serviceTypeEntity.setName("Service type 0001");
        serviceTypeEntity.setDescription("Service type description");
        serviceTypeEntity.setActive(true);

        Assertions.assertAll("Test Getters And Setters",
                () -> Assertions.assertNotNull(serviceTypeEntity.getId()),
                () -> Assertions.assertNotNull(serviceTypeEntity.getName()),
                () -> Assertions.assertNotNull(serviceTypeEntity.getDescription()),
                () -> Assertions.assertNotNull(serviceTypeEntity.toString()),
                () -> Assertions.assertTrue(serviceTypeEntity.isActive()),
                () -> Assertions.assertNotEquals(1, serviceTypeEntity.hashCode()),
                () -> Assertions.assertNotEquals(new ServiceTypeEntity(), serviceTypeEntity)
        );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ServiceTypeEntity}
     *   <li>{@link ServiceTypeEntity#setActive(boolean)}
     *   <li>{@link ServiceTypeEntity#setDescription(String)}
     *   <li>{@link ServiceTypeEntity#setId(UUID)}
     *   <li>{@link ServiceTypeEntity#setName(String)}
     *   <li>{@link ServiceTypeEntity#toString()}
     *   <li>{@link ServiceTypeEntity#getDescription()}
     *   <li>{@link ServiceTypeEntity#getId()}
     *   <li>{@link ServiceTypeEntity#getName()}
     *   <li>{@link ServiceTypeEntity#isActive()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ServiceTypeEntity actualServiceTypeEntity = new ServiceTypeEntity();
        actualServiceTypeEntity.setActive(true);
        actualServiceTypeEntity.setDescription("The kind of service being offered");
        actualServiceTypeEntity.setId(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"));
        actualServiceTypeEntity.setName("Name");
        String actualToStringResult = actualServiceTypeEntity.toString();
        assertEquals("The kind of service being offered", actualServiceTypeEntity.getDescription());
        assertEquals(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"), actualServiceTypeEntity.getId());
        assertEquals("Name", actualServiceTypeEntity.getName());
        assertTrue(actualServiceTypeEntity.isActive());
        assertEquals("ServiceTypeEntity{active=true, id=849a7d96-5fda-413c-9926-41f660078e76, description='The kind of service being offered',"
                + " name='Name'}", actualToStringResult);
    }

}
