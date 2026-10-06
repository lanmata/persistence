package com.umdc.persistence.general.domains;

import com.umdc.commons.general.pojo.AuditEventType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ManagedClientAuditEventEntityTest {

    private static final String TEST_IP      = "10.0.0.5";
    private static final String TEST_JSON    = "{\"grant_type\":\"client_credentials\"}";
    private static final String TEST_OUTCOME = "SUCCESS";

    // ── @PrePersist lifecycle ──────────────────────────────────────────────────

    @Test
    @DisplayName("prePersist sets occurredAt when null")
    void prePersistSetsOccurredAtWhenNull() {
        ManagedClientAuditEventEntity entity = new ManagedClientAuditEventEntity();
        assertNull(entity.getOccurredAt());

        entity.prePersist();

        assertNotNull(entity.getOccurredAt());
    }

    @Test
    @DisplayName("prePersist does NOT overwrite occurredAt when already set")
    void prePersistDoesNotOverwriteOccurredAt() {
        LocalDateTime expected = LocalDateTime.of(2024, Month.JANUARY, 15, 10, 30, 0);
        ManagedClientAuditEventEntity entity = new ManagedClientAuditEventEntity();
        entity.setOccurredAt(expected);

        entity.prePersist();

        assertEquals(expected, entity.getOccurredAt());
    }

    // ── getters / setters ─────────────────────────────────────────────────────

    @Test
    @DisplayName("all getters and setters round-trip correctly")
    void allGettersAndSettersWorkCorrectly() {
        UUID id       = UUID.randomUUID();
        UUID clientId = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());

        ManagedClientAuditEventEntity entity = new ManagedClientAuditEventEntity();
        entity.setId(id);
        entity.setClientId(clientId);
        entity.setEventType(AuditEventType.TOKEN_REFRESH);
        entity.setIpAddress(TEST_IP);
        entity.setOutcome(TEST_OUTCOME);
        entity.setDetails(TEST_JSON);
        entity.setOccurredAt(now);

        assertEquals(id, entity.getId());
        assertEquals(clientId, entity.getClientId());
        assertEquals(AuditEventType.TOKEN_REFRESH, entity.getEventType());
        assertEquals(TEST_IP, entity.getIpAddress());
        assertEquals(TEST_OUTCOME, entity.getOutcome());
        assertEquals(TEST_JSON, entity.getDetails());
        assertEquals(now, entity.getOccurredAt());
    }
}
