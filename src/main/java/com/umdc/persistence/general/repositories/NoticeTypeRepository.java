/*
 *
 *  @(#)NoticeTypeRepository.java
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

package com.umdc.persistence.general.repositories;

import com.umdc.persistence.general.domains.NoticeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository interface for managing {@link NoticeTypeEntity} persistence operations.
 * This interface extends {@link JpaRepository}, providing essential methods for
 * CRUD operations, pagination, and sorting of {@link NoticeTypeEntity} objects.
 *
 * The underlying database table for the {@link NoticeTypeEntity} is `notice_type`,
 * located in the `general` schema. Entities are identified by a {@link UUID} primary key.
 */
public interface NoticeTypeRepository extends JpaRepository<NoticeTypeEntity, UUID> {
}
