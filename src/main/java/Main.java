import java.util.ArrayList;

public class Main {
    public static ArrayList<Task> tasks;
    public static FileHandler fileHandler;

    public static void main(String[] args){
        tasks = new ArrayList<>();

        InputHandler inputHandler = new InputHandler();
        fileHandler = new FileHandler();
        inputHandler.read();
    }
}
