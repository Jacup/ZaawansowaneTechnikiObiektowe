public class Main {

    public static void main(String[] args) throws Exception {

        Animal dog1 = new Animal(Animal.AnimalType.DOG);
        System.out.println("Weight of dog1:" + dog1.getWeight());

        dog1.feed();
        dog1.feed();
        System.out.println("Weight of dog1 after feeding:" + dog1.getWeight());

        var totalWalks = 6;
        for (int i = 0; i < totalWalks; i++) {
            dog1.takeForAWalk();
        }

        System.out.println("Weight of dog1:" + dog1.getWeight());

        dog1.takeForAWalk();

    }
}
