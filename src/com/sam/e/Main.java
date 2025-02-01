package com.sam.e;
import java.util.ArrayList;

import static com.sam.e.Print.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main implements Reducable{
    public static void main (String[] args)   {

        println("Hello World!");

        printf("Hello World!");

        print("\nHello World!\nHell\to\to\to\tWorld");
    }

    public static <T extends Reducable<T>> ArrayList<T> reduceAll(ArrayList<T> list) {
        ArrayList<T> result = new ArrayList<>();

        for (T element : list) {
            result.add(element.reduce());
        }

        return result;
    }

    // Replace T with whatever type you want to reduce it
    @Override
    public Object reduce() {
        return null;
    }

}
