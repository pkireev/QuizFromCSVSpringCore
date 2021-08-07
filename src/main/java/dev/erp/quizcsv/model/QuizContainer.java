package dev.erp.quizcsv.model;

import java.util.ArrayList;
import java.util.List;

public class QuizContainer {
    private List<List<String>> container = new ArrayList<>();
    private int qntOfQuestions;

    public List<String> getQuiz(int order) {
        return container.get(order);
    }


    public void add(List<String> record) {
        container.add(record);
    }

    public void plusOne() {
        qntOfQuestions++;
    }

    public int getQntOfQuestions() {
        return qntOfQuestions;
    }
}
