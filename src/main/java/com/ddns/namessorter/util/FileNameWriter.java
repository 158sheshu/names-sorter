package com.ddns.namessorter.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileNameWriter {
    public void writeNames(String filePath, List<String> names) throws IOException {
        Files.write(Path.of(filePath), names);
    }
}