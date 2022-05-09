package main.devices;

import main.creatures.Human;

import java.time.LocalDateTime;

public record Transaction(Human seller, Human buyer, Double value,
                          LocalDateTime transactionDate) {

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public Double getValue() {
        return value;
    }

    public Human getBuyer() {
        return buyer;
    }

    public Human getSeller() {
        return seller;
    }
}
