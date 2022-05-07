package Models;

public class Animal {

    private Double weight;

    public enum AnimalType {
        CAT, DOG, SNAKE
    }

    public Animal(AnimalType type) {

        switch (type) {
            case CAT -> this.weight = 5.0;
            case DOG -> this.weight = 10.0;
            case SNAKE -> this.weight = 1.0;
        }
    }

    public Double getWeight() {
        return this.weight;
    }

    public void feed() throws Exception {
        if (!isAlive())
            throw new Exception("Models.Animal is dead, you can not feed dead animal :(");
        else
            this.weight += 1.0;
    }

    public void takeForAWalk() throws Exception {
        if (!isAlive())
            throw new Exception("Models.Animal is dead, you can not take for a walk dead animal :(");
        this.weight -= 2.0;
    }

    public boolean isAlive() {
        if (this.weight > 0.0) {
            return true;
        } else {
            return false;
        }
    }

}
