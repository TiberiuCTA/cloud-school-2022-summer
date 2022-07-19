import java.util.*;

public class DogShelter<T extends Animal> extends Shelter implements IShelter {

    private float latitude;
    private float longitude;

    private LinkedList<T> lista = new LinkedList<>();

    public DogShelter(String name, Account account, List<Animal> animals) {
        super(name, account, animals);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public float getLatitude() {
        return this.latitude;
    }

    @Override
    public float getLongitude() {
        return this.longitude;
    }

    @Override
    public String getOwner() {
        return null;
    }

    @Override
    public double reciveDonation() {
        return 0;
    }

    @Override
    public Pair spend() {
        return null;
    }

    public void addAnimal(T animal) {
        lista.add(animal);
    }
}
