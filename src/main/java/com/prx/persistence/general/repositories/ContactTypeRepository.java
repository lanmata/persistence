/*
 * @(#)ContactTypeRepository.java.
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

import com.prx.persistence.general.domains.ContactTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * ContactTypeRepository.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 19-01-2021
 */
public interface ContactTypeRepository  extends CrudRepository<ContactTypeEntity, UUID> {

}
