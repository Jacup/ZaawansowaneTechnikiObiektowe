import devices.Car;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Human {

    private final String firstName;
    private final String lastName;
    private Double salary;
    private final Map<LocalDateTime, Double> salaryQueries;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private Car car;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salaryQueries = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car carToAdd) throws Exception {
        if (car == null) {
            if (carToAdd.getValue() <= salary) {
                System.out.println("Congratulations! " + getFullName() + " can afford " + carToAdd.getName());
                car = carToAdd;
            } else if (carToAdd.getValue() > salary && (carToAdd.getValue() / 12) < salary) {
                System.out.println(getFullName() + " can't afford " + carToAdd.getName() + ", but bank will help him to buy it!");
                car = carToAdd;
            } else {
                System.out.println(getFullName() + " is poor, he should ride a bike :( ");
            }
        } else {
            throw new Exception("This guy already has a car");
        }
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
        System.out.println("| Please visit Halina from HR to get your copy of doc. " +
                "PS. Pegasus knows everything ( \u0361\u00B0 \u035C\u0296 \u0361\u00B0)");
        System.out.println(" ------------");
        this.salary = salary;
    }
}
