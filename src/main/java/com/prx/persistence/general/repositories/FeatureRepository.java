/*
 * @(#)FeatureRepository.java.
 *
 * Copyright (c) Luis Antonio Mata Mata. All rights reserved.
 *
 * All rights to this product are owned by Luis Antonio Mata Mata and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by Luis Antonio Mata Mata.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.prx.persistence.general.repositories;

import com.prx.persistence.general.domains.FeatureEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * FeatureRepository.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
public interface FeatureRepository extends CrudRepository<FeatureEntity, UUID> {

    /**
     * Busca un feature en base al nombre.
     *
     * @param name {@link String}
     * @return Objeto de tipo {@link Optional}<{@link FeatureEntity>
     */
    @Query(value = "SELECT f FROM FeatureEntity f WHERE f.name = :name ORDER BY f.name DESC")
    Optional<FeatureEntity> findByName(@Param("name") String name);

    /**
     * Busca un feature en base al Id y el estado.
     *
     * @param ids {@link String}
     * @param active {@link boolean}
     * @return Objeto de tipo {@link Optional}<{@link FeatureEntity>
     */
    @Query(value = "SELECT f FROM FeatureEntity f WHERE f.id IN :ids and f.active = :active ORDER BY f.name DESC")
    Optional<Iterable<FeatureEntity>> findByIdAndStatus(@Param("ids") List<UUID> ids, @Param("active") boolean active);

}
