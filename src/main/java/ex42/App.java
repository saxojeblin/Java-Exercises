/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */


package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        //Create a list of people
        //Fill the list with proper info
        ArrayList<Person> peopleList = fillPeopleList();
        //Print the list in tabular format
        printTableList(peopleList);
    }

    public static ArrayList<Person> fillPeopleList() throws FileNotFoundException {
        //Create input file to read from
        File inputFile = new File("src/main/java/ex42/exercise42_input.txt");
        Scanner input = new Scanner(inputFile);
        ArrayList<Person> peopleList  = new ArrayList<>();

        //Create a string that can be used to parse
        String parse = ",";

        //Loop through each line of input
        while(input.hasNextLine()) {

            //Create a string array which each index being an attribute of a person
            String[] peopleInfo = input.nextLine().split(parse);
            int sal = Integer.parseInt(peopleInfo[2]);

            //Add the person to the list with proper attributes
            peopleList.add(new Person(peopleInfo[0], peopleInfo[1], sal));

        }
        //Return the list
        return peopleList;
    }

    public static void printTableList (ArrayList<Person> peopleList) {
        //Print tabular format (first two lines)
        System.out.println("Last       First      Salary\n---------------------------");
        //Print each person using printf formatter
        for(int i=0; i<peopleList.size(); i++) {
            System.out.printf("%-10s %-10s %-10d\n", peopleList.get(i).getFirstName(), peopleList.get(i).getLastName(), peopleList.get(i).getSalary());
        }
    }
}

