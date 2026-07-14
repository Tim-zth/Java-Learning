package business;

public class Order {

    OrderItem[] orderItems = new OrderItem[20];
    int current = 0;

    Order(){
    }


    public void addOrderItem(MenuItem menuItem, int quantity){
        if (menuItem == null || quantity <= 0) {
            return;
        }

        int index = searchItem(menuItem);

        if (index >= 0) {
            orderItems[index].quantity += quantity;
            return;
        }

        if (current >= orderItems.length) {
            System.out.println("Order is full.");
            return;
        }

        orderItems[current] = new OrderItem(menuItem, quantity);
        current++;
    }


    public void increaseQuantity(MenuItem menuItem, int quantityToAdd){
        int index = searchItem(menuItem);
        if(index >= 0){
            orderItems[index].quantity += quantityToAdd;
        }
        else{
            System.out.println("Item does not exist");
        }
    }


    public void removeOrderItem(MenuItem menuItem){
        int index = searchItem(menuItem);
        if(index >= 0){
            for(int i = index; i < current - 1; i++){
                orderItems[i] = orderItems[i + 1];
            }
            current--;
            orderItems[current] = null;
        }
        else{
            System.out.println("Item does not exist");
        }
    }


    public void decreaseQuantity(MenuItem menuItem, int quantityToDecrease){
        int index = searchItem(menuItem);
        if(index != -1){
            if(orderItems[index].quantity - quantityToDecrease >= 0){
                orderItems[index].quantity -= quantityToDecrease;
            }
            else{
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

        for(int i = 0; i < current; i++){

            System.out.printf("%s * %d    $%.2f\n", orderItems[i].menuItem.name, orderItems[i].quantity,
                    orderItems[i].calculateSubtotal());

            total += orderItems[i].calculateSubtotal();
        }

        System.out.printf("Total :  $%.2f\n", total);
    }


    // return index of that item
    public int searchItem(MenuItem menuItem){

        for(int i = 0; i < current; i++){
            if(orderItems[i].menuItem == menuItem){
                return i;
            }
        }
        return -1;
    }


}
