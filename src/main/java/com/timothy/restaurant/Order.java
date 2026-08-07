package com.timothy.restaurant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {

    private final ArrayList<OrderItem> orderItems = new ArrayList<>();
    private final LocalDateTime createAt;
    private final int orderId;
    private static int nextOrderId = 1;

    public Order(){
        createAt = LocalDateTime.now();
        this.orderId = nextOrderId;
        nextOrderId++;
    }

    public void addOrderItem(MenuItem menuItem, int quantity){
        if(menuItem == null || quantity <= 0) {
            return;
        }
        int index = searchItem(menuItem);

        if(index >= 0) {
            orderItems.get(index).updateQuantity(quantity);
            return;
        }
        orderItems.add(new OrderItem(menuItem, quantity));
    }


    public void removeOrderItem(MenuItem menuItem){
        int index = searchItem(menuItem);
        if(index >= 0){
            orderItems.remove(index);
        }
        else{
            System.out.println("Item does not exist");
        }
    }


    public void updateQuantity(MenuItem menuItem, int quantity) {
        int index = searchItem(menuItem);
        if(index != -1){
            boolean valid = orderItems.get(index).updateQuantity(quantity);
            if(!valid){
                System.out.println("Quantity cannot be negative");
            }
        }
        else{
            System.out.println("Item does not exist");
        }

    }


    public void printReceipt(){
        double total = 0;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date = createAt.format(dateTimeFormatter);

        System.out.println("========== Receipt ==========");
        System.out.println("Order Id: " + orderId);
        System.out.println(date);

        for (OrderItem orderItem : orderItems) {

            System.out.printf("%s * %d    $%.2f\n", orderItem.getMenuItem().getName(),
                    orderItem.getQuantity(),
                    orderItem.calculateSubtotal());

            total += orderItem.calculateSubtotal();
        }
        System.out.printf("Total :  $%.2f\n", total);
    }


    public int searchItem(MenuItem menuItem){
        for(int i = 0; i < orderItems.size(); i++){
            if(orderItems.get(i).getMenuItem() == menuItem){
                return i;
            }
        }
        return -1;
    }


    public int getOrderId(){
        return this.orderId;
    }

    public LocalDateTime getCreateAt(){
        return this.createAt;
    }

    public ArrayList<OrderItem> getOrderItems(){
        return this.orderItems;
    }


}
