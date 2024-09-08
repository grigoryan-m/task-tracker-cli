import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    File file = new File("tasks.dat");
    public FileHandler(){
        if(loadTasks()){
            System.out.println("Tasks loaded");
        }
    }

    public void saveTasks(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(Main.tasks);
            out.writeInt(Task.staticId);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean loadTasks(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            if(file.exists()) {
                Main.tasks = (ArrayList<Task>) in.readObject();
                Task.staticId = in.readInt();
                in.close();
                return true;
            }
            System.out.println("File doesn't exist");
            in.close();
            return false;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File loading error");
        }
        return false;
    }
}
