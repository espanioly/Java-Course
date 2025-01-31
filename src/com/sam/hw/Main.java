package com.sam.hw;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Item[] store = new Item[4];
        store [0] = new Ball("soccer ball", 5, "Red");
        store [1] = new Glass("cup", 10, 20);
        store [2] = new Lamp("Da vinki" , 200, 300);
        store [3] = new PaintBoard("Mona Lisa", 19, 20,20);
        for(Item i : store){
            System.out.println(i);
            i.broken();
        } for(Item i : store) {
            System.out.println(i);
        }
    }
}