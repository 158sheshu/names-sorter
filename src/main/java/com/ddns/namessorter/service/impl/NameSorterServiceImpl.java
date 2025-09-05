package com.ddns.namessorter.service.impl;

import com.ddns.namessorter.model.PersonName;
import com.ddns.namessorter.service.NameSorterService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the NameSorterService interface.
 * Provides functionality to sort a list of PersonName objects.
 */
public class NameSorterServiceImpl implements NameSorterService {
    /**
     * Sorts a list of PersonName objects first by last name, then by given names.
     *
     * @param names List of PersonName objects to be sorted.
     * @return A new list of PersonName objects sorted by last name and given names.
     */
    public List<PersonName> sortNames(List<PersonName> names) {

        //sort by last name, then by given names
        return names.stream()
                .sorted(Comparator.comparing(PersonName::getLastName)
                        .thenComparing(p -> String.join(" ", p.getGivenNames())))
                .collect(Collectors.toList());
    }
}