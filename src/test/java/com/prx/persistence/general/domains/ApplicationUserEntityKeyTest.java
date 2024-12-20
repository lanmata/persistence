package com.prx.persistence.general.domains;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationUserEntityKeyTest {

    @Test
    void idIsSetCorrectly() {
        ApplicationUserEntityKey key = new ApplicationUserEntityKey();
        UUID serviceId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        key.setApplicationId(serviceId);
        key.setUserId(userId);
        assertEquals(serviceId, key.getApplicationId());
        assertEquals(userId, key.getUserId());
    }

    @Test
    void defaultServiceIdIsNull() {
        ApplicationUserEntityKey key = new ApplicationUserEntityKey();
        assertNull(key.getApplicationId());
    }

    @Test
    void defaultUserIdIsNull() {
        ApplicationUserEntityKey key = new ApplicationUserEntityKey();
        assertNull(key.getUserId());
    }

    @Test
    void equalsAndHashCode() {
        ApplicationUserEntityKey key1 = new ApplicationUserEntityKey();
        ApplicationUserEntityKey key2 = new ApplicationUserEntityKey();
        UUID serviceId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        key1.setApplicationId(serviceId);
        key1.setUserId(userId);
        key2.setApplicationId(serviceId);
        key2.setUserId(userId);
        assertEquals(key1, key2);
        assertEquals(key1.hashCode(), key2.hashCode());
    }

    @Test
    void notEqualsDifferentServiceId() {
        ApplicationUserEntityKey key1 = new ApplicationUserEntityKey();
        ApplicationUserEntityKey key2 = new ApplicationUserEntityKey();
        key1.setApplicationId(UUID.randomUUID());
        key1.setUserId(UUID.randomUUID());
        key2.setApplicationId(UUID.randomUUID());
        key2.setUserId(key1.getUserId());
        assertNotEquals(key1, key2);
    }

    @Test
    void notEqualsDifferentUserId() {
        ApplicationUserEntityKey key1 = new ApplicationUserEntityKey();
        ApplicationUserEntityKey key2 = new ApplicationUserEntityKey();
        key1.setApplicationId(UUID.randomUUID());
        key1.setUserId(UUID.randomUUID());
        key2.setApplicationId(key1.getApplicationId());
        key2.setUserId(UUID.randomUUID());
        assertNotEquals(key1, key2);
    }
}
