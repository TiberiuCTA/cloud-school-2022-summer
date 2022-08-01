import java.lang.reflect.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Entity {
    //insert update getAll getById delete

    public <T> List<T> getAll() throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        List<T> resultList = new ArrayList<>();


        //SELECT * FROM tabela
        //ResultSet -> tip + numele coloanelor din db (se potrivesc cu cele din clasa)
        //pentru fiecare element din resultSet
        //cine e T?
        //obj=apelez constructorul lui T
        //setez pe obj toate valorile pe care le decopar in ResultSet

        //ne trebuie
        //1.numele tabelei(din adnotare)
        //reflection
        Class<Entity> c = (Class<Entity>) this.getClass();
        ActiveRecord annotation=c.getAnnotation(ActiveRecord.class);
        String tableName= annotation.tableName();
        String primaryKeyName= annotation.primaryKeyName();

        //2.rulam SELECT
        Connection connection=DBUtils.getConnection();
        if(connection==null){
            return null;
        }
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM "+tableName);

        //metadatele din ResultSet
        ResultSetMetaData meta=rs.getMetaData();
        int noColumns=meta.getColumnCount();


        //3.interpretam rs si cream obiectele de tip T
        while(rs.next()){
            //gasim constructorul lui T ca sa putem crea obiectul
            //reflection
            T obj=(T) c.getDeclaredConstructor().newInstance();
            for(int i=1;i<=noColumns;i++){
                //acelasi cu atributul din java
                String columnName=meta.getColumnName(i);
                //campul din java
                Field f=c.getDeclaredField(columnName);

                //verificam tipul lui f
                if(f.getType()==int.class){
                    int value=rs.getInt(columnName);
                    f.setInt(obj, value); // obj.columnName=value
                }
                else if(f.getType()==String.class){
                    String value=rs.getString(columnName);
                    f.set(obj, value);
                }
                else if(f.getType()== Date.class){
                    Date value=rs.getDate(columnName);
                    f.set(obj, value);
                }
                //DATETIME IN sql = TIMESTAMP
            }
            resultList.add(obj);
        }

        return resultList;
    }

    public void insert() throws SQLException, IllegalAccessException {
//        INSERT INTO tableName (campuri ....) VALUES (? ? ?);

        //        1. Numele tabelei - se ia din annotation

        Class<Entity> myClass = (Class<Entity>)this.getClass(); // reflection
        ActiveRecord annotation = myClass.getAnnotation(ActiveRecord.class); // reflection
        String tableName = annotation.tableName();
        String primaryKeyName = annotation.primaryKeyName();

        //        2. Rulam SELECT

        Connection connection = DBUtils.getConnection();

        if(connection == null){
            System.exit(0);
        }
        String sql = "INSERT INTO " + tableName + " (";
        Field[] f = myClass.getDeclaredFields();

        for(Field field : f){
//            if(field.getName() != primaryKeyName){
            sql += field.getName();
            sql += ", ";
//            }
        }
        sql = sql.substring(0, sql.length()-2);
        sql += ") VALUES(";
        for(int i=0 ; i< f.length ; i++){
            sql += "?, ";
        }
        sql = sql.substring(0, sql.length()-2);
        sql += ");";
        System.out.println(sql);

        PreparedStatement ps = connection.prepareStatement(sql);

        for(int i=0 ; i< f.length ; i++){

            if (!f[i].getName().equals(primaryKeyName)) {
                if(f[i].getType() == int.class){
                    ps.setInt(i+1, f[i].getInt(this));
                }
                else if(f[i].getType() == String.class){
                    ps.setString(i+1, (String)f[i].get(this));
                }
                else if(f[i].getType() == Date.class){
                    ps.setDate(i+1, (Date)f[i].get(this));
                }
            }
            else {
                ps.setNull(i+1, Types.INTEGER);
            }
        }
        ps.executeUpdate();
    }
}
