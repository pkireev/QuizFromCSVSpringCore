import dev.erp.quizcsv.controller.ConsoleInput;
import dev.erp.quizcsv.dao.DAOCSVReader;
import dev.erp.quizcsv.model.QuizContainer;
import dev.erp.quizcsv.view.PrintToScreen;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        DAOCSVReader file = context.getBean(DAOCSVReader.class);
        QuizContainer quiz = context.getBean(QuizContainer.class);
        ConsoleInput con = context.getBean(ConsoleInput.class);
        PrintToScreen out = context.getBean(PrintToScreen.class);

        file.readFile();
        out.print("Please enter your name:");
        String username = con.getString();

        out.print("Hello, " + username);

        int qnt = quiz.getQntOfQuestions();
        out.print(String.format("You have to pass: %d questions\n", qnt));

        List<String> question;
        int correct = 0;

        for (int i = 0; i < qnt; i++) {
            question = quiz.getQuiz(i);

            out.print(String.format("Question %d:\n", i + 1));
            out.print(question.get(0));
            out.print("Options:");

            for (int j = 1; j <= 5; j++) {
                out.print(j + " - " + question.get(j));
            }

            int ans = con.getInt();
            if (ans == Integer.parseInt(question.get(6))) {
                correct++;
            }

        }

        out.print("You have " + correct + " correct answers!");

    }
}
