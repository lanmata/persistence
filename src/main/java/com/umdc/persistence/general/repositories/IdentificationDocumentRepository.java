/*
 *  @(#)IdentificationDocumentRepository.java
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

import com.umdc.persistence.general.domains.IdentificationDocumentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * IdentificationDocumentRepository is a repository interface for performing CRUD
 * operations on IdentificationDocumentEntity objects. This interface extends
 * {@link CrudRepository} to inherit methods
 * for saving, deleting, and finding IdentificationDocumentEntity instances.
 *
 * IdentificationDocumentEntity represents identification documents associated
 * with individuals, containing information such as document number, expiration
 * date, identification type, and the associated person.
 *
 * This repository is utilized to manage the persistence context and provides data
 * access functionality for managing identification documents.
 *
 * @author <a href="mailto:luis.antonio.mata@gmail.com">Luis Antonio Mata</a>
 */
public interface IdentificationDocumentRepository extends CrudRepository<IdentificationDocumentEntity, UUID> {
}
