import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable {
    private static int staticId;
    public int id;

    private String description;
    private String status;

    transient FileHandler fileHandler;

    public Task(String description) throws InvalidStatusException{
        fileHandler = new FileHandler();
        id = staticId++;
        this.description = description;
        setStatus("todo");
        Main.tasks.add(this);
        fileHandler.saveTasks();
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return id + " " + status + " " + description;
    }
}
