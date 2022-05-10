package main.creatures;

public class Pet extends Animal {

    private final AnimalType type;

    @Override
    public void feed(Double foodWeight) {

    }

    public enum AnimalType {
        CAT, DOG, SNAKE,
    }

    public Pet(Pet.AnimalType type) {
        super(type);
        this.type = type;
    }

    public void takeForAWalk() throws Exception {
        if (!isAlive()) throw new Exception("This animal is dead, you can not take for a walk dead animal :(");
        this.weight -= 2.0;
    }

    public boolean isPies() {
        return this.type.equals(AnimalType.DOG);
    }
}
