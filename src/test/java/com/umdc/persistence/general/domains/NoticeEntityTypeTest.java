/*
 *
 *  @(#)NoticeTypeTest.java
 *
 *  Copyright (c) Luis Antonio Mata Mata. All rights reserved.
 *
 *   All rights to this product are owned by Luis Antonio Mata Mata and may only
 *  be used under the terms of its associated license document. You may NOT
 *  copy, modify, sublicense, or distribute this source file or portions of
 *  it unless previously authorized in writing by Luis Antonio Mata Mata.
 *  In any event, this notice and the above copyright must always be included
 *  verbatim with this file.
 *
 */
package com.umdc.persistence.general.domains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NoticeEntityTypeTest {
    private NoticeTypeEntity noticeTypeEntity;
    private UUID id;
    private String name;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean active;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        name = "Test Notice";
        description = "Test Description";
        createdAt = Instant.now();
        updatedAt = Instant.now();
        active = true;
        noticeTypeEntity = new NoticeTypeEntity();
        noticeTypeEntity.setId(id);
        noticeTypeEntity.setName(name);
        noticeTypeEntity.setDescription(description);
        noticeTypeEntity.setCreatedAt(createdAt);
        noticeTypeEntity.setUpdatedAt(updatedAt);
        noticeTypeEntity.setActive(active);
    }

    @Test
    void testDefaultConstructor() {
        NoticeTypeEntity nt = new NoticeTypeEntity();
        assertNotNull(nt);
    }

    @Test
    void testGetSetId() {
        UUID newId = UUID.randomUUID();
        noticeTypeEntity.setId(newId);
        assertEquals(newId, noticeTypeEntity.getId());
    }

    @Test
    void testGetSetName() {
        String newName = "Another Name";
        noticeTypeEntity.setName(newName);
        assertEquals(newName, noticeTypeEntity.getName());
    }

    @Test
    void testGetSetDescription() {
        String newDescription = "Another Description";
        noticeTypeEntity.setDescription(newDescription);
        assertEquals(newDescription, noticeTypeEntity.getDescription());
    }

    @Test
    void testGetSetCreatedAt() {
        Instant newCreatedAt = Instant.now();
        noticeTypeEntity.setCreatedAt(newCreatedAt);
        assertEquals(newCreatedAt, noticeTypeEntity.getCreatedAt());
    }

    @Test
    void testGetSetUpdatedAt() {
        Instant newUpdatedAt = Instant.now();
        noticeTypeEntity.setUpdatedAt(newUpdatedAt);
        assertEquals(newUpdatedAt, noticeTypeEntity.getUpdatedAt());
    }

    @Test
    void testGetSetActive() {
        noticeTypeEntity.setActive(false);
        assertFalse(noticeTypeEntity.getActive());
        noticeTypeEntity.setActive(true);
        assertTrue(noticeTypeEntity.getActive());
    }
}

