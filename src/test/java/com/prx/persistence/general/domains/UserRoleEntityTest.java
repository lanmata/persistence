/*
 * @(#)UserRolEntityTest.java.
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

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserRolEntityTest.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
class UserRoleEntityTest {
    @Test
    void gettersAndSetters() {
        final var userRoleEntity = new UserRoleEntity();
        final var userEntity = new UserEntity();
        final var roleEntity = new RoleEntity();
        final var features = new HashSet<RoleFeatureEntity>();
        final var users = new HashSet<UserRoleEntity>();
        final var userRolePk = new UserRolePK();

        roleEntity.setId(UUID.fromString("1f23ab15-2a00-451b-b36e-275213eca3aa"));
        roleEntity.setName("Rol 0001");
        roleEntity.setDescription("Rol description");
        roleEntity.setActive(true);
        roleEntity.setRoleFeatures(features);
        roleEntity.setUserRoleEntities(users);

        userEntity.setId(UUID.fromString("e8c8f126-09f2-4ae9-9bb6-4fa459b77609"));
        userEntity.setAlias("Alias");
        userEntity.setActive(true);
        userEntity.setPassword("34567890");
        userEntity.setPerson(new PersonEntity());

        userRolePk.setRoleId(UUID.fromString("1f23ab15-2a00-451b-b36e-275213eca3aa"));
        userRolePk.setUserId(UUID.fromString("e8c8f126-09f2-4ae9-9bb6-4fa459b77609"));

        userRoleEntity.setUser(userEntity);
        userRoleEntity.setRole(roleEntity);
        userRoleEntity.setActive(true);
        userRoleEntity.setUserRolePK(userRolePk);

        assertAll("Test Getters and Setters",
                () -> assertNotNull(userRoleEntity.getRole()),
                () -> assertNotNull(userRoleEntity.getUser()),
                () -> assertNotNull(userRoleEntity.toString()),
                () -> assertNotNull(userRoleEntity.getActive()),
                () -> assertNotNull(userRoleEntity.getUserRolePK()),
                () -> assertNotNull(userRoleEntity.getUserRolePK().getUserId()),
                () -> assertNotNull(userRoleEntity.getUserRolePK().getRoleId()),
                () -> assertNotEquals(1, userRoleEntity.hashCode()),
                () -> assertNotEquals(new UserRoleEntity(), userRoleEntity)
        );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link UserRoleEntity}
     *   <li>{@link UserRoleEntity#setActive(Boolean)}
     *   <li>{@link UserRoleEntity#setRole(RoleEntity)}
     *   <li>{@link UserRoleEntity#setUser(UserEntity)}
     *   <li>{@link UserRoleEntity#setUserRolePK(UserRolePK)}
     *   <li>{@link UserRoleEntity#toString()}
     *   <li>{@link UserRoleEntity#getActive()}
     *   <li>{@link UserRoleEntity#getRole()}
     *   <li>{@link UserRoleEntity#getUser()}
     *   <li>{@link UserRoleEntity#getUserRolePK()}
     * </ul>
     */
    @Test
    void testConstructor() {
        var roleUuid = UUID.fromString("5c5838d8-eaba-4441-ac3a-14d1f53732a0");
        var personUuid = UUID.fromString("5de2fd78-37a6-4962-883e-6208f9366bd0");
        var userUuid = UUID.fromString("0cf6dfaf-283a-4e91-8159-3df4d99e9f93");
        UserRoleEntity actualUserRoleEntity = new UserRoleEntity();
        actualUserRoleEntity.setActive(true);
        RoleEntity roleId = new RoleEntity();
        roleId.setActive(true);
        roleId.setDescription("The characteristics of someone or something");
        roleId.setId(roleUuid);
        roleId.setName("Name");
        roleId.setRoleFeatures(new HashSet<>());
        roleId.setUserRoleEntities(new HashSet<>());
        actualUserRoleEntity.setRole(roleId);
        PersonEntity person = new PersonEntity();
        person.setBirthdate(LocalDate.of(1970, 1, 1));
        person.setGender("Gender");
        person.setId(personUuid);
        person.setLastName("Doe");
        person.setMiddleName("Middle Name");
        person.setName("Name");
        UserEntity userId = new UserEntity();
        userId.setActive(true);
        userId.setAlias("Alias");
        userId.setId(userUuid);
        userId.setPassword("iloveyou");
        userId.setPerson(person);
        userId.setUserRole(new HashSet<>());
        actualUserRoleEntity.setUser(userId);
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setRoleId(roleUuid);
        userRolePK.setUserId(userUuid);
        actualUserRoleEntity.setUserRolePK(userRolePK);
        String actualToStringResult = actualUserRoleEntity.toString();
        assertTrue(actualUserRoleEntity.getActive());
        assertSame(roleId, actualUserRoleEntity.getRole());
        assertSame(userId, actualUserRoleEntity.getUser());
        assertSame(userRolePK, actualUserRoleEntity.getUserRolePK());
        assertEquals("UserRoleEntity{userRolePK=UserRolePK{user=0cf6dfaf-283a-4e91-8159-3df4d99e9f93," +
                " role=5c5838d8-eaba-4441-ac3a-14d1f53732a0}user=UserEntity{id=0cf6dfaf-283a-4e91-8159-3df4d99e9f93," +
                " alias='Alias', password='iloveyou', active=true, person=PersonEntity{id=5de2fd78-37a6-4962-883e-6208f9366bd0," +
                " name='Name', middleName='Middle Name', lastName='Doe', gender='Gender', birthdate=1970-01-01}," +
                " userRole=[]}, role=RoleEntity{id=5c5838d8-eaba-4441-ac3a-14d1f53732a0, name='Name', " +
                "description='The characteristics of someone or something', userRoleEntities=[], roleFeatures=[]," +
                " active=true}, active=true}", actualToStringResult);
    }
}
