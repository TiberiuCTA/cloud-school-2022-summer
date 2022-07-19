import java.util.*;

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal("caine", 10);
        Animal a2 = new Animal("pisica", 15);
        Animal a3 = new Animal("maimuta", 7);

        List<Animal> lista = new LinkedList<>();
        lista.add(a1);
        lista.add(a2);
        lista.add(a3);

        Account ac = new Account(1, "12321321", Currency.EURO, 10000, new Date(), 100);

        DogShelter<Animal> sh = new DogShelter<>("DogShelter", ac, lista);
    }
}
