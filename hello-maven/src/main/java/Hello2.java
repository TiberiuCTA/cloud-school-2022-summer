/*import org.apache.commons.lang3.tuple.*;

import java.sql.*;

public class Hello {
    public static void main(String[] args){
        Pair<String, Integer> pair=new ImmutablePair<>("cmz", 2);
        System.out.println(pair.getLeft());
        Hello.connect();
    }

    private static void connect() {
        String connectionUrl = "jdbc:mysql://localhost:3306/dbsummer_2022";
        String username = "root";
        String password = "root";
        new Customer().connect(6);
        //try {
            //Connection connection = DriverManager.getConnection(connectionUrl,
            //        username, password);
            /*PreparedStatement ps=connection.prepareStatement("INSERT INTO `customers2` (`username`, `phone`) VALUES (?, ?)");
            ps.setString(1, "elena");
            ps.setString(2, "0732492200");
            int noInserted=ps.executeUpdate();
            System.out.print(noInserted);
            System.out.println(noInserted>0? " Inserted":" None");*/
            /*Statement s=connection.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM customers2");
            StringBuilder sb=new StringBuilder();
            while (rs.next()) {
                String phone=rs.getString("phone");
                String name=rs.getString("username");
                sb.append(name+"   "+phone+"\n");
            }
            System.out.println(sb);*/
        /*} catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


class Customer{
    static String tableName="customers2";
    String username;
    String phone;
    Integer id;

    public static Customer getById(){
        return null;
    }
public Customer(){

}

    public Customer(String username, String phone, Integer id) {
        this.username = username;
        this.phone = phone;
        this.id = id;
    }

    public void connect(int ID) {
        String connectionUrl = "jdbc:mysql://localhost:3306/dbsummer_2022";
        String username = "root";
        String password = "root";
        try {
            Connection connection = DriverManager.getConnection(connectionUrl,
                    username, password);
            /*PreparedStatement ps=connection.prepareStatement("INSERT INTO `customers2` (`username`, `phone`) VALUES (?, ?)");
            ps.setString(1, "elena");
            ps.setString(2, "0732492200");
            int noInserted=ps.executeUpdate();
            System.out.print(noInserted);
            System.out.println(noInserted>0? " Inserted":" None");*/
            /*Statement s=connection.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM customers2");
            StringBuilder sb=new StringBuilder();
            while (rs.next()) {
                String phone=rs.getString("phone");
                String name=rs.getString("username");
                sb.append(name+"   "+phone+"\n");
            }
            System.out.println(sb);
            Statement s=connection.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM `"+Customer.tableName+"` WHERE `id`='"+ID+"'");
                String phone=rs.getString("phone");
                String name=rs.getString("username");
               System.out.println(new Customer(phone, name, ID));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                '}';
    }
}*/