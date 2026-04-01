/*
 *
 *  @(#)NoticeIdTest.java
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

package com.prx.persistence.general.domains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NoticeEntityIdTest {
    private NoticeId noticeId;
    private UUID userId;
    private UUID applicationId;
    private UUID noticeTypeId;

    @BeforeEach
    void setUp() {
        noticeId = new NoticeId();
        userId = UUID.randomUUID();
        applicationId = UUID.randomUUID();
        noticeTypeId = UUID.randomUUID();
    }

    @Test
    void testDefaultConstructor() {
        NoticeId id = new NoticeId();
        assertNotNull(id);
    }

    @Test
    void testGetSetUserId() {
        noticeId.setUserId(userId);
        assertEquals(userId, noticeId.getUserId());
    }

    @Test
    void testGetSetApplicationId() {
        noticeId.setApplicationId(applicationId);
        assertEquals(applicationId, noticeId.getApplicationId());
    }

    @Test
    void testGetSetNoticeTypeId() {
        noticeId.setNoticeTypeId(noticeTypeId);
        assertEquals(noticeTypeId, noticeId.getNoticeTypeId());
    }

    @Test
    void testEqualsAndHashCode() {
        noticeId.setUserId(userId);
        noticeId.setApplicationId(applicationId);
        noticeId.setNoticeTypeId(noticeTypeId);

        NoticeId other = new NoticeId();
        other.setUserId(userId);
        other.setApplicationId(applicationId);
        other.setNoticeTypeId(noticeTypeId);

        assertEquals(noticeId, other);
        assertEquals(noticeId.hashCode(), other.hashCode());

        other.setNoticeTypeId(UUID.randomUUID());
        assertNotEquals(noticeId, other);
    }
}

