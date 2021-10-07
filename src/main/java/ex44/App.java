/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex44;

import com.google.gson.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        //Create an array list of products to store product info from input
        ArrayList<Products> productList = getProductList();
        int check = 0;
        while(check == 0) {
            String userInput = getUserInput();
            check = searchForProduct(userInput, productList);
            if (check == 0) {
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        }
    }

    //Method to create an array list of products from json input
    public static ArrayList<Products> getProductList() throws FileNotFoundException {
        //Create an array list of products to fill
        ArrayList<Products> productList = new ArrayList<>();
        //Get the input file
        File input = new File("src/main/java/ex44/exercise44_input.json");
        Gson gson = new Gson();

        /*Json process of deserialization:
        1. Create a Json element, which essentially is the entire json file in a usable form
        2. Create a json object from the json element, in this case is the "products"
        3. Create a json array from the "products" object, which we will use to pull the
        contents of each individual index of the array */

        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileObject = fileElement.getAsJsonObject();
        JsonArray jsonProductArray = fileObject.get("products").getAsJsonArray();
        //Go through the json array and store data into a product that gets added to the list
        for (JsonElement productElement : jsonProductArray) {
            JsonObject productJsonObject = productElement.getAsJsonObject();

            String name = productJsonObject.get("name").getAsString();
            Double price = productJsonObject.get("price").getAsDouble();
            int quantity = productJsonObject.get("quantity").getAsInt();

            Products product = new Products(name,price,quantity);
            productList.add(product);

        }

        return productList;
    }

    //Method to get input from user on what product they are searching for
    public static String getUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the product name? ");
        return input.nextLine();
    }

    //Method to search list of products to find item user is looking for
    public static int searchForProduct(String userInput, ArrayList<Products> productList) {
        int check = 0;
        //Check each product and see if the product user is searching for exists
        for (int i=0; i<productList.size(); i++)  {
            String name = productList.get(i).getName();
            //if the product exists, display its information and set the check counter equal to 1
            if (name.equals(userInput)) {
                productList.get(i).displayProductInfo();
                check = 1;
            }
        }
        return check;
    }
}
