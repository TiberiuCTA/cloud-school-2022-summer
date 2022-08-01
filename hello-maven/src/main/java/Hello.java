import java.sql.*;

public class Hello {

    public void insert(Connection connection) {
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

    public boolean delete(Connection connection, int id) throws SQLException {
        Statement s = connection.createStatement();
        int noDeleted = s.executeUpdate("DELETE FROM `" + "orders" + "` WHERE `id` = '" + id + "'");
        return noDeleted > 0;
    }

    public void update(Connection connection) {
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

    public void select(Connection connection, String tableName) throws SQLException {
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM `"+tableName+"`");

        StringBuilder sb = new StringBuilder();
        while(rs.next()) {
            String phone = rs.getString("phone");
            String username = rs.getString("username");
            sb.append(username + " (" + phone + ")" + "\n");
        }
        System.out.print(sb);
    }

    public Connection connect() throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/tema3";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(connectionUrl, username, password);
    }

    public static void main(String args[]) {
        try {
            Hello hello=new Hello();
            Connection connection = hello.connect();
//            Hello.insert(connection);
            hello.select(connection, Customer.tableName);

           // Customer customer = Customer.getById(connection, 3);
            //System.out.println(customer);
            //Hello.delete(connection, 7);
//            System.out.println(Customer.delete(connection, 9) ? "s-a sters" : "nu s-a sters");
            //boolean added = Order.addOrder(connection, customer, new Order("2022-01-01", "2022-01-01", "in progress", customer.id));
            //System.out.println((added ? "added " : " not added") + " order");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
