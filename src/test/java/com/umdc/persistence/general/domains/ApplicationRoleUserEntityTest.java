package com.umdc.persistence.general.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationRoleUserEntityTest {

    @Test
    @DisplayName("ID is set correctly")
    void idIsSetCorrectly() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        ApplicationRoleUserEntityId id = new ApplicationRoleUserEntityId();
        entity.setId(id);
        assertSame(id, entity.getId());
    }

    @Test
    @DisplayName("User is set correctly")
    void userIsSetCorrectly() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        UserEntity user = new UserEntity();
        entity.setUser(user);
        assertSame(user, entity.getUser());
    }

    @Test
    @DisplayName("Role is set correctly")
    void roleIsSetCorrectly() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        RoleEntity role = new RoleEntity();
        entity.setRole(role);
        assertSame(role, entity.getRole());
    }

    @Test
    @DisplayName("Application is set correctly")
    void applicationIsSetCorrectly() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        ApplicationEntity application = new ApplicationEntity();
        entity.setApplication(application);
        assertSame(application, entity.getApplication());
    }

    @Test
    @DisplayName("Active is set correctly")
    void activeIsSetCorrectly() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        entity.setActive(true);
        assertTrue(entity.getActive());
    }

    @Test
    @DisplayName("Default active is false")
    void defaultActiveIsFalse() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        assertFalse(entity.getActive());
    }

    @Test
    @DisplayName("ID is null by default")
    void idIsNullByDefault() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        assertNull(entity.getId());
    }

    @Test
    @DisplayName("User is null by default")
    void userIsNullByDefault() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        assertNull(entity.getUser());
    }

    @Test
    @DisplayName("Role is null by default")
    void roleIsNullByDefault() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        assertNull(entity.getRole());
    }

    @Test
    @DisplayName("Application is null by default")
    void applicationIsNullByDefault() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        assertNull(entity.getApplication());
    }

    @Test
    @DisplayName("Creator ID is set correctly")
    void creatorIdIsSetCorrectly() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        UUID creatorId = UUID.randomUUID();
        entity.setCreatorId(creatorId);
        assertEquals(creatorId, entity.getCreatorId());
    }

    @Test
    @DisplayName("Creator ID is null by default")
    void creatorIdIsNullByDefault() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        assertNull(entity.getCreatorId());
    }

    @Test
    @DisplayName("Created date is set correctly")
    void createdDateIsSetCorrectly() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        LocalDateTime now = LocalDateTime.now();
        entity.setCreatedDate(now);
        assertEquals(now, entity.getCreatedDate());
    }

    @Test
    @DisplayName("Created date is null by default")
    void createdDateIsNullByDefault() {
        ApplicationRoleUserEntity entity = new ApplicationRoleUserEntity();
        assertNull(entity.getCreatedDate());
    }
}
