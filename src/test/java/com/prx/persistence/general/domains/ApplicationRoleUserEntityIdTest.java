package com.prx.persistence.general.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationRoleUserEntityIdTest {

    @Test
    @DisplayName("User ID is set correctly")
    void userIdIsSetCorrectly() {
        ApplicationRoleUserEntityId id = new ApplicationRoleUserEntityId();
        UUID userId = UUID.randomUUID();
        id.setUserId(userId);
        assertEquals(userId, id.getUserId());
    }

    @Test
    @DisplayName("Role ID is set correctly")
    void roleIdIsSetCorrectly() {
        ApplicationRoleUserEntityId id = new ApplicationRoleUserEntityId();
        UUID roleId = UUID.randomUUID();
        id.setRoleId(roleId);
        assertEquals(roleId, id.getRoleId());
    }

    @Test
    @DisplayName("Application ID is set correctly")
    void applicationIdIsSetCorrectly() {
        ApplicationRoleUserEntityId id = new ApplicationRoleUserEntityId();
        UUID applicationId = UUID.randomUUID();
        id.setApplicationId(applicationId);
        assertEquals(applicationId, id.getApplicationId());
    }

    @Test
    @DisplayName("Default User ID is null")
    void defaultUserIdIsNull() {
        ApplicationRoleUserEntityId id = new ApplicationRoleUserEntityId();
        assertNull(id.getUserId());
    }

    @Test
    @DisplayName("Default Role ID is null")
    void defaultRoleIdIsNull() {
        ApplicationRoleUserEntityId id = new ApplicationRoleUserEntityId();
        assertNull(id.getRoleId());
    }

    @Test
    @DisplayName("Default Application ID is null")
    void defaultApplicationIdIsNull() {
        ApplicationRoleUserEntityId id = new ApplicationRoleUserEntityId();
        assertNull(id.getApplicationId());
    }

    @Test
    @DisplayName("Equals and hashCode work correctly")
    void equalsAndHashCode() {
        ApplicationRoleUserEntityId id1 = new ApplicationRoleUserEntityId();
        ApplicationRoleUserEntityId id2 = new ApplicationRoleUserEntityId();
        UUID userId = UUID.randomUUID();
        UUID roleId = UUID.randomUUID();
        UUID applicationId = UUID.randomUUID();
        id1.setUserId(userId);
        id1.setRoleId(roleId);
        id1.setApplicationId(applicationId);
        id2.setUserId(userId);
        id2.setRoleId(roleId);
        id2.setApplicationId(applicationId);
        assertEquals(id1, id2);
        assertEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    @DisplayName("Not equals with different User ID")
    void notEqualsDifferentUserId() {
        ApplicationRoleUserEntityId id1 = new ApplicationRoleUserEntityId();
        ApplicationRoleUserEntityId id2 = new ApplicationRoleUserEntityId();
        id1.setUserId(UUID.randomUUID());
        id1.setRoleId(UUID.randomUUID());
        id1.setApplicationId(UUID.randomUUID());
        id2.setUserId(UUID.randomUUID());
        id2.setRoleId(id1.getRoleId());
        id2.setApplicationId(id1.getApplicationId());
        assertNotEquals(id1, id2);
    }

    @Test
    @DisplayName("Not equals with different Role ID")
    void notEqualsDifferentRoleId() {
        ApplicationRoleUserEntityId id1 = new ApplicationRoleUserEntityId();
        ApplicationRoleUserEntityId id2 = new ApplicationRoleUserEntityId();
        id1.setUserId(UUID.randomUUID());
        id1.setRoleId(UUID.randomUUID());
        id1.setApplicationId(UUID.randomUUID());
        id2.setUserId(id1.getUserId());
        id2.setRoleId(UUID.randomUUID());
        id2.setApplicationId(id1.getApplicationId());
        assertNotEquals(id1, id2);
    }

    @Test
    @DisplayName("Not equals with different Application ID")
    void notEqualsDifferentApplicationId() {
        ApplicationRoleUserEntityId id1 = new ApplicationRoleUserEntityId();
        ApplicationRoleUserEntityId id2 = new ApplicationRoleUserEntityId();
        id1.setUserId(UUID.randomUUID());
        id1.setRoleId(UUID.randomUUID());
        id1.setApplicationId(UUID.randomUUID());
        id2.setUserId(id1.getUserId());
        id2.setRoleId(id1.getRoleId());
        id2.setApplicationId(UUID.randomUUID());
        assertNotEquals(id1, id2);
    }

    @Test
    @DisplayName("Equals with same object")
    void equalsSameObject() {
        ApplicationRoleUserEntityId id = new ApplicationRoleUserEntityId();
        assertEquals(id, id);
    }

    @Test
    @DisplayName("Not equals with null")
    void notEqualsNull() {
        ApplicationRoleUserEntityId id = new ApplicationRoleUserEntityId();
        assertNotEquals(id, null);
    }

    @Test
    @DisplayName("Not equals with different class")
    void notEqualsDifferentClass() {
        ApplicationRoleUserEntityId id = new ApplicationRoleUserEntityId();
        Object obj = new Object();
        assertNotEquals(id, obj);
    }
}
