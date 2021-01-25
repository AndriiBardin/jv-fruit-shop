package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionResult;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    Storage storage;

    public StorageDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void push(TransactionResult transactionResult) {
        Integer oldValue = storage.getState().get(transactionResult.getFruit());
        if (oldValue == null) {
            oldValue = 0;
        }
        storage.getState().put(transactionResult.getFruit(), oldValue
                + transactionResult.getValue());
    }

    @Override
    public Map<Fruit, Integer> pull() {
        return storage.getState();
    }
}
