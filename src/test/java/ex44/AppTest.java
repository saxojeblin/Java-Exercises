/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex44;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class AppTest {

    @BeforeClass
    public static void beforeClass() {
        App app = new App();
    }

    @Test
    public void testGetProductList() throws FileNotFoundException {
        ArrayList<Products> actualList = App.getProductList();
        ArrayList<Products> expectedList = new ArrayList<>();
        expectedList.add(new Products("Widget", 25.00, 5));
        expectedList.add(new Products("Thing", 15.00, 5));
        expectedList.add(new Products("Doodad", 5.00, 10));

        for (int i=0; i<expectedList.size(); i++) {
            assertEquals(expectedList.get(i).getName(), actualList.get(i).getName());
            assertEquals(expectedList.get(i).getPrice(), actualList.get(i).getPrice(), 1);
            assertEquals(expectedList.get(i).getQuantity(), actualList.get(i).getQuantity());
        }
    }

    @Test
    public void testSearchForProduct() throws FileNotFoundException {
        ArrayList<Products> productList = App.getProductList();
        assertEquals(0, App.searchForProduct("iPad", productList));
        assertEquals(0, App.searchForProduct("Galaxy", productList));
        assertEquals(1, App.searchForProduct("Thing", productList));
        assertEquals(1, App.searchForProduct("Doodad", productList));
        assertEquals(1, App.searchForProduct("Widget", productList));
    }


}
