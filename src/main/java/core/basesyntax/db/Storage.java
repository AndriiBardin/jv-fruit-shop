package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    Map<Fruit, Integer> state = new HashMap<>();

    public Map<Fruit, Integer> getState() {
        return state;
    }
}

