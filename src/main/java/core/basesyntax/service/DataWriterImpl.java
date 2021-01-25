package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class DataWriterImpl implements DataWriter {
    @Override
    public void write(List<String> report, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(path))) {
            for (String row: report) {
                bufferedWriter.write(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("File was not found");
        }
    }
}
