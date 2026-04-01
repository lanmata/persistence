/*
 *
 *  @(#)NoticeRepository.java
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

package com.prx.persistence.general.repositories;

import com.prx.persistence.general.domains.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * NoticeRepository interface.
 *
 * This interface provides methods to perform CRUD operations and interact
 * with the data persistence layer for {@link NoticeEntity}. It extends
 * {@link JpaRepository}, inheriting a wide range of JPA-related operations.
 *
 * The repository is responsible for managing {@link NoticeEntity} objects
 * using their primary key of type {@link UUID}. The {@link JpaRepository}
 * provides functionality for basic CRUD operations, pagination, and sorting.
 */
public interface NoticeRepository extends JpaRepository<NoticeEntity, UUID> {
}
