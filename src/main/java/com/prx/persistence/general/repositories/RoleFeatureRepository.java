package com.prx.persistence.general.repositories;

import com.prx.persistence.general.domains.RoleFeatureEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleFeatureRepository extends CrudRepository<RoleFeatureEntity, UUID> {
}
