import devices.Car;

public class Main {

    static Human me;
    static Car car1;
    static Car car2;
    static Car car3;

    public static void main(String[] args) throws Exception {
// tooltip: use only one task per run. To run, uncomment one method only.

//        zad034();
//        zad05();
        zad06();
    }

    private static void zad034() throws Exception {
        me = new Human("Jakub", "Gramburg");

        me.setSalary(10000.0);
        // me.setSalary(-3000.0);

        me.getSalary();
        me.getSalary();
        me.setSalary(15000.0);
        System.out.println(me.getFullName() + " has a salary: " + me.getSalary());
    }

    private static void zad05() throws Exception {
        me = new Human("Jakub", "Gramburg");

        me.setSalary(15000.0);
        car1 = new Car("Ford", "Focus", 10000.0);
        car2 = new Car("Audi", "RS3", 150000.0);
        car3 = new Car("Ferrari", "Aventador", 1000000.0);

        me.setCar(car1);
        me.setCar(car2);
        me.setCar(car3);
    }

    private static void zad06() {
        car1 = new Car("Audi", "RS3", 150000.0);
        car2 = new Car("Audi", "RS3", 150000.0);

        var areEqual = car1.equals(car2);
        // even when objects have the same attributes(they're the same), for OS they are two separate objects,
        // with different references in memory heap.

        System.out.println("is car1 equal to car2? Answer is:  " + areEqual);
        System.out.println(car1);
        // print whole car results in printing hashcode values of the objects
        // after adding 'toString()' in class, we can override default hashcode printing, with own print msg, for example
        // devices.Car.cs:14
        me = new Human("Jakub", "Gramburg");
        System.out.println(me);

    }
}
