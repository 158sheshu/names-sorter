package com.ddns.namessorter;

import com.ddns.namessorter.model.PersonName;
import com.ddns.namessorter.service.NameSorterService;
import com.ddns.namessorter.service.impl.NameSorterServiceImpl;
import com.ddns.namessorter.util.FileNameReader;
import com.ddns.namessorter.util.FileNameWriter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Main class for the name sorter application
 */
public class Main {
    /**
     * Main method to run the name sorter application.
     *
     * @param args Command line arguments where the first argument is the input file path.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar names-sorter.jar <file-path>");
            return;
        }
        // Get input and output file paths
        String inputFile = args[0];
        String outputFile = "sorted-names-list.txt";

        try {
            //Initialize reader, writer, and sorter
            FileNameReader reader = new FileNameReader();
            FileNameWriter writer = new FileNameWriter();
            NameSorterService sorter = new NameSorterServiceImpl();

            // Read names from file and converts to PersonName objects
            List<PersonName> names = reader.readNames(inputFile)
                                           .stream()
                                           .map(PersonName::new)
                                           .collect(Collectors.toList());
            // Sort names
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