package business;

public class User {
    String username;
    String email;
    String password;


    User(){
        this.username = "Guest";
    }
    User(String username, String password){
        this.username = username;
        this.password = password;
    }
    User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
