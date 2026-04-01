/*
 *  @(#)ApplicationRepository.java
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

import com.prx.persistence.general.domains.ApplicationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Interface for the Application Repository.
 *
 * This repository interface handles the persistence and retrieval of {@link ApplicationEntity}
 * objects using the methods provided by {@link CrudRepository}.
 * It supports basic CRUD operations and works with {@link UUID} as the primary key type.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 */
public interface ApplicationRepository extends CrudRepository<ApplicationEntity, UUID> {
}
