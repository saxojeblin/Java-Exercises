/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex42;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @BeforeClass
    public static void beforeClass() {
        App app = new App();
    }

    @Test
    public void testFillPeopleList() throws FileNotFoundException {
        //Create a person array list through method in App.java
        //Create the expected person array list
        ArrayList<Person> test = new ArrayList<>();
        ArrayList<Person> actual = App.fillPeopleList();

        test.add(new Person("Ling", "Mai", 55900));
        test.add(new Person("Johnson", "Jim", 56500));
        test.add(new Person("Jones", "Aaron", 46000));
        test.add(new Person("Jones", "Chris", 34500));
        test.add(new Person("Swift", "Geoffrey", 14200));
        test.add(new Person("Xiong", "Fong", 65000));
        test.add(new Person("Zarnecki", "Sabrina", 51500));

        //test at each index that the first/last names and salaries are equal
        for (int i=0; i<test.size(); i++) {
            assertEquals(test.get(i).getFirstName(), actual.get(i).getFirstName());
            assertEquals(test.get(i).getLastName(), actual.get(i).getLastName());
            assertEquals(test.get(i).getSalary(), actual.get(i).getSalary());
        }
    }
}
