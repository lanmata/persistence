package com.prx.persistence.general.repositories;

import com.prx.persistence.general.domains.ApplicationUserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUserEntity, UUID> {
}
