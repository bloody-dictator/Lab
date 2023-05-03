import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOut {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static void fileWrite(String filepath, String str){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filepath));
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
