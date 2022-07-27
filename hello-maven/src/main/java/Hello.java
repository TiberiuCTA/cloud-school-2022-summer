import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.sql.*;

public class Hello {

    private static void insert(Connection connection) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `customers` (`username`, `phone`) VALUES (? , ?)");
            ps.setString(1, "popescud");
            ps.setString(2, "0721982713");
            int noInserted = ps.executeUpdate();
            System.out.println((noInserted > 0 ? noInserted : "None ") + "inserted");
        } catch (SQLException exception) {
            System.err.println("There was a problem with SQL: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    private static void select(Connection connection) throws SQLException {
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM `customers`");

        StringBuilder sb = new StringBuilder();
        while(rs.next()) {
            String phone = rs.getString("phone");
            String username = rs.getString("username");
            sb.append(username + " (" + phone + ")" + "\n");
        }
        System.out.print(sb);
    }

    private static Connection connect() throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/db_tech_school";
        String username = "root";
        String password = "D@t@tables";
        return DriverManager.getConnection(connectionUrl, username, password);
    }

    public static void main(String args[]) {
        Pair pari = new ImmutablePair<String, String>("test", "altceva");
        try {
            Connection connection = Hello.connect();
//            Hello.insert(connection);
//            Hello.select(connection);

            Customer customer = Customer.getById(connection, 3);
//            System.out.println(customer);
//            System.out.println(Customer.delete(connection, 9) ? "s-a sters" : "nu s-a sters");
            boolean added = Order.addOrder(connection, customer, new Order("2022-01-01", "2022-01-01", "in progress", customer.id));
            System.out.println((added ? "added " : " not added") + " order");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
