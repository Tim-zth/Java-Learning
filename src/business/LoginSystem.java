package business;

import java.util.Scanner;
import java.util.Random;

public class LoginSystem {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String username;
        String password;
        int rand1;
        int rand2;
        int answer;

        for(int i = 0; i < 3; i++){

            System.out.println("Enter your username: ");
            username = scanner.nextLine();

            System.out.println("Enter your password: ");
            password = scanner.nextLine();

            if(username.equals("Timothy Zhang") && password.equals("12345678")){
                rand1 = random.nextInt(1,101);
                rand2 = random.nextInt(1,101);
                System.out.printf("Human verification: %d + %d = ? ", rand1, rand2);
                answer = scanner.nextInt();
                scanner.nextLine();
                if(answer == rand1 + rand2){
                    System.out.println("Login successfully");
                    break;
                }
                else{
                    System.out.println("You are not human");
                    break;
                }
            }
            else{
                System.out.println("Wrong username or password");
                System.out.println("Please try again");
            }
        }

        scanner.close();
    }

}
