package com.ddns.namessorter.model;

import java.util.Arrays;
import java.util.List;

public class PersonName {
    private final String fullName;
    private final String lastName;
    private final List<String> givenNames;

    public PersonName(String fullName) {
        this.fullName = fullName.trim();
        String[] parts = this.fullName.split("\\s+");
        this.lastName = parts[parts.length - 1];
        this.givenNames = Arrays.asList(Arrays.copyOf(parts, parts.length - 1));
    }

    public String getFullName() {
        return fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getGivenNames() {
        return givenNames;
    }

    @Override
    public String toString() {
        return fullName;
    }
}