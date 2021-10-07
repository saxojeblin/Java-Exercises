/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex44;
//  Class to store information of a product from json input
public class Products {
    //Object attributes name,price,quantity
    private String name;
    private double price;
    private int quantity;
    //Method to create object
    public Products(String name1, double price1, int quantity1) {
        this.name = name1;
        this.price = price1;
        this.quantity = quantity1;
    }
    //Methods to return each attribute of product object
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    //Method to print attributes of product object
    public void displayProductInfo() {
        System.out.println("Name: " + this.name);
        System.out.printf("Price: %.2f\n", this.price);
        System.out.println("Quantity: " + this.quantity);
    }

}
