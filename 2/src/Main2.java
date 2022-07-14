import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main2 {
    public static void main(String[] args){
        BusStation busStation=new BusStation();

        busStation.arrayList.add(new Bus("galben", true, 30, 10));
        busStation.arrayList.add(new Taxi("galben", true, 3, 15));
        busStation.arrayList.add(new Bus("rosu", true, 20, 6));
        busStation.arrayList.add(new Taxi("alb", true, 1, 50));
        busStation.arrayList.add(new Bus("albastru", true, 35, 8));
        busStation.arrayList.add(new Taxi("verde", true, 2, 25));

        System.out.println("\n--- showAllVehicles");
        busStation.showAllVehicles();
        System.out.println("\n--- showTotalProfit");
        busStation.showTotalProfit();
        System.out.println("\n--- sortVehicles by profit");
        busStation.sortVehicles();
    }
}

abstract class Vehicle implements Comparable<Vehicle>{
    private String colour;
    private boolean functional;

    public Vehicle(){

    }

    public Vehicle(String colour, boolean functional) {
        this.colour = colour;
        this.functional = functional;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isFunctional() {
        return functional;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    abstract int charge();
    abstract int profit();
    abstract void display();

    public int compareTo(Vehicle vehicle){
        return ((Integer)profit()).compareTo(vehicle.profit());
    }
}

class Bus extends Vehicle{
    int noPassangers, ticketPrice;

    public Bus(int noPassangers, int ticketPrice) {
        this.noPassangers = noPassangers;
        this.ticketPrice = ticketPrice;
    }

    public Bus(String colour, boolean functional, int noPassangers, int ticketPrice) {
        super(colour, functional);
        this.noPassangers = noPassangers;
        this.ticketPrice = ticketPrice;
    }

    public int charge(){
        return ticketPrice*noPassangers;
    }
    public int profit(){
        return (25*charge())/100;
    }
    public void display(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "noPassangers=" + noPassangers +
                ", ticketPrice=" + ticketPrice +
                ", profit=" + profit() +
                '}';
    }
}

class Taxi extends Vehicle{
    int noPassangers, ticketPrice;

    public Taxi(int noPassangers, int ticketPrice) {
        this.noPassangers = noPassangers;
        this.ticketPrice = ticketPrice;
    }

    public Taxi(String colour, boolean functional, int noPassangers, int ticketPrice) {
        super(colour, functional);
        this.noPassangers = noPassangers;
        this.ticketPrice = ticketPrice;
    }

    public int charge(){
        return ticketPrice*noPassangers;
    }
    public int profit(){
        return (25*charge())/100;
    }
    public void display(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "noPassangers=" + noPassangers +
                ", ticketPrice=" + ticketPrice +
                ", profit=" + profit() +
                '}';
    }
}

class BusStation{
    ArrayList<Vehicle> arrayList=new ArrayList<>();

    public void showAllVehicles(){
        for(int i=0;i<arrayList.size();i++){
            arrayList.get(i).display();
        }
    }
    public void showTotalProfit(){
        int totalProfit=0;
        for(int i=0;i<arrayList.size();i++){
            totalProfit+=arrayList.get(i).profit();
        }
        System.out.println(totalProfit);
    }
    public void sortVehicles(){
        Collections.sort(arrayList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return v1.compareTo(v2);
            }
        });
        System.out.println(arrayList);
    }
}
