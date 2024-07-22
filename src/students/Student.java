package students;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Student {
    final private String name;
    private int classNumber;

    public Student (@JsonProperty("name") String name){
        this.name = name;
    }
    protected void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
    public String getName (){
        return name;
    }
    public int getClassNumber (){
        return classNumber;
    }
}
