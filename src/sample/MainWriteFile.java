package sample;

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
        Subject calculus_1 = new Subject("∑∫dx", "01417111", "Calculus 1", DifficultLevel.QUITE_HARD, 3, false);
        Subject introCS = new Subject("0101", "01418114", "Introduction to computer science", DifficultLevel.QUITE_EASY, 2, false);
        Subject knowledgeOfTheLand = new Subject("KU", "01999111", "Knowledge of the land", DifficultLevel.EASY, 2, false);
        allSubject.add(calculus_1);
        allSubject.add(introCS);
        allSubject.add(knowledgeOfTheLand);

        Gson gson = new Gson();
        String json = gson.toJson(allSubject);

        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("SubjectDataController.json")));
            writer.println(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
