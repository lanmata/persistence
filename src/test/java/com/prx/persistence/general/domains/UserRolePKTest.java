/*
 * @(#)UserRolPKTest.java.
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * UserRolPKTest.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
class UserRolePKTest {

    @Test
    void gettersAndSetters() {
        final var userRolePK = new UserRolePK();
        final var userEntity = new UserEntity();
        final var roleEntity = new RoleEntity();
        final var features = new HashSet<RoleFeatureEntity>();
        final var users = new HashSet<UserRoleEntity>();
        final var userRolePK2 = new UserRolePK();
        final var userEntity2 = new UserEntity();
        final var roleEntity2 = new RoleEntity();
        final var features2 = new HashSet<RoleFeatureEntity>();
        final var users2 = new HashSet<UserRoleEntity>();
        final var userRolPK3 = new UserRolePK();
        final var userRolePK4 = userRolePK;

        roleEntity.setId("e8c8f126-09f2-4ae9-9bb6-4fa459b77609");
        roleEntity.setName("Rol 0001");
        roleEntity.setDescription("Rol description");
        roleEntity.setActive(true);
        roleEntity.setRoleFeatures(features);
        roleEntity.setUserRoleEntities(users);

        userEntity.setId("b09c7f73-ce44-46b3-b561-0db1791688cd");
        userEntity.setAlias("Alias 2");
        userEntity.setActive(true);
        userEntity.setPassword("34567890");
        userEntity.setPerson(new PersonEntity());

        userRolePK.setUserId(userEntity.getId());
        userRolePK.setRoleId(roleEntity.getId());

        roleEntity2.setId("e8c8f126-09f2-4ae9-9bb6-4fa459b77609");
        roleEntity2.setName("Rol 0002");
        roleEntity2.setDescription("Rol description 2");
        roleEntity2.setActive(true);
        roleEntity2.setRoleFeatures(features2);
        roleEntity2.setUserRoleEntities(users2);

        userEntity2.setId("98cc6676-fbc0-43ac-bb3b-695ab8ee7dba");
        userEntity2.setAlias("Alias 2");
        userEntity2.setActive(true);
        userEntity2.setPassword("34567890");
        userEntity2.setPerson(new PersonEntity());

        userRolePK2.setUserId(userEntity2.getId());
        userRolePK2.setRoleId(roleEntity2.getId());

        userRolPK3.setUserId(userEntity.getId());
        userRolPK3.setRoleId(roleEntity.getId());

        Assertions.assertAll("Test Getters and Setters",
                () -> Assertions.assertNotNull(userRolePK.getRoleId()),
                () -> Assertions.assertNotNull(userRolePK.getUserId()),
                () -> Assertions.assertNotNull(userRolePK.toString()),
                () -> Assertions.assertNotEquals(1, userRolePK.hashCode()),
                () -> Assertions.assertNotEquals(userRolePK2, userRolePK),
                () -> Assertions.assertNotEquals(userRolePK2, new Object()),
                () -> Assertions.assertNotEquals(null, userRolePK),
                () -> Assertions.assertNotEquals(null, userRolePK),
                () -> Assertions.assertEquals(userRolePK, userRolePK4)
        );

        userRolPK3.setUserId(userEntity2.getId());
        userRolPK3.setRoleId(roleEntity.getId());
        Assertions.assertNotEquals(userRolePK, userRolPK3);
        userRolPK3.setUserId(userEntity2.getId());
        userRolPK3.setRoleId(roleEntity2.getId());
        Assertions.assertNotEquals(userRolePK, userRolPK3);
        userRolPK3.setUserId(userEntity.getId());
        userRolPK3.setRoleId(roleEntity.getId());
        Assertions.assertEquals(userRolePK, userRolPK3);

    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link UserRolePK}
     *   <li>{@link UserRolePK#setRoleId(String)}
     *   <li>{@link UserRolePK#setUserId(String)}
     *   <li>{@link UserRolePK#toString()}
     *   <li>{@link UserRolePK#getRoleId()}
     *   <li>{@link UserRolePK#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserRolePK actualUserRolePK = new UserRolePK();
        actualUserRolePK.setRoleId("42");
        actualUserRolePK.setUserId("42");
        String actualToStringResult = actualUserRolePK.toString();
        assertEquals("42", actualUserRolePK.getRoleId());
        assertEquals("42", actualUserRolePK.getUserId());
        assertEquals("UserRolePK{user=42, role=42}", actualToStringResult);
    }

    /**
     * Method under test: {@link UserRolePK#equals(Object)}
     */
    @Test
    void testEquals6() {
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setRoleId(null);
        userRolePK.setUserId("42");
        assertThrows(NullPointerException.class, userRolePK::getRoleId);
    }

    /**
     * Method under test: {@link UserRolePK#equals(Object)}
     */
    @Test
    void testEquals8() {
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setRoleId("42");
        userRolePK.setUserId(null);
        assertThrows(NullPointerException.class, userRolePK::getUserId);
    }

    /**
     * Method under test: {@link UserRolePK#equals(Object)}
     */
    @Test
    void testEquals() {
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setRoleId("42");
        userRolePK.setUserId("42");
        assertNotEquals(null, userRolePK);
    }

    /**
     * Method under test: {@link UserRolePK#equals(Object)}
     */
    @Test
    void testEquals2() {
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setRoleId("42");
        userRolePK.setUserId("42");
        assertNotEquals("Different type to UserRolePK", userRolePK);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserRolePK#equals(Object)}
     *   <li>{@link UserRolePK#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setRoleId("7cf1a019-a6c3-452e-a6db-54afa039f1d6");
        userRolePK.setUserId("35457947-3114-41dc-b303-8dc39cf6d29f");
        UserRolePK userRolePK1 = new UserRolePK();
        userRolePK.setRoleId("98cc6676-fbc0-43ac-bb3b-695ab8ee7dba");
        userRolePK.setUserId("87d86eed-cbf3-43a6-8751-40500ed13260");
        assertNotEquals(userRolePK, userRolePK1);
        int expectedHashCodeResult = userRolePK.hashCode();
        assertEquals(expectedHashCodeResult, userRolePK.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserRolePK#equals(Object)}
     *   <li>{@link UserRolePK#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setRoleId("42");
        userRolePK.setUserId("42");

        UserRolePK userRolePK2 = new UserRolePK();
        userRolePK2.setRoleId("42");
        userRolePK2.setUserId("42");
        assertEquals(userRolePK, userRolePK2);
        int expectedHashCodeResult = userRolePK.hashCode();
        assertEquals(expectedHashCodeResult, userRolePK2.hashCode());
    }

    /**
     * Method under test: {@link UserRolePK#equals(Object)}
     */
    @Test
    void testEquals5() {
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setRoleId("Role Id");
        userRolePK.setUserId("42");

        UserRolePK userRolePK2 = new UserRolePK();
        userRolePK2.setRoleId("42");
        userRolePK2.setUserId("42");
        assertNotEquals(userRolePK, userRolePK2);
    }

    /**
     * Method under test: {@link UserRolePK#equals(Object)}
     */
    @Test
    void testEquals7() {
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setRoleId("42");
        userRolePK.setUserId("User Id");

        UserRolePK userRolePK2 = new UserRolePK();
        userRolePK2.setRoleId("42");
        userRolePK2.setUserId("42");
        assertNotEquals(userRolePK, userRolePK2);
    }
}
