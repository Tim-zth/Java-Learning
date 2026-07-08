package business;

import java.util.Scanner;

public class RestaurantMenu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int burgerNum = 0;
        int pizzaNum = 0;
        int pastaNum = 0;

        int order = -1;
        double total;
        String receipt;


        while(order != 0){

            displayMenu();

            System.out.println("What would you like to order: ");
            order = scanner.nextInt();

            if(order == 0){
                break;
            }

            System.out.println("How many? ");

            switch(order){
                case 1 -> burgerNum += scanner.nextInt();
                case 2 -> pizzaNum += scanner.nextInt();
                case 3 -> pastaNum += scanner.nextInt();
            }

            total = calculateTotalPrice(burgerNum, pizzaNum, pastaNum);
            System.out.printf("That's $%.2f in total.\n", total);

        }
        scanner.nextLine();

        total = calculateTotalPrice(burgerNum, pizzaNum, pastaNum);

        System.out.println("Do you want receipt? [Y/N]");
        receipt = scanner.nextLine();
        if(receipt.equalsIgnoreCase("Y")){
            displayReceipt(burgerNum, pizzaNum, pastaNum, total);
        }

        scanner.close();
    }

    static String burger = "burger";
    static String pizza = "Pizza";
    static String pasta = "Pasta";

    static double burgerPrice = 12.5;
    static double pizzaPrice = 18;
    static double pastaPrice = 15;


    //this method displays the menu
    static void displayMenu(){

        System.out.println("========== Menu ==========");
        System.out.printf("1. %-10s    $%.2f\n", burger, burgerPrice);
        System.out.printf("2. %-10s    $%.2f\n", pizza, pizzaPrice);
        System.out.printf("3. %-10s    $%.2f\n", pasta, pastaPrice);
        System.out.println("0. Check Out");
    }

    //this method calculates the total price
    static double calculateTotalPrice(int burgerNum, int pizzaNum, int pastaNum){
        return burgerNum * burgerPrice + pizzaNum * pizzaPrice + pastaNum * pastaPrice;
    }

    //this method displays the receipt
    static void displayReceipt(int burgerNum, int pizzaNum, int pastaNum, double total){
        System.out.println("========== Receipt ==========");
        if(burgerNum > 0){
            System.out.printf("%s * %d    $%.2f\n", burger, burgerNum, burgerNum * burgerPrice);
        }
        if(pizzaNum > 0){
            System.out.printf("%s * %d    $%.2f\n", pizza, pizzaNum, pizzaNum * pizzaPrice);
        }
        if(pastaNum > 0){
            System.out.printf("%s * %d    $%.2f\n", pasta, pastaNum, pastaNum * pastaPrice);
        }
        System.out.printf("Total :  $%.2f\n", total);
    }

}
