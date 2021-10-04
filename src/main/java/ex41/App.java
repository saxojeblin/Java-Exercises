/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    /* Create the list of names from input, sort it, and then print to output*/
    public static void main(String[] args) throws IOException {
        //Create the list
        ArrayList<Person> nameList = fillNames();
        //Sort the list
        Collections.sort(nameList);
        // Print the list
        printSortedList(nameList);
    }

    /* Get the list from input text file */
    public static ArrayList<Person> fillNames() throws FileNotFoundException {

        ArrayList<Person> nameList  = new ArrayList<>();
        //Create input file to be read
        File file = new File("src/main/java/ex41/exercise41_input.txt");
        Scanner input = new Scanner(file);
        //Add each line of input to list as a person
        while(input.hasNextLine()) {
            nameList.add(new Person(input.nextLine()));
        }
        return nameList;
    }

    /* Print out the sorted list to output.txt by printing each index of the list in order */
    public static void printSortedList(ArrayList<Person> list) throws IOException {
        //Create output file to write on
        FileWriter writer = new FileWriter("src/main/java/ex41/exercise41_output.txt");
        //Print total names/format, then print each name in order
        writer.write("Total of " + list.size() + " names\n-----------------\n");
        for (int i=0; i<list.size(); i++ ) {
            writer.write(list.get(i).getName() + "\n");
        }
        writer.close();
    }
}
