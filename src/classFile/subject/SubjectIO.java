package classFile.subject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class SubjectIO {
    private ArrayList<Subject> allSubject;

    public SubjectIO() {
        this.allSubject = new ArrayList<>();
        initSubject();
        writeSubject();
    }

    private void initSubject() {
        Subject calculus_1 = new Subject("∑∫dx", "01417111", "Calculus 1", DifficultLevel.QUITE_HARD, 3, "ยา");
        Subject introCS = new Subject("0101", "01418114", "Introduction to computer science", DifficultLevel.QUITE_EASY, 2, "ยา");
        Subject knowledgeOfTheLand = new Subject("KU", "01999111", "Knowledge of the land", DifficultLevel.EASY, 2, "ยา");
        Subject funCom = new Subject(".py", "01418113", "Fundamental Programing", DifficultLevel.MEDIUM, 3, "ยา");
        Subject digital = new Subject("IC_", "01418131", "Digital computer logic", DifficultLevel.MEDIUM, 3, "ยา");
        Subject eng2 = new Subject("Eng", "01355112", "English xxxxxx", DifficultLevel.ANY, 3, "ยา");
        allSubject.add(calculus_1);
        allSubject.add(introCS);
        allSubject.add(knowledgeOfTheLand);
        allSubject.add(funCom);
        allSubject.add(digital);
        allSubject.add(eng2);
    }

    public void writeSubject() {

        try {
            File subjectData = new File("SubjectData.json");

            if (!subjectData.exists()) {
                Gson gson = new Gson();
                String json = gson.toJson(allSubject);
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(subjectData)));
                writer.println(json);
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Subject> readSubject(String filename) {
        ArrayList<Subject> subjects = null;
        try {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            subjects = gson.fromJson(reader, new TypeToken<ArrayList<Subject>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return subjects;
    }
}
