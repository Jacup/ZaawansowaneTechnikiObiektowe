package main.creatures;

import interfaces.Feedable;

public abstract class Animal implements Feedable {

    protected Double weight;

    public Animal(Pet.AnimalType type) {
        switch (type) {
            case CAT -> this.weight = 5.0;
            case DOG -> this.weight = 10.0;
            case SNAKE -> this.weight = 1.0;
        }
    }

    public Animal(FarmAnimal.AnimalType type) {
        switch (type) {
            case COW -> this.weight = 200.0;
            case PIG -> this.weight = 300.0;
        }
    }

    public Animal() {

    }

    public Double getWeight() {
        return this.weight;
    }

    public void feed() throws Exception {
        feed(1.0);
    }

    public void feed(FarmAnimal animalToBeEaten) throws Exception {
        if (!animalToBeEaten.equals(this))
            throw new Exception("Come on, what are you doing, this animal cannot eat self");

        feed(animalToBeEaten.getWeight());
    }

    public void feed(Double foodWeight) throws Exception {
        if (!isAlive()) throw new Exception("Animal is dead, you can not feed dead animal :(");
        else this.weight += foodWeight;
    }

    public boolean isAlive() {
        if (this.weight > 0.0) {
            return true;
        } else {
            return false;
        }
    }
}
