package core.basesyntax.model;

public enum OperationTypes {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private final String type;

    OperationTypes(String type) {
        this.type = type;
    }

    public static OperationTypes operationGet(String operation) {
        for (OperationTypes transaction : OperationTypes.values()) {
            if (transaction.type.equals(operation)) {
                return transaction;
            }
        }
        throw new IllegalArgumentException("Operand is not supported");
    }

    public String get() {
        return type;
    }
}
