package core.basesyntax.orm;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationTypes;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public interface TransactionOrm {

    static List<Transaction> mapFromLines(List<String> lines) {
        return lines.stream().map(TransactionOrm::mapFromLine).collect(Collectors.toList());
    }

    private static Transaction mapFromLine(String line) {
        String[] input = line.split(",");

        Transaction transaction = new Transaction(
                OperationTypes.operationGet(input[0]),
                new Fruit(input[1]),
                Integer.parseInt(input[2]));
        return transaction;
    }
}
