package main.devices;

import interfaces.Saleable;
import main.Human;

public class Car extends Device implements Saleable {

    private Double value;

    public Car(String producer, String model, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction);
        this.value = value;
    }

    @Override
    public void turnOn() {
        System.out.println("vroom vroom. . . ");
    }

    @Override
    public String toString() {
        return "Models.devices.Car{" + "model='" + getModel() + '\'' + ", producer='" + getProducer() + '\'' + ", value=" + value + '}';
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return getProducer() + " " + getModel();
    }

    public Car getCar() {
        return this;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (isOwner(seller) && buyerHasEnoughCash(buyer, price)) {
            buyer.buyCar(this, price);
            seller.sellCar(price);
            System.out.println("Transaction between " + buyer.getFullName() + " and " + seller.getFullName() + " has been finished succesfully");
        }
    }

    private boolean buyerHasEnoughCash(Human buyer, Double cash) {
        var hasEnoughCash = buyer.getCash() >= cash;
        if (!hasEnoughCash) System.out.println(buyer.getFullName() + " cannot afford this car!");

        return hasEnoughCash;
    }

    private boolean isOwner(Human seller) {
        var isOwner = this.equals(seller.getCar());
        if (!isOwner)
            System.out.println(seller.getFullName() + " cannot sell " + getCar() + " because it's not his car!");

        return isOwner;
    }
}