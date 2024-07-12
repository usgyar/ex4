import students.Class;
import students.Student;
import students.Subject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class SaveClassToFile {
    public void saveClassToFile(Class cls, String filePath, boolean append) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(cls.getClassNumber() + "\n");

            writer.write(cls.getStudents().size() + "\n");
            for (Student student : cls.getStudents()) {
                writer.write(student.getName() + "\n");
            }

            writer.write(cls.getSubjects().size() + "\n");
            for (Subject subject : cls.getSubjects()) {
                writer.write(subject.getName() + "\n");
                writer.write(subject.getMarks().size() + "\n");
                for (String studentName : subject.getMarks().keySet()) {
                    writer.write(studentName + "\n");
                    ArrayList<Integer> marks = subject.getMarks().get(studentName);
                    writer.write(marks.size() + "\n");
                    for (int mark : marks) {
                        writer.write(mark + " ");
                    }
                    writer.write("\n");
                }
            }
            writer.write(";\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}