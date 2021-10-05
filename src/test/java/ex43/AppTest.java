/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex43;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @BeforeClass
    public static void beforeClass() {
        App app = new App();
    }

    public Website testGetWebsiteInfo() {
        //Simply creates an example website with the following attritubtes
        return new Website("awesomeco", "Max Power", true, true);
    }

    @Test
    public void testCreateWebsiteFolder() throws IOException {
        //Create an example website
        Website website = testGetWebsiteInfo();
        website.createWebsiteFolder();
        //Create files in the folders that should have been generated
        File websiteCheck = new File("src/main/java/ex43/website");
        File awesomecoCheck = new File("src/main/java/ex43/website/awesomeco");
        File htmlCheck  = new File("src/main/java/ex43/website/awesomeco");
        File jsCheck  = new File("src/main/java/ex43/website/awesomeco/js");
        File cssCheck  = new File("src/main/java/ex43/website/awesomeco/css");
        //If the files failed to generate, then the folders don't exist. So, if the test fails, just assertEqual 1 and 2, which fails.
        //Otherwise, the test passes and files generated successfully.
        if (websiteCheck.exists() && awesomecoCheck.exists() && htmlCheck.exists() && jsCheck.exists() && cssCheck.exists()) {
            assertEquals(1,1);
        }
        else {
            assertEquals(1,2);
        }
    }
}
