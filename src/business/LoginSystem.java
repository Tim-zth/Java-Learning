package business;

import java.util.Scanner;
import java.util.Random;

public class LoginSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("========== Sign Up ==========");
        User user = signUp(scanner);

        System.out.println("========== Sign In ==========");
        if(!signIn(scanner, random, user)){
            System.out.println("Failed to sign in");
        }

        scanner.close();
    }


    static User signUp(Scanner scanner){

        String email = getUserEmail(scanner);

        String username = getUserUsername(scanner);

        String password = getUserPassword(scanner);

        return new User(username, password, email);
    }


    // Temporary implementation.
    // Will be replaced with a user repository
    static boolean signIn(Scanner scanner, Random random, User user){

        String usernameEntered;
        String passwordEntered;
        int attempts = 3;

        while(attempts > 0) {
            System.out.println("Enter your username: ");
            usernameEntered = scanner.nextLine();

            System.out.println("Enter your password: ");
            passwordEntered = scanner.nextLine();

            attempts--;

            if (usernameEntered.equals(user.username) && passwordEntered.equals(user.password)) {

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


    /**
     * Prompts the user to enter a username until a valid one is provided.
     *
     * @param scanner Scanner used to read user input.
     * @return A valid username entered by the user.
     */
    static String getUserUsername(Scanner scanner){

        while(true){

            System.out.println("Please enter your username: ");

            String username = scanner.nextLine();

            if(isValidUsername(username)){
                return username;
            }

            System.out.println("Please enter a valid username");
        }
    }


    /**
     * Validates whether a username satisfies all required rules.
     *
     * <p><b>Username requirements:</b></p>
     * <ul>
     *   <li>Must not be empty.</li>
     *   <li>Must not contain spaces.</li>
     * </ul>
     *
     * @param username Username to validate.
     * @return true if the username is valid.
     */
    static boolean isValidUsername(String username){
        return !username.contains(" ") && !username.isBlank();
    }


    /**
     * Prompts the user to enter an email address until a valid one is provided.
     *
     * @param scanner Scanner used to read user input.
     * @return A valid email address entered by the user.
     */
    static String getUserEmail(Scanner scanner){

        while(true){

            System.out.println("Enter your email: ");

            String email = scanner.nextLine();

            if(isValidEmail(email)){
                return email;
            }

            System.out.println("Please enter a valid email address");
        }
    }


    /**
     * Validates whether an email address satisfies all required rules.
     *
     * <p><b>Email requirements:</b></p>
     * <ul>
     *   <li>Must contain @ .</li>
     * </ul>
     *
     * @param email Email address to validate.
     * @return true if the email address is valid.
     */
    static boolean isValidEmail(String email){
        return email.contains("@");
    }


    /**
     * Prompts the user to enter a password until a valid one is provided.
     *
     * @param scanner Scanner used to read user input.
     * @return A valid password entered by the user.
     */
    static String getUserPassword(Scanner scanner){

        System.out.println("Create your password: ");
        System.out.println("1. at least 8 characters");
        System.out.println("2. contains number");
        System.out.println("3. contains uppercase letter");
        System.out.println("4. contains special character");

        while(true){
            String password = scanner.nextLine();

            if(isValidPassword(password)){
                return password;
            }

            System.out.println("Create your password: ");
        }
    }


    /**
     * Validates whether a password satisfies all required rules.
     *
     * <p><b>Password requirements:</b></p>
     * <ul>
     *   <li>Must contain at least 8 characters</li>
     *   <li>Must contain number</li>
     *   <li>Must contain an uppercase letter</li>
     *   <li>Must contain a special character</li>
     * </ul>
     *
     * @param password Password to validate.
     * @return true if the password is valid.
     */
    static boolean isValidPassword(String password) {

        boolean hasValidLength = checkLength(password);
        boolean hasNumber = checkContainsNumber(password);
        boolean hasUppercase = checkContainsUppercase(password);
        boolean hasSpecialCharacter = checkContainsSpecialCharacter(password);

        if(!hasValidLength){
            System.out.println("password has to be at least 8 characters");
        }
        if(!hasNumber){
            System.out.println("password has to contain number");
        }
        if(!hasUppercase){
            System.out.println("password has to contain uppercase letter");
        }
        if(!hasSpecialCharacter) {
            System.out.println("password has to contain special character");
        }

        return hasValidLength
                && hasNumber
                && hasUppercase
                && hasSpecialCharacter;
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


}

