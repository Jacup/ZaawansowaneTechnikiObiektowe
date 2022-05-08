package main.devices;

import interfaces.Saleable;
import main.creatures.Human;

public abstract class Car extends Device implements Saleable , Comparable<Car>{

    public Car(String producer, String model, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
    }

    @Override
    public void turnOn() {
        System.out.println("vroom vroom. . . ");
    }

    public abstract void refuel();

    @Override
    public String toString() {
        return getProducer() + " " + getModel() + " " + getYearOfProduction();
    }

    public String getName() {
        return getProducer() + " " + getModel();
    }

    public Car getCar() {
        return this;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if (isOwner(seller) && buyerHasEnoughCash(buyer, price)) {
            buyer.buyCar(this, price);
            seller.sellCar(this, price);
            System.out.println("Transaction between " + buyer.getFullName() + " and " + seller.getFullName() + " has been finished succesfully");
        }
    }

    private boolean buyerHasEnoughCash(Human buyer, Double cash) {
        var hasEnoughCash = buyer.getCash() >= cash;
        if (!hasEnoughCash) System.out.println(buyer.getFullName() + " cannot afford this car!");

        return hasEnoughCash;
    }

    private boolean isOwner(Human seller) {
        for (Car car : seller.getGarage()) {
            if (this.getCar().equals(car)) return true;
            else continue;
        }
        return false;
    }

    @Override
    public int compareTo(Car o) {
        if (this.getYearOfProduction() != o.getYearOfProduction())
            return this.getYearOfProduction() - o.getYearOfProduction();
        else
            return this.getName().compareTo(o.getName());
    }

}