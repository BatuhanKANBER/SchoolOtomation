package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnecter {
    private static final String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf8";
    private static final String username = "root";
    private static final String password = "";
    public Connection connection = null;

    public DbConnecter(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException exception){
            System.out.println("Driver bulunamadı: " + exception);
        }

        try {
            connection = DriverManager.getConnection(url, username, password);
        }catch (SQLException exception){
            System.out.println("Veritabanı bağlantısı başarısız: " + exception);
        }
    }
}
