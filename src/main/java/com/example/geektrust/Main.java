package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.geektrust.services.HandleCommands;

public class Main {
    public static void main(String[] args) {
        // /*
        // Sample code to read from file passed as command line argument
        List<String> listOfCommands = new ArrayList<>();

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            // FileInputStream fis = new FileInputStream("C:\\Users\\ishme\\OneDrive\\Desktop\\java-maven-starter-kit\\sample_input\\input2.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
               listOfCommands.add(sc.nextLine());

            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }

        // for(String i : listOfCommands){
        //     System.out.println(i);
        // }

        // new HandleCommands(listOfCommands).getCommands();
        new HandleCommands(listOfCommands).operateCommands();
        // */
    }
}
