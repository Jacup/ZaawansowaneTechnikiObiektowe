package Interfaces;
import Models.Human;

public interface Saleable { public String hello = "hi";

    public default void sell(Human seller, Human buyer, Double price) {

    }
}
