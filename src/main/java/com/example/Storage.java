/*
* File: Storage.java
* Author: Pók László
* Copyright: 2025, Pók László
* Group: Szoft I/N
* Date: 2025-05-26
* Github: https://github.com/poklaszlo/
* Licenc: MIT
*/

package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static void writer(ArrayList<Cylinder> cylinders) {
        try {
            try_writer(cylinders);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    private static void try_writer(ArrayList<Cylinder> cylinders) throws IOException {
        FileWriter writer = new FileWriter("storage.txt",
                            Charset.forName("utf-8"),true);
        for (Cylinder cylinder : cylinders) {
            writer.write(String.valueOf(cylinder.getRadius()));
            writer.write(" : ");
            writer.write(String.valueOf(cylinder.getHeight()));
            writer.write(" : ");
            writer.write(String.valueOf(cylinder.getSurface()));
            writer.write("\n");
        }
        writer.close();
    }
    public static ArrayList<Cylinder> readFile(){
        try {
            return try_readFile();
        } catch (FileNotFoundException e) {
            System.err.println("fájl nem találhato");
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    private static ArrayList<Cylinder> try_readFile() throws FileNotFoundException {
        ArrayList<Cylinder> cylinders = new ArrayList<>(); 
        File myfile = new File("storage.txt");
        try(Scanner scanner = new Scanner(myfile)){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(" : ");
                cylinders.add(new Cylinder(
                    Double.parseDouble(values[0]),
                    Double.parseDouble(values[1]),
                    Double.parseDouble(values[2])
                ));
            }    
            }
        return cylinders;
        
    }
}
