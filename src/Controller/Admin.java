package Controller;

import Database.DbConnecter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin {
    private DbConnecter dbConnecter;
    private Statement statement = null;
    private String query = null;
    public Admin() throws SQLException {
        dbConnecter = new DbConnecter();
        statement = dbConnecter.connection.createStatement();
    }

    public boolean login(String username, String password){
        query = "SELECT * FROM admins";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString("username");
                String pass = resultSet.getString("password");
                if (username.equals(name) && password.equals(pass)){
                    return true;
                }
            }
        }catch (SQLException exception){
            System.out.println(exception);
        }
        return false;
    }
}
