package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuRepo {

    private Connection connection;

    public void connect() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }

    public void disconnect() throws SQLException{
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public boolean addItem(MenuItem menuItem) throws SQLException{
        String sql = "insert into menu(name, price) values(?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, menuItem.getName());
            preparedStatement.setDouble(2, menuItem.getPrice());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows == 1;
        }
    }

    public boolean removeItem(MenuItem menuItem) throws SQLException{
        String sql = "delete from menu where id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, menuItem.getId());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows == 1;
        }
    }

    public MenuItem searchItem(String name) throws SQLException{
        String sql = "select id, name, price from menu where name = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);

            try(ResultSet rs = preparedStatement.executeQuery()){
                if(!rs.next()){
                    return null;
                }
                int id = rs.getInt("id");
                String itemName = rs.getString("name");
                double itemPrice = rs.getDouble("price");

                return new MenuItem(id, itemName, itemPrice);
            }
        }
    }


    public List<MenuItem> getAllItems() throws SQLException{

        List<MenuItem> itemList = new ArrayList<>();
        String sql = "select * from menu";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();){

            while(rs.next()){
                int id = rs.getInt("id");
                String itemName = rs.getString("name");
                double price = rs.getDouble("price");
                itemList.add(new MenuItem(id, itemName, price));
            }
            return itemList;
        }
    }
}