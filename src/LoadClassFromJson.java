import com.fasterxml.jackson.databind.ObjectMapper;
import students.Class;

import java.io.File;
import java.io.IOException;

public class LoadClassFromJson {
    public Class loadClassFromJson (String filePath){
        ObjectMapper mapper = new ObjectMapper();
        Class cls = null;
        try {
            cls = mapper.readValue(new File(filePath), Class.class);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return cls;
    }
}
