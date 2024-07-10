import students.Class;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadClassFromFile {
    public Class loadClassFromFile(String filePath) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Class class2 = (Class) objectInputStream.readObject();

        objectInputStream.close();
        return class2;
    }
}
