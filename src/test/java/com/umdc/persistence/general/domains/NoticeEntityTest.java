/*
 *
 *  @(#)NoticeTest.java
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

import static org.junit.jupiter.api.Assertions.*;

class NoticeEntityTest {
    private NoticeEntity notice;
    private NoticeId noticeId;
    private NoticeTypeEntity noticeTypeEntity;
    private Instant createdAt;

    @BeforeEach
    void setUp() {
        notice = new NoticeEntity();
        noticeId = new NoticeId();
        noticeTypeEntity = new NoticeTypeEntity();
        createdAt = Instant.now();
    }

    @Test
    void testDefaultConstructor() {
        NoticeEntity n = new NoticeEntity();
        assertNotNull(n);
    }

    @Test
    void testGetSetId() {
        notice.setId(noticeId);
        assertEquals(noticeId, notice.getId());
    }

    @Test
    void testGetSetNoticeType() {
        notice.setNoticeType(noticeTypeEntity);
        assertEquals(noticeTypeEntity, notice.getNoticeType());
    }

    @Test
    void testGetSetCreatedAt() {
        notice.setCreatedAt(createdAt);
        assertEquals(createdAt, notice.getCreatedAt());
    }
}

