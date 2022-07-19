import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        ArrayList<Doctor> arrayList = new ArrayList<>();
        ArrayList<Generalist> generics = new ArrayList<>();
        arrayList.add(new Surgeon("heart", "Mihai1"));
        arrayList.add(new Generalist(12, "Andrei1"));
        arrayList.add(new Surgeon("heart", "Mihai2"));
        arrayList.add(new Generalist(10, "Andrei2"));
        arrayList.add(new Surgeon("kidney", "Mihai3"));
        arrayList.add(new Generalist(5, "Andrei3"));

        System.out.println("\n---Iterate through the array and print all the doctors");
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) instanceof Generalist)
                generics.add(((Generalist) arrayList.get(i)));
            System.out.println(arrayList.get(i));
        }

        HashMap<String, Integer> hashMap = new HashMap<>();

        System.out.println();
        int sum = 0, noOfGeneralist = 0;
        System.out.println("---Using instanceOf, perform the specific behaviour depending on doctor’s type");
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) instanceof Surgeon) {
                ((Surgeon) arrayList.get(i)).intervention();

                if (hashMap.get(((Surgeon) arrayList.get(i)).expertise) == null)
                    hashMap.put(((Surgeon) arrayList.get(i)).expertise, 1);
                else {
                    int newVal = hashMap.get(((Surgeon) arrayList.get(i)).expertise) + 1;
                    hashMap.replace(((Surgeon) arrayList.get(i)).expertise, newVal);
                }
                if (hashMap.get(((Surgeon) arrayList.get(i)).expertise) >= 2) {
                    System.out.println("---Check if there are at least two doctors with the same expertise");
                    System.out.println(" >>> expertiza comuna este " + ((Surgeon) arrayList.get(i)).expertise);
                }
            }
            if (arrayList.get(i) instanceof Generalist) {
                noOfGeneralist++;
                ((Generalist) arrayList.get(i)).getRecipe();
                sum += ((Generalist) arrayList.get(i)).noPatients;
            }
        }

        Collections.sort(generics, new Comparator<Generalist>() {
            @Override
            public int compare(Generalist g1, Generalist g2) {
                return g1.compareTo(g2);
            }
        });
        System.out.println("\n---Order all generalist doctors by the number of their patients (optional)");
        System.out.println(generics);

        int res = 0;
        for (int i = 0; i < generics.size(); i++) {
            if (generics.get(i).noPatients > sum / noOfGeneralist)
                res++;
        }
        System.out.println("\n---Find out how many generalist doctors have a larger number " +
                "of patients than the medium number of all generalists");
        System.out.println(res);
    }
}

class Doctor {
    String name;

    public Doctor() {

    }

    public Doctor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Surgeon extends Doctor {
    String expertise;

    public Surgeon() {

    }

    public Surgeon(String expertise, String name) {
        super(name);
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        return "Surgeon{" +
                "expertise='" + expertise + '\'' +
                '}';
    }

    public void intervention() {
        System.out.println("intervention");
    }
}

class Generalist extends Doctor implements Comparable<Generalist> {
    int noPatients;

    public Generalist() {

    }

    public Generalist(int noPatients, String name) {
        super(name);
        this.noPatients = noPatients;
    }

    @Override
    public String toString() {
        return "Generalist{" +
                "noPatients=" + noPatients +
                '}';
    }

    public void getRecipe() {
        System.out.println("recipe");
    }

    public int compareTo(Generalist generalist) {
        return ((Integer) noPatients).compareTo(generalist.noPatients);
    }
}
