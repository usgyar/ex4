import students.Class;
import students.Student;
import students.Subject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class LoadClassFromFile {
    public ArrayList<Class> loadClassFromFile(String filePath) throws IOException{
        File file = new File(filePath);
        if (!file.exists())
            throw new FileNotFoundException("Файл не найден");

        ArrayList<Class> classes = new ArrayList<>();

        IsValidInt cheak = new IsValidInt();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.equals(";")) {
                    continue;
                }

                Class cls = new Class(Integer.parseInt(line));

                int studentCount;
                String studentCountStr = scanner.nextLine();
                if (!cheak.isValidInt(studentCountStr))
                    throw new IOException("Неверный формат");
                studentCount = Integer.parseInt(studentCountStr);

                for (int j = 0; j < studentCount; j++) {
                    Student student = new Student(scanner.nextLine());
                    cls.addStudent(student);
                }

                int subjectCount;
                try{
                    subjectCount = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e){
                    throw new IOException("Неверный формат");
                }
                for (int j = 0; j < subjectCount; j++) {
                    String subjectName = scanner.nextLine();
                    Subject subject = new Subject(subjectName);
                    int marksCount;
                    String marksCountStr = scanner.nextLine();
                    if (!cheak.isValidInt(marksCountStr))
                        throw new IOException("Неверный формат");
                    marksCount = Integer.parseInt(marksCountStr);

                    for (int k = 0; k < marksCount; k++) {
                        String studentName = scanner.nextLine().trim();
                        ArrayList<Integer> marks = new ArrayList<>();
                        String[] marksStr = scanner.nextLine().split(" ");
                        for (String mark: marksStr) {
                            int m;
                            if (!cheak.isValidInt(mark))
                                throw new IOException("Неверный формат");
                            m = Integer.parseInt(mark);
                            if (m < 0 || m > 10)
                                throw new IOException("Неверный формат");
                            marks.add(Integer.parseInt(mark));
                        }
                        subject.getMarks().put(studentName, marks);
                    }
                    cls.addSubject(subject);
                }

                classes.add(cls);
            }
        }
        return classes;
    }
}
