/*
 *  @(#)AddressRepository.java
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
package com.umdc.persistence.general.repositories;

import com.umdc.persistence.general.domains.AddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * AddressRepository.
 *
 * This interface provides CRUD operations for handling {@link AddressEntity}
 * objects in the persistence layer. Extends functionality from
 * {@link CrudRepository} with {@code AddressEntity} as the entity type and
 * {@code UUID} as the ID type.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 */
public interface AddressRepository extends CrudRepository<AddressEntity, UUID> {

    /**
     * Finds all addresses belonging to a given person.
     *
     * @param personId the UUID of the associated person
     * @return the list of addresses for that person
     */
    List<AddressEntity> findByPersonId(UUID personId);
}
