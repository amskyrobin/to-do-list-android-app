package example.codeclan.com.forgetmenot;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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


        return view;


    }
}
