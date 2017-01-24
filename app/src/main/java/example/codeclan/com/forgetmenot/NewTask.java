package example.codeclan.com.forgetmenot;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import static example.codeclan.com.forgetmenot.R.id.addNewTask;
import static example.codeclan.com.forgetmenot.R.id.priorityTaskList;

/**
 * Created by user on 22/01/2017.
 */

public class NewTask extends Fragment {

    EditText enterNewTask;
    Button addNewTask;
    TextView showTasks;




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_task, container, false);

        enterNewTask = (EditText) view.findViewById(R.id.enterNewTask);
        addNewTask = (Button) view.findViewById(R.id.addNewTask);
        showTasks = (TextView) view.findViewById(R.id.showTasks);

        addNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTaskJson();
            }
        });

        return view;
    }

    public void saveTaskJson (){
        SharedPreferences taskSharedPref = getActivity().getSharedPreferences("tasks", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= taskSharedPref.edit();


        SharedPreferences commonSharedPref = getActivity().getSharedPreferences("common", Context.MODE_PRIVATE);
        int taskId = commonSharedPref.getInt("task_id_counter", 0);
        Task task = new Task(enterNewTask.getText().toString(), taskId);

        commonSharedPref.edit().putInt("task_id_counter", taskId +1).apply();


        Gson gson = new Gson();
        String jsonTask = gson.toJson(task);


        editor.putString(task.getSpKey(), jsonTask);
        editor.apply();

        Toast.makeText(getActivity(), "saved", Toast.LENGTH_LONG).show();
    }


    }

