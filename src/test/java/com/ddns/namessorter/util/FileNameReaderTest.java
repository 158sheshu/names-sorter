package com.ddns.namessorter.util;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileNameReaderTest {

    @Test
    void testReadNames_ValidFile() throws IOException {
        File tempFile = File.createTempFile("test", ".txt");
        tempFile.deleteOnExit();

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("John Doe\n");
            writer.write("Alice Smith\n");
            writer.write("Bob Brown\n");
        }

        FileNameReader reader = new FileNameReader();
        List<String> names = reader.readNames(tempFile.getAbsolutePath());

        assertEquals(3, names.size());
        assertEquals("John Doe", names.get(0));
        assertEquals("Alice Smith", names.get(1));
        assertEquals("Bob Brown", names.get(2));
    }

    @Test
    void testReadNames_EmptyFile() throws IOException {
        File tempFile = File.createTempFile("empty", ".txt");
        tempFile.deleteOnExit();

        FileNameReader reader = new FileNameReader();
        List<String> names = reader.readNames(tempFile.getAbsolutePath());

        assertEquals(0, names.size());
    }

    @Test
    void testReadNames_FileNotFound() {
        FileNameReader reader = new FileNameReader();
        assertThrows(IOException.class, () -> reader.readNames("nonexistent.txt"));
    }

    @Test
    void testReadNames_NullFilePath() {
        FileNameReader reader = new FileNameReader();
        assertThrows(NullPointerException.class, () -> reader.readNames(null));
    }
}