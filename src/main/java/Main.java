import java.util.ArrayList;

public class Main {
    public static ArrayList<Task> tasks;

    public static void main(String[] args){
        tasks = new ArrayList<>();

        InputHandler inputHandler = new InputHandler();
        inputHandler.read();
    }
}
