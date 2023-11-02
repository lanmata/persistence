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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

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
        final var roleFeature = new RoleFeatureEntity();
        final var users = new HashSet<UserRoleEntity>();
        final var featureEntity = new FeatureEntity();

        final var roleFeaturePk2 = new RoleFeaturePK();
        final var roleEntity2 = new RoleEntity();
        final var features2 = new HashSet<RoleFeatureEntity>();
        final var roleFeature2 = new RoleFeatureEntity();
        final var users2 = new HashSet<UserRoleEntity>();
        final var featureEntity2 = new FeatureEntity();

        featureEntity.setId(UUID.fromString("9d03ff25-842a-4625-9143-52eee8d710e7"));
        featureEntity.setActive(true);
        featureEntity.setName("Feature name");
        featureEntity.setDescription("Feature description");
        featureEntity.setRolFeatures(features);

        roleEntity.setId(UUID.fromString("416073e8-f117-466e-8183-a867616fa991"));
        roleEntity.setName("Rol 0001");
        roleEntity.setDescription("Rol description");
        roleEntity.setActive(true);
        roleEntity.setRoleFeatures(features);
        roleEntity.setUserRoleEntities(users);

        roleFeature.setRole(roleEntity);
        roleFeature.setFeature(featureEntity);
        features.add(roleFeature);

        roleFeaturePk.setFeatureId(featureEntity.getId());
        roleFeaturePk.setRoleId(roleEntity.getId());
        final var roleFeaturePk3 = new RoleFeaturePK();
        final var roleFeaturePk4 = roleFeaturePk;

        featureEntity2.setId(UUID.fromString("9d03ff25-842a-4625-9143-52eee8d710e7"));
        featureEntity2.setActive(true);
        featureEntity2.setName("Feature name 2");
        featureEntity2.setDescription("Feature description 2");
        featureEntity2.setRolFeatures(features);
        roleFeature2.setRole(roleEntity);
        roleFeature2.setFeature(featureEntity);
        features.add(roleFeature2);

        roleEntity2.setId(UUID.fromString("416073e8-f117-466e-8183-a867616fa991"));
        roleEntity2.setName("Rol 0002");
        roleEntity2.setDescription("Rol description 2");
        roleEntity2.setActive(true);
        roleEntity2.setRoleFeatures(features2);
        roleEntity2.setUserRoleEntities(users2);

        roleFeaturePk2.setFeatureId(featureEntity2.getId());
        roleFeaturePk2.setRoleId(roleEntity2.getId());

        featureEntity2.setId(UUID.fromString("1f23ab15-2a00-451b-b36e-275213eca3aa"));
        featureEntity2.setActive(true);
        featureEntity2.setName("Feature name 2");
        featureEntity2.setDescription("Feature description 2");
        featureEntity2.setRolFeatures(features2);

        Assertions.assertAll("Test Getters and Setters",
                () -> Assertions.assertNotNull(roleFeaturePk.getRoleId()),
                () -> Assertions.assertNotNull(roleFeaturePk.getFeatureId()),
                () -> Assertions.assertNotNull(roleFeaturePk.toString()),
                () -> Assertions.assertNotEquals(1, roleFeaturePk.hashCode()),
                () -> Assertions.assertEquals(roleFeaturePk, roleFeaturePk2),
                () -> Assertions.assertNotEquals(roleFeaturePk, new Object()),
                () -> Assertions.assertNotEquals(null, roleFeaturePk),
                () -> Assertions.assertEquals(roleFeaturePk, roleFeaturePk4)
        );

        roleFeaturePk3.setFeatureId(UUID.fromString("1f23ab15-2a00-451b-b36e-275213eca3aa"));
        roleFeaturePk3.setRoleId(roleFeaturePk.getRoleId());
        Assertions.assertNotEquals(roleFeaturePk, roleFeaturePk3);
        roleFeaturePk3.setFeatureId(roleFeaturePk.getFeatureId());
        roleFeaturePk3.setRoleId(UUID.fromString("1f23ab15-2a00-451b-b36e-275213eca3aa"));
        Assertions.assertNotEquals(roleFeaturePk, roleFeaturePk3);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link RoleFeaturePK}
     *   <li>{@link RoleFeaturePK#setFeatureId(UUID)}
     *   <li>{@link RoleFeaturePK#setRoleId(UUID)}
     *   <li>{@link RoleFeaturePK#toString()}
     *   <li>{@link RoleFeaturePK#getFeatureId()}
     *   <li>{@link RoleFeaturePK#getRoleId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        var featureUuid = UUID.fromString("5fd250b6-3246-4d56-8af4-fc67a68b562f");
        var roleUuid = UUID.fromString("f791981a-afb7-41bf-addf-9cbdfda8e7f8");
        RoleFeaturePK actualRoleFeaturePK = new RoleFeaturePK();
        actualRoleFeaturePK.setFeatureId(featureUuid);
        actualRoleFeaturePK.setRoleId(roleUuid);
        String actualToStringResult = actualRoleFeaturePK.toString();
        assertEquals(featureUuid, actualRoleFeaturePK.getFeatureId());
        assertEquals(roleUuid, actualRoleFeaturePK.getRoleId());
        assertEquals("RoleFeaturePK{role=f791981a-afb7-41bf-addf-9cbdfda8e7f8, " +
                "feature=5fd250b6-3246-4d56-8af4-fc67a68b562f}", actualToStringResult);
    }

    /**
     * Method under test: {@link RoleFeaturePK#equals(Object)}
     */
    @Test
    void testEquals6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
        //       at com.prx.persistence.general.domains.RoleFeaturePK.equals(RoleFeaturePK.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeatureId(null);
        roleFeaturePK.setRoleId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));

        RoleFeaturePK roleFeaturePK2 = new RoleFeaturePK();
        roleFeaturePK2.setFeatureId(UUID.fromString("24426101-6828-454e-b7e2-42c2f8798d96"));
        roleFeaturePK2.setRoleId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));
        assertThrows(NullPointerException.class, () -> roleFeaturePK.equals(roleFeaturePK2));
    }

    /**
     * Method under test: {@link RoleFeaturePK#equals(Object)}
     */
    @Test
    void testEquals() {
        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeatureId(UUID.fromString("24426101-6828-454e-b7e2-42c2f8798d96"));
        roleFeaturePK.setRoleId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));
        assertNotEquals(null, roleFeaturePK);
    }

    /**
     * Method under test: {@link RoleFeaturePK#equals(Object)}
     */
    @Test
    void testEquals2() {
        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeatureId(UUID.fromString("24426101-6828-454e-b7e2-42c2f8798d96"));
        roleFeaturePK.setRoleId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));
        assertNotEquals("Different type to RoleFeaturePK", roleFeaturePK);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RoleFeaturePK#equals(Object)}
     *   <li>{@link RoleFeaturePK#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeatureId(UUID.fromString("24426101-6828-454e-b7e2-42c2f8798d96"));
        roleFeaturePK.setRoleId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));
        assertEquals(roleFeaturePK, roleFeaturePK);
        int expectedHashCodeResult = roleFeaturePK.hashCode();
        assertEquals(expectedHashCodeResult, roleFeaturePK.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RoleFeaturePK#equals(Object)}
     *   <li>{@link RoleFeaturePK#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeatureId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));
        roleFeaturePK.setRoleId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));

        RoleFeaturePK roleFeaturePK2 = new RoleFeaturePK();
        roleFeaturePK2.setFeatureId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));
        roleFeaturePK2.setRoleId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));
        assertEquals(roleFeaturePK, roleFeaturePK2);
        int expectedHashCodeResult = roleFeaturePK.hashCode();
        assertEquals(expectedHashCodeResult, roleFeaturePK2.hashCode());
    }

    /**
     * Method under test: {@link RoleFeaturePK#equals(Object)}
     */
    @Test
    void testEquals5() {
        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeatureId(UUID.fromString("cb7969ce-759c-4fa5-b819-c6cdeb6faa01"));
        roleFeaturePK.setRoleId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));

        RoleFeaturePK roleFeaturePK2 = new RoleFeaturePK();
        roleFeaturePK2.setFeatureId(UUID.fromString("e7a3946c-3ad2-4925-932f-3e60df07d371"));
        roleFeaturePK2.setRoleId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));
        assertNotEquals(roleFeaturePK, roleFeaturePK2);
    }

    /**
     * Method under test: {@link RoleFeaturePK#equals(Object)}
     */
    @Test
    void testEquals7() {
        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeatureId(UUID.fromString("cb7969ce-759c-4fa5-b819-c6cdeb6faa01"));
        roleFeaturePK.setRoleId(UUID.fromString("af2f2a8c-569d-46f7-a2f4-3f4a8f73cc51"));

        RoleFeaturePK roleFeaturePK2 = new RoleFeaturePK();
        roleFeaturePK2.setFeatureId(UUID.fromString("cb7969ce-759c-4fa5-b819-c6cdeb6faa01"));
        roleFeaturePK2.setRoleId(UUID.fromString("87fb0054-d08f-4b4e-a905-cfc65e4eb962"));
        assertNotEquals(roleFeaturePK, roleFeaturePK2);
    }

}
