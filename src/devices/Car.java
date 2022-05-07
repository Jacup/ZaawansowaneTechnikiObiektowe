package devices;

public class Car extends Device{

    private Double value;

    public Car(String producer, String model, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction);
        this.value = value;
    }

    @Override
    public void turnOn() {
        System.out.println("wrum wrum. . . ");
    }

    @Override
    public String toString() {
        return "devices.Car{" +
                "model='" + getModel() + '\'' +
                ", producer='" + getProducer() + '\'' +
                ", value=" + value +
                '}';
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return getProducer() + " " + getModel();
    }
}