package com.prx.persistence.general.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationEntityTest {

    @Test
    @DisplayName("Getters and Setters")
    void gettersAndSetters() {
        final var service = new ApplicationEntity();

        service.setId(UUID.fromString("1f23ab15-2a00-451b-b36e-275213eca3aa"));
        service.setName("Application name");
        service.setDescription("Service description");
        service.setServiceTypeId(UUID.randomUUID());
        service.setActive(true);

        assertAll("Test Getters and Setters",
                () -> assertNotNull(service.getId()),
                () -> assertNotNull(service.getName()),
                () -> assertNotNull(service.getDescription()),
                () -> assertNotNull(service.getServiceTypeId()),
                () -> assertTrue(service.isActive()),
                () -> assertNotNull(service.toString()),
                () -> assertNotEquals(1, service.hashCode()),
                () -> assertNotEquals(new ApplicationEntity(), service)
        );
    }

    @Test
    @DisplayName("Constructor with Parameters")
    void constructorWithParameters() {
        UUID id = UUID.randomUUID();
        String name = "Test Application";
        String description = "Test Description";
        UUID serviceTypeId = UUID.randomUUID();
        boolean active = true;

        ApplicationEntity service = new ApplicationEntity();
        service.setId(id);
        service.setName(name);
        service.setDescription(description);
        service.setServiceTypeId(serviceTypeId);
        service.setActive(active);

        assertEquals(id, service.getId());
        assertEquals(name, service.getName());
        assertEquals(description, service.getDescription());
        assertEquals(serviceTypeId, service.getServiceTypeId());
        assertTrue(service.isActive());
    }

    @Test
    @DisplayName("toString Contains All Fields")
    void toStringContainsAllFields() {
        UUID id = UUID.randomUUID();
        String name = "Test Application";
        String description = "Test Description";
        UUID serviceTypeId = UUID.randomUUID();
        boolean active = true;

        ApplicationEntity service = new ApplicationEntity();
        service.setId(id);
        service.setName(name);
        service.setDescription(description);
        service.setServiceTypeId(serviceTypeId);
        service.setActive(active);

        String toString = service.toString();
        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains(name));
        assertTrue(toString.contains(description));
        assertTrue(toString.contains(serviceTypeId.toString()));
        assertTrue(toString.contains(String.valueOf(active)));
    }

    @Test
    @DisplayName("Equals and HashCode")
    void equalsAndHashCode() {
        UUID id = UUID.randomUUID();
        ApplicationEntity applicationEntity = new ApplicationEntity();
        applicationEntity.setId(id);
        ApplicationEntity applicationEntity1 = new ApplicationEntity();
        applicationEntity1.setId(id);

        assertNotEquals(applicationEntity.hashCode(), applicationEntity1.hashCode());
    }

    @Test
    @DisplayName("Not Equals Different Id")
    void notEqualsDifferentId() {
        ApplicationEntity service1 = new ApplicationEntity();
        service1.setId(UUID.randomUUID());
        ApplicationEntity service2 = new ApplicationEntity();
        service2.setId(UUID.randomUUID());

        assertNotEquals(service1, service2);
    }

    @Test
    @DisplayName("Constructor")
    void constructor() {
        ApplicationEntity actualApplicationEntity = new ApplicationEntity();
        actualApplicationEntity.setActive(true);
        actualApplicationEntity.setServiceTypeId(UUID.fromString("c29f4874-2260-425d-bebb-2d1448f82e2b"));
        actualApplicationEntity.setDescription("The characteristics of someone or something");
        actualApplicationEntity.setId(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"));
        actualApplicationEntity.setName("Name");
        actualApplicationEntity.setCodeName("NNM");
        String actualToStringResult = actualApplicationEntity.toString();
        assertEquals("The characteristics of someone or something", actualApplicationEntity.getDescription());
        assertEquals(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"), actualApplicationEntity.getId());
        assertEquals("Name", actualApplicationEntity.getName());
        assertEquals("NNM", actualApplicationEntity.getCodeName());
        assertTrue(actualApplicationEntity.isActive());
        assertEquals("ServiceEntity{id=849a7d96-5fda-413c-9926-41f660078e76, name='Name'," + " codeName='NNM'," +
                " description='The characteristics of someone or something', serviceTypeId=c29f4874-2260-425d-bebb-2d1448f82e2b," +
                " active=true, applicationRoleUser=null}", actualToStringResult);
    }
}
