package core.basesyntax.model;

import java.util.List;

public interface TransactionManager {
    void process(List<Transaction> transactions);
}
