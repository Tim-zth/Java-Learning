package business;

import java.io.*;
import java.util.ArrayList;

public class UserList {

    private final ArrayList<User> users = new ArrayList<>();

    public UserList(){
        importUsers();
    }

    public boolean addUser(User user){
        if(user == null){
            return false;
        }
        if(isUsernameTaken(user.getUsername())){
            return false;
        }
        if(isEmailTaken(user.getEmail())){
            return false;
        }
        users.add(user);
        saveUsers();
        return true;
    }


    public boolean removeUser(String username){
        User user = getUser(username);
        if (user == null) {
            return false;
        }
        boolean removed = users.remove(user);

        if (removed) {
            saveUsers();
        }
        return removed;
    }


    public boolean isUsernameTaken(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    public boolean isEmailTaken(String email){
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


    private void saveUsers(){

        try(FileWriter writer = new FileWriter("Users.txt")){
            for(User user : users){
                writer.write(
                        user.getUsername() + "," +
                                user.getPassword() + "," +
                                user.getEmail() +
                                System.lineSeparator()
                );
            }
        }
        catch(IOException e){
            System.out.println("unable to save users");
        }
    }


    private void importUsers(){

        try(BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                String[] userData = line.split(",");

                if(userData.length != 3){
                    continue;
                }
                String username = userData[0];
                String password = userData[1];
                String email = userData[2];

                users.add(new User(username, password, email));
            }
        }
        catch(FileNotFoundException e){
            // No saved users yet. The file will be created when a user is added.
        }
        catch(IOException e){
            System.out.println("unable to load users");
        }
    }


    public void changeUsername(User user, String username){
        user.setUsername(username);
        saveUsers();
    }

    public void changePassword(User user, String password){
        user.setPassword(password);
        saveUsers();
    }

    public void changeEmail(User user, String email){
        user.setEmail(email);
        saveUsers();
    }



}
