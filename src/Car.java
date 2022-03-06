public class Car {

    private String model;
    private String producer;


    public Car(String producer, String  model) {
        this.producer = producer;
        this.model = model;
    }

    public String getName() {
        return producer + " " + model;
    }
}