package example.codeclan.com.forgetmenot;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Map;

/**
 * Created by user on 22/01/2017.
 */

public class TaskList extends Fragment {

    TextView taskList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        taskList = (TextView) view.findViewById(R.id.taskList);

        taskList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayTaskList();
            }
        });

        return view;
    }


    public void displayTaskList(){

        String textValue = "";

        Map<String, ?> allTasks = getActivity().getSharedPreferences("tasks", Context.MODE_PRIVATE).getAll();
        for (Map.Entry<String, ?> entry : allTasks.entrySet()) {
            if (entry.getValue() instanceof String) {
                textValue += (String)entry.getValue();
            }
        }
        taskList.setText(textValue);
    }
}

