package students;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Subject implements Serializable {
    final private String name;
    private HashMap<String, ArrayList<Integer>> marks;
    public Subject(@JsonProperty("name") String name) {
        this.name = name;
        marks = new HashMap<>();
    }

    public void addMark(String studentName, int mark) {
        if (mark >= 0 && mark <= 10) {
            if (!marks.containsKey(studentName)) {
                marks.put(studentName, new ArrayList<>());
            }
            marks.get(studentName).add(mark);
        } else {
            System.err.println("Оценка вне допустимого диапазона");
        }
    }

    public String getName() {
        return name;
    }

    public HashMap<String, ArrayList<Integer>> getMarks() {
        return marks;
    }
}
