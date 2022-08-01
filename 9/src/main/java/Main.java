import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;

//vad tipul cu reflection (perspectiva RUNTIME - aici lucrez cu obiecte, nu clase)
public class Main {
    public static void main(String[] args) throws SQLException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        /*List<User> users = User.getAll();
        List<Command> commands = Command.getAll();*/
        User u = new User();
        List<User> userList=u.getAll();
        for(User x:userList){
            System.out.println(x);
        }

        Command c = new Command();
        List<Command> commands=c.getAll();
        for(Command x:commands){
            System.out.println(x);
        }

//        User newUser=new User("Fntastik Fefe", "francesco@fanta");
//        newUser.insert();
//
//        userList=u.getAll();
//        for(User x:userList){
//            System.out.println(x);
//        }
    }
}
