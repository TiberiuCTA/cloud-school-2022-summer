public class Client {
    PizzaFactory factory;
    public Client(PizzaFactory factory){
        this.factory = factory;
        this.factory.attachObserver(this);
    }
}
