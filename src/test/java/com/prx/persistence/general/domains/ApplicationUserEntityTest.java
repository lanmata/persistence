package com.prx.persistence.general.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationUserEntityTest {

    @Test
    void getId() {
        ApplicationUserEntity applicationUserEntity = new ApplicationUserEntity();
        ApplicationUserEntityKey id = new ApplicationUserEntityKey();
        applicationUserEntity.setId(id);
        Assertions.assertSame(id, applicationUserEntity.getId());
    }

    @Test
    void setId() {
        ApplicationUserEntity applicationUserEntity = new ApplicationUserEntity();
        ApplicationUserEntityKey id = new ApplicationUserEntityKey();
        applicationUserEntity.setId(id);
        Assertions.assertSame(id, applicationUserEntity.getId());
    }

    @Test
    void getService() {
        ApplicationUserEntity applicationUserEntity = new ApplicationUserEntity();
        ApplicationEntity service = new ApplicationEntity();
        applicationUserEntity.setApplication(service);
        Assertions.assertSame(service, applicationUserEntity.getApplication());
    }

    @Test
    void setService() {
        ApplicationUserEntity applicationUserEntity = new ApplicationUserEntity();
        ApplicationEntity service = new ApplicationEntity();
        applicationUserEntity.setApplication(service);
        Assertions.assertSame(service, applicationUserEntity.getApplication());
    }

    @Test
    void getUser() {
        ApplicationUserEntity applicationUserEntity = new ApplicationUserEntity();
        UserEntity user = new UserEntity();
        applicationUserEntity.setUser(user);
        Assertions.assertSame(user, applicationUserEntity.getUser());
    }

    @Test
    void setUser() {
        ApplicationUserEntity applicationUserEntity = new ApplicationUserEntity();
        UserEntity user = new UserEntity();
        applicationUserEntity.setUser(user);
        Assertions.assertSame(user, applicationUserEntity.getUser());
    }

    @Test
    void getActive() {
        ApplicationUserEntity applicationUserEntity = new ApplicationUserEntity();
        applicationUserEntity.setActive(true);
        Assertions.assertTrue(applicationUserEntity.getActive());
    }

    @Test
    void setActive() {
        ApplicationUserEntity applicationUserEntity = new ApplicationUserEntity();
        applicationUserEntity.setActive(true);
        Assertions.assertTrue(applicationUserEntity.getActive());
    }
}
