package business;

import java.util.ArrayList;

public class UserList {

    private final ArrayList<User> users = new ArrayList<>();

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
        return true;
    }


    public boolean removeUser(String username){
        User user = getUser(username);
        if (user == null) {
            return false;
        }
        return users.remove(user);
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



}
