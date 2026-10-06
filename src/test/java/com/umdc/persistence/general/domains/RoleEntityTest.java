/*
 * @(#)RolEntityTest.java.
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

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RolEntityTest.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
class RoleEntityTest {

    @Test
    void gettersAndSetters() {
        final var roleEntity = new RoleEntity();
        final var roleFeatureEntities = new HashSet<RoleFeatureEntity>();
        final var applicationRoleUserEntities = new HashSet<ApplicationRoleUserEntity>();

        final var applicationEntity = new ApplicationEntity();
        applicationEntity.setId(UUID.fromString("2f6a6f0d-6b0a-4d13-9d3d-4a5c6d7e8f90"));

        roleEntity.setId(UUID.fromString("f12dab93-0ea0-414e-a062-568f88af49cb"));
        roleEntity.setName("Rol 0001");
        roleEntity.setDescription("Description rol");
        roleEntity.setActive(true);
        roleEntity.setRoleFeatures(roleFeatureEntities);
        roleEntity.setApplicationRoleUser(applicationRoleUserEntities);
        roleEntity.setApplication(applicationEntity);

        Assertions.assertAll("Test Getters and Setters",
                () -> Assertions.assertNotNull(roleEntity.getId()),
                () -> Assertions.assertNotNull(roleEntity.getName()),
                () -> Assertions.assertNotNull(roleEntity.getDescription()),
                () -> Assertions.assertTrue(roleEntity.isActive()),
                () -> Assertions.assertNotNull(roleEntity.getRoleFeatures()),
                () -> Assertions.assertNotNull(roleEntity.getApplicationRoleUser()),
                () -> Assertions.assertNotNull(roleEntity.getApplication()),
                () -> Assertions.assertNotNull(roleEntity.toString()),
                () -> Assertions.assertNotEquals(1, roleEntity.hashCode()),
                () -> Assertions.assertNotEquals(new RoleEntity(), roleEntity)
        );

    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link RoleEntity}
     *   <li>{@link RoleEntity#setActive(boolean)}
     *   <li>{@link RoleEntity#setDescription(String)}
     *   <li>{@link RoleEntity#setId(UUID)}
     *   <li>{@link RoleEntity#setName(String)}
     *   <li>{@link RoleEntity#setRoleFeatures(Set)}
     *   <li>{@link RoleEntity#setApplicationRoleUser(Set)}}
     *   <li>{@link RoleEntity#toString()}
     *   <li>{@link RoleEntity#getDescription()}
     *   <li>{@link RoleEntity#getId()}
     *   <li>{@link RoleEntity#getName()}
     *   <li>{@link RoleEntity#getRoleFeatures()}
     *   <li>{@link RoleEntity#getApplicationRoleUser()}
     *   <li>{@link RoleEntity#isActive()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RoleEntity actualRoleEntity = new RoleEntity();
        actualRoleEntity.setActive(true);
        actualRoleEntity.setDescription("The characteristics of someone or something");
        actualRoleEntity.setId(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"));
        actualRoleEntity.setName("Name");
        HashSet<RoleFeatureEntity> roleFeatures = new HashSet<>();
        actualRoleEntity.setRoleFeatures(roleFeatures);
        HashSet<ApplicationRoleUserEntity> applicationRoleUserEntities = new HashSet<>();
        actualRoleEntity.setApplicationRoleUser(applicationRoleUserEntities);
        ApplicationEntity application = new ApplicationEntity();
        application.setId(UUID.fromString("2f6a6f0d-6b0a-4d13-9d3d-4a5c6d7e8f90"));
        actualRoleEntity.setApplication(application);
        String actualToStringResult = actualRoleEntity.toString();
        assertEquals("The characteristics of someone or something", actualRoleEntity.getDescription());
        assertEquals(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"), actualRoleEntity.getId());
        assertEquals("Name", actualRoleEntity.getName());
        assertSame(roleFeatures, actualRoleEntity.getRoleFeatures());
        assertSame(applicationRoleUserEntities, actualRoleEntity.getApplicationRoleUser());
        assertSame(application, actualRoleEntity.getApplication());
        assertTrue(actualRoleEntity.isActive());
        assertEquals(
                "RoleEntity{id=849a7d96-5fda-413c-9926-41f660078e76," +
                        " name='Name', description='The characteristics of someone or something'," +
                        " applicationRoleUser=[], roleFeatures=[], active=true," +
                        " applicationId=2f6a6f0d-6b0a-4d13-9d3d-4a5c6d7e8f90}",
                actualToStringResult);
    }

}
