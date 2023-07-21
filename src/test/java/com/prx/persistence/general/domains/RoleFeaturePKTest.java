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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
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
        final var roleFeature = new RoleFeatureEntity();
        final var users = new HashSet<UserRoleEntity>();
        final var featureEntity = new FeatureEntity();

        final var roleFeaturePk2 = new RoleFeaturePK();
        final var roleEntity2 = new RoleEntity();
        final var features2 = new HashSet<RoleFeatureEntity>();
        final var roleFeature2 = new RoleFeatureEntity();
        final var users2 = new HashSet<UserRoleEntity>();
        final var featureEntity2 = new FeatureEntity();

        featureEntity.setId("9d03ff25-842a-4625-9143-52eee8d710e7");
        featureEntity.setActive(true);
        featureEntity.setName("Feature name");
        featureEntity.setDescription("Feature description");
        featureEntity.setRolFeatures(features);

        roleEntity.setId("416073e8-f117-466e-8183-a867616fa991");
        roleEntity.setName("Rol 0001");
        roleEntity.setDescription("Rol description");
        roleEntity.setActive(true);
        roleEntity.setRoleFeatures(features);
        roleEntity.setUserRoleEntities(users);

        roleFeature.setRole(roleEntity);
        roleFeature.setFeature(featureEntity);
        features.add(roleFeature);

        roleFeaturePk.setFeature(featureEntity.getId());
        roleFeaturePk.setRole(roleEntity.getId());
        final var roleFeaturePk3 = new RoleFeaturePK();
        final var roleFeaturePk4 = roleFeaturePk;

        featureEntity2.setId("9d03ff25-842a-4625-9143-52eee8d710e7");
        featureEntity2.setActive(true);
        featureEntity2.setName("Feature name 2");
        featureEntity2.setDescription("Feature description 2");
        featureEntity2.setRolFeatures(features);
        roleFeature2.setRole(roleEntity);
        roleFeature2.setFeature(featureEntity);
        features.add(roleFeature2);

        roleEntity2.setId("416073e8-f117-466e-8183-a867616fa991");
        roleEntity2.setName("Rol 0002");
        roleEntity2.setDescription("Rol description 2");
        roleEntity2.setActive(true);
        roleEntity2.setRoleFeatures(features2);
        roleEntity2.setUserRoleEntities(users2);

        roleFeaturePk2.setFeature(featureEntity2.getId());
        roleFeaturePk2.setRole(roleEntity2.getId());

        featureEntity2.setId("1f23ab15-2a00-451b-b36e-275213eca3aa");
        featureEntity2.setActive(true);
        featureEntity2.setName("Feature name 2");
        featureEntity2.setDescription("Feature description 2");
        featureEntity2.setRolFeatures(features2);

        Assertions.assertAll("Test Getters and Setters",
                () -> Assertions.assertNotNull(roleFeaturePk.getRole()),
                () -> Assertions.assertNotNull(roleFeaturePk.getFeature()),
                () -> Assertions.assertNotNull(roleFeaturePk.toString()),
                () -> Assertions.assertNotEquals(1, roleFeaturePk.hashCode()),
                () -> Assertions.assertEquals(roleFeaturePk, roleFeaturePk2),
                () -> Assertions.assertNotEquals(roleFeaturePk, new Object()),
                () -> Assertions.assertNotEquals(null, roleFeaturePk),
                () -> Assertions.assertEquals(roleFeaturePk, roleFeaturePk4)
        );

        roleFeaturePk3.setFeature("1f23ab15-2a00-451b-b36e-275213eca3aa");
        roleFeaturePk3.setRole(roleFeaturePk.getRole());
        Assertions.assertNotEquals(roleFeaturePk, roleFeaturePk3);
        roleFeaturePk3.setFeature(roleFeaturePk.getFeature());
        roleFeaturePk3.setRole("1f23ab15-2a00-451b-b36e-275213eca3aa");
        Assertions.assertNotEquals(roleFeaturePk, roleFeaturePk3);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link RoleFeaturePK}
     *   <li>{@link RoleFeaturePK#setFeature(String)}
     *   <li>{@link RoleFeaturePK#setRole(String)}
     *   <li>{@link RoleFeaturePK#toString()}
     *   <li>{@link RoleFeaturePK#getFeature()}
     *   <li>{@link RoleFeaturePK#getRole()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RoleFeaturePK actualRoleFeaturePK = new RoleFeaturePK();
        actualRoleFeaturePK.setFeature("Feature");
        actualRoleFeaturePK.setRole("Role");
        String actualToStringResult = actualRoleFeaturePK.toString();
        assertEquals("Feature", actualRoleFeaturePK.getFeature());
        assertEquals("Role", actualRoleFeaturePK.getRole());
        assertEquals("RoleFeaturePK{role=Role, feature=Feature}", actualToStringResult);
    }

    /**
     * Method under test: {@link RoleFeaturePK#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
        //       at com.prx.persistence.general.domains.RoleFeaturePK.equals(RoleFeaturePK.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeature(null);
        roleFeaturePK.setRole("Role");

        RoleFeaturePK roleFeaturePK2 = new RoleFeaturePK();
        roleFeaturePK2.setFeature("Feature");
        roleFeaturePK2.setRole("Role");
        assertThrows(NullPointerException.class, () -> roleFeaturePK.equals(roleFeaturePK2));
    }

    /**
     * Method under test: {@link RoleFeaturePK#equals(Object)}
     */
    @Test
    void testEquals() {
        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeature("Feature");
        roleFeaturePK.setRole("Role");
        assertNotEquals(null, roleFeaturePK);
    }

    /**
     * Method under test: {@link RoleFeaturePK#equals(Object)}
     */
    @Test
    void testEquals2() {
        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeature("Feature");
        roleFeaturePK.setRole("Role");
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
        roleFeaturePK.setFeature("Feature");
        roleFeaturePK.setRole("Role");
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
        roleFeaturePK.setFeature("Feature");
        roleFeaturePK.setRole("Role");

        RoleFeaturePK roleFeaturePK2 = new RoleFeaturePK();
        roleFeaturePK2.setFeature("Feature");
        roleFeaturePK2.setRole("Role");
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
        roleFeaturePK.setFeature("Role");
        roleFeaturePK.setRole("Role");

        RoleFeaturePK roleFeaturePK2 = new RoleFeaturePK();
        roleFeaturePK2.setFeature("Feature");
        roleFeaturePK2.setRole("Role");
        assertNotEquals(roleFeaturePK, roleFeaturePK2);
    }

    /**
     * Method under test: {@link RoleFeaturePK#equals(Object)}
     */
    @Test
    void testEquals7() {
        RoleFeaturePK roleFeaturePK = new RoleFeaturePK();
        roleFeaturePK.setFeature("Feature");
        roleFeaturePK.setRole("Feature");

        RoleFeaturePK roleFeaturePK2 = new RoleFeaturePK();
        roleFeaturePK2.setFeature("Feature");
        roleFeaturePK2.setRole("Role");
        assertNotEquals(roleFeaturePK, roleFeaturePK2);
    }

}
