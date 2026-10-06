package com.umdc.persistence.general.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ManagedClientEntityTest {

    private static final String TEST_NAME        = "billing-service";
    private static final String TEST_DESCRIPTION = "M2M client for the billing service";
    private static final String TEST_SECRET_HASH = System.getProperty("test.secret.hash", "");
    private static final String TEST_PREV_HASH   = System.getProperty("test.prev.hash", "");

    // ── @PrePersist lifecycle ──────────────────────────────────────────────────

    @Test
    @DisplayName("prePersist sets createdAt when null")
    void prePersistSetsCreatedAtWhenNull() {
        ManagedClientEntity entity = new ManagedClientEntity();
        assertNull(entity.getCreatedAt());

        entity.prePersist();

        assertNotNull(entity.getCreatedAt());
    }

    @Test
    @DisplayName("prePersist does NOT overwrite createdAt when already set")
    void prePersistDoesNotOverwriteCreatedAt() {
        LocalDateTime expected = LocalDateTime.of(2024, Month.JANUARY, 15, 10, 30, 0);
        ManagedClientEntity entity = new ManagedClientEntity();
        entity.setCreatedAt(expected);

        entity.prePersist();

        assertEquals(expected, entity.getCreatedAt());
    }

    // ── @PreUpdate lifecycle ───────────────────────────────────────────────────

    @Test
    @DisplayName("preUpdate sets lastUpdatedAt")
    void preUpdateSetsLastUpdatedAt() {
        ManagedClientEntity entity = new ManagedClientEntity();
        assertNull(entity.getLastUpdatedAt());

        entity.preUpdate();

        assertNotNull(entity.getLastUpdatedAt());
    }

    // ── defaults ───────────────────────────────────────────────────────────────

    @Test
    @DisplayName("active defaults to true")
    void activeDefaultsToTrue() {
        ManagedClientEntity entity = new ManagedClientEntity();
        assertTrue(entity.isActive());
    }

    // ── getters / setters ─────────────────────────────────────────────────────

    @Test
    @DisplayName("all getters and setters round-trip correctly")
    void allGettersAndSettersWorkCorrectly() {
        UUID id            = UUID.randomUUID();
        UUID applicationId = UUID.randomUUID();
        List<String> scopes = List.of("read", "write");
        LocalDateTime now = LocalDateTime.now();

        ManagedClientEntity entity = new ManagedClientEntity();
        entity.setId(id);
        entity.setName(TEST_NAME);
        entity.setDescription(TEST_DESCRIPTION);
        entity.setApplicationId(applicationId);
        entity.setSecretHash(TEST_SECRET_HASH);
        entity.setPrevSecretHash(TEST_PREV_HASH);
        entity.setScopes(scopes);
        entity.setActive(false);
        entity.setCreatedAt(now);
        entity.setLastUpdatedAt(now);
        entity.setSecretLastRotatedAt(now);

        assertEquals(id, entity.getId());
        assertEquals(TEST_NAME, entity.getName());
        assertEquals(TEST_DESCRIPTION, entity.getDescription());
        assertEquals(applicationId, entity.getApplicationId());
        assertEquals(TEST_SECRET_HASH, entity.getSecretHash());
        assertEquals(TEST_PREV_HASH, entity.getPrevSecretHash());
        assertEquals(scopes, entity.getScopes());
        assertFalse(entity.isActive());
        assertEquals(now, entity.getCreatedAt());
        assertEquals(now, entity.getLastUpdatedAt());
        assertEquals(now, entity.getSecretLastRotatedAt());
    }
}
