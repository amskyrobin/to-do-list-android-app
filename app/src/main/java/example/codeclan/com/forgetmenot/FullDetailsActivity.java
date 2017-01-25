package example.codeclan.com.forgetmenot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by user on 25/01/2017.
 */

public class FullDetailsActivity extends AppCompatActivity {

    TextView fullDetails;
    Task task;
    ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_details_activity);

        tasks = getTaskList();

        fullDetails = (TextView)findViewById(R.id.fullDetails);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int position = extras.getInt("Position");
        System.out.println("");
        String details = extras.getString("Tasks");


        Task task = tasks.get(position);

        Log.d("On create called", task.getTaskDesc());

//
//        String fullDetails = task.getTaskDesc();
//
        fullDetails.setText(details);

    }

    public ArrayList<Task> getTaskList(){ //Previously void return type



        Map<String, ?> allTasks = getSharedPreferences("tasks", Context.MODE_PRIVATE).getAll();
        ArrayList<Task> tasks;
        tasks = new ArrayList<Task>();
        for (Map.Entry<String, ?> entry : allTasks.entrySet()) {
            if (entry.getValue() instanceof String) {
//                textValue += (String)entry.getValue();
                tasks.add(Task.fromJson(entry.getValue().toString()));
            }
        }
//        taskList.setText(tasks.toString());
        return tasks;
    }
}
