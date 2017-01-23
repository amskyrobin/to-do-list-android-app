package example.codeclan.com.forgetmenot;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.Map;

public class jsonMain extends AppCompatActivity {


    EditText enterNewTask;
    Button addNewTask;
    TextView showTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterNewTask = (EditText) findViewById(R.id.enterNewTask);
        addNewTask = (Button) findViewById(R.id.addNewTask);
        showTasks = (TextView) findViewById(R.id.showTasks);
    }


    public void saveTask (View view){
        SharedPreferences taskSharedPref = getSharedPreferences("tasks", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = taskSharedPref.edit();
        editor.putString("task", enterNewTask.getText().toString());
        editor.apply();

        Toast.makeText(this, "saved", Toast.LENGTH_LONG).show();
    }

    public void displayTask (View view){
        SharedPreferences sharedPref = getSharedPreferences("tasks", Context.MODE_PRIVATE);

        String task = sharedPref.getString("task", "");

//        Map<String, ?> task = sharedPref.getAll()
//                for (task<String, ?> entry:map.getEntrySet());

        showTasks.setText(task);
    }

    public void saveTaskJson (){
        SharedPreferences taskSharedPref = getSharedPreferences("tasks", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= taskSharedPref.edit();


        SharedPreferences commonSharedPref = getSharedPreferences("common", Context.MODE_PRIVATE);
        int taskId = commonSharedPref.getInt("task_id_counter", 0);
        Task task = new Task(enterNewTask.getText().toString(), taskId);

        commonSharedPref.edit().putInt("task_id_counter", taskId +1).apply();


        Gson gson = new Gson();
        String jsonTask = gson.toJson(task);

        editor.putString(task.getSpKey(), jsonTask);
        editor.apply();

        Toast.makeText(this, "saved", Toast.LENGTH_LONG).show();
    }

    public void getSavedObjectFromPreference(View view){

        SharedPreferences taskSharedPref = getSharedPreferences("tasks", Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = taskSharedPref.getString("task", "");
        Task task = gson.fromJson(json, Task.class);
        showTasks.setText(json);

    }



}
