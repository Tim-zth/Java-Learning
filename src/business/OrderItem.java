package business;

public class OrderItem {

    MenuItem menuItem;
    int quantity;

    OrderItem(MenuItem menuItem, int quantity){

        this.menuItem = menuItem;
        this.quantity = quantity;

    }


    public double calculateSubtotal(){
        return menuItem.price * quantity;
    }


}
