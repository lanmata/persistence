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
class ServiceEntityTest {

    @Test
    void gettersAndSetters() {
        final var service = new ServiceEntity();

        service.setId(UUID.fromString("1f23ab15-2a00-451b-b36e-275213eca3aa"));
        service.setName("Application name");
        service.setDescription("Service description");
        service.setServiceTypeId("1f23ab15-2a00-451b-b36e-275213eca3aa");
        service.setActive(true);

        Assertions.assertAll("Test Getters and Setters",
                () -> Assertions.assertNotNull(service.getId()),
                () -> Assertions.assertNotNull(service.getName()),
                () -> Assertions.assertNotNull(service.getDescription()),
                () -> Assertions.assertNotNull(service.getServiceTypeId()),
                () -> Assertions.assertTrue(service.isActive()),
                () -> Assertions.assertNotNull(service.toString()),
                () -> Assertions.assertNotEquals(1, service.hashCode()),
                () -> Assertions.assertNotEquals(new ServiceEntity(), service)
        );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ServiceEntity}
     *   <li>{@link ServiceEntity#setActive(boolean)}
     *   <li>{@link ServiceEntity#setDescription(String)}
     *   <li>{@link ServiceEntity#setServiceTypeId(String)}
     *   <li>{@link ServiceEntity#setId(UUID)}
     *   <li>{@link ServiceEntity#setName(String)}
     *   <li>{@link ServiceEntity#toString()}
     *   <li>{@link ServiceEntity#getDescription()}
     *   <li>{@link ServiceEntity#getServiceTypeId()}
     *   <li>{@link ServiceEntity#getId()}
     *   <li>{@link ServiceEntity#getName()}
     *   <li>{@link ServiceEntity#isActive()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ServiceEntity actualServiceEntity = new ServiceEntity();
        actualServiceEntity.setActive(true);
        actualServiceEntity.setServiceTypeId("c29f4874-2260-425d-bebb-2d1448f82e2b");
        actualServiceEntity.setDescription("The characteristics of someone or something");
        actualServiceEntity.setId(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"));
        actualServiceEntity.setName("Name");
        String actualToStringResult = actualServiceEntity.toString();
        assertEquals("The characteristics of someone or something", actualServiceEntity.getDescription());
        assertEquals(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"), actualServiceEntity.getId());
        assertEquals("Name", actualServiceEntity.getName());
        assertTrue(actualServiceEntity.isActive());
        assertEquals("ServiceEntity{id=849a7d96-5fda-413c-9926-41f660078e76, name='Name', description='The characteristics of someone or something',"
                + " serviceTypeId='c29f4874-2260-425d-bebb-2d1448f82e2b', active=true}", actualToStringResult);
    }

}
