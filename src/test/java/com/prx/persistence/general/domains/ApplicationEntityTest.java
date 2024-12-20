package com.prx.persistence.general.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ServiceTest.
 *
 * @author Luis Antonio Mata
 * @version 1.0.0, 22-10-2020
 */
class ApplicationEntityTest {

    @Test
    void gettersAndSetters() {
        final var service = new ApplicationEntity();

        service.setId(UUID.fromString("1f23ab15-2a00-451b-b36e-275213eca3aa"));
        service.setName("Application name");
        service.setDescription("Service description");
        service.setServiceTypeId(UUID.randomUUID());
        service.setActive(true);

        Assertions.assertAll("Test Getters and Setters",
                () -> Assertions.assertNotNull(service.getId()),
                () -> Assertions.assertNotNull(service.getName()),
                () -> Assertions.assertNotNull(service.getDescription()),
                () -> Assertions.assertNotNull(service.getServiceTypeId()),
                () -> Assertions.assertTrue(service.isActive()),
                () -> Assertions.assertNotNull(service.toString()),
                () -> Assertions.assertNotEquals(1, service.hashCode()),
                () -> Assertions.assertNotEquals(new ApplicationEntity(), service)
        );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ApplicationEntity}
     *   <li>{@link ApplicationEntity#setActive(boolean)}
     *   <li>{@link ApplicationEntity#setDescription(String)}
     *   <li>{@link ApplicationEntity#setServiceTypeId(UUID)}
     *   <li>{@link ApplicationEntity#setId(UUID)}
     *   <li>{@link ApplicationEntity#setName(String)}
     *   <li>{@link ApplicationEntity#toString()}
     *   <li>{@link ApplicationEntity#getDescription()}
     *   <li>{@link ApplicationEntity#getServiceTypeId()}
     *   <li>{@link ApplicationEntity#getId()}
     *   <li>{@link ApplicationEntity#getName()}
     *   <li>{@link ApplicationEntity#isActive()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ApplicationEntity actualApplicationEntity = new ApplicationEntity();
        actualApplicationEntity.setActive(true);
        actualApplicationEntity.setServiceTypeId(UUID.fromString("c29f4874-2260-425d-bebb-2d1448f82e2b"));
        actualApplicationEntity.setDescription("The characteristics of someone or something");
        actualApplicationEntity.setId(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"));
        actualApplicationEntity.setName("Name");
        String actualToStringResult = actualApplicationEntity.toString();
        assertEquals("The characteristics of someone or something", actualApplicationEntity.getDescription());
        assertEquals(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"), actualApplicationEntity.getId());
        assertEquals("Name", actualApplicationEntity.getName());
        assertTrue(actualApplicationEntity.isActive());
        assertEquals("ServiceEntity{id=849a7d96-5fda-413c-9926-41f660078e76, name='Name', description='The characteristics of someone or something',"
                + " serviceTypeId=c29f4874-2260-425d-bebb-2d1448f82e2b, active=true}", actualToStringResult);
    }

}
