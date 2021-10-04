/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex41;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @BeforeClass
    public static void beforeClass() {
        App app = new App();
    }

    @Test
    public void testFillNames() throws FileNotFoundException {
        //Create a person array list through method in App.java
        //Create the expected person array list
        ArrayList<Person> test = new ArrayList<Person>();
        ArrayList<Person> actual = new ArrayList<Person>();
        actual = App.fillNames();

        test.add(new Person("Ling, Mai"));
        test.add(new Person("Johnson, Jim"));
        test.add(new Person("Zarnecki, Sabrina"));
        test.add(new Person("Jones, Chris"));
        test.add(new Person("Jones, Aaron"));
        test.add(new Person("Swift, Geoffrey"));
        test.add(new Person("Xiong, Fong"));

        //test at each index that the names are equal
        for (int i=0; i<test.size(); i++) {
            assertEquals(test.get(i).getName(), actual.get(i).getName());
        }
    }

    @Test
    public void testCompareToAndSort() throws FileNotFoundException {
        //Create a person array list through method in App.java
        //Create the expected person array list
        ArrayList<Person> test = new ArrayList<Person>();
        ArrayList<Person> actual = new ArrayList<Person>();
        actual = App.fillNames();

        //Add the test persons in the expected order
        test.add(new Person("Johnson, Jim"));
        test.add(new Person("Jones, Aaron"));
        test.add(new Person("Jones, Chris"));
        test.add(new Person("Ling, Mai"));
        test.add(new Person("Swift, Geoffrey"));
        test.add(new Person("Xiong, Fong"));
        test.add(new Person("Zarnecki, Sabrina"));

        //sort the actual list
        Collections.sort(actual);

        //compare test and actual
        for (int i=0; i<test.size(); i++) {
            assertEquals(test.get(i).getName(), actual.get(i).getName());
        }
    }
}
