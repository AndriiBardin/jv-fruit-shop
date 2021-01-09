package core.basesyntax.model;

import java.util.Objects;

public class Transactions {
    private Operations type;
    private Fruit fruit;
    private Integer quantity;

    public Transactions (Operations type,Fruit fruit,Integer quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.type = type;
    }

    public Operations getType() {
        return type;
    }

    public void setType(Operations type) {
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

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return type == that.type
                && Objects.equals(fruit, that.fruit)
                && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, quantity);
    }
}
