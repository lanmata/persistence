/*
 * @(#)RolFeatureEntityTest.java.
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
 * RolFeatureEntityTest.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
class RoleFeatureEntityTest {
    @Test
    void gettersAndSetters(){
        final var roleFeatureEntity = new RoleFeatureEntity();
        final var featureEntity = new FeatureEntity();
        final var roleEntity = new RoleEntity();
        final var features = new HashSet<RoleFeatureEntity>();
        final var users = new HashSet<UserRoleEntity>();

        roleEntity.setId(3L);
        roleEntity.setName("Rol 0001");
        roleEntity.setDescription("Rol description");
        roleEntity.setActive(true);
        roleEntity.setRoleFeatures(features);
        roleEntity.setUserRoleEntities(users);
        featureEntity.setId(1L);
        featureEntity.setActive(true);
        featureEntity.setName("Feature name");
        featureEntity.setDescription("Feature name");

        roleFeatureEntity.setFeature(featureEntity);
        roleFeatureEntity.setRole(roleEntity);
        roleFeatureEntity.setActive(true);

        Assertions.assertAll("Test Getters and Setters",
            () -> Assertions.assertNotNull(roleFeatureEntity.getRole()),
            () -> Assertions.assertNotNull(roleFeatureEntity.getFeature()),
            () -> Assertions.assertNotNull(roleFeatureEntity.getActive()),
            () -> Assertions.assertNotNull(roleFeatureEntity.toString()),
            () -> Assertions.assertNotEquals(1, roleFeatureEntity.hashCode()),
            () -> Assertions.assertNotEquals(new RoleFeatureEntity(), roleFeatureEntity)
        );
    }
}
