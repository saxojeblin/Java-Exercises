/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Website {

    private String siteName;
    private String author;
    private boolean jsFolder;
    private boolean cssFolder;

    public Website (String site, String author1, boolean js, boolean css) {
        siteName = site;
        author = author1;
        jsFolder = js;
        cssFolder = css;
    }

    public void createWebsiteFolder() throws IOException {
        //create the folder "website" and the website name folder inside it
        new File("src/main/java/ex43/website").mkdirs();
        String fileName = "src/main/java/ex43/website/" + this.siteName;
        new File(fileName).mkdirs();
        //print to user folders created
        fileCreated(fileName);
        //Create html file
        createHtmlFile(fileName);
        //Create js file (if applicable)
        if (this.jsFolder) {
            new File(fileName + "/js").mkdirs();
            fileCreated(fileName + "/js/");
        }
        //Create css file (if applicable)
        if (this.cssFolder) {
            new File(fileName + "/css").mkdirs();
            fileCreated(fileName + "/css/");
        }
    }

    public void createHtmlFile(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName + "/index.html");

        writer.write("<!DOCTYPE html>\n" +
                "<head>\n" +
                "    <meta name=\"author\" content=\"" + this.author + "\">\n" +
                "    <title>" + this.siteName + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    \n" +
                "</body>\n" +
                "</html>");
        writer.close();
        fileCreated(fileName + "/index.html");
    }

    public void fileCreated(String file) {
        //Print to user the name of a file that was created
        System.out.println("Created "+ file);
    }

}
