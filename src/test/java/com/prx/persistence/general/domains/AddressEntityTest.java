package com.prx.persistence.general.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * AddressTest.
 *
 * @author Luis Antonio Mata
 * @version 1.0.0, 21-10-2020
 */
class AddressEntityTest {

    @Test
    void gettersAndSetters() {
        final var address = new AddressEntity();
        address.setId(UUID.fromString("4e5d31fe-78c9-4dc0-8001-75fdb7b4eba7"));
        address.setPerson(new PersonEntity());
        address.setZipcode("1010-9");
        address.setAddress("Address description");

        Assertions.assertAll("Test Getters And Setters",
                () -> Assertions.assertNotNull(address.getId()),
                () -> Assertions.assertNotNull(address.getPerson()),
                () -> Assertions.assertNotNull(address.getZipcode()),
                () -> Assertions.assertNotNull(address.getAddress()),
                () -> Assertions.assertNotNull(address.toString()),
                () -> Assertions.assertNotEquals(1, address.hashCode()),
                () -> Assertions.assertNotEquals(new AddressEntity(), address)
        );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link AddressEntity}
     *   <li>{@link AddressEntity#setAddress(String)}
     *   <li>{@link AddressEntity#setId(UUID)}
     *   <li>{@link AddressEntity#setPerson(PersonEntity)}
     *   <li>{@link AddressEntity#setZipcode(String)}
     *   <li>{@link AddressEntity#toString()}
     *   <li>{@link AddressEntity#getAddress()}
     *   <li>{@link AddressEntity#getId()}
     *   <li>{@link AddressEntity#getPerson()}
     *   <li>{@link AddressEntity#getZipcode()}
     * </ul>
     */
    @Test
    void testConstructor() {
        var addressUuid = UUID.fromString("ffb41e69-b6b8-4afc-a742-6de63788d773");
        var personUuid = UUID.fromString("fc23b1a9-c58a-4a4c-9538-f32105af7293");
        AddressEntity actualAddressEntity = new AddressEntity();
        actualAddressEntity.setAddress("42 Main St");
        actualAddressEntity.setId(addressUuid);
        PersonEntity person = new PersonEntity();
        person.setBirthdate(LocalDate.of(1970, 1, 1));
        person.setGender("Gender");
        person.setId(personUuid);
        person.setLastName("Doe");
        person.setMiddleName("Middle Name");
        person.setName("Name");
        actualAddressEntity.setPerson(person);
        actualAddressEntity.setZipcode("21654");
        String actualToStringResult = actualAddressEntity.toString();
        assertEquals("42 Main St", actualAddressEntity.getAddress());
        assertEquals(addressUuid, actualAddressEntity.getId());
        assertSame(person, actualAddressEntity.getPerson());
        assertEquals("21654", actualAddressEntity.getZipcode());
        assertEquals(
                "AddressEntity{id=ffb41e69-b6b8-4afc-a742-6de63788d773, address='42 Main St', zipcode='21654'," +
                        " person=PersonEntity{id=fc23b1a9-c58a-4a4c-9538-f32105af7293, name='Name'," +
                        " middleName='Middle Name', lastName='Doe', gender='Gender', birthdate=1970-01-01}}",
                actualToStringResult);
    }

}
