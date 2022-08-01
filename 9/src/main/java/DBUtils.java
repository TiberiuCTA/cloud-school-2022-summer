import java.sql.*;

public class DBUtils {
    public static Connection getConnection(){
        try {
            Connection connection= DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/dbsummer_2022", "root", "root");
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
