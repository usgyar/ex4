import students.Class;
import students.Student;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Class class1 = new Class(2);
        Student student1 = new Student("bob");
        Student student2 = new Student("tom");
        class1.addStudent(student1);
        class1.removeStudent(student2);
        System.out.println(student1.getClassNumber());

        SaveClassToFile saveClassToFile = new SaveClassToFile();
        saveClassToFile.saveClassToFile(class1, "file.txt");

        LoadClassFromFile loadClassFromFile = new LoadClassFromFile();
        Class class2 = loadClassFromFile.loadClassFromFile("file.txt");
        System.out.println(class2.getClassNumber());
    }
}