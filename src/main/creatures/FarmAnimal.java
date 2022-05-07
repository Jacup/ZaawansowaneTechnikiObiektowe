package main.creatures;

import interfaces.Edible;

public class FarmAnimal extends Animal implements Edible {



    public enum AnimalType {
        PIG, COW,
    }

    public FarmAnimal(AnimalType type) {
        super(type);
    }

    @Override
    public void beEaten(Human eatenBy) {

    }
}
