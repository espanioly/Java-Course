package com.sam.hw;

public class PaintBoard extends Item{
    int width = 0;
    int height = 0;

    public PaintBoard(String name, int weight, int width, int height) {
        super(name, weight);
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.print(", width: " + this.width + ", height: " + this.height);
        return "";
    }

    @Override
    public void broken(){
        setHeight(-99);
        setWidth(-99);
        setWeight(-99);
        this.name += " is broken";
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
}
