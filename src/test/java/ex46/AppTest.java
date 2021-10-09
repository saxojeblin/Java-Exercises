/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex46;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @BeforeClass
    public static void beforeClass() {
        App app = new App();
    }

    public void fillWordList(ArrayList<String> wordList) {
        wordList.add("badger");
        wordList.add("badger");
        wordList.add("badger");
        wordList.add("badger");
        wordList.add("mushroom");
        wordList.add("mushroom");
        wordList.add("snake");
        wordList.add("badger");
        wordList.add("badger");
        wordList.add("badger");
    }

    @Test
    public void testGetWordList() throws FileNotFoundException {
        //Create the expected list
        ArrayList<String> expected = new ArrayList<>();
        fillWordList(expected);
        //Create the actual list
        ArrayList<String> actual = App.getWordList();
        //Test to ensure they are the same in terms of value
        for(int i=0; i<expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testGetEachWord() throws FileNotFoundException {
        //Create the expected set of words
        Set<String> expected = new HashSet<>();
        expected.add("badger");
        expected.add("mushroom");
        expected.add("snake");
        //Create the actual set of words
        Set<String> actual = App.getEachWord();
        //Compare and see if they are equal
        assertEquals(expected,actual);
    }

    @Test
    public void testPrintWordFrequency() throws FileNotFoundException {
        //Create the expected word list
        ArrayList<Word> expected = new ArrayList<>();
        expected.add(new Word("badger", 7));
        expected.add(new Word("mushroom", 2));
        expected.add(new Word("snake", 1));
        //Create the actual word list
        ArrayList<String> wordList = App.getWordList();
        Set<String> wordSet = App.getEachWord();
        ArrayList<Word> actual = App.getWordFrequency(wordList, wordSet);
        //Compare the list's Word attributes
        for(int i=0; i<3; i++) {
            assertEquals(expected.get(i).getName(), actual.get(i).getName());
            assertEquals(expected.get(i).getFrequency(), actual.get(i).getFrequency());
        }
    }
}
