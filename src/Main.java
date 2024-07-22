import students.Class;
import students.Student;
import students.Subject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Class class1 = new Class(2);
        Student student1 = new Student("bob");
        Student student2 = new Student("tom");
        class1.addStudent(student1);
        class1.addStudent(student2);
        Subject sub1 = new Subject("math");
        Subject sub2 = new Subject("english");
        class1.addSubject(sub1);
        class1.addSubject(sub2);
        sub1.addMark(student1.getName(), 5);
        sub2.addMark(student1.getName(), 8);
        sub1.addMark(student1.getName(), 6);
        sub2.addMark(student2.getName(), 5);
        sub1.addMark(student2.getName(), 8);
        sub2.addMark(student2.getName(), 6);

        Class class2 = new Class(1);
        Student student3 = new Student("obo");
        Student student4 = new Student("mot");
        class2.addStudent(student3);
        class2.addStudent(student4);
        Subject sub3 = new Subject("mh");
        Subject sub4 = new Subject("eng");
        class2.addSubject(sub3);
        class2.addSubject(sub4);
        sub3.addMark(student3.getName(), 5);
        sub4.addMark(student3.getName(), 8);
        sub3.addMark(student3.getName(), 6);
        sub4.addMark(student4.getName(), 5);
        sub3.addMark(student4.getName(), 8);
        sub4.addMark(student4.getName(), 6);

        SaveClassToJson saveClassToJson = new SaveClassToJson();
        saveClassToJson.saveClassToJson(class1, "file.json");

        LoadClassFromJson loadClassFromJson = new LoadClassFromJson();
        class2 = loadClassFromJson.loadClassFromJson("file.json");
        System.out.println(class2.getClassNumber());
        for (Student student : class2.getStudents())
            System.out.println(student.getName());
        for (Subject subject : class2.getSubjects()) {
            System.out.println(subject.getName() + subject.getMarks());
        }
    }
}