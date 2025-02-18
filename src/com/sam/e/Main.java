package com.sam.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.sam.e.Print.*;

public class Main {

    public static String reverseSeperator(String s){
        String rev = "";
        //ArrayList<String> StringArrayList = new ArrayList<>();

        //String[] words = s.split("\\s+"); // this ignores every space including new line tab or a regular space
        String[] words = s.split("[ \t]+"); // this only works for spaces and tabs
        //String[] words = s.split("[ ]+"); // this only works for spaces
        ArrayList<String> StringArrayList = new ArrayList<>(Arrays.asList(words));

        Collections.reverse(StringArrayList);

        for (int i = 0; i < StringArrayList.size()-1; i++){
            rev = rev + StringArrayList.get(i).trim() + " ";
        }
        rev = rev + StringArrayList.get(StringArrayList.size()-1);
        return rev;
    }

    public static void main(String[] args) {
        String yup = " aoidnoas o o  o ijg5eo     jgkd     hitu wown\nowo     woow\toow  owow oow     ow ow ow ow ow owo     wow 0000\t00 1 2 3 !!!!!";
        println(reverseSeperator(yup));
    }
}
