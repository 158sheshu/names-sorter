package com.ddns.namessorter.util;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileNameWriterTest {

    @Test
    void testWriteNames_ValidInput() throws IOException {
        File tempFile = File.createTempFile("output", ".txt");
        tempFile.deleteOnExit();

        FileNameWriter writer = new FileNameWriter();
        List<String> names = List.of("John Doe", "Alice Smith", "Bob Brown");
        writer.writeNames(tempFile.getAbsolutePath(), names);

        List<String> writtenLines = Files.readAllLines(tempFile.toPath());
        assertEquals(names, writtenLines);
    }

    @Test
    void testWriteNames_EmptyList() throws IOException {
        File tempFile = File.createTempFile("output_empty", ".txt");
        tempFile.deleteOnExit();

        FileNameWriter writer = new FileNameWriter();
        writer.writeNames(tempFile.getAbsolutePath(), List.of());

        List<String> writtenLines = Files.readAllLines(tempFile.toPath());
        assertEquals(0, writtenLines.size());
    }

    @Test
    void testWriteNames_NullFilePath() {
        FileNameWriter writer = new FileNameWriter();
        assertThrows(NullPointerException.class, () -> writer.writeNames(null, List.of("John Doe")));
    }

    @Test
    void testWriteNames_NullNamesList() throws IOException {
        File tempFile = File.createTempFile("output_null", ".txt");
        tempFile.deleteOnExit();

        FileNameWriter writer = new FileNameWriter();
        assertThrows(NullPointerException.class, () -> writer.writeNames(tempFile.getAbsolutePath(), null));
    }
}