/*
 * @(#)FeatureEntityTest.java.
 *
 * Copyright (c) Luis Antonio Mata Mata. All rights reserved.
 *
 * All rights to this product are owned by Luis Antonio Mata Mata and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by Luis Antonio Mata Mata.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */

package com.prx.persistence.general.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FeatureEntityTest.
 *
 * @author <a href='mailto:luis.antonio.mata@gmail.com'>Luis Antonio Mata.</a>
 * @version 1.0.3.20200904-01, 18-01-2021
 */
class FeatureEntityTest {
    @Test
    void gettersAndSetters() {
        final var featureEntity = new FeatureEntity();
        final var rolFeatures = new HashSet<RoleFeatureEntity>();

        featureEntity.setId(UUID.fromString("76e47fc1-75d4-4c16-b40a-e67006964a7e"));
        featureEntity.setActive(true);
        featureEntity.setName("Feature name");
        featureEntity.setDescription("Feature description");
        featureEntity.setRolFeatures(rolFeatures);

        Assertions.assertAll("Test Getters And Setters",
                () -> Assertions.assertNotNull(featureEntity.getId()),
                () -> Assertions.assertNotNull(featureEntity.getName()),
                () -> Assertions.assertNotNull(featureEntity.toString()),
                () -> Assertions.assertNotNull(featureEntity.getActive()),
                () -> Assertions.assertNotNull(featureEntity.getDescription()),
                () -> Assertions.assertNotNull(featureEntity.getRolFeatures()),
                () -> Assertions.assertNotEquals(1, featureEntity.hashCode()),
                () -> Assertions.assertNotEquals(new FeatureEntity(), featureEntity)
        );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link FeatureEntity}
     *   <li>{@link FeatureEntity#setActive(Boolean)}
     *   <li>{@link FeatureEntity#setDescription(String)}
     *   <li>{@link FeatureEntity#setId(UUID)}
     *   <li>{@link FeatureEntity#setName(String)}
     *   <li>{@link FeatureEntity#setRolFeatures(Set)}
     *   <li>{@link FeatureEntity#toString()}
     *   <li>{@link FeatureEntity#getActive()}
     *   <li>{@link FeatureEntity#getDescription()}
     *   <li>{@link FeatureEntity#getId()}
     *   <li>{@link FeatureEntity#getName()}
     *   <li>{@link FeatureEntity#getRolFeatures()}
     * </ul>
     */
    @Test
    void testConstructor() {
        FeatureEntity actualFeatureEntity = new FeatureEntity();
        actualFeatureEntity.setActive(true);
        actualFeatureEntity.setDescription("The characteristics of someone or something");
        actualFeatureEntity.setId(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"));
        actualFeatureEntity.setName("Name");
        HashSet<RoleFeatureEntity> rolFeatures = new HashSet<>();
        actualFeatureEntity.setRolFeatures(rolFeatures);
        String actualToStringResult = actualFeatureEntity.toString();
        assertTrue(actualFeatureEntity.getActive());
        assertEquals("The characteristics of someone or something", actualFeatureEntity.getDescription());
        assertEquals(UUID.fromString("849a7d96-5fda-413c-9926-41f660078e76"), actualFeatureEntity.getId());
        assertEquals("Name", actualFeatureEntity.getName());
        assertSame(rolFeatures, actualFeatureEntity.getRolFeatures());
        assertEquals(
                "FeatureEntity{id=849a7d96-5fda-413c-9926-41f660078e76, name='Name', description='The characteristics of someone or something', active=true,"
                        + " rolFeatures=[]}",
                actualToStringResult);
    }
}
