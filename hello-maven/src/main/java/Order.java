import java.sql.*;

public class Order extends OrderDetails{
    static String tableName = "orders";
    String order_date;
    String shipped_date;
    String status;
    String comments;
    int customer_id;

    public Order(String order_date, String shipped_date, String status, int customer_id) {
        this.order_date = order_date;
        this.shipped_date = shipped_date;
        this.status = status;
        this.customer_id = customer_id;
    }

    public boolean addOrder(Connection connection, Customer customer, Order order) throws SQLException {
        if (customer == null) return false;
        PreparedStatement ps = connection.prepareStatement("INSERT INTO `orders`" +
                " (`order_date`, `shipped_date`, `status`, `customer_id`) " +
                "VALUES (DATE ? , DATE ?, ?, ?)");
        ps.setString(1, order.order_date);
        ps.setString(2, order.shipped_date);
        ps.setString(3, order.status);
        ps.setInt(4, customer.id);
        int noInserted = ps.executeUpdate();
        return noInserted > 0;
    }

}
