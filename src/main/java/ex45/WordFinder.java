/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex45;

import java.io.FileWriter;
import java.io.IOException;

public class WordFinder {
    //Only attribute of wordfinder is string array of each input line
    private String[] lines;
    //Object creator method
    public WordFinder(String[] lines1) {
        lines = lines1;
    }
    //Method to replace "utilize" with "use" in each line string
    public void replaceWords() {
        //Loop through each index of string array
        for (int i=0; i<this.lines.length; i++) {
            //Replace every instance of word "utilize" with "use"
            String replaceString = this.lines[i].replace("utilize", "use");
            this.lines[i] = replaceString;
        }
    }
    //Returns the line at given index
    public String getLine(int i) {
        return lines[i];
    }
    //Method to create the output file
    public void createOutput(String outputName) throws IOException {
        //Create output file of user desired name
        FileWriter writer = new FileWriter("src/main/java/ex45/" + outputName + ".txt");
        //Print each index of string array to output
        for (int i=0; i<this.lines.length; i++) {
            writer.write(this.lines[i] + "\n");
        }
        //Close the output file
        writer.close();
    }
}
