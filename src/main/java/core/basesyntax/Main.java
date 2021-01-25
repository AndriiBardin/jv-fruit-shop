package core.basesyntax;

import core.basesyntax.dao.StorageDAO;
import core.basesyntax.dao.StorageDAOImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Report;
import core.basesyntax.model.Transaction;
import core.basesyntax.model.TransactionManager;
import core.basesyntax.orm.TransactionORM;
import core.basesyntax.service.*;
import core.basesyntax.service.reports.PlainReportGenerator;
import core.basesyntax.service.reports.ReportGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataReader reader = new DataReaderImpl();
        List<String> lines = reader.linesFromFile("src/main/java/core/basesyntax/test.csv");

        DataInputValidator validator = new InputValidatorImpl();
        validator.isValid(lines);

        List<Transaction> transactions = TransactionORM.mapFromLines(lines);

        Storage storage = new Storage();

        StorageDAO dao = new StorageDAOImpl(storage);

        TransactionManager manager = new ShopSupervisor(dao);
        manager.process(transactions);

        ReportGenerator reportGenerator = new PlainReportGenerator(dao);
        Report report = reportGenerator.generate();

        report.getLines().forEach(System.out::println);

        DataWriter dataWriter = new DataWriterImpl();
        dataWriter.write(report.getLines(), "testout.csv");
    }
}
