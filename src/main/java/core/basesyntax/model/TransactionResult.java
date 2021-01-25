package core.basesyntax.model;

public class TransactionResult {

    Fruit fruit;
    Integer value;

    public TransactionResult(Fruit fruit, Integer value) {
        this.fruit = fruit;
        this.value = value;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Integer getValue() {
        return value;
    }
}
