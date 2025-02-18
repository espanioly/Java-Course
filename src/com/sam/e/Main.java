package com.sam.e;
import static com.sam.e.Print.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // returns Sqrt of Int with lower bound
    public static int sqrt(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int i = 1;
        while (i * i <= n) {
            i++;
        }
        // lower bound
        return i - 1;
    }

    public static void main(String[] args) {
        println("" + sqrt(9)); //3
        println("" + sqrt(10)); //3
        println("" + sqrt(8)); //2
        println("" + sqrt(80)); //8
        println("" + sqrt(81)); //9
        println("" + sqrt(82)); //9
    }
}
