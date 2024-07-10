package students;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Subject implements Serializable{
    final private String name;
    private HashMap<String, Integer> marks;

    public Subject (String name){
        this.name = name;
        marks = new HashMap<>();
    }
    public String getName (){
        return name;
    }
    public void addMark(String name, int mark){
        if (mark >= 0 && mark <= 10)
            marks.put(name, mark);
        else
            System.err.println("Оценка вне допустимого диапазона");
    }
}
