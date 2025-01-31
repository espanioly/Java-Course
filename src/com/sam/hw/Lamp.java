package com.sam.hw;

public class Lamp extends Item implements IBreakable{
    int watt = 0;
    public Lamp(String name, int weight, int watt) {
        super(name, weight);
        this.watt = watt;
    }
    @Override
    public String toString() {
        super.toString();
        System.out.print(", watt: " + this.watt);
        return "";
    }

    @Override
    public void broken(){
        setWatt(-99);
        setWeight(-99);
        this.name += " is broken";
    }

    public void setWatt(int watt){
        this.watt = watt;
    }
    public int getWatt(){
        return this.watt;
    }
}
