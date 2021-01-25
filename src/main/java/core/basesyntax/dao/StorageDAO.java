package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionResult;

import java.util.Map;

public interface StorageDAO {
    void push(TransactionResult transactionResult);
    Map<Fruit, Integer> pull();
}
