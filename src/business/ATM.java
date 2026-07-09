package business;
import java.util.Scanner;

//ATM program
public class ATM {
    public static void main(String[] args){

        //declare variables
        Scanner scanner = new Scanner(System.in);
        double balance = 0;
        boolean isRunning = true;
        int choice;

        while(isRunning){
            //display menu
            System.out.println("Banking Program");
            System.out.println("1. Show balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.println("Enter your choice(1-4): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> {
                    showBalance(balance);

                }
                case 2 -> {
                    balance += deposit(scanner);

                }
                case 3 -> {
                    balance -= withdraw(scanner, balance);

                }
                case 4 -> {
                    isRunning = false;
                }
                default -> {
                    System.out.println("Invalid choice");
                }
            }

        }



        scanner.close();
    }

    static void showBalance(double balance){
        System.out.printf("$%.2f\n", balance);
    }

    static double deposit(Scanner scanner){

        double amount;

        System.out.println("Enter an amount to be deposited: ");
        amount = scanner.nextDouble();

        if(amount < 0){
            System.out.println("Amount can't be negative");
            return 0;
        }
        else{
            return amount;
        }
    }

    static double withdraw(Scanner scanner, double balance){

        double amount;

        System.out.println("Enter an amount to be withdrawn: ");
        amount = scanner.nextDouble();

        if(amount < 0){
            System.out.println("Amount can't be negative");
            return 0;
        }
        else if(amount > balance){
            System.out.println("INSUFFICIENT FUNDS");
            return 0;
        }
        else{
            return amount;
        }

    }


}
