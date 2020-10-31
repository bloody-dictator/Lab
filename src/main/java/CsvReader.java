import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
    public static ArrayList<String> reader(String filePath) {
        ArrayList<String> fromCsvList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fromCsvList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fromCsvList;
    }
}