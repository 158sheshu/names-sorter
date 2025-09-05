package com.ddns.namessorter.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Utility class for writing names to a file
 */
public class FileNameWriter {

    /**
     * Writes a list of names to a file, one name per line.
     *
     * @param filePath the path to the output file
     * @param names    the list of names to write
     * @throws IOException if an I/O error occurs writing to the file
     */
    public void writeNames(String filePath, List<String> names) throws IOException {
        //writes the list of names to the specified file, each name on a new line.
        Files.write(Path.of(filePath), names);
    }
}