package calculators;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double principal;
        double rate;
        int compoundsPerYear;
        int years;
        double amount;

        System.out.print("Enter the principal: ");
        principal = scanner.nextDouble();

        System.out.print("Enter the rate (in %): ");
        rate = scanner.nextDouble() / 100;

        System.out.print("Enter the compounds per year: ");
        compoundsPerYear = scanner.nextInt();

        System.out.print("Enter the years: ");
        years = scanner.nextInt();

        amount = principal * Math.pow((1+ rate / compoundsPerYear),compoundsPerYear * years);
        System.out.printf("The final amount after %d years is $%,.2f\n", years, amount);



        scanner.nextLine();
        System.out.print("Do you want receipt? [Y/N] ");
        String receipt = scanner.nextLine();

        double interest = amount - principal;

        if(receipt.equalsIgnoreCase("Y")){
            System.out.printf("%-13s : $%,10.2f\n", "Principal", principal);
            System.out.printf("%-13s : $%,10.2f\n", "Interest", interest);
            System.out.printf("%-13s : $%,10.2f\n", "Final", amount);
        }

        scanner.close();

    }
}