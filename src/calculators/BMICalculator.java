package calculators;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        double height;
        double weight;


        System.out.print("Enter your height in m: ");
        height = scanner.nextDouble();

        System.out.print("Enter your weight in kg: ");
        weight = scanner.nextDouble();

        double bmi = weight / Math.pow(height, 2);
        System.out.printf("Your BMI is %.2f\n", bmi);

        if(bmi < 18.5){
            System.out.println("You are underweight");
        }
        else if(bmi < 24.9){
            System.out.println("You are healthy");
        }
        else if(bmi < 29.9){
            System.out.println("You are overweight");
        }
        else{
            System.out.println("You are Obese");
        }

        scanner.close();
    }
}

