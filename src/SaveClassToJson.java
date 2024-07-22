import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import students.Class;

public class SaveClassToJson {
    public void saveClassToJson(Class cls, String filePath) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filePath), cls);
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
