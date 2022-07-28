/*
 * @(#)RolFeaturePKTest.java.
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
 * RolFeaturePKTest.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
class RoleFeaturePKTest {

    @Test
    void gettersAndSetters() {
        final var roleFeaturePk = new RoleFeaturePK();
        final var roleEntity = new RoleEntity();
        final var features = new HashSet<RoleFeatureEntity>();
        final var users = new HashSet<UserRoleEntity>();
        final var featureEntity = new FeatureEntity();

        final var roleFeaturePk2 = new RoleFeaturePK();
        final var roleEntity2 = new RoleEntity();
        final var features2 = new HashSet<RoleFeatureEntity>();
        final var users2 = new HashSet<UserRoleEntity>();
        final var featureEntity2 = new FeatureEntity();

        featureEntity.setId(1L);
        featureEntity.setActive(true);
        featureEntity.setName("Feature name");
        featureEntity.setDescription("Feature description");
        featureEntity.setRolFeatures(features);

        roleEntity.setId(3L);
        roleEntity.setName("Rol 0001");
        roleEntity.setDescription("Rol description");
        roleEntity.setActive(true);
        roleEntity.setRoleFeatures(features);
        roleEntity.setUserRoleEntities(users);

        roleFeaturePk.setFeature(featureEntity.getId());
        roleFeaturePk.setRole(roleEntity.getId());
        final var roleFeaturePk3 = roleFeaturePk;

        featureEntity2.setId(1L);
        featureEntity2.setActive(true);
        featureEntity2.setName("Feature name 2");
        featureEntity2.setDescription("Feature description 2");
        featureEntity2.setRolFeatures(features);

        roleEntity2.setId(3L);
        roleEntity2.setName("Rol 0002");
        roleEntity2.setDescription("Rol description 2");
        roleEntity2.setActive(true);
        roleEntity2.setRoleFeatures(features2);
        roleEntity2.setUserRoleEntities(users2);

        roleFeaturePk2.setFeature(featureEntity2.getId());
        roleFeaturePk2.setRole(roleEntity2.getId());

        featureEntity2.setId(1L);
        featureEntity2.setActive(true);
        featureEntity2.setName("Feature name 2");
        featureEntity2.setDescription("Feature description 2");
        featureEntity2.setRolFeatures(features2);

        Assertions.assertNotNull(roleFeaturePk);
        Assertions.assertNotNull(roleFeaturePk.getRole());
        Assertions.assertNotNull(roleFeaturePk.getFeature());
        Assertions.assertNotNull(roleFeaturePk.toString());
        Assertions.assertNotEquals(1, roleFeaturePk.hashCode());
        Assertions.assertNotNull(roleFeaturePk2);
        Assertions.assertNotNull(roleFeaturePk2.getRole());
        Assertions.assertNotNull(roleFeaturePk2.getFeature());
        Assertions.assertNotNull(roleFeaturePk2.toString());
        Assertions.assertNotEquals(1, roleFeaturePk.hashCode());
        Assertions.assertEquals(roleFeaturePk, roleFeaturePk3);
    }

}
