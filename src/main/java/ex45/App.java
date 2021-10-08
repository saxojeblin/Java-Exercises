/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        //Create a string array of each line of input
        String[] input = getInput();
        //Create a word finder object with the input string array
        WordFinder sentence = new WordFinder(input);
        //Call method to replace the words
        sentence.replaceWords();
        //Get the output name and create output file
        String outputName = getOutputName();
        sentence.createOutput(outputName);
    }
    //Method to get the data out of the input text file as string array
    public static String[] getInput() throws FileNotFoundException {
        //Create input file and scanner
        File input = new File("src/main/java/ex45/exercise45_input.txt");
        Scanner sc = new Scanner(input);
        String[] lines = new String[3];
        //Fill each index of a string array with each line of input text file
        for(int i=0; i<3; i++) {
            lines[i] = sc.nextLine();
        }
        //Return string array
        return lines;
    }
    //Method to get output file name from user
    public static String getOutputName() {
        //Simply returns user input to be output file name
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the name of the output file: ");
        return input.nextLine();
    }
}
