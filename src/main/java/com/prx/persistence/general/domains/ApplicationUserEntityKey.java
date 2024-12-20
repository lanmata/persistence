package com.prx.persistence.general.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class ApplicationUserEntityKey implements Serializable {
    @Serial
    private static final long serialVersionUID = -8275434924031321217L;
    @NotNull
    @Column(name = "application_id", nullable = false)
    private UUID applicationId;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    public ApplicationUserEntityKey() {
        // Default constructor
    }

    public UUID getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(UUID serviceId) {
        this.applicationId = serviceId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ApplicationUserEntityKey entity = (ApplicationUserEntityKey) o;
        return Objects.equals(this.applicationId, entity.applicationId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, userId);
    }

}
