package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.IOException;

public class DataWriterImpl implements DataWriter {
    @Override
    public void formReport(String report, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(path))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file");
        }
    }
}