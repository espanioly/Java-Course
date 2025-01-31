package com.sam.hw;

public class Ball extends Item implements IBreakable{
    String color = "";
    public Ball(String name, int weight, String color) {
        super(name, weight);
        this.color = color;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.print(", color: " + this.color);
        return "";
    }

    @Override
    public void broken(){
        setWeight(-99);
        setColor(null);
        this.name += " is broken";
    }

    public String getColor(String color){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }
}
