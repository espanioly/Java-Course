package com.sam.hw;

public class Glass extends Item{
    int capacity = 0;
    public Glass(String name, int weight, int capacity) {
        super(name, weight);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.print(", capacity: " + this.capacity);
        return "";
    }

    @Override
    public void broken(){
        setCapacity(-99);
        setWeight(-99);
        this.name += " is broken";
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public int get(){
        return this.capacity;
    }
}
