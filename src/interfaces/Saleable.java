package interfaces;
import main.creatures.Human;

public interface Saleable { public String hello = "hi";

    public default void sell(Human seller, Human buyer, Double price) {

    }
}
