package com.timothy.auth;

import com.timothy.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserRepo {

    private Connection connection;

    public UserRepo(){
    }

    public void connect() throws SQLException{
        connection = DatabaseConnection.getConnection();
    }

    public void disconnect() throws SQLException{
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public boolean addUser(User user) throws SQLException{
        String sql = "insert into users (user_name, user_password, user_email) values (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows == 1;
        }
    }

    public boolean removeUser(User user) throws SQLException{
        String sql = "delete from users where user_name = ? and user_email = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows == 1;
        }
    }

    public User searchUser(String name) throws SQLException{

        String sql = "select * from users where user_name = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                int id = rs.getInt("user_id");
                String username = rs.getString("user_name");
                String password = rs.getString("user_password");
                String email = rs.getString("user_email");
                LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();

                return new User(id, username, password, email, createdAt);
            }
        }
    }

    public boolean changeUsername(User user, String newUsername) throws SQLException{

        String sql = "update users set user_name = ? where user_name = ? and user_email = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows == 1;
        }
    }

    public boolean changePassword(User user, String newPassword) throws SQLException{

        String sql = "update users set user_password = ? where user_name = ? and user_email = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows == 1;
        }
    }

    public boolean changeEmail(User user, String newEmail) throws SQLException{

        String sql = "update users set user_email = ? where user_name = ? and user_email = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, newEmail);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows == 1;
        }
    }


    public boolean isUsernameTaken(String username) throws SQLException{
        String sql = "select 1 from users where user_name = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, username);

            try(ResultSet rs = preparedStatement.executeQuery()){
                return rs.next();
            }
        }
    }

    public boolean isEmailTaken(String email) throws SQLException{
        String sql = "select 1 from users where user_email = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, email);

            try(ResultSet rs = preparedStatement.executeQuery()){
                return rs.next();
            }
        }
    }

}
