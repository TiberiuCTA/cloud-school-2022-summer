import java.sql.*;

public class Customer {
    static String tableName = "customers";
    int id;
    String username;
    String phone;
    String city;

    public Customer(int id, String username, String phone, String city) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.city = city;
    }

    public Customer getById(Connection connection, int id) throws SQLException {
        // SELECT * FROM `customers` WHERE id = '?'
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM `" + Customer.tableName + "` WHERE `id` = '" + id + "' LIMIT 1");

        if(rs.next()) {
            int selId = rs.getInt("id");
            String username = rs.getString("username");
            String phone = rs.getString("phone");
            String city = rs.getString("city");
            return new Customer(selId, username, phone, city);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
