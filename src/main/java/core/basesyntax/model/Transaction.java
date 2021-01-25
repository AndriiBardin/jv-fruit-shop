package core.basesyntax.model;

import java.util.Objects;

public class Transaction {
    private OperationTypes type;
    private Fruit fruit;
    private Integer quantity;

    public Transaction(OperationTypes type, Fruit fruit, Integer quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.type = type;
    }

    public OperationTypes getType() {
        return type;
    }

    public void setType(OperationTypes type) {
        this.type = type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return type == that.type
                && Objects.equals(fruit, that.fruit)
                && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, quantity);
    }

   /* @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", fruit=" + fruit +
                ", quantity=" + quantity +
                '}';
    }*/
}
