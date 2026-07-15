/*
 *  @(#)ApplicationRoleUserRepository.java
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

import com.umdc.persistence.general.domains.ApplicationRoleUserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 */
public interface ApplicationRoleUserRepository extends JpaRepository<ApplicationRoleUserEntity, UUID> {

    @Query("SELECT aru FROM ApplicationRoleUserEntity aru WHERE aru.user.id = :userId AND aru.application.id = :applicationId")
    ApplicationRoleUserEntity findByUserAndApplication(@Param("userId") UUID userId, @Param("applicationId") UUID applicationId);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("DELETE FROM ApplicationRoleUserEntity a WHERE a.user.id = :userId AND a.application.id = :applicationId")
    void deleteByUserIdAndApplicationId(@Param("userId") UUID userId, @Param("applicationId") UUID applicationId);

}
