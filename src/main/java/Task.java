import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable {
    public static int staticId;
    public int id;

    private String description;
    private String status;

    public Task(String description) throws InvalidStatusException{
        id = staticId++;
        this.description = description;
        setStatus("todo");
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
