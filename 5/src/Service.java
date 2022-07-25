import java.io.*;
import java.util.List;

public class Service {
    public static void saveIntoBinaryFile(String fileName, List<Student> students) {
        ObjectOutputStream os;
        try {os = new ObjectOutputStream(new FileOutputStream(fileName));}
        catch  (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            os.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readFromBinaryFile(String fileName) {
        ObjectInputStream is;
        try {
            is = new ObjectInputStream(new FileInputStream((fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Student> toReturn;

        try {
            toReturn = (List<Student>)is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return toReturn;
    }
}
