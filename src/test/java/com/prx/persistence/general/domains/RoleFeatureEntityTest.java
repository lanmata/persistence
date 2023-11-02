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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RolFeatureEntityTest.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
class RoleFeatureEntityTest {
    @Test
    void gettersAndSetters() {
        final var roleFeatureEntity = new RoleFeatureEntity();
        final var featureEntity = new FeatureEntity();
        final var roleEntity = new RoleEntity();
        final var features = new HashSet<RoleFeatureEntity>();
        final var users = new HashSet<UserRoleEntity>();
        final var roleFeaturePk = new RoleFeaturePK();

        roleEntity.setId(UUID.fromString("416073e8-f117-466e-8183-a867616fa991"));
        roleEntity.setName("Rol 0001");
        roleEntity.setDescription("Rol description");
        roleEntity.setActive(true);
        roleEntity.setRoleFeatures(features);
        roleEntity.setUserRoleEntities(users);
        featureEntity.setId(UUID.fromString("9d03ff25-842a-4625-9143-52eee8d710e7"));
        featureEntity.setActive(true);
        featureEntity.setName("Feature name");
        featureEntity.setDescription("Feature name");

        roleFeaturePk.setRoleId(UUID.fromString("416073e8-f117-466e-8183-a867616fa991"));
        roleFeaturePk.setFeatureId(UUID.fromString("9d03ff25-842a-4625-9143-52eee8d710e7"));

        roleFeatureEntity.setFeature(featureEntity);
        roleFeatureEntity.setRole(roleEntity);
        roleFeatureEntity.setActive(true);
        roleFeatureEntity.setRoleFeaturePK(roleFeaturePk);

        Assertions.assertAll("Test Getters and Setters",
                () -> Assertions.assertNotNull(roleFeatureEntity.getRole()),
                () -> Assertions.assertNotNull(roleFeatureEntity.getFeature()),
                () -> Assertions.assertNotNull(roleFeatureEntity.getActive()),
                () -> Assertions.assertNotNull(roleFeatureEntity.toString()),
                () -> Assertions.assertNotNull(roleFeatureEntity.getRoleFeaturePK()),
                () -> Assertions.assertNotNull(roleFeatureEntity.getRoleFeaturePK().getRoleId()),
                () -> Assertions.assertNotNull(roleFeatureEntity.getRoleFeaturePK().getFeatureId()),
                () -> Assertions.assertNotEquals(1, roleFeatureEntity.hashCode()),
                () -> Assertions.assertNotEquals(new RoleFeatureEntity(), roleFeatureEntity)
        );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link RoleFeatureEntity}
     *   <li>{@link RoleFeatureEntity#setActive(Boolean)}
     *   <li>{@link RoleFeatureEntity#setFeature(FeatureEntity)}
     *   <li>{@link RoleFeatureEntity#setRole(RoleEntity)}
     *   <li>{@link RoleFeatureEntity#setRoleFeaturePK(RoleFeaturePK)}
     *   <li>{@link RoleFeatureEntity#toString()}
     *   <li>{@link RoleFeatureEntity#getActive()}
     *   <li>{@link RoleFeatureEntity#getFeature()}
     *   <li>{@link RoleFeatureEntity#getRole()}
     *   <li>{@link RoleFeatureEntity#getRoleFeaturePK()}
     * </ul>
     */
    @Test
    void testConstructor() {
        var featureUuid = UUID.fromString("611aec48-f8f6-4e05-9b95-7080f50dd624");
        var roleUuid = UUID.fromString("07648dfe-e606-49bb-a13e-d0753faab8ea");
        RoleFeatureEntity actualRoleFeatureEntity = new RoleFeatureEntity();
        actualRoleFeatureEntity.setActive(true);
        FeatureEntity feature = new FeatureEntity();
        feature.setActive(true);
        feature.setDescription("The characteristics of someone or something");
        feature.setId(featureUuid);
        feature.setName("Name");
        feature.setRolFeatures(new HashSet<>());
        actualRoleFeatureEntity.setFeature(feature);
        RoleEntity role = new RoleEntity();
        role.setActive(true);
        role.setDescription("The characteristics of someone or something");
        role.setId(roleUuid);
        role.setName("Name");
        role.setRoleFeatures(new HashSet<>());
        role.setUserRoleEntities(new HashSet<>());
        actualRoleFeatureEntity.setRole(role);
        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeatureId(featureUuid);
        roleFeaturePK.setRoleId(roleUuid);
        actualRoleFeatureEntity.setRoleFeaturePK(roleFeaturePK);
        String actualToStringResult = actualRoleFeatureEntity.toString();
        assertTrue(actualRoleFeatureEntity.getActive());
        assertSame(feature, actualRoleFeatureEntity.getFeature());
        assertSame(role, actualRoleFeatureEntity.getRole());
        assertSame(roleFeaturePK, actualRoleFeatureEntity.getRoleFeaturePK());
        assertEquals(
                "RoleFeatureEntity{role=RoleEntity{id=07648dfe-e606-49bb-a13e-d0753faab8ea, name='Name', "
                        + "description='The characteristics of someone or something', userRoleEntities=[], "
                        + "roleFeatures=[], active=true}, feature=FeatureEntity{id=611aec48-f8f6-4e05-9b95-7080f50dd624,"
                        + " name='Name', description='The characteristics of someone or something', active=true, "
                        + "rolFeatures=[]}, active=true}",
                actualToStringResult);
    }
}
