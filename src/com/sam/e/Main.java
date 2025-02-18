package com.sam.e;
import java.util.ArrayList;
import java.util.Arrays;

import static com.sam.e.Print.*;


public class Main {
    public String[] sortArray(String[] arr){
        ArrayList<String> green = new ArrayList<>();
        ArrayList<String> yellow = new ArrayList<>();
        ArrayList<String> red = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            if(arr[i].equalsIgnoreCase("red")){
                red.add(arr[i]);
            } else if (arr[i].equalsIgnoreCase("green")) {
                    green.add(arr[i]);
            }else if (arr[i].equalsIgnoreCase("yellow")){
                yellow.add(arr[i]);
            }else{
                printeln("ERRORRRRR WRONG INPUT!!!!");
            }
        }
        red.addAll(green);
        red.addAll(yellow);
        return red.toArray(new String[arr.length]);
        // Needs testing
    }

    public static void main(String[] args) {


    }
}
