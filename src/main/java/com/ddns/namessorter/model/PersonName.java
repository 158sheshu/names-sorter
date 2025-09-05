package com.ddns.namessorter.model;

import java.util.Arrays;
import java.util.List;

/**
 * Model class representing a person's name.
 */
public class PersonName {

    // Full name of the person
    private final String fullName;
    // Last name of the person
    private final String lastName;
    // List of given names (first and middle names)
    private final List<String> givenNames;

    // Constructor that takes a full name and splits it into last name and given names
    public PersonName(String fullName) {
        this.fullName = fullName.trim();
        String[] parts = this.fullName.split("\\s+");
        this.lastName = parts[parts.length - 1];
        this.givenNames = Arrays.asList(Arrays.copyOf(parts, parts.length - 1));
    }

    // Getter for full name
    public String getFullName() {
        return fullName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Getter for given names
    public List<String> getGivenNames() {
        return givenNames;
    }

    @Override
    public String toString() {
        return fullName;
    }
}