package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;
    private Integer amount;

    public Fruit(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name) &&
                Objects.equals(amount, fruit.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }
}
