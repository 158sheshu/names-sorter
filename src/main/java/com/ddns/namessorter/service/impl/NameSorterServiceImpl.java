package com.ddns.namessorter.service.impl;

import com.ddns.namessorter.model.PersonName;
import com.ddns.namessorter.service.NameSorterService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NameSorterServiceImpl implements NameSorterService {
    public List<PersonName> sortNames(List<PersonName> names) {
        return names.stream()
                .sorted(Comparator.comparing(PersonName::getLastName)
                        .thenComparing(p -> String.join(" ", p.getGivenNames())))
                .collect(Collectors.toList());
    }
}