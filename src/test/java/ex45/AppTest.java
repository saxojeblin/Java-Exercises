/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex45;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @BeforeClass
    public static void beforeClass() {
        App app = new App();
    }

    @Test
    public void testGetInput() throws FileNotFoundException {
        String[] expected = new String[3];
        expected[0] = "One should never utilize the word \"utilize\" in writing. Use \"use\" instead.";
        expected[1] = "For example, \"She uses an IDE to write her Java programs\" instead of \"She";
        expected[2] = "utilizes an IDE to write her Java programs\".";

        String[] actual = App.getInput();

        for(int i=0; i<3; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testReplaceWords() throws FileNotFoundException {
        String[] expectedText = new String[3];
        expectedText[0] = "One should never use the word \"use\" in writing. Use \"use\" instead.";
        expectedText[1] = "For example, \"She uses an IDE to write her Java programs\" instead of \"She";
        expectedText[2] = "uses an IDE to write her Java programs\".";
        WordFinder expected = new WordFinder(expectedText);

        String[] actualInput = App.getInput();
        WordFinder actual = new WordFinder(actualInput);
        actual.replaceWords();

        for(int i=0; i<3; i++) {
            assertEquals(expected.getLine(i), actual.getLine(i));
        }
    }

    @Test
    public void testCreateOutput() throws IOException {
        String[] input = App.getInput();
        WordFinder sentence = new WordFinder(input);
        sentence.replaceWords();
        String outputName = "output";
        sentence.createOutput(outputName);

        File file = new File("src/main/java/ex45/output.txt");

        if (file.exists()) {
            assertEquals(1,1);
        }
        else
            assertEquals(0,1);
    }
}
