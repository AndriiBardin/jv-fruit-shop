package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Report;
import core.basesyntax.model.Transaction;
import core.basesyntax.model.TransactionManager;
import core.basesyntax.orm.TransactionOrm;
import core.basesyntax.service.DataInputValidator;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataReaderImpl;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.DataWriterImpl;
import core.basesyntax.service.InputValidatorImpl;
import core.basesyntax.service.ShopSupervisor;
import core.basesyntax.service.reports.PlainReportGenerator;
import core.basesyntax.service.reports.ReportGenerator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataReader reader = new DataReaderImpl();
        List<String> lines = reader.linesFromFile("src/main/java/core/basesyntax/test.csv");

        DataInputValidator validator = new InputValidatorImpl();
        validator.isValid(lines);

        List<Transaction> transactions = TransactionOrm.mapFromLines(lines);

        Storage storage = new Storage();

        StorageDao dao = new StorageDaoImpl(storage);

        TransactionManager manager = new ShopSupervisor(dao);
        manager.process(transactions);

        ReportGenerator reportGenerator = new PlainReportGenerator(dao);
        Report report = reportGenerator.generate();

        report.getLines().forEach(System.out::println);

        DataWriter dataWriter = new DataWriterImpl();
        dataWriter.write(report.getLines(), "testout.csv");
    }
}
