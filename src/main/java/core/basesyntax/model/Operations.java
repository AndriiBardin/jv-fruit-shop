package core.basesyntax.model;

import jdk.dynalink.Operation;

public enum Operations {
    BALANCE ("b"),
    SUPPLY ("s"),
    RETURN ("r"),
    PURCHASE ("p");

    private final String type;

    Operations(String type){
        this.type = type;
    }

    public static Operations operationGet(String operation) {
        for (Operations transaction : Operations.values()) {
            if (transaction.type.equalsIgnoreCase(operation)) {
                return transaction;
            }
        }
        throw new IllegalArgumentException("Operand is not supported");
    }

    private String getOperation() {
        return type;
    }
}
