package com.prx.persistence.general.domains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        service.setId("1f23ab15-2a00-451b-b36e-275213eca3aa");
        service.setName("Application name");
        service.setDescription("Service description");
        service.setActive(true);

        Assertions.assertAll("Test Getters and Setters",
                () -> Assertions.assertNotNull(service.getId()),
                () -> Assertions.assertNotNull(service.getName()),
                () -> Assertions.assertNotNull(service.getDescription()),
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
     *   <li>{@link ServiceEntity#setId(String)}
     *   <li>{@link ServiceEntity#setName(String)}
     *   <li>{@link ServiceEntity#toString()}
     *   <li>{@link ServiceEntity#getDescription()}
     *   <li>{@link ServiceEntity#getId()}
     *   <li>{@link ServiceEntity#getName()}
     *   <li>{@link ServiceEntity#isActive()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ServiceEntity actualServiceEntity = new ServiceEntity();
        actualServiceEntity.setActive(true);
        actualServiceEntity.setDescription("The characteristics of someone or something");
        actualServiceEntity.setId("42");
        actualServiceEntity.setName("Name");
        String actualToStringResult = actualServiceEntity.toString();
        assertEquals("The characteristics of someone or something", actualServiceEntity.getDescription());
        assertEquals("42", actualServiceEntity.getId());
        assertEquals("Name", actualServiceEntity.getName());
        assertTrue(actualServiceEntity.isActive());
        assertEquals("ServiceEntity{id=42, name='Name', description='The characteristics of someone or something',"
                + " active=true}", actualToStringResult);
    }

}
