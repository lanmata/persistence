package com.umdc.persistence.general.repositories;

import com.umdc.persistence.general.domains.RoleFeatureEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


/**
 * Repository interface for RoleFeatureEntity.
 *
 * Provides CRUD operations for RoleFeatureEntity instances.
 * Extends the CrudRepository interface from Spring Data.
 *
 * RoleFeatureRepository is used to manage the persistence of RoleFeatureEntity
 * objects in the database and supports basic CRUD operations.
 *
 * @see CrudRepository
 * @see RoleFeatureEntity
 */
public interface RoleFeatureRepository extends CrudRepository<RoleFeatureEntity, UUID> {
}
