package com.ddns.namessorter.model;

import com.ddns.namessorter.model.PersonName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonNameTest {

    @Test
    void testPersonNameParsing_ValidInput() {
        PersonName name = new PersonName("Adonis Julius Archer");

        assertEquals("Archer", name.getLastName());
        assertEquals(List.of("Adonis", "Julius"), name.getGivenNames());
        assertEquals("Adonis Julius Archer", name.getFullName());
    }

    @Test
    void testPersonNameParsing_SingleName() {
        PersonName name = new PersonName("Archer");

        assertEquals("Archer", name.getLastName());
        assertEquals(List.of(), name.getGivenNames());
        assertEquals("Archer", name.getFullName());
    }

    @Test
    void testPersonNameParsing_NullInput() {
        assertThrows(NullPointerException.class, () -> new PersonName(null));
    }
}