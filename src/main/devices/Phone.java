package main.devices;

public class Phone extends Device {
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

//    public void installApp(String appName) {
//    }
//
//    public void installApp(String appName, String appVersion) {
//    }
//
//    public void installApp(String appName) {
//    }
//
//    public void installApp(String appName) {
//    }
}
