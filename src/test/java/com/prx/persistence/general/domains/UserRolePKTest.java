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

        roleEntity.setId(3L);
        roleEntity.setName("Rol 0001");
        roleEntity.setDescription("Rol description");
        roleEntity.setActive(true);
        roleEntity.setRoleFeatures(features);
        roleEntity.setUserRoleEntities(users);

        userEntity.setId(7L);
        userEntity.setAlias("Alias 2");
        userEntity.setActive(true);
        userEntity.setPassword("34567890");
        userEntity.setPerson(new PersonEntity());

        userRolePK.setUser(userEntity);
        userRolePK.setRole(roleEntity);

        roleEntity2.setId(3L);
        roleEntity2.setName("Rol 0002");
        roleEntity2.setDescription("Rol description 2");
        roleEntity2.setActive(true);
        roleEntity2.setRoleFeatures(features2);
        roleEntity2.setUserRoleEntities(users2);

        userEntity2.setId(4L);
        userEntity2.setAlias("Alias 2");
        userEntity2.setActive(true);
        userEntity2.setPassword("34567890");
        userEntity2.setPerson(new PersonEntity());

        userRolePK2.setUser(userEntity2);
        userRolePK2.setRole(roleEntity2);

        userRolPK3.setUser(userEntity);
        userRolPK3.setRole(roleEntity);

        Assertions.assertAll("Test Getters and Setters",
            () -> Assertions.assertNotNull(userRolePK.getRole()),
            () -> Assertions.assertNotNull(userRolePK.getUser()),
            () -> Assertions.assertNotNull(userRolePK.toString()),
            () -> Assertions.assertNotEquals(1, userRolePK.hashCode()),
            () -> Assertions.assertNotEquals(userRolePK2, userRolePK),
            () -> Assertions.assertNotEquals(userRolePK2, new Object()),
            () -> Assertions.assertNotEquals(null, userRolePK),
            () -> Assertions.assertNotEquals(userRolePK, (UserRolePK) null),
            () -> Assertions.assertEquals(userRolePK,userRolePK4)
        );

        userRolPK3.setUser(userEntity2);
        userRolPK3.setRole(roleEntity);
        Assertions.assertNotEquals(userRolePK, userRolPK3);
        userRolPK3.setUser(userEntity);
        userRolPK3.setRole(roleEntity2);
        Assertions.assertNotEquals(userRolePK, userRolPK3);
        userRolPK3.setUser(userEntity);
        userRolPK3.setRole(roleEntity);
        Assertions.assertEquals(userRolePK, userRolPK3);

    }
}
