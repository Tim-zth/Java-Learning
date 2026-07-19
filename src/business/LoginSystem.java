package business;

import java.util.Scanner;
import java.util.Random;

public class LoginSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        UserList userList = new UserList();
        boolean quit = false;

        while(!quit){
            System.out.println("1. Sign In");
            System.out.println("2. Create Account");
            System.out.println("0. Exit");


            Integer option = getUserOption(scanner);
            if(option == null){
                System.out.println("Option must be a number");
                continue;
            }
            switch(option){
                case 1 -> {
                    signIn(scanner, random, userList);
                }
                case 2 -> {
                    createAccount(scanner, userList);
                }
                case 0 -> {
                    quit = true;
                }
                default -> {
                    System.out.println("Invalid input");
                }
            }
        }
        scanner.close();
    }


    static void createAccount(Scanner scanner, UserList userList){

        String email = getUserEmail(scanner, userList);
        String username = getUserUsername(scanner, userList);
        String password = getUserPassword(scanner);

        if (userList.addUser(new User(username, password, email))) {
            System.out.println("Account created successfully.");
        }
        else {
            System.out.println("Unable to create account.");
        }
    }


    static void signIn(Scanner scanner, Random random, UserList userList){

        String usernameEntered;
        String passwordEntered;

        System.out.println("Enter your username: ");
        usernameEntered = scanner.nextLine();
        User user = userList.getUser(usernameEntered);

        System.out.println("Enter your password: ");
        passwordEntered = scanner.nextLine();

        if(user == null || !passwordEntered.equals(user.getPassword())){
            System.out.println("Wrong username or password");
        }
        else{
            if (humanVerification(scanner, random)) {
                System.out.println("Login successfully");
                accountPage(scanner, user, userList);
            } else {
                System.out.println("You are not human");
            }
        }
    }


    static String getUserUsername(Scanner scanner, UserList userList){

        while(true){
            System.out.println("Please enter your username: ");
            String username = scanner.nextLine();

            if(!isValidUsername(username)){
                System.out.println("Please enter a valid username");
                continue;
            }
            if(userList.isUsernameTaken(username)){
                System.out.println("Username is taken");
                continue;
            }
            return username;
        }
    }


    static boolean isValidUsername(String username){
        return !username.contains(" ") && !username.isBlank();
    }


    static String getUserEmail(Scanner scanner, UserList userList){

        while(true){
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();

            if(!isValidEmail(email)){
                System.out.println("Please enter a valid email address");
                continue;
            }
            if(userList.isEmailTaken(email)) {
                System.out.println("The email has been used by another account");
                continue;
            }
            return email;
        }
    }


    static boolean isValidEmail(String email){
        return email.contains("@");
    }


    static String getUserPassword(Scanner scanner){

        System.out.println("Create your password: ");
        printPasswordRequirements();

        while(true){
            String password = scanner.nextLine();

            if(isValidPassword(password)){
                return password;
            }

            System.out.println("Create your password: ");
        }
    }


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
            if(Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }


    static boolean checkContainsUppercase(String password){
        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                return true;
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
        int rand1;
        int rand2;

        rand1 = random.nextInt(1, 101);
        rand2 = random.nextInt(1, 101);
        System.out.printf("Human verification: %d + %d = ? ", rand1, rand2);

        try{
            int response = Integer.parseInt(scanner.nextLine());
            return response == rand1 + rand2;
        }
        catch(NumberFormatException e){
            return false;
        }
    }


    static void accountPage(Scanner scanner, User user, UserList userList){

        while(true){
            System.out.println("Welcome " + user.getUsername());
            System.out.println("==========Account Page=========");
            System.out.println("1. Profile");
            System.out.println("2. Change username");
            System.out.println("3. Change password");
            System.out.println("4. Change email");
            System.out.println("5. Logout");

            Integer option = getUserOption(scanner);
            if(option == null){
                System.out.println("Option must be a number.");
                continue;
            }

            switch (option){
                case 1 -> {
                    viewProfile(user);
                }
                case 2 -> {
                    changeUsername(scanner, user, userList);
                }
                case 3 -> {
                    changePassword(scanner, user, userList);
                }
                case 4 -> {
                    changeEmail(scanner, user, userList);
                }
                case 5 -> {
                    System.out.println("Logged out successfully.");
                    return;
                }
                default -> {
                    System.out.println("Invalid option");
                }
            }
        }
    }

    static void changeUsername(Scanner scanner, User user, UserList userList){
        //check if new username is valid
        System.out.println("Enter new username: ");
        String username = scanner.nextLine();

        if(!isValidUsername(username)){
            System.out.println("Invalid username");
            return;
        }
        if(userList.isUsernameTaken(username)){
            System.out.println("Username is taken");
            return;
        }
        userList.changeUsername(user, username);
    }

    static void changePassword(Scanner scanner, User user, UserList userList){
        System.out.println("Enter new password: ");
        printPasswordRequirements();

        String password = scanner.nextLine();

        if(isValidPassword(password)){
            userList.changePassword(user, password);
            return;
        }
        System.out.println("Invalid password");
    }

    static void changeEmail(Scanner scanner, User user, UserList userList){
        System.out.println("Enter new email: ");

        String email = scanner.nextLine();

        if(!isValidEmail(email)){
            System.out.println("Invalid email address");
            return;
        }
        if(userList.isEmailTaken(email)) {
            System.out.println("The email has been used by another account");
            return;
        }
        userList.changeEmail(user, email);
    }

    static void viewProfile(User user){
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email address: " + user.getEmail());
    }

    static Integer getUserOption(Scanner scanner){
        try{
            return Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e){
            return null;
        }
    }

    static void printPasswordRequirements(){
        System.out.println("1. at least 8 characters");
        System.out.println("2. contains number");
        System.out.println("3. contains uppercase letter");
        System.out.println("4. contains special character");
    }



}

