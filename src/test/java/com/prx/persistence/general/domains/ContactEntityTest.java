package com.prx.persistence.general.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ContactEntityTest.
 *
 * @author Luis Antonio Mata
 * @version 1.0.0, 22-10-2020
 */
class ContactEntityTest {

    @Test
    void gettersAndSetters() {
        final var contactEntity = new ContactEntity();
        final var contactTypeEntity = new ContactTypeEntity();
        contactTypeEntity.setId(UUID.fromString("e8c8f126-09f2-4ae9-9bb6-4fa459b77609"));
        contactTypeEntity.setName("Contact type 0001");
        contactTypeEntity.setDescription("Contact type description");
        contactTypeEntity.setActive(true);

        contactEntity.setId(UUID.fromString("6adc26ba-87d7-4241-8dca-ce565288a048"));
        contactEntity.setActive(true);
        contactEntity.setPerson(new PersonEntity());
        contactEntity.setContent("Content");
        contactEntity.setContactType(contactTypeEntity);

        Assertions.assertAll("Test Getters And Setters",
                () -> Assertions.assertNotNull(contactEntity.getId()),
                () -> Assertions.assertNotNull(contactEntity.getPerson()),
                () -> Assertions.assertNotNull(contactEntity.getActive()),
                () -> Assertions.assertNotNull(contactEntity.getContent()),
                () -> Assertions.assertNotNull(contactEntity.getContactType()),
                () -> Assertions.assertNotNull(contactEntity.toString()),
                () -> Assertions.assertNotEquals(1, contactEntity.hashCode()),
                () -> Assertions.assertNotEquals(new ContactEntity(), contactEntity)
        );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ContactEntity}
     *   <li>{@link ContactEntity#setActive(Boolean)}
     *   <li>{@link ContactEntity#setContactType(ContactTypeEntity)}
     *   <li>{@link ContactEntity#setContent(String)}
     *   <li>{@link ContactEntity#setId(UUID)}
     *   <li>{@link ContactEntity#setPerson(PersonEntity)}
     *   <li>{@link ContactEntity#toString()}
     *   <li>{@link ContactEntity#getActive()}
     *   <li>{@link ContactEntity#getContactType()}
     *   <li>{@link ContactEntity#getContent()}
     *   <li>{@link ContactEntity#getId()}
     *   <li>{@link ContactEntity#getPerson()}
     * </ul>
     */
    @Test
    void testConstructor() {
        var uuid = UUID.fromString("994bb172-c54b-4b30-b9b7-23536ae62aa6");
        ContactEntity actualContactEntity = new ContactEntity();
        actualContactEntity.setActive(true);
        ContactTypeEntity contactType = new ContactTypeEntity();
        contactType.setActive(true);
        contactType.setDescription("The characteristics of someone or something");
        contactType.setId(uuid);
        contactType.setName("Name");
        actualContactEntity.setContactType(contactType);
        actualContactEntity.setContent("Not all who wander are lost");
        actualContactEntity.setId(uuid);
        PersonEntity person = new PersonEntity();
        person.setBirthdate(LocalDate.of(1970, 1, 1));
        person.setGender("Gender");
        person.setId(uuid);
        person.setLastName("Doe");
        person.setMiddleName("Middle Name");
        person.setName("Name");
        actualContactEntity.setPerson(person);
        String actualToStringResult = actualContactEntity.toString();
        assertTrue(actualContactEntity.getActive());
        assertSame(contactType, actualContactEntity.getContactType());
        assertEquals("Not all who wander are lost", actualContactEntity.getContent());
        assertEquals(uuid, actualContactEntity.getId());
        assertSame(person, actualContactEntity.getPerson());
        assertEquals("ContactEntity{id=994bb172-c54b-4b30-b9b7-23536ae62aa6, content='Not all who wander are lost',"
                + " contactType=ContactTypeEntity{id=994bb172-c54b-4b30-b9b7-23536ae62aa6,"
                + " name='Name', description='The characteristics of someone or something', active=true}, active=true,"
                + " person=PersonEntity{id=994bb172-c54b-4b30-b9b7-23536ae62aa6, name='Name', middleName='Middle Name', lastName='Doe', gender='Gender',"
                + " birthdate=1970-01-01}}", actualToStringResult);
    }

}
