import java.io.Serializable;

public class Task implements Serializable {
    public static int staticId;
    public int id;

    private String description;
    private String status;

    public Task(String description) {
        id = staticId++;
        this.description = description;
        this.status = "todo";
    }

    public Task(String description, String status) {
        id = staticId++;
        this.description = description;
        this.status = status;
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
