package core.basesyntax.service;

import core.basesyntax.model.OperationTypes;

import java.util.List;

public class InputValidatorImpl implements DataInputValidator {
    private static final String ROW_FORMAT = "[a-zA-Z],[a-zA-Z],[\\d]";

    @Override
    public boolean isValid(List<String> line) {
        for (String l : line) {
            if (! l.matches(ROW_FORMAT)
                    && l.substring(0, 1).equals(OperationTypes.operationGet(l.substring(0, 1)))
                    && l.split(",")[1].matches("[a-zA-Z]")
                    && l.split(",")[2].matches("[\\d]")) {
                throw new RuntimeException("Input data is not valid");
            }
        }
        return true;
    }
}



