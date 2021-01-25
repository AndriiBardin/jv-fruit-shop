package core.basesyntax.service;

import core.basesyntax.dao.StorageDAO;
import core.basesyntax.model.Transaction;
import core.basesyntax.model.TransactionManager;
import core.basesyntax.model.TransactionResult;

import java.util.List;

public class ShopSupervisor implements TransactionManager {

    StorageDAO dao;

    public ShopSupervisor(StorageDAO dao) {
        this.dao = dao;
    }

    @Override
    public void process(List<Transaction> transactions) {
        transactions.stream()
                .map(TransactionCalculator::calculate)
                .forEach(this.dao::push);
    }

    public static class TransactionCalculator {

        static TransactionResult calculate(Transaction transaction) {
            switch (transaction.getType().get()) {
                case "b":
                case "s":
                case "r":
                    return new TransactionResult(transaction.getFruit(), transaction.getQuantity());
                case "p":
                    return new TransactionResult(transaction.getFruit(), -transaction.getQuantity());
            }
            throw new RuntimeException("Unsupported operation");
        }
    }
}
