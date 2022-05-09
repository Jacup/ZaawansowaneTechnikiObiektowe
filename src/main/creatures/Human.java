package main.creatures;

import main.devices.Car;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Human extends Animal {

    private final String firstName;
    private final String lastName;
    private final Map<LocalDateTime, Double> salaryQueries;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final int DEFAULTGARAGESIZE = 3;

    private Double salary;
    private Double cash;
    private Car[] garage;

    public Human(String firstName, String lastName, Double cash) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
        this.salaryQueries = new HashMap<>();
        this.garage = new Car[DEFAULTGARAGESIZE];
    }

    public Human(String firstName, String lastName, Double cash, Integer garageSize) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
        this.salaryQueries = new HashMap<>();
        this.garage = new Car[DEFAULTGARAGESIZE];
    }

    @Override
    public String toString() {
        String msg = "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", salary=" + salary;
        if (haveAnyCar()) msg += "\nCars:";
        for (int i = 0; i < garage.length; i++) {
            if (!isEmpty(i)) {
                msg += "\n   " + garage[i].toString();
            }
        }
        return msg;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Car[] getGarage() {
        return this.garage;
    }

    public Car getCar(Integer parkingSpace) {
        return garage[parkingSpace];
    }

    private boolean haveAnyCar() {
        boolean carFound = false;

        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == null) continue;
            else carFound = true;
        }
        return carFound;
    }

    /*
    I know that is quite good spaghetti, bon appétit :)
    I will refactor this nested and doubled if statements if I have enough time
    */
    public void setCar(Car carToAdd, Integer parkingSpace) throws Exception {
        if (parkingSpace < garage.length && isEmpty(parkingSpace)) {
            if (carToAdd.getValue() <= salary) {
                System.out.println("Congratulations! " + getFullName() + " can afford " + carToAdd.getName());
                garage[parkingSpace] = carToAdd;
                carToAdd.addOwner(this);
            } else if (carToAdd.getValue() > salary && (carToAdd.getValue() / 12) < salary) {
                System.out.println(getFullName() + " can't afford " + carToAdd.getName() + ", but bank will help him to buy it!");
                garage[parkingSpace] = carToAdd;
                carToAdd.addOwner(this);
            } else {
                System.out.println(getFullName() + " is poor, he should ride a bike :( ");
            }
        } else {
            throw new Exception("Cannot set car on " + parkingSpace + " parking space");
        }
    }

    public void setCar(Car carToAdd) throws Exception {
        setCar(carToAdd, getEmptySpot());
    }

    private Integer getEmptySpot() throws Exception {
        for (int i = 0; i < garage.length; i++) {
            if (isEmpty(i)) return i;
        }
        throw new Exception(this.getFullName() + "don't have empty slots in garage!");
    }

    private Boolean isEmpty(int i) {
        if (garage[i] == null) return true;
        else return false;
    }

    public void sellCar(Car carToRemove, Double price) throws Exception {
        int spotInGarage = findCarSpotInGarage(carToRemove);
        garage[spotInGarage] = null;
        addCash(price);
    }

    private int findCarSpotInGarage(Car carToRemove) throws Exception {
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == carToRemove) return i;
        }
        throw new Exception("ERROR. Something go wrong.");
    }

    public void buyCar(Car carToAdd, Double price) throws Exception {
        var emptySpot = getEmptySpot();
        removeCash(price);
        garage[emptySpot] = carToAdd;
        carToAdd.addOwner(this);
    }

    public Double getSalary() {
        if (!salaryQueries.isEmpty()) {
            System.out.println("\n ------------");
            System.out.println("| Salary queries:");

            for (var query : salaryQueries.entrySet()) {
                System.out.println("| Query at " + DTF.format(query.getKey()) + " returned salary: " + query.getValue());
            }
            System.out.println(" ------------");
        }
        salaryQueries.put(LocalDateTime.now(), salary);
        return this.salary;
    }

    public void setSalary(Double salary) throws Exception {
        if (salary < 0) {
            throw new Exception("Salary cannot be negative");
        }

        LocalDateTime createdDate = LocalDateTime.now();

        System.out.println("\n ------------");
        System.out.println("| New salary " + salary + " has been saved!  || " + DTF.format(createdDate));
        System.out.println("| Please visit Halina from HR to get your copy of doc. " + "PS. Pegasus knows everything ( \u0361\u00B0 \u035C\u0296 \u0361\u00B0)");
        System.out.println(" ------------");
        this.salary = salary;
    }

    public Double getCash() {
        return cash;
    }

    public void addCash(Double value) {
        cash += value;
    }

    public void removeCash(Double value) {
        if (cash >= value) {
            cash -= value;
        } else {
            try {
                throw new Exception(getFullName() + " doesn't have enough cash");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Double getGarageValue() {
        Double sum = 0.0;
        for (Car car : garage) {
            if (car != null) sum = sum + car.getValue();
        }
        return sum;
    }

    public void sortGarage() {
        Arrays.sort(garage);
    }
}

