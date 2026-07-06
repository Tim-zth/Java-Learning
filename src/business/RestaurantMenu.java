package business;

import java.util.Scanner;

public class RestaurantMenu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String burger = "burger";
        String pizza = "Pizza";
        String pasta = "Pasta";

        double burgerPrice = 12.5;
        double pizzaPrice = 18;
        double pastaPrice = 15;

        int burgerNum = 0;
        int pizzaNum = 0;
        int pastaNum = 0;

        int order;
        double total;
        String receipt;


        System.out.println("========== Menu ==========");
        System.out.printf("1. %-10s    $%.2f\n", burger, burgerPrice);
        System.out.printf("2. %-10s    $%.2f\n", pizza, pizzaPrice);
        System.out.printf("3. %-10s    $%.2f\n", pasta, pastaPrice);
        System.out.println("What would you like to order: ");
        order = scanner.nextInt();

        System.out.println("How many? ");

        switch(order){
            case 1 -> burgerNum = scanner.nextInt();
            case 2 -> pizzaNum = scanner.nextInt();
            case 3 -> pastaNum = scanner.nextInt();
        }

        scanner.nextLine();

        total = burgerNum * burgerPrice + pizzaNum * pizzaPrice + pastaNum * pastaPrice;

        System.out.printf("That's $%.2f in total.\n", total);
        System.out.println("Do you want receipt? [Y/N]");
        receipt = scanner.nextLine();
        if(receipt.equalsIgnoreCase("Y")){
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

        scanner.close();
    }
}