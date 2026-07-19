package business;

import java.time.LocalDateTime;

public class User {
    private String username;
    private String email;
    private String password;
    private final LocalDateTime createdAt;


    //register new user
    public User(String username, String password, String email){
        this(username, password, email, LocalDateTime.now());
    }

    //restore user from users file
    public User(String username, String password, String email, LocalDateTime createdAt){
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
}
