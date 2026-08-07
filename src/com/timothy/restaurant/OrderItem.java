package com.timothy.restaurant;

public class OrderItem {

    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity){

        this.menuItem = menuItem;
        this.quantity = quantity;

    }


    public double calculateSubtotal(){
        return menuItem.getPrice() * quantity;
    }

    public MenuItem getMenuItem(){
        return this.menuItem;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public boolean updateQuantity(int quantity){
        if(this.quantity + quantity < 1){
            return false;
        }
        this.quantity += quantity;
        return true;
    }


}
