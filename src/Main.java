public class Main {

    public static void main(String[] args) throws Exception {

        Human me = new Human("Jakub", "Gramburg");
        Car car1 = new Car("Ford", "Focus");

        me.addCar(car1);

        System.out.println(me.getFullName() + " has a car: " + me.car.getName());
    }
}
