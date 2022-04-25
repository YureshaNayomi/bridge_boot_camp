package AdminTask;

public class Admin {
    //member variables
    private String taskID;
    //private String userID;
    private String taskDate;
    private String taskInformation;

    //constructors

    public Admin() {
        taskID = "T000";
        taskDate = "";
        taskInformation = "Nothing Happened";
    }

    public Admin(String taskID, String taskDate, String taskInformation) {
        this.taskID = taskID;
        this.taskDate = taskDate;
        this.taskInformation = taskInformation;
    }
    //setters

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public void setTaskInformation(String taskInformation) {
        this.taskInformation = taskInformation;
    }

    //getters


    public String getTaskID() {
        return taskID;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public String getTaskInformation() {
        return taskInformation;
    }
}

