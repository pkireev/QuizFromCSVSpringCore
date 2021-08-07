package dev.erp.quizcsv.dao;

import dev.erp.quizcsv.model.QuizContainer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class DAOCSVReader {
    private final String filename;
    private final QuizContainer container;


    public DAOCSVReader(QuizContainer container, String filename) {
        this.container = container;
        this.filename = filename;
    }

    public void readFile() throws IOException{
        if (filename == null) {
            return;
        }

        final String COMMA_DELIMITER = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                container.add(Arrays.asList(values));
                container.plusOne();
            }
        }

    }
}
