package com.ddns.namessorter.service;

import com.ddns.namessorter.model.PersonName;
import java.util.List;

public interface NameSorterService {
    List<PersonName> sortNames(List<PersonName> names);
}