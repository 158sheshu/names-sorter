package com.ddns.namessorter.service.impl;

import com.ddns.namessorter.model.PersonName;
import com.ddns.namessorter.service.NameSorterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameSorterServiceImplTest {


    private NameSorterService nameSorterService;

    @BeforeEach
    void setUp() {
        nameSorterService = new NameSorterServiceImpl();
    }


    @Test
    void testSortNames_Success() {
        List<PersonName> input = Arrays.asList(
                new PersonName("Janet Parsons"),
                new PersonName("Adonis Julius Archer"),
                new PersonName("Beau Tristan Bentley")
        );

        List<PersonName> sorted = nameSorterService.sortNames(input);

        assertEquals("Adonis Julius Archer", sorted.get(0).getFullName());
        assertEquals("Beau Tristan Bentley", sorted.get(1).getFullName());
        assertEquals("Janet Parsons", sorted.get(2).getFullName());
    }

    @Test
    void testSortNames_EmptyList() {
        List<PersonName> input = Collections.emptyList();

        List<PersonName> sorted = nameSorterService.sortNames(input);

        assertEquals(0, sorted.size());
    }

    @Test
    void testSortNames_NullInput() {
        assertThrows(NullPointerException.class, () -> nameSorterService.sortNames(null));
    }

    @Test
    void testSortNames_SingleName() {
        List<PersonName> input = Collections.singletonList(new PersonName("Leo Gardner"));

        List<PersonName> sorted = nameSorterService.sortNames(input);

        assertEquals(1, sorted.size());
        assertEquals("Leo Gardner", sorted.get(0).getFullName());
    }

    @Test
    void testSortNames_MultipleGivenNames() {
        List<PersonName> input = Arrays.asList(
                new PersonName("Hunter Uriah Mathew Clarke"),
                new PersonName("Frankie Conner Ritter")
        );

        List<PersonName> sorted = nameSorterService.sortNames(input);

        assertEquals("Hunter Uriah Mathew Clarke", sorted.get(0).getFullName());
        assertEquals("Frankie Conner Ritter", sorted.get(1).getFullName());
    }

}