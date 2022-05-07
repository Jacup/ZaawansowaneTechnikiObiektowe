package devices;

import java.net.SocketOption;

public class Phone extends Device{
    public Phone(String producer, String model, int yearOfProduction) {
        super(model, producer, yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("TURNING ON PHONE");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
