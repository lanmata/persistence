package com.prx.persistence.general.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "application_user", schema = "general")
public class ApplicationUserEntity {
    @EmbeddedId
    private ApplicationUserEntityKey id;

    @MapsId("applicationId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private ApplicationEntity application;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @NotNull
    @ColumnDefault("false")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    public ApplicationUserEntity() {
        // Default constructor
    }

    public ApplicationUserEntityKey getId() {
        return id;
    }

    public void setId(ApplicationUserEntityKey id) {
        this.id = id;
    }

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity service) {
        this.application = service;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
