package main.devices;

import interfaces.Saleable;

public abstract class Device implements Saleable {
    private final String model;
    private final String producer;
    private final int yearOfProduction;

    public Device(String model, String producer, int yearOfProduction) {
        this.model = model;
        this.producer = producer;
        this.yearOfProduction = yearOfProduction;
    }

    public abstract void turnOn();

    @Override
    public String toString() {
        return producer + " " + model;
    }

    public String getModel() {
        return model;
    }

    public String getProducer() {
        return producer;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }
}
