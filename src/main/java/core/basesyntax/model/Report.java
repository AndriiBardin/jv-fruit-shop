package core.basesyntax.model;

import java.util.List;

public class Report {
    List<String> lines;

    public Report(List<String> lines) {
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }
}
