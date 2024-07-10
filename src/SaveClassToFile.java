import students.Class;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveClassToFile {
    public void saveClassToFile(Class class1, String filePath) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(class1);

        objectOutputStream.close();
    }
}
