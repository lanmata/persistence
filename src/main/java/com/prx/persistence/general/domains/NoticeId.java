/*
 *
 *  @(#)NoticeId.java
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

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class NoticeId implements Serializable {
    private static final long serialVersionUID = 5052947020753481421L;
    @NotNull
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @NotNull
    @Column(name = "application_id", nullable = false)
    private UUID applicationId;

    @NotNull
    @Column(name = "notice_type_id", nullable = false)
    private UUID noticeTypeId;

    public NoticeId() {
        // Default constructor
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(UUID applicationId) {
        this.applicationId = applicationId;
    }

    public UUID getNoticeTypeId() {
        return noticeTypeId;
    }

    public void setNoticeTypeId(UUID noticeTypeId) {
        this.noticeTypeId = noticeTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NoticeId entity = (NoticeId) o;
        return Objects.equals(this.noticeTypeId, entity.noticeTypeId) &&
                Objects.equals(this.applicationId, entity.applicationId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noticeTypeId, applicationId, userId);
    }

}
