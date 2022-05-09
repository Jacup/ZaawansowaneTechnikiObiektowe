package main.devices;

import interfaces.Saleable;
import main.apps.AppVersion;
import main.creatures.Human;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public abstract class Car extends Device implements Saleable, Comparable<Car> {

    private final ArrayList<Human> owners;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public Car(String producer, String model, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
        owners = new ArrayList<>();
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
        if (isOwner(seller) && isLatestOwner(seller) && buyerHasEnoughCash(buyer, price)) {
            buyer.buyCar(this, price);
            seller.sellCar(this, price);
            transactions.add(new Transaction(seller, buyer, price, LocalDateTime.now()));
            System.out.println("Transaction between " + buyer.getFullName() + " and " + seller.getFullName() + " has been finished succesfully");
        }
    }

    private boolean isLatestOwner(Human seller) {
        return owners.get(owners.size() - 1).equals(seller);
    }

    private boolean buyerHasEnoughCash(Human buyer, Double cash) {
        var hasEnoughCash = buyer.getCash() >= cash;
        if (!hasEnoughCash) System.out.println(buyer.getFullName() + " cannot afford this car!");

        return hasEnoughCash;
    }

    private boolean isOwner(Human seller) {
        for (Car car : seller.getGarage()) {
            if (this.getCar().equals(car)) return true;
        }
        return false;
    }

    @Override
    public int compareTo(Car o) {
        if (this.getYearOfProduction() != o.getYearOfProduction())
            return this.getYearOfProduction() - o.getYearOfProduction();
        else return this.getName().compareTo(o.getName());
    }

    public ArrayList<Human> getOwners() {
        return owners;
    }

    public void addOwner(Human newOwner) {
        this.owners.add(newOwner);
    }

    public boolean isBrandNew() {
        return this.owners.isEmpty();
    }

    public boolean transactionExists(Human seller, Human buyer) {
        Optional<Transaction> transaction = transactions.stream()
                .filter(x -> x.seller().equals(seller) && x.buyer().equals(buyer)).findFirst();

        return transaction.isPresent();
    }

    public int getTransactionsAmount() {
        return transactions.size();
    }
}