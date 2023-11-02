/*
 *  @(#)ContactRepository.java
 *
 *  Copyright (c) Luis Antonio Mata Mata. All rights reserved.
 *
 *  All rights to this product are owned by Luis Antonio Mata Mata and may only
 *  be used under the terms of its associated license document. You may NOT
 *  copy, modify, sublicense, or distribute this source file or portions of
 *  it unless previously authorized in writing by Luis Antonio Mata Mata.
 *  In any event, this notice and the above copyright must always be included
 *  verbatim with this file.
 */
package com.prx.persistence.general.repositories;

import com.prx.persistence.general.domains.ContactEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 */
public interface ContactRepository extends CrudRepository<ContactEntity, UUID> {

    /**
     * Getting a contact list by person ID.
     *
     * @param personId {@link String}.
     * @return {@link Optional}<{@link List}<{@link ContactEntity}>>
     */
    @Query(value = "SELECT ce FROM ContactEntity ce WHERE ce.person.id = :personId ORDER BY ce.contactType.name")
    Optional<List<ContactEntity>> listByPersonId(@Param("personId") UUID personId);
}
