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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RoleFeaturePKTest {

    @Test
    @DisplayName("Role ID is set correctly")
    void roleIdIsSetCorrectly() {
        RoleFeaturePK pk = new RoleFeaturePK();
        UUID roleId = UUID.randomUUID();
        pk.setRoleId(roleId);
        assertEquals(roleId, pk.getRoleId());
    }

    @Test
    @DisplayName("Feature ID is set correctly")
    void featureIdIsSetCorrectly() {
        RoleFeaturePK pk = new RoleFeaturePK();
        UUID featureId = UUID.randomUUID();
        pk.setFeatureId(featureId);
        assertEquals(featureId, pk.getFeatureId());
    }

    @Test
    @DisplayName("Default Role ID is null")
    void defaultRoleIdIsNull() {
        RoleFeaturePK pk = new RoleFeaturePK();
        assertNull(pk.getRoleId());
    }

    @Test
    @DisplayName("Default Feature ID is null")
    void defaultFeatureIdIsNull() {
        RoleFeaturePK pk = new RoleFeaturePK();
        assertNull(pk.getFeatureId());
    }

    @Test
    @DisplayName("Equals with same object")
    void equalsSameObject() {
        RoleFeaturePK pk = new RoleFeaturePK();
        assertEquals(pk, pk);
    }

    @Test
    @DisplayName("Not equals with null")
    void notEqualsNull() {
        RoleFeaturePK pk = new RoleFeaturePK();
        assertNotEquals(null, pk);
    }

    @Test
    @DisplayName("Not equals with different class")
    void notEqualsDifferentClass() {
        RoleFeaturePK pk = new RoleFeaturePK();
        Object obj = new Object();
        assertNotEquals(pk, obj);
    }

    @Test
    @DisplayName("Equals and hashCode work correctly")
    void equalsAndHashCode() {
        RoleFeaturePK pk1 = new RoleFeaturePK();
        RoleFeaturePK pk2 = new RoleFeaturePK();
        UUID roleId = UUID.randomUUID();
        UUID featureId = UUID.randomUUID();
        pk1.setRoleId(roleId);
        pk1.setFeatureId(featureId);
        pk2.setRoleId(roleId);
        pk2.setFeatureId(featureId);
        assertEquals(pk1, pk2);
        assertEquals(pk1.hashCode(), pk2.hashCode());
    }

    @Test
    @DisplayName("Not equals with different Role ID")
    void notEqualsDifferentRoleId() {
        RoleFeaturePK pk1 = new RoleFeaturePK();
        RoleFeaturePK pk2 = new RoleFeaturePK();
        pk1.setRoleId(UUID.randomUUID());
        pk1.setFeatureId(UUID.randomUUID());
        pk2.setRoleId(UUID.randomUUID());
        pk2.setFeatureId(pk1.getFeatureId());
        assertNotEquals(pk1, pk2);
    }

    @Test
    @DisplayName("Not equals with different Feature ID")
    void notEqualsDifferentFeatureId() {
        RoleFeaturePK pk1 = new RoleFeaturePK();
        RoleFeaturePK pk2 = new RoleFeaturePK();
        pk1.setRoleId(UUID.randomUUID());
        pk1.setFeatureId(UUID.randomUUID());
        pk2.setRoleId(pk1.getRoleId());
        pk2.setFeatureId(UUID.randomUUID());
        assertNotEquals(pk1, pk2);
    }

    @Test
    @DisplayName("ToString returns correct format")
    void toStringReturnsCorrectFormat() {
        RoleFeaturePK pk = new RoleFeaturePK();
        UUID roleId = UUID.randomUUID();
        UUID featureId = UUID.randomUUID();
        pk.setRoleId(roleId);
        pk.setFeatureId(featureId);
        String expected = "RoleFeaturePK{role=" + roleId + ", feature=" + featureId + "}";
        assertEquals(expected, pk.toString());
    }
}
