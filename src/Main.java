public class Main {

    static Human me;
    static Car car1;
    static Car car2;
    static Car car3;

    public static void main(String[] args) throws Exception {
// tooltip: use only one task per run. To run, uncomment one method only.

//        zad034();
//        zad05();

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

    private static void zad034() throws Exception {
        me = new Human("Jakub", "Gramburg");

        me.setSalary(10000.0);
        // me.setSalary(-3000.0);

        me.getSalary();
        me.getSalary();
        me.setSalary(15000.0);
        System.out.println(me.getFullName() + " has a salary: " + me.getSalary());
    }
}
