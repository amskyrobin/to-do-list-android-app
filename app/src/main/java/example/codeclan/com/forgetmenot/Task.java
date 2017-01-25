package example.codeclan.com.forgetmenot;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 22/01/2017.
 */

public class Task {

    public static final String SP_KEY_TASK_PREFIX =  "task_id_";

    @SerializedName("taskDesc")
    private String taskDesc;

    @SerializedName("id")
    private int id;

    @SerializedName("taskDetails")
    private String taskDetails;

    public Task(String taskDesc, int id, String taskDetails){
        this.taskDesc = taskDesc;
        this.id = id;
        this.taskDetails = taskDetails;
    }

    public String getTaskDesc(){
        return this.taskDesc;
    }

    public String getTaskDetails(){
        return this.taskDetails;
    }

    public int getId(){
        return this.id;
    }

    public String getSpKey(){
        return SP_KEY_TASK_PREFIX + id;
    }

    public static Task fromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Task.class);
    }

}
