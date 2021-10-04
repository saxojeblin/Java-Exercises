/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */
package ex41;

public class Person implements Comparable<Person> {
    //Person's name
    private String name;

    public Person(String name1) {
        name = name1;
    }

    @Override //Sorting method. Compares a person's name to decide if should go after or before the prev name
    public int compareTo (Person p) {
        //get int to determine if before or after
        int compInt = this.name.compareTo(p.name);
        if (compInt < 0) {
            return -1; //name was "bigger"
        }
        if (compInt > 0) {
            return 1;  //name was "smaller"
        }
        return 0;
    }
    //get the name of the object
    public String getName() {
        return name;
    }

}
