/*
 * @(#)RolRepository.java.
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

import com.prx.persistence.general.domains.RoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * RolRepository.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
public interface RoleRepository extends CrudRepository<RoleEntity, UUID> {

    /**
     * Search roles by role id list.
     *
     * @param idRoles {@link Iterable<String>} elements.
     * @return {@link Optional} object type with {@link List<RoleEntity>} elements.
     */
    @Query(value = "SELECT r FROM RoleEntity r WHERE r.id IN :idRoles ORDER BY r.id ASC")
    Optional<List<RoleEntity>> findById(@Param("idRoles") List<UUID> idRoles);

    /**
     * Search roles by status list.
     *
     * @param status {@link Boolean} elements.
     * @return {@link Optional} object type with {@link List<RoleEntity>} elements.
     */
    @Query(value = "SELECT r FROM RoleEntity r WHERE r.active = :status ORDER BY r.id ASC")
    Optional<List<RoleEntity>> findByStatus(@Param("status") Boolean status);

    /**
     * Search roles by user id.
     *
     * @param idUser {@link String} with {@link String} elements.
     *
     * @return {@link Optional} object type with {@link List<RoleEntity>} elements.
     */
    @Query(value = "SELECT ur.role FROM UserRoleEntity ur WHERE ur.user.id = :idUser ORDER BY ur.user.id ASC")
    Optional<List<RoleEntity>> findByUserId(@Param("idUser") UUID idUser);

    /**
     * Search roles by user id.
     *
     * @param active {@link boolean}.
     * @param ids {@link List<UUID>}.
     *
     * @return {@link Optional} with {@link List<RoleEntity>} elements.
     */
    @Query(value="SELECT r FROM RoleEntity r WHERE r.id IN :ids AND r.active = :active")
    Optional<List<RoleEntity>> findByStatusAndRoleId(@Param("active") boolean active, @Param("ids") List<UUID> ids);

}
