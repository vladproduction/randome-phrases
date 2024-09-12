package com.vladproduction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect output to capture printed statements
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testRandomPhrases(){
        // Call the method to test
        Main.printRandomPhrase();

        // Get the output content
        String output = outContent.toString().trim();
        // Check the output contains a time and one of the phrases
        assertTrue(output.matches("\\d{2}:\\d{2}:\\d{2} : .*"));
        assertTrue(Main.PHRASES.stream().anyMatch(output::contains));

    }

    @Test
    public void testMultipleRandomPhrases() {
        // Execute multiple times to cover randomization
        for (int i = 0; i < 10; i++) {
            String previousOutput = outContent.toString(); // Store previous output
            Main.printRandomPhrase();
            String currentOutput = outContent.toString();
            assertTrue(currentOutput.length() > previousOutput.length());
        }
    }

    @AfterEach
    public void tearDown() {
        // Reset system output to console
        System.setOut(originalOut);
    }

}