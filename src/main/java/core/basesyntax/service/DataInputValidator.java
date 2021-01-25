package core.basesyntax.service;

import java.util.List;

public interface DataInputValidator {

   boolean isValid(List<String> line);

    //todo: implement me
    //todo: add validators for input values
    // * values[0] -- check operation is in OperationTypes
    // * values[1] -- check is string
    // * values[2] -- check integer, and is positive
    // return true if all pass

//
// throw new DataInputValidatorException(String.format("Input data is not valid, reason %s", reason);

}


