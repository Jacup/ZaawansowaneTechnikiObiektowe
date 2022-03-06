public class Main {

    static Human me;
    static Car car1;

    public static void main(String[] args) throws Exception {
        me = new Human("Jakub", "Gramburg");
        car1 = new Car("Ford", "Focus");

        me.addCar(car1);

        // zad034();


    }

    private static void zad034() throws Exception {
        System.out.println(me.getFullName() + " has a car: " + me.car.getName());
        me.setSalary(10000.0);
        // me.setSalary(-3000.0);

        me.getSalary();
        me.getSalary();
        me.setSalary(15000.0);
        System.out.println(me.getFullName() + " has a salary: " + me.getSalary());
    }
}
