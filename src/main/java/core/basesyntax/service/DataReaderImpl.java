package core.basesyntax.service;

import core.basesyntax.db.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataReaderImpl implements DataReader {
    @Override
    public List<String> linesFromFile(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(Files.newBufferedReader(Path.of(path)))) {
            bufferedReader.readLine(); // skip first line
            String line = bufferedReader.readLine();
            while (line != null) {
                list.add(line);
                line = bufferedReader.readLine();
            }
            if (list.isEmpty()) {
                throw new RuntimeException("File is empty!");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't locate file at " + path);
        }
        return list;
    }
}