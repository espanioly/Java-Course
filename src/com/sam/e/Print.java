package com.sam.e;

public class Print {
    public static void println(String string){
        System.out.println(string);
    }
    public static void print(String string){
        System.out.print(string);
    }
    public static void printf(String string, Object... args) {
        System.out.printf(string, args);
    }
    public static void printe(String string){System.err.print(string);}
    public static void printeln(String string){System.err.println(string);}
}
