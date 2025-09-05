package com.ddns.namessorter;

import com.ddns.namessorter.model.PersonName;
import com.ddns.namessorter.service.NameSorterService;
import com.ddns.namessorter.service.impl.NameSorterServiceImpl;
import com.ddns.namessorter.util.FileNameReader;
import com.ddns.namessorter.util.FileNameWriter;


import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar names-sorter.jar <file-path>");
            return;
        }

        String inputFile = args[0];
        String outputFile = "sorted-names-list.txt";

        try {
            FileNameReader reader = new FileNameReader();
            FileNameWriter writer = new FileNameWriter();
            NameSorterService sorter = new NameSorterServiceImpl();

            List<PersonName> names = reader.readNames(inputFile)
                                           .stream()
                                           .map(PersonName::new)
                                           .collect(Collectors.toList());

            List<PersonName> sorted = sorter.sortNames(names);

            // Print to console
            sorted.forEach(System.out::println);

            // Write to file
            writer.writeNames(outputFile, 
                              sorted.stream().map(PersonName::getFullName).collect(Collectors.toList()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}