public class Human {

    private final String firstName;
    private final String lastName;
    Car car;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addCar(Car car1) throws Exception {
        if (car == null) {
            car = car1;
        } else {
            throw new Exception("This guy already has a car");
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
