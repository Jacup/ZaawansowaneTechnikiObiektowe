package main;

import main.apps.App;
import main.apps.AppVersion;
import main.creatures.FarmAnimal;
import main.creatures.Human;
import main.creatures.Pet;
import main.devices.Car;
import main.devices.Diesel;
import main.devices.Phone;

public class Main {

    static Human me;
    static Car car1;
    static Car car2;
    static Car car3;

    public static void main(String[] args) throws Exception {
// tooltip: use only one task per run. To run, uncomment one method only.

//        zad034();
//        zad05();
//        zad06();
//        zad07();
//        zad08();
//        zad09();
//        zad10();
        zad11();
    }

    private static void zad034() throws Exception {
        me = new Human("Jakub", "Gramburg", 5000.0);

        me.setSalary(10000.0);
        // me.setSalary(-3000.0);

        me.getSalary();
        me.getSalary();
        me.setSalary(15000.0);
        System.out.println(me.getFullName() + " has a salary: " + me.getSalary());
    }

    private static void zad05() throws Exception {
        me = new Human("Jakub", "Gramburg", 5000.0);

        me.setSalary(15000.0);
        car1 = new Diesel("Ford", "Focus", 2015, 10000.0);
        car2 = new Diesel("Audi", "RS3", 2015, 150000.0);
        car3 = new Diesel("Ferrari", "Aventador", 2020, 1000000.0);

        me.setCar(car1);
        // wincyj sie nie da
        me.setCar(car2);
        me.setCar(car3);
    }

    private static void zad06() {
        car1 = new Diesel("Audi", "RS3", 2015, 150000.0);
        car2 = new Diesel("Audi", "RS3", 2015, 150000.0);

        var areEqual = car1.equals(car2);
        // even when objects have the same attributes(they look the same), for OS they are two separate objects,
        // with different references in memory heap.

        System.out.println("is car1 equal to car2? Answer is:  " + areEqual);
        System.out.println(car1);
        // print whole car results in printing hashcode values of the objects
        // after adding 'toString()' in class, we can override default hashcode printing, with own print msg, for example
        // Models.devices.Car.cs:14
        me = new Human("Jakub", "Gramburg", 5000.0);
        System.out.println(me);
    }

    private static void zad07() {
        car1 = new Diesel("Audi", "RS3", 2015, 150000.0);
        car1.turnOn();
    }

    private static void zad08() throws Exception {
        car1 = new Diesel("Audi", "RS3", 2015, 150000.0);

        me = new Human("Jakub", "Gramburg", 5000.0);
        me.setSalary(15000.0); //needed due to prev tasks
        me.setCar(car1, 0);

        Human someone = new Human("Jan", "Pawel", 1000000.0);

        car1.sell(me, someone, car1.getValue());
//        me.sell(me, someone, 50000.0);        // you cannot trade people, we are in XXI century...

    }

    private static void zad09() throws Exception {
        me = new Human("Jakub", "Gramburg", 5000.0);

        FarmAnimal peppa = new FarmAnimal(FarmAnimal.AnimalType.PIG);
        Pet burek = new Pet(Pet.AnimalType.DOG);

// allowed:
        me.feed(peppa);                 // good, you can eat pig
        burek.feed(peppa.getWeight());  // burek loves pork too
        burek.feed(peppa);              // another way of feeding

// not allowed:
//        me.feed(burek);                 // dogs are not tasty (didn't try, just guessing)
//        peppa.feed(burek);              // bad idea
//        peppa.feed(peppa);              // that is weird and forbidden
    }

    private static void zad10() throws Exception {

        App facebook = new App("Facebook");
        App twitter = new App("Twitter");
        twitter.addNewVersion(1, "www.twitter.com/1");

        //      var latestversion = facebook.getLatestVersion();            // should throw exception
        facebook.addNewVersion(1, "www.facebook.com/1");
        var latestversion = facebook.getLatestVersion();            // should return v1

        facebook.addNewVersion(2, "www.facebook.com/2");
        var latestversion2 = facebook.getLatestVersion();            // should return v2

        Phone myPhone = new Phone("Samsung", "Galaxy S22", 2022, 3000.0);
        myPhone.installApp(facebook);
//        myPhone.installApp(facebook, 3);    // failure
        myPhone.installApp(facebook, 1); // provide version number, even if is invalid.


    }


    private static void zad11() throws Exception {
// init objects
        me = new Human("Jakub", "Gramburg", 5000.0);
        me.setSalary(10000.0);
        Human someone = new Human("Jan", "Pawel", 1000000.0);
        someone.setSalary(5000.0);
        System.out.println(me.toString());
        car1 = new Diesel("Daewoo", "Matiz", 2000, 999.0);
        car2 = new Diesel("VW", "Golf", 1999, 5000.0);
        car3 = new Diesel("VW", "Passat", 2010, 5000.0);

// test ability to setCar with salary:
        me.setCar(car1);                        // random spot (first available, in this case 0)
        me.setCar(car2, 2);          // defined spot
        someone.setCar(car3);
//        me.setCar(car1, 5);                     // its illegal;

// trading car between users and putting them on first available spot
        car1.sell(me, someone, car1.getValue());

// trading car between users and putting them on first available spot, but buyer don't have empty spot
        Human andrzej = new Human("Mariusz", "Pudzianowski", 1000000.0, 0);
        car2.sell(me, someone, car2.getValue());
        System.out.println("Someone's garage is worth: " + someone.getGarageValue());
        someone.sortGarage();           // sorting by yearOfProd, than name
    }

}
