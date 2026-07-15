/*
 *  @(#)UserRepository.java
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

import com.umdc.persistence.general.domains.UserEntity;
import jakarta.validation.constraints.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link UserEntity} instances.
 * Extends {@link JpaRepository} to provide standard CRUD operations and custom
 * query methods for user-related data.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 */
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    ///  Find a user by alias.
    ///
    /// @param alias the user alias to find the user
    /// @return the user entity
    @Query("SELECT u FROM UserEntity u WHERE u.alias = :alias")
    UserEntity findByAlias(@Param("alias") String alias);

    ///  Find a user by email.
    ///
    /// @param userId the user email to find the user
    /// @return the user entity
    @Query("SELECT u FROM UserEntity u INNER JOIN FETCH u.person p LEFT JOIN FETCH p.contacts WHERE u.id = :userId")
    UserEntity findUserInfo(@Param("userId") UUID userId);

    ///  Find a user by email.
    ///
    /// @param alias the user email to find the user
    /// @return the user entity
    UserEntity findByAliasAndPassword(String alias, String password);

    ///  Find a user by email.
    ///
    /// @param email         the user email to find the user
    /// @param applicationId the application ID to find the user
    /// @return the user entity
    @Query("SELECT u FROM UserEntity u JOIN u.applicationRoleUser ar WHERE u.email = :email AND ar.application.id = :applicationId")
    Optional<UserEntity> findByEmailAndApplication(@Email @NotBlank @NotEmpty @NotNull @Size(min = 5, max = 250) String email, UUID applicationId);

    ///  Find a user by alias.
    ///
    /// @param alias         the user alias to find the user
    /// @param applicationId the application ID to find the user
    /// @return the user entity
    @Query("SELECT u FROM UserEntity u JOIN u.applicationRoleUser ar WHERE u.alias = :alias AND ar.application.id = :applicationId")
    Optional<UserEntity> findByAliasAndApplication(@NotBlank @NotEmpty @NotNull @Size(min = 5, max = 12) String alias, UUID applicationId);

    ///  Find a user by alias.
    ///
    /// @param applicationId the application ID to find the user
    /// @return the user entity
    @Query("SELECT u FROM UserEntity u JOIN u.applicationRoleUser ar WHERE ar.application.id = :applicationId")
    List<UserEntity> findByApplication(UUID applicationId);

}
