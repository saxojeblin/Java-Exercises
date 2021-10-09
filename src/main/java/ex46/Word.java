/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex46;
//Class which contaings Word objects and can compare attributes of the class
public class Word implements Comparable<Word> {
    //Word's attributes: name and frequency
    private String name;
    private int frequency;
    //Object builder
    public Word(String name1, int freq) {
        this.frequency = freq;
        this.name = name1;
    }
    //Attribute returners:
    public String getName() {
        return this.name;
    }
    public int getFrequency() {
        return this.frequency;
    }

    //Method to compare the frequency of two Word objects for sorting
    @Override
    public int compareTo(Word o) {
        int compareFreq = ((Word)o).getFrequency();
        return compareFreq - this.frequency;
    }
}
