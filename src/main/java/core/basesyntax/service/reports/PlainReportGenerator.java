package core.basesyntax.service.reports;

import core.basesyntax.dao.StorageDAO;
import core.basesyntax.model.Report;

import java.util.stream.Collectors;

public class PlainReportGenerator implements ReportGenerator {

    StorageDAO dao;

    public PlainReportGenerator(StorageDAO dao) {
        this.dao = dao;
    }

    @Override
    public Report generate() {
        return new Report(dao.pull().entrySet().stream()
                .map(entry -> String.format("%s,%d", entry.getKey().getName(), entry.getValue()))
                .collect(Collectors.toList()));
    }
}
