import java.io.*;

public class FileHandler {
    private static int id;
    private final ObjectOutput out;
    private final BufferedReader bufferedReader;
    static {
        id = 0;
    }
    public FileHandler(){
        try {
            fileWriter = new FileWriter(new File("data.json"), false);
            bufferedReader = new BufferedReader(new FileReader("data.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean writeFile(String description, String status){

    }

    public boolean updateJSON(int id, String newDescription){

        return true;
    }

    public static void main(String[] args){

    }
}
