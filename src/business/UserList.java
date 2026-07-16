package business;

public class UserList {

    private User[] users = new User[20];
    private int current = 0;

    public UserList(){
    }


    public boolean addUser(User user){
        if(user == null){
            return false;
        }
        if(isUsernameTaken(user.getUsername()) || isEmailTaken(user.getEmail())){
            return false;
        }
        users[current] = user;
        current++;
        return true;
    }


    public void removeUser(User user){

        int index = searchUser(user.getUsername());

        if(index != -1){
            for(int i = index; i < current - 1; i++){
                users[i] = users[i + 1];
            }
            current--;
            users[current] = null;
        }
        else{
            System.out.println("User does not exist");
        }
    }


    private int searchUser(String username){
        for(int i = 0; i < current; i++){
            if(users[i].getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }


    public boolean isUsernameTaken(String username){
        return searchUser(username) != -1;
    }


    public boolean isEmailTaken(String email){
        for(int i = 0; i < current; i++){
            if(users[i].getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public User getUser(String username){
        int index = searchUser(username);
        if(index == -1){
            return null;
        }
        return users[index];
    }



}
