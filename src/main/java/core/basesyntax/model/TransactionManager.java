package core.basesyntax.model;

import core.basesyntax.model.Transaction;

import java.util.List;

public interface TransactionManager {
    void process(List<Transaction> transactions);
}
