package com.prx.persistence.general.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * PersonEntityTest.
 *
 * @author Luis Antonio Mata
 * @version 1.0.0, 21-10-2020
 */
class PersonEntityTest {

    @Test
    void gettersAndSetters() {
        final var personEntity = new PersonEntity();

        personEntity.setId(UUID.fromString("673bc2e0-15d9-47ca-b0dc-b98673089cec"));
        personEntity.setGender("M");
        personEntity.setName("Paco");
        personEntity.setMiddleName("Pepe");
        personEntity.setLastName("Pedroza");
        personEntity.setBirthdate(LocalDate.of(1979, 4, 14));

        Assertions.assertAll("Test Getters And Setters",
                () -> Assertions.assertNotNull(personEntity.getId()),
                () -> Assertions.assertNotNull(personEntity.getName()),
                () -> Assertions.assertNotNull(personEntity.getMiddleName()),
                () -> Assertions.assertNotNull(personEntity.getLastName()),
                () -> Assertions.assertNotNull(personEntity.getGender()),
                () -> Assertions.assertNotNull(personEntity.getBirthdate()),
                () -> Assertions.assertNotNull(personEntity.toString()),
                () -> Assertions.assertNotEquals(1, personEntity.hashCode()),
                () -> Assertions.assertNotEquals(new PersonEntity(), personEntity)
        );

    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PersonEntity}
     *   <li>{@link PersonEntity#setBirthdate(LocalDate)}
     *   <li>{@link PersonEntity#setGender(String)}
     *   <li>{@link PersonEntity#setId(UUID)}
     *   <li>{@link PersonEntity#setLastName(String)}
     *   <li>{@link PersonEntity#setMiddleName(String)}
     *   <li>{@link PersonEntity#setName(String)}
     *   <li>{@link PersonEntity#toString()}
     *   <li>{@link PersonEntity#getBirthdate()}
     *   <li>{@link PersonEntity#getGender()}
     *   <li>{@link PersonEntity#getId()}
     *   <li>{@link PersonEntity#getLastName()}
     *   <li>{@link PersonEntity#getMiddleName()}
     *   <li>{@link PersonEntity#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        var personUuid = UUID.fromString("308919fc-7b31-4642-b9a8-7fa60ce64b8c");
        PersonEntity actualPersonEntity = new PersonEntity();
        LocalDate birthdate = LocalDate.of(1970, 1, 1);
        actualPersonEntity.setBirthdate(birthdate);
        actualPersonEntity.setGender("Gender");
        actualPersonEntity.setId(personUuid);
        actualPersonEntity.setLastName("Doe");
        actualPersonEntity.setMiddleName("Middle Name");
        actualPersonEntity.setName("Name");
        String actualToStringResult = actualPersonEntity.toString();
        assertSame(birthdate, actualPersonEntity.getBirthdate());
        assertEquals("Gender", actualPersonEntity.getGender());
        assertEquals(personUuid, actualPersonEntity.getId());
        assertEquals("Doe", actualPersonEntity.getLastName());
        assertEquals("Middle Name", actualPersonEntity.getMiddleName());
        assertEquals("Name", actualPersonEntity.getName());
        assertEquals("PersonEntity{id=308919fc-7b31-4642-b9a8-7fa60ce64b8c, name='Name'," +
                " middleName='Middle Name', lastName='Doe', gender='Gender', birthdate=1970-01-01}", actualToStringResult);
    }

}
