package com.prx.persistence.general.domains;

import com.prx.commons.enums.types.IdentificationType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * IdentificationDocumentTest.
 *
 * @author Luis Antonio Mata
 * @version 1.0.0, 22-10-2020
 */
class IdentificationDocumentEntityTest {

    @Test
    void gettersAndSetters() {
        final var identificationDocument = new IdentificationDocumentEntity();

        identificationDocument.setId(UUID.fromString("42c24163-4716-47f0-b158-25806755306a"));
        identificationDocument.setNumber(114);
        identificationDocument.setPerson(new PersonEntity());
        identificationDocument.setExpirationDate(LocalDateTime.now(ZoneId.systemDefault()));
        identificationDocument.setIdentificationType(IdentificationType.PASSPORT);

        Assertions.assertAll("Test Getters And Setters",
                () -> Assertions.assertNotNull(identificationDocument.getId()),
                () -> Assertions.assertNotNull(identificationDocument.toString()),
                () -> Assertions.assertNotNull(identificationDocument.getPerson()),
                () -> Assertions.assertNotNull(identificationDocument.getNumber()),
                () -> Assertions.assertNotNull(identificationDocument.getExpirationDate()),
                () -> Assertions.assertNotNull(identificationDocument.getIdentificationType()),
                () -> Assertions.assertNotEquals(1, identificationDocument.hashCode()),
                () -> Assertions.assertNotEquals(new IdentificationDocumentEntity(), identificationDocument)
        );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link IdentificationDocumentEntity}
     *   <li>{@link IdentificationDocumentEntity#setExpirationDate(LocalDateTime)}
     *   <li>{@link IdentificationDocumentEntity#setId(UUID)}
     *   <li>{@link IdentificationDocumentEntity#setIdentificationType(IdentificationType)}
     *   <li>{@link IdentificationDocumentEntity#setNumber(Integer)}
     *   <li>{@link IdentificationDocumentEntity#setPerson(PersonEntity)}
     *   <li>{@link IdentificationDocumentEntity#toString()}
     *   <li>{@link IdentificationDocumentEntity#getExpirationDate()}
     *   <li>{@link IdentificationDocumentEntity#getId()}
     *   <li>{@link IdentificationDocumentEntity#getIdentificationType()}
     *   <li>{@link IdentificationDocumentEntity#getNumber()}
     *   <li>{@link IdentificationDocumentEntity#getPerson()}
     * </ul>
     */
    @Test
    void testConstructor() {
        IdentificationDocumentEntity actualIdentificationDocumentEntity = new IdentificationDocumentEntity();
        LocalDateTime expirationDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualIdentificationDocumentEntity.setExpirationDate(expirationDate);
        actualIdentificationDocumentEntity.setId(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"));
        actualIdentificationDocumentEntity.setIdentificationType(IdentificationType.PASSPORT);
        actualIdentificationDocumentEntity.setNumber(10);
        PersonEntity person = new PersonEntity();
        person.setBirthdate(LocalDate.of(1970, 1, 1));
        person.setGender("Gender");
        person.setId(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"));
        person.setLastName("Doe");
        person.setMiddleName("Middle Name");
        person.setName("Name");
        actualIdentificationDocumentEntity.setPerson(person);
        String actualToStringResult = actualIdentificationDocumentEntity.toString();
        assertSame(expirationDate, actualIdentificationDocumentEntity.getExpirationDate());
        assertEquals(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"), actualIdentificationDocumentEntity.getId());
        assertEquals(IdentificationType.PASSPORT, actualIdentificationDocumentEntity.getIdentificationType());
        assertEquals(10, actualIdentificationDocumentEntity.getNumber().intValue());
        assertSame(person, actualIdentificationDocumentEntity.getPerson());
        assertEquals(
                "IdentificationDocumentEntity{id=849a7d96-5fda-413c-9926-41f660078e76, number=10, expirationDate=1970-01-01T00:00, identificationType=PASSPORT,"
                        + " person=PersonEntity{id=849a7d96-5fda-413c-9926-41f660078e76, name='Name', middleName='Middle Name', lastName='Doe', gender='Gender',"
                        + " birthdate=1970-01-01}}",
                actualToStringResult);
    }

}
