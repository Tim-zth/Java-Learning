package business;

import java.util.Scanner;
import java.util.Random;

public class LoginSystem {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String username = "";
        String password = "";
        int rand1;
        int rand2;
        int answer;
        int loginStatus;
        String email;
        String usernameEntered;
        String passwordEntered;

        //password conditions
        boolean containsNumber = false;
        boolean containsUppercase = false;
        boolean containsSpecialCharacter = false;


        System.out.println("========== Startup Menu ==========");
        System.out.println("1. Sign Up");
        System.out.println("2. Sign In");
        loginStatus = scanner.nextInt();
        scanner.nextLine();

        if(loginStatus == 1){
            System.out.println("Please enter your email: ");
            email = scanner.nextLine();
            username = email.substring(0,email.indexOf("@"));


            while(true){
                System.out.println("Please enter your password: ");
                System.out.println("1. at least 8 characters");
                System.out.println("2. contains number");
                System.out.println("3. contains uppercase letter");
                System.out.println("4. contains special character");

                String tempPassword = scanner.nextLine();

                //reset conditions
                containsNumber = false;
                containsUppercase = false;
                containsSpecialCharacter = false;


                //check if the password is at least 8 characters
                if(tempPassword.length() < 8){
                    System.out.println("password less than 8 characters");
                    continue;
                }

                //check if it contains number

                for(int i = 0; i < tempPassword.length(); i++){
                    if(containsNumber){
                        break;
                    }
                    switch(tempPassword.charAt(i)){
                        case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' -> {
                            //System.out.println("contains number");
                            containsNumber = true;
                            break;
                        }
                    }
                }
                if(!containsNumber){
                    System.out.println("password has to contain number");
                    continue;
                }

                //check if it contains uppercase letter

                for(int i = 0; i < tempPassword.length(); i++){
                    if(containsUppercase){
                        break;
                    }
                    switch(tempPassword.charAt(i)){
                        case 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K', 'L', 'M', 'N',
                             'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' ->
                        {
                            containsUppercase = true;
                            break;
                        }
                        }
                }
                if(!containsUppercase){
                    System.out.println("password has to contain uppercase");
                    continue;
                }

                //check if it contains special character

                for(int i = 0; i < tempPassword.length(); i++){
                    if(containsSpecialCharacter){
                        break;
                    }

                    switch(tempPassword.charAt(i)){
                        case '!', '@', '#', '$', '%', '^', '&', '*' ->
                        {
                            containsSpecialCharacter = true;
                            break;
                        }
                    }
                }
                if(!containsSpecialCharacter){
                    System.out.println("password has to contain a special character");
                    continue;
                }
                // sign up successfully
                if(containsNumber && containsUppercase && containsSpecialCharacter){
                    password = tempPassword;
                    System.out.println("Sign up successful!");
                    System.out.println("Your username is: " + username);
                    break;
                }
            }

        }
        else if(loginStatus ==2){
            while(true) {

                System.out.println("Enter your username: ");
                usernameEntered = scanner.nextLine();

                System.out.println("Enter your password: ");
                passwordEntered = scanner.nextLine();

                if (usernameEntered.equals(username) && passwordEntered.equals(password)) {
                    rand1 = random.nextInt(1, 101);
                    rand2 = random.nextInt(1, 101);
                    System.out.printf("Human verification: %d + %d = ? ", rand1, rand2);
                    answer = scanner.nextInt();
                    scanner.nextLine();
                    if (answer == rand1 + rand2) {
                        System.out.println("Login successfully");
                        break;
                    } else {
                        System.out.println("You are not human");
                        break;
                    }
                } else {
                    System.out.println("Wrong username or password");
                    System.out.println("Please try again");
                }
            }

        }
        else{
            System.out.println("Invalid Input");
        }


        scanner.close();
    }
}

