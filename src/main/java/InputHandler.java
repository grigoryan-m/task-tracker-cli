import java.io.*;
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
        catch(WrongArgumentListException e){
            System.out.println(e.getMessage());
            read();
        }
    }

    private void handleCommand(String command) throws WrongArgumentListException{
        String[] split;
        if(command.startsWith("add")){
            split = command.split(" ", 2);
            if(split.length != 2){
                throw new WrongArgumentListException("Wrong argument list!");
            }
            Task task = new Task(split[1]);
            Main.tasks.add(task);
            Main.fileHandler.saveTasks();
        }
        else if(command.startsWith("update")){
            split = command.split(" ", 3);
            if(split.length != 3){
                throw new WrongArgumentListException("Wrong argument list!");
            }
            for(int i = 0; i < Main.tasks.size(); i++){
                if(Main.tasks.get(i).id == Integer.parseInt(split[1])){
                    Main.tasks.get(i).setDescription(split[2]);
                }
            }
        }
        else if(command.startsWith("delete")) {
            split = command.split(" ", 2);
            if(split.length != 2){
                throw new WrongArgumentListException("Wrong argument list!");
            }
            for(int i = 0; i < Main.tasks.size(); i++){
                if(Main.tasks.get(i).id == Integer.parseInt(split[1])){
                    Main.tasks.remove(Main.tasks.get(i));
                }
            }
        }
        else if(command.startsWith("mark-in-progress")){
            split = command.split(" ", 2);
            if(split.length != 2){
                throw new WrongArgumentListException("Wrong argument list!");
            }
            for(int i = 0; i < Main.tasks.size(); i++){
                if(Main.tasks.get(i).id == Integer.parseInt(split[1])){
                    Main.tasks.get(i).setStatus("in-progress");
                }
            }
            Main.fileHandler.saveTasks();
        }
        else if(command.startsWith("mark-done")){
            split = command.split(" ", 2);
            if(split.length != 2){
                throw new WrongArgumentListException("Wrong argument list!");
            }
            for(int i = 0; i < Main.tasks.size(); i++){
                if(Main.tasks.get(i).id == Integer.parseInt(split[1])){
                    Main.tasks.get(i).setStatus("done");
                }
            }
            Main.fileHandler.saveTasks();
        }
        else if(command.startsWith("list")){
            split = command.split(" ");
            if(split.length == 1){
                for(int i = 0; i < Main.tasks.size(); i++){
                    System.out.println(Main.tasks.get(i));
                }
            }
            else if(split.length == 2){
                if(split[1].equals("todo") || split[1].equals("in-progress") || split[1].equals("done")){
                    listTasksWithStatus(split[1]);
                }
                else {
                    System.out.println("Invalid argument!");
                }
            }
        }
        else{
            System.out.println("invalid command!");
        }
        read();
    }

    private void listTasksWithStatus(String status){
        for(int i = 0; i < Main.tasks.size(); i++){
            if(Main.tasks.get(i).getStatus().equals(status)){
                System.out.println(Main.tasks.get(i));
            }
        }
    }
}
