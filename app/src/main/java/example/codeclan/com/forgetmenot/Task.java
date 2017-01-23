package example.codeclan.com.forgetmenot;

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

    public Task(String taskDesc, int id){
        this.taskDesc = taskDesc;
        this.id = id;
    }

    public String getTaskDesc(){
        return this.taskDesc;
    }

    public int getId(){
        return this.id;
    }

    public String getSpKey(){
        return SP_KEY_TASK_PREFIX + id;
    }

}
