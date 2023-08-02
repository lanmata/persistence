package com.prx.persistence.general.repositories;

import com.prx.persistence.general.domains.RoleFeatureEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleFeatureRepository extends CrudRepository<RoleFeatureEntity, String> {

    @Modifying
    @Query("Delete from RoleFeatureEntity entt where entt.role = :roleId and entt.feature = :featureId")
    void deleteRoleFeatureByRoleIdAndFeatureId(@Param("roleId") String roleId, @Param("featureId") String featureId);
}
