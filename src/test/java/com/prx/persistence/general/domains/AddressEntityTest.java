package com.prx.persistence.general.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * AddressTest.
 *
 * @author Luis Antonio Mata
 * @version 1.0.0, 21-10-2020
 */
class AddressEntityTest {

    @Test
    void gettersAndSetters(){
        final var address = new AddressEntity();
        address.setId(1);
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
    
}
