package com.prx.persistence.general.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserEntityTest.
 *
 * @author Luis Antonio Mata
 * @version 1.0.0, 22-10-2020
 */
class UserEntityTest {

    @Test
    void gettersAndSetters() {
        final var userEntity = new UserEntity();

        userEntity.setId(UUID.fromString("1f23ab15-2a00-451b-b36e-275213eca3aa"));
        userEntity.setAlias("Alias");
        userEntity.setActive(true);
        userEntity.setPassword("34567890");
        userEntity.setPerson(new PersonEntity());
        userEntity.setUserRole(new HashSet<>());

        Assertions.assertAll("Test Getters and Setters",
                () -> Assertions.assertNotNull(userEntity.getId()),
                () -> Assertions.assertNotNull(userEntity.toString()),
                () -> Assertions.assertNotNull(userEntity.getAlias()),
                () -> Assertions.assertNotNull(userEntity.getPerson()),
                () -> Assertions.assertNotNull(userEntity.getActive()),
                () -> Assertions.assertNotNull(userEntity.getUserRole()),
                () -> Assertions.assertNotNull(userEntity.getPassword()),
                () -> Assertions.assertNotEquals(1, userEntity.hashCode()),
                () -> Assertions.assertNotEquals(new UserEntity(), userEntity)
        );

    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link UserEntity}
     *   <li>{@link UserEntity#setActive(Boolean)}
     *   <li>{@link UserEntity#setAlias(String)}
     *   <li>{@link UserEntity#setId(UUID)}
     *   <li>{@link UserEntity#setPassword(String)}
     *   <li>{@link UserEntity#setPerson(PersonEntity)}
     *   <li>{@link UserEntity#setUserRole(Set)}
     *   <li>{@link UserEntity#toString()}
     *   <li>{@link UserEntity#getActive()}
     *   <li>{@link UserEntity#getAlias()}
     *   <li>{@link UserEntity#getId()}
     *   <li>{@link UserEntity#getPassword()}
     *   <li>{@link UserEntity#getPerson()}
     *   <li>{@link UserEntity#getUserRole()}
     * </ul>
     */
    @Test
    void testConstructor() {
        var userUuid = UUID.fromString("c018c63d-60ce-4744-9051-fe25eb417108");
        var personUuid = UUID.fromString("1f8573b4-80c0-408a-8a98-0051c88912cc");
        UserEntity actualUserEntity = new UserEntity();
        actualUserEntity.setActive(true);
        actualUserEntity.setAlias("Alias");
        actualUserEntity.setId(userUuid);
        actualUserEntity.setPassword("iloveyou");
        PersonEntity person = new PersonEntity();
        person.setBirthdate(LocalDate.of(1970, 1, 1));
        person.setGender("Gender");
        person.setId(personUuid);
        person.setLastName("Doe");
        person.setMiddleName("Middle Name");
        person.setName("Name");
        actualUserEntity.setPerson(person);
        HashSet<UserRoleEntity> userRole = new HashSet<>();
        actualUserEntity.setUserRole(userRole);
        String actualToStringResult = actualUserEntity.toString();
        assertTrue(actualUserEntity.getActive());
        assertEquals("Alias", actualUserEntity.getAlias());
        assertEquals(userUuid, actualUserEntity.getId());
        assertEquals("iloveyou", actualUserEntity.getPassword());
        assertSame(person, actualUserEntity.getPerson());
        assertSame(userRole, actualUserEntity.getUserRole());
        assertEquals("UserEntity{id=c018c63d-60ce-4744-9051-fe25eb417108, alias='Alias', password='iloveyou'," +
                " active=true, person=PersonEntity{id=1f8573b4-80c0-408a-8a98-0051c88912cc, name='Name'," +
                " middleName='Middle Name', lastName='Doe', gender='Gender', birthdate=1970-01-01}," +
                " userRole=[]}", actualToStringResult);
    }

}
