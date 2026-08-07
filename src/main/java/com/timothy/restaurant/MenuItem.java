package com.timothy.restaurant;

public class MenuItem {

    private Integer id;
    private String name;
    private double price;

    MenuItem(String name, double price){
        this.id = null;
        this.name = name;
        this.price = price;
    }

    MenuItem(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getId() {
        if (id == null) {
            throw new IllegalStateException(
                    "Menu item has not been saved to the database."
            );
        }
        return id;
    }
}
