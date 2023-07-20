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

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserRolEntityTest.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
class UserRoleEntityTest {
    @Test
    void gettersAndSetters(){
        final var userRoleEntity = new UserRoleEntity();
        final var userEntity = new UserEntity();
        final var roleEntity = new RoleEntity();
        final var features = new HashSet<RoleFeatureEntity>();
        final var users = new HashSet<UserRoleEntity>();
        final var userRolePk = new UserRolePK();

        roleEntity.setId(3L);
        roleEntity.setName("Rol 0001");
        roleEntity.setDescription("Rol description");
        roleEntity.setActive(true);
        roleEntity.setRoleFeatures(features);
        roleEntity.setUserRoleEntities(users);

        userEntity.setId(3L);
        userEntity.setAlias("Alias");
        userEntity.setActive(true);
        userEntity.setPassword("34567890");
        userEntity.setPerson(new PersonEntity());

        userRolePk.setRoleId(1L);
        userRolePk.setUserId(1L);

        userRoleEntity.setUserId(userEntity);
        userRoleEntity.setRoleId(roleEntity);
        userRoleEntity.setActive(true);
        userRoleEntity.setUserRolePK(userRolePk);

        assertAll("Test Getters and Setters",
            () -> assertNotNull(userRoleEntity.getRoleId()),
            () -> assertNotNull(userRoleEntity.getUserId()),
            () -> assertNotNull(userRoleEntity.toString()),
            () -> assertNotNull(userRoleEntity.getActive()),
            () -> assertNotNull(userRoleEntity.getUserRolePK()),
            () -> assertNotNull(userRoleEntity.getUserRolePK().getUserId()),
            () -> assertNotNull(userRoleEntity.getUserRolePK().getRoleId()),
            () -> assertNotEquals(1, userRoleEntity.hashCode()),
            () -> assertNotEquals(new UserRoleEntity(), userRoleEntity)
        );
    }
}
