import java.io.*;
import java.util.HashMap;

public class InputHandler {
    BufferedReader in;

    public InputHandler(){
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void read(){
        try{
            System.out.print("> ");
            String line = in.readLine();
            handleCommand(line);
        }catch(IOException e){
            // Handle
        }
    }

    private void handleCommand(String command){
        String[] split;
        if(command.startsWith("add")){
            split = command.split(" ", 2);

        }
        else if(command.startsWith("update")){
            split = command.split(" ", 3);

        }
        else if(command.startsWith("delete")) {

        }
        else if(command.startsWith("mark-in-progress")){

        }
        else if(command.startsWith("mark-done")){
            split = command.split(" ", 2);

        }
        else if(command.startsWith("list")){
            split = command.split(" ");

        }
        else{
            System.out.println("invalid command!");
        }
        read();
    }
}
