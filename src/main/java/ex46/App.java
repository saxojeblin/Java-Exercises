/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        //Get the list of each word (including duplicates) from input
        ArrayList<String> allWords = getWordList();
        //Get the set of words (so each word once)
        Set<String> eachWord = getEachWord();
        //Create a list of word objects that have their frequency in descending order
        ArrayList<Word> wordFrequency = getWordFrequency(allWords, eachWord);
        //Print word object list
        printWordFrequency(wordFrequency);

    }
    //Method to get the list of each word in input
    public static ArrayList<String> getWordList() throws FileNotFoundException {
        //Create a file and scanner to pull input
        File file = new File("src/main/java/ex46/exercise46_input.txt");
        Scanner sc = new Scanner(file);
        //Create an array list of words and a temp word string
        ArrayList<String> words = new ArrayList<>();
        String word;
        //Traverse input file, adding each word to the list (including duplicates)
        while(sc.hasNext()) {
            word = sc.next();
            words.add(word);
        }
        //Return the word list
        return words;
    }
    //Method to get the set of words from input
    public static Set<String> getEachWord() throws FileNotFoundException {
        //Create a file and scanner to pull input
        File file = new File("src/main/java/ex46/exercise46_input.txt");
        Scanner sc = new Scanner(file);
        //Create a string set to fill from input
        Set<String> words = new HashSet<>();
        //Traverse input file, adding each word to the set (no duplicates)
        while(sc.hasNext()) {
            words.add(sc.next());
        }
        //Return the word set
        return words;
    }
    //Method to return a list of Word objects, each word containing its name and frequency
    public static ArrayList<Word> getWordFrequency(ArrayList<String> allWords, Set<String> eachWord) {
        //Create Word array list to build upon
        ArrayList<Word> wordFreq = new ArrayList<>();
        //Convert set of words to an array
        String[] arrEachWord = eachWord.toArray(new String[eachWord.size()]);
        //Iterate through the set of words array
        for (int i=0; i<eachWord.size(); i++) {
            //Grab the word name and initialize the frequency integer
            String wordName = arrEachWord[i];
            int freq = 0;
            //Iterate through the entire word list (includes duplicates)
            for (int j=0; j<allWords.size(); j++) {
                //Each time the given word is found, increase that word's frequency by 1
                if (wordName.equals(allWords.get(j))) {
                    freq++;
                }
            }
            //Create a word object with the frequency and name of the word
            Word wordObject = new Word(wordName, freq);
            //Add the object to the Word list
            wordFreq.add(wordObject);
        }
        //Sort the list in descending order
        Collections.sort(wordFreq);
        //Return the finished list
        return wordFreq;
    }
    //Method to print the Word array list
    public static void printWordFrequency(ArrayList<Word> words) {
        //Iterate through the Word list
        for (Word word : words) {
            //Build a string containing a number of '*' based on the word's frequency
            String histogram;
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<word.getFrequency(); i++) {
                sb.append('*');
            }
            histogram = sb.toString();
            String wordName = word.getName() + ":";
            //Print the word's name and its frequency in the '*' format
            System.out.printf("%-10s %-10s\n", wordName, histogram);
        }
    }
}
