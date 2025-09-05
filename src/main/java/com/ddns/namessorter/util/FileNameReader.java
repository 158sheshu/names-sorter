package com.ddns.namessorter.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Utility class for reading names from a file.
 */
public class FileNameReader {

    /**
     * Reads names from a file, one name per line.
     *
     * @param filePath the path to the input file
     * @return a list of names read from the file
     * @throws IOException if an I/O error occurs reading from the file
     */
    public List<String> readNames(String filePath) throws IOException {
        //reads all lines from the file and returns them as a list of strings
        return Files.readAllLines(Path.of(filePath));
    }
}