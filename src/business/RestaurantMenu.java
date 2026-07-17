package business;

import java.util.Scanner;

public class RestaurantMenu {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        Order order = takeOrder(scanner);

        scanner.close();
    }


    static Order takeOrder(Scanner scanner){

        Order order = new Order();
        Menu menu = new Menu();

        boolean finishedOrdering = false;

        while(!finishedOrdering){

            System.out.println("""
                
                ===== Restaurant =====
                1. Add item
                2. View current order
                3. Modify order
                0. Checkout
                """);

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 -> addItem(scanner, order, menu);
                case 2 -> checkOrder(order);
                case 3 -> editOrder(scanner, order, menu);
                case 0 -> {
                    finishedOrdering = true;
                    checkOut(order);
                }
            }
        }
        return order;
    }


    static void addItem(Scanner scanner, Order order, Menu menu){
        menu.display();

        System.out.print("What would you like to order: ");
        String itemName = scanner.nextLine();

        MenuItem menuItem = menu.searchItem(itemName);

        if (menuItem == null) {
            System.out.println("Item is not on the menu.");
            return;
        }

        System.out.print("How many do you want: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        order.addOrderItem(menuItem, quantity);
    }


    static void checkOrder(Order order){
        order.printReceipt();
    }


    static void editOrder(Scanner scanner, Order order, Menu menu){
        boolean finishedEditing = false;

        while(!finishedEditing){

            System.out.println("""
                
                ===== Restaurant =====
                1. Increase quantity
                2. Decrease quantity
                3. Remove item
                0. Finish
                """);

            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1 -> {
                    System.out.println("Choose an item: ");
                    String itemName = scanner.nextLine();

                    System.out.println("How many to Increase: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    MenuItem menuItem = menu.searchItem(itemName);

                    order.updateQuantity(menuItem, quantity);
                }
                case 2 -> {
                    System.out.println("Choose an item: ");
                    String itemName = scanner.nextLine();

                    System.out.println("How many to decrease: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    MenuItem menuItem = menu.searchItem(itemName);

                    order.updateQuantity(menuItem, quantity);
                }
                case 3 -> {
                    System.out.println("Choose an item: ");
                    String itemName = scanner.nextLine();

                    MenuItem menuItem = menu.searchItem(itemName);

                    order.removeOrderItem(menuItem);
                }
                case 0 -> finishedEditing = true;
            }
        }
    }


    static void checkOut(Order order){
        order.printReceipt();
    }

}
