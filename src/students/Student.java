package students;

import java.io.Serializable;

public class Student implements Serializable {
    final private String name;
    private int classNumber;

    public Student (String name){
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
