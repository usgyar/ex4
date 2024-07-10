package students;

import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable{
    private int classNumber;

    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;

    public Class(int numberClass){
        this.classNumber = numberClass;

        students = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    public void addStudent (Student student){
        if (students.indexOf(student) == -1) {
            students.add(student);
            student.setClassNumber(classNumber);
        } else {
            System.err.println("Этот студент уже есть в группе");
        }
    }
    public void removeStudent (Student student){
        int idx = students.indexOf(student);
        if (idx != -1)
            students.remove(idx);
        else
            System.err.println("Этого студента нет в группе");
    }
    public void addSubject (Subject subject){
        if (subjects.indexOf(subject) == -1)
            subjects.add(subject);
        else
            System.err.println("Этот предмет уже есть в группе");
    }
    public void removeSubject (Subject subject){
        int idx = subjects.indexOf(subject);
        if (idx != -1)
            subjects.remove(idx);
        else
            System.err.println("Этого предмета нет в группе");
    }
    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    public int getClassNumber (){
        return classNumber;
    }
}
