package business;

import java.util.Scanner;
import java.util.Random;

public class LoginSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String username = "";
        String password = "";
        int choice;
        boolean loggedIn = false;


        showStartupMenu();

        choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("========== Sign Up ==========");
            username = getUsername(scanner);
            password = signUp(scanner);

            System.out.println("========== Sign In ==========");

            loggedIn = signIn(scanner, random, username, password);
        }
        else if (choice == 2){
            System.out.println("========== Sign In ==========");
            loggedIn = signIn(scanner, random, username, password);
        }

        scanner.close();
    }


    //start up menu
    static void showStartupMenu(){
        System.out.println("========== Startup Menu ==========");
        System.out.println("1. Sign Up");
        System.out.println("2. Sign In");
    }


    // sign in/ sign up flow
    static String signUp(Scanner scanner){

        String password = "";

        System.out.println("Create your password: ");
        System.out.println("1. at least 8 characters");
        System.out.println("2. contains number");
        System.out.println("3. contains uppercase letter");
        System.out.println("4. contains special character");

        do {

            String tempPassword = scanner.nextLine();
            if(!checkLength(tempPassword)){
                System.out.println("password has to be at least 8 characters");
            }
            if(!checkContainsNumber(tempPassword)){
                System.out.println("password has to contain number");
            }
            if(!checkContainsUppercase(tempPassword)){
                System.out.println("password has to contain uppercase letter");
            }
            if(!checkContainsSpecialCharacter(tempPassword)) {
                System.out.println("password has to contain special character");
            }

            if(isValidPassword(tempPassword)){
                password = tempPassword;
            }
            else{
                System.out.println("Create your password: ");
            }
        }while(password.isEmpty());

        return password;

    }


    static boolean signIn(Scanner scanner, Random random, String username, String password){

        String usernameEntered;
        String passwordEntered;
        int attempts = 3;

        while(attempts > 0) {
            System.out.println("Enter your username: ");
            usernameEntered = scanner.nextLine();

            System.out.println("Enter your password: ");
            passwordEntered = scanner.nextLine();

            attempts--;

            if (usernameEntered.equals(username) && passwordEntered.equals(password)) {

                if (humanVerification(scanner, random)) {
                    System.out.println("Login successfully");
                    return true;
                } else {
                    System.out.println("You are not human");
                    break;
                }
            } else {
                System.out.println("Wrong username or password");
                System.out.printf("You have %d attempts left\n", attempts);
            }
        }
        return false;
    }


    // check if new password is valid
    static boolean isValidPassword(String password) {
        return checkLength(password)
                && checkContainsNumber(password)
                && checkContainsUppercase(password)
                && checkContainsSpecialCharacter(password);
    }

    static boolean checkLength(String password){
        return password.length() >= 8;
    }

    static boolean checkContainsNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            switch (password.charAt(i)) {
                case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' -> {
                    return true;
                }
            }
        }
        return false;
    }


    static boolean checkContainsUppercase(String password){
        for(int i = 0; i < password.length(); i++){
            switch(password.charAt(i)){
                case 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K', 'L', 'M', 'N',
                     'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' ->
                {
                    return true;
                }
            }
        }
        return false;
    }


    static boolean checkContainsSpecialCharacter(String password){
        for(int i = 0; i < password.length(); i++){
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }


    // human verification for sign in
    static boolean humanVerification(Scanner scanner, Random random){
        int humanVerificationResponse;
        int rand1;
        int rand2;

        rand1 = random.nextInt(1, 101);
        rand2 = random.nextInt(1, 101);
        System.out.printf("Human verification: %d + %d = ? ", rand1, rand2);
        humanVerificationResponse = scanner.nextInt();
        scanner.nextLine();

        return humanVerificationResponse == rand1 + rand2;
    }


    // get username
    static String getUsername(Scanner scanner){
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();
        String username = email.substring(0,email.indexOf("@"));
        System.out.println("Your username is: " + username);
        return username;
    }


}

