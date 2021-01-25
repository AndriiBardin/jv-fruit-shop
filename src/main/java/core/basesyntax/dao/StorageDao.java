package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionResult;
import java.util.Map;

public interface StorageDao {

    void push(TransactionResult transactionResult);

    Map<Fruit, Integer> pull();
}
