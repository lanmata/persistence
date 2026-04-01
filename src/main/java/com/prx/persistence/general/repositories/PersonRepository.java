/*
 *  @(#)PersonRepository.java
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

import com.prx.persistence.general.domains.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * PersonRepository represents a repository interface for managing PersonEntity objects.
 * It extends the CrudRepository interface, providing basic CRUD functionality,
 * and includes custom query methods for specific operations.
 *
 * @param <PersonEntity> Represents the entity type handled by the repository.
 * @param <UUID> Represents the type of the ID for the entity.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 */
public interface PersonRepository extends CrudRepository<PersonEntity, UUID> {
    @Query("SELECT p FROM PersonEntity p WHERE p.name = :name AND p.middleName = :middleName AND p.lastName = :lastName")
    PersonEntity findByFirstNameMiddleNameLastName(@Param("name") String name, @Param("middleName") String middleName, @Param("lastName") String lastName);

}
