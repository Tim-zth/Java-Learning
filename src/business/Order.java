package business;

import java.util.ArrayList;

public class Order {

    private final ArrayList<OrderItem> orderItems = new ArrayList<>();

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

        System.out.println("========== Receipt ==========");

        for(int i = 0; i < orderItems.size(); i++){

            System.out.printf("%s * %d    $%.2f\n", orderItems.get(i).getMenuItem().getName(),
                    orderItems.get(i).getQuantity(),
                    orderItems.get(i).calculateSubtotal());

            total += orderItems.get(i).calculateSubtotal();
        }

        System.out.printf("Total :  $%.2f\n", total);
    }


    // return index of that item
    public int searchItem(MenuItem menuItem){
        for(int i = 0; i < orderItems.size(); i++){
            if(orderItems.get(i).getMenuItem() == menuItem){
                return i;
            }
        }
        return -1;
    }


}
