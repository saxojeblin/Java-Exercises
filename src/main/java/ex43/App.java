/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex43;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        //Create a website object
        Website website = getWebsiteInfo();
        //Create the files using the website object
        website.createWebsiteFolder();
    }

    public static Website getWebsiteInfo() {
        Scanner input = new Scanner(System.in);
        //Create variables to store inputs from user
        boolean css, js;
        String author, siteName;
        //Obtain inputs from user
        siteName = getSiteName(input);
        author = getAuthor(input);
        css = getCSS(input);
        js = getJS(input);
        //Create website with attributes of variables stored from user
        return new Website(siteName, author, js, css);

    }

    public static String getSiteName(Scanner input) {
        //Ask for site name, scan it, and return it
        System.out.print("Site name: ");
        return input.nextLine();
    }

    public static String getAuthor(Scanner input) {
        //Ask for author, scan it, and return it
        System.out.print("Author: ");
        return input.nextLine();
    }

    public static boolean getJS(Scanner input) {
        //Ask Y/N for javascript folder
        System.out.print("Do you want a folder for javascript? ");
        String answer = input.nextLine();
        boolean checkAnswer;
        //If they answered yes, return a true boolean;
        if(answer.equals("y") || answer.equals("Y") || answer.equals("yes") || answer.equals("Yes")) {
            checkAnswer = true;
        }
        //else return a false boolean
        else {
            checkAnswer = false;
        }
        return checkAnswer;
    }

    public static boolean getCSS(Scanner input) {
        //Ask Y/N for a CSS folder and scan it
        System.out.print("Do you want a folder for CSS? ");
        String answer = input.nextLine();
        boolean checkAnswer;
        //If they answered yes, return a tree boolean
        if(answer.equals("y") || answer.equals("Y") || answer.equals("yes") || answer.equals("Yes")) {
            checkAnswer = true;
        }
        //else return a false boolean
        else {
            checkAnswer = false;
        }

        return checkAnswer;
    }
}