package com.sam.hw;

public abstract class Item implements IBreakable{
    String name = "";
    int weight = 0;
    private IBreakable[] items;

    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }



    @Override
    public String toString(){
            String data = "name: " + this.name + ", weight: " + this.weight;
            System.out.print(data);
        return "";
    }
    public String get(String name){
        return this.name;
    }

    public int get(int weight){
        return this.weight;
    }

    public void broken(IBreakable o){
        o.ibreak();
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void broken();
}
