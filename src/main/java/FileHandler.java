import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    public FileHandler(){
        try {
            File file = new File("tasks.dat");
            out = new ObjectOutputStream(new FileOutputStream(file));
            in = new ObjectInputStream(new FileInputStream(file));
            if(loadTasks()){
                System.out.println("Tasks loaded!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveTasks(){
        try {
            out.writeObject(Main.tasks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean loadTasks(){
        try {
            Main.tasks = (ArrayList<Task>) in.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File doesn't exist!");
            return false;
        }
    }
}
