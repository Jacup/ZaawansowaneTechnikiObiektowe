package main.creatures;

public class Pet extends Animal {
    @Override
    public void feed(Double foodWeight) {

    }

    public enum AnimalType {
        CAT, DOG, SNAKE,
    }

    public Pet(Pet.AnimalType type) {
        super(type);
    }

    public void takeForAWalk() throws Exception {
        if (!isAlive()) throw new Exception("This animal is dead, you can not take for a walk dead animal :(");
        this.weight -= 2.0;
    }
}
