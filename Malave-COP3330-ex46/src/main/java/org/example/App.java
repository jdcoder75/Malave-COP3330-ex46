package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.lang.*;

/*
 *  UCF COP3330 Fall 2021 Assignment 46 Solution
 *  Copyright 2021 Jose Malave
 */
public class App {

    //this is where we are going to read in the file.
    public static String[] readArray(String path) {

        int ctr = 0;
        try {
            //read in the file
            Scanner sc = new Scanner(new File(path));
            //iterate through each word in the file
            //and increase the counter
            while (sc.hasNext()) {
                ctr += 1;
                sc.next();
            }

            //here we initialize the array size
            String[] words = new String[ctr];

            //have a scanner start from the top of the file again
            Scanner sc2 = new Scanner(new File(path));


            //now place all of the words into an array
            for(int i = 0; i < ctr; i++)
            {
                words[i] = sc2.next();
            }
            //return the array back to main
            return words;

            //catch the error
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //if it didn't work, send null back to main
        return null;

    }

    public static void printArr(String[] words)
    {
        //create a new array to store the frequency of each word
        int[]  visit =  new int[words.length];

        //visited places
        int visited = -1;


        //loop through words array
        for(int i = 0; i < words.length; i++)
        {
            //have a counter count the number of repeated words
            int counter = 1;
            for(int j = i+1; j< words.length;j++)
            {
                //check if words have repeated and increase the counter and
                //set the index equal to -1
                boolean retval1;
                if(retval1 = words[i].equals(words[j]))
                {
                    counter++;
                    visit[j] = visited;
                }

            }
            //check if the current location is -1 or not
            //if not, have visit hold the counter number
            if(visit[i] != visited)
            {
                visit[i] = counter;
            }
        }

        //here we are going to print out all of the words that repeated
        for(int i = 0; i < visit.length;i++){
            if(visit[i] != visited)
            {

                //display to help show who repeated the most
                for(int j = 0; j < visit[i]; j++)
                {
                    System.out.print(" * ");
                }
                System.out.print("\n");
            }
        }
    }



    public static void main(String[] args) {

        //have a string array take in the data from readArray
        String[] words = readArray("exercise46_input.txt");

        //Here we will print the frequency of each word in the array
        printArr(words);

    }
}


