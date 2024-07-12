import students.Class;
import students.Student;
import students.Subject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class LoadClassFromFile {
    public ArrayList<Class> loadClassFromFile(String filePath) {
        ArrayList<Class> classes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.equals(";")) {
                    continue;
                }

                Class cls = new Class(Integer.parseInt(line));

                int studentCount = Integer.parseInt(scanner.nextLine().trim());
                for (int j = 0; j < studentCount; j++) {

                    Student student = new Student(scanner.nextLine());
                    cls.addStudent(student);
                }

                int subjectCount = Integer.parseInt(scanner.nextLine());
                for (int j = 0; j < subjectCount; j++) {
                    String subjectName = scanner.nextLine();
                    Subject subject = new Subject(subjectName);
                    int marksCount = Integer.parseInt(scanner.nextLine());
                    for (int k = 0; k < marksCount; k++) {
                        String studentName = scanner.nextLine().trim();
                        ArrayList<Integer> marks = new ArrayList<>();
                        String[] marksStr = scanner.nextLine().split(" ");
                        for (String mark: marksStr) {
                            marks.add(Integer.parseInt(mark));
                        }
                        subject.getMarks().put(studentName, marks);
                    }
                    cls.addSubject(subject);
                }

                classes.add(cls);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return classes;
    }
}
