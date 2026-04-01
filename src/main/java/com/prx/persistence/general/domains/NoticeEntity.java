/*
 *
 *  @(#)Notice.java
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

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "notice", schema = "general")
public class NoticeEntity {
    @EmbeddedId
    private NoticeId id;

    @MapsId("noticeTypeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "notice_type_id", nullable = false)
    private NoticeTypeEntity noticeTypeEntity;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public NoticeEntity() {
        // Default constructor
    }

    public NoticeId getId() {
        return id;
    }

    public void setId(NoticeId id) {
        this.id = id;
    }

    public NoticeTypeEntity getNoticeType() {
        return noticeTypeEntity;
    }

    public void setNoticeType(NoticeTypeEntity noticeTypeEntity) {
        this.noticeTypeEntity = noticeTypeEntity;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
