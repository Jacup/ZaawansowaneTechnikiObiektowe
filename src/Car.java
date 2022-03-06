public class Car {

    private final String model;
    private final String producer;
    private Double value;

    public Car(String producer, String  model, Double value) {
        this.producer = producer;
        this.model = model;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return producer + " " + model;
    }
}