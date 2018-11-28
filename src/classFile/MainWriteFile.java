package classFile;

import classFile.subject.DifficultLevel;
import classFile.subject.Subject;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainWriteFile {
    public static void main(String[] args) {
        List<Subject> allSubject = new ArrayList<>();
        Subject calculus_1 = new Subject("∑∫dx", "01417111", "Calculus 1", DifficultLevel.QUITE_HARD, 3, false, "ยา");
        Subject introCS = new Subject("0101", "01418114", "Introduction to computer science", DifficultLevel.QUITE_EASY, 2, false, "ยา");
        Subject knowledgeOfTheLand = new Subject("KU", "01999111", "Knowledge of the land", DifficultLevel.EASY, 2, false, "ยา");
        Subject funCom = new Subject(".py", "01418113", "Fundamental Programing", DifficultLevel.MEDIUM, 3, false, "ยา");
        Subject digital = new Subject("IC_", "01418131", "Digital computer logic", DifficultLevel.MEDIUM, 3, false, "ยา");
        Subject eng2 = new Subject("Eng", "01355112", "English xxxxxx", DifficultLevel.ANY, 3, false, "ยา");
        allSubject.add(calculus_1);
        allSubject.add(introCS);
        allSubject.add(knowledgeOfTheLand);
        allSubject.add(funCom);
        allSubject.add(digital);
        allSubject.add(eng2);

        Gson gson = new Gson();
        String json = gson.toJson(allSubject);

        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("SubjectData.json")));
            writer.println(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
